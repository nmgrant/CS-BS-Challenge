package GameClasses;

import CardClasses.Card;
import CardClasses.Penalty;
import CardClasses.Reward;
import java.awt.event.*;
import java.util.Random;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class GameController implements Serializable {

    private GameModel model;
    private GameView frame;
    private File gameFile;
    // Sounds backgroundMusic = new Sounds("/Sounds/PokemonRoute1.wav");
    Sounds drawCardSound = new Sounds("/Sounds/PokeballCaught.wav");
    Sounds playCardSound = new Sounds("/Sounds/PokemonGo.wav");
    Sounds backgroundMusic = new Sounds("/Sounds/PokemonTGCBackgroundMusic.wav");
    Sounds nextCardSound = new Sounds("/Sounds/PokeballExpand.wav");

    public GameController(GameModel model, GameView frame) {
        this.model = model;
        this.frame = frame;
        frame.setVisible(true);
        gameFile = frame.getGameFile();
        addListeners();
        backgroundMusic.loop();
    }

    private void addListeners() {
        frame.addPlayCardActionPerformed(new PlayCardActionPerformed());
        frame.addMoveActionPerformed(new MoveActionPerformed());
        frame.addCardButtonActionPerformed(new CardActionPerformed());
        frame.addDrawCardButtonActionPerformed(new DrawCardButtonActionPerformed());
        frame.addNewGameActionPerformed(new NewGameActionPerformed());
        frame.addSaveGameActionPerformed(new SaveGameActionPerformed());
        frame.addLoadGameActionPerformed(new LoadGameActionPerformed());
        frame.addExitGameActionPerformed(new ExitGameActionPerformed());
    }

    private void completeGame() {
        Player winner = null;
        for (Player player : model.getPlayers()) {
            if (player.isWinner()) {
                winner = player;
            }
        }
        JOptionPane.showMessageDialog(frame, winner + " has won!");
        
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSED));
        System.exit(0);
    }

    private class NewGameActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            model = new GameModel();
            frame.dispose();
            frame = new GameView(model, gameFile);
            frame.setVisible(true);
            addListeners();
        }
    }

    private class SaveGameActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.saveGame(model, gameFile);
        }
    }

    private class LoadGameActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loadGame();
            frame.dispose();
            frame = new GameView(model, gameFile);
            frame.setVisible(true);
            addListeners();
        }
    }

    private class ExitGameActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }
    }

    private class PlayCardActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            drawCardSound.stop();
            backgroundMusic.pause();

            playCardSound.play();
            playCard();

            backgroundMusic.loop();
        }
    }

    private class MoveActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            movePlayer();
        }
    }

    private class DrawCardButtonActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            playCardSound.stop();
            backgroundMusic.pause();

            drawCardSound.play();
            drawCard();

            backgroundMusic.loop();
        }
    }

    private class CardActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            nextCardSound.play();
            nextCard();

            try {
                Thread.sleep(450);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            nextCardSound.stop();
        }
    }

    public void playCard() {
        Card chosenCard = frame.getCardButton().getCurrentCard();
        boolean success = chosenCard.playCard(model.getCurrentPlayer());

        String result = "\n" + model.getCurrentPlayer().getName() + " played "
                + chosenCard.getCardName();

        if (success) {
            result += " and has received: ";
            result += applyReward(chosenCard.getReward());
        } else {
            result += " and has failed. Penalties: ";
            result += applyPenalty(chosenCard.getPenalty());
        }

        model.getDiscardDeck().addCard(chosenCard);
        model.getDeckOfCards().removeCard(chosenCard);
        model.getCurrentPlayer().getHand().remove(chosenCard);

        frame.updateCardButton();

        frame.updateBottomConsole(result);
        frame.updateInformationPanel();

        nextPlayer();
    }

    public String applyReward(Reward reward) {
        int qualityPoints = reward.getQualityPointsReward();
        SkillPoints skillPoints = reward.getSkillReward();
        int cardsDrawn = reward.getCardReward();
        Room room = reward.getRoomReward();

        String result = "";
        if (qualityPoints > 0) {
            model.getCurrentPlayer().adjustQualityPoints(qualityPoints);
            model.updateTotalQualityPoints();
            result += " Quality Points: " + qualityPoints;
        }
        if (skillPoints != null) {
            model.getCurrentPlayer().getSkillPoints().adjustSkillPoints(skillPoints);
            result += skillPoints;
        }
        if (cardsDrawn > 0) {
            for (int i = 0; i < cardsDrawn; i++) {
                model.checkToReshuffleDeck();
                model.getCurrentPlayer().pickUpCard(model.getDeckOfCards().getTopCard());
                model.getDeckOfCards().removeCard(model.getDeckOfCards().getTopCard());
            }
            result += " Cards: " + cardsDrawn;
        }
        if (cardsDrawn < 0) {

        }
        if (room != null) {
            teleportPlayer(room);
            result += " and has moved to: " + room;
        }

        return result;
    }

    public String applyPenalty(Penalty penalty) {
        Card playedCard = frame.getCardButton().getCurrentCard();
        int qualityPoints = penalty.getQualityPointsPenalty();
        SkillPoints skillPoints = penalty.getSkillPenalty();
        Card[] cardsDiscarded = penalty.getCardPenalty();
        boolean leaveCard = penalty.checkLeaveCard(playedCard);
        Room room = penalty.getRoomPenalty();

        String result = "";
        if (qualityPoints != 0) {
            model.getCurrentPlayer().adjustQualityPoints(qualityPoints);
            model.updateTotalQualityPoints();
            result += " Quality Points: " + qualityPoints;
        }
        if (skillPoints != null) {
            model.getCurrentPlayer().getSkillPoints().adjustSkillPoints(skillPoints);
            result += skillPoints;
        }
        if (cardsDiscarded != null) {
            result += " Cards: ";
            for (int i = 0; i < cardsDiscarded.length; i++) {
                model.getCurrentPlayer().discardCard(cardsDiscarded[i]);
                model.addCardToDiscardDeck(cardsDiscarded[i]);
                result += cardsDiscarded[i] + " ";
            }
        }
        if (room != null) {
            teleportPlayer(room);
            result += " and has moved to: " + room;
        }
        if (leaveCard) {
            model.getCurrentPlayer().getRoom().placeCardInRoom(playedCard);
            model.getCurrentPlayer().discardCard(playedCard);
        }

        return result;
    }

    public void movePlayer() {
        if (frame.getMoveList().getSelectedValue() == null) {
            return;
        }

        if (model.getCurrentPlayer().getMoves() > 0) {

            Room currentPlayerRoom = model.getCurrentPlayer().getRoom();
            Point currentPlayerSpace = model.getCurrentPlayer().getSpace();
            currentPlayerRoom.setSpaceAvailability(currentPlayerSpace);

            Room selectedRoom = (Room) frame.getMoveList().getSelectedValue();

            model.getCurrentPlayer().setRoom(selectedRoom);
            model.getCurrentPlayer().setSpace(selectedRoom.findAvailableSpace());
            model.getCurrentPlayer().decreaseMoves();

            if (model.getCurrentPlayer().getMoves() == 0) {
                frame.getMove().setEnabled(false);
            }

            if (!currentPlayerRoom.getRoomCards().isEmpty()) {
                String pickedUpCard = currentPlayerRoom.getRoomCards().toString();
                model.getCurrentPlayer().pickUpRoomCard();
                frame.updateBottomConsole(model.getCurrentPlayer().getName()
                        + " picked up: " + pickedUpCard);
            }
        }
        frame.updateInformationPanel();
        frame.updatePlayerPosition(model.getCurrentPlayer());
        frame.updateList();
    }

    public void teleportPlayer(Room room) {
        for (Room modelRoom : model.getRooms()) {
            if (room.equals(modelRoom)) {
                room = modelRoom;
            }
        }

        Room currentPlayerRoom = model.getCurrentPlayer().getRoom();
        Point currentPlayerSpace = model.getCurrentPlayer().getSpace();
        currentPlayerRoom.setSpaceAvailability(currentPlayerSpace);

        model.getCurrentPlayer().setRoom(room);
        model.getCurrentPlayer().setSpace(room.findAvailableSpace());

        frame.updatePlayerPosition(model.getCurrentPlayer());
        frame.updateList();

        frame.updateBottomConsole("\n" + model.getCurrentPlayer() + " has teleported to "
                + room);
        frame.updateInformationPanel();
    }

    public void drawCard() {
        model.checkToReshuffleDeck();
        Card drawnCard = model.getDeckOfCards().getTopCard();
        model.getCurrentPlayer().pickUpCard(drawnCard);
        frame.getCardButton().drawCard();
        frame.updateCardButton();
        model.removeCardFromDeck(drawnCard);
        frame.updateInformationPanel();
        model.getCurrentPlayer().resetMoves();
        frame.updateList();
    }

    public void nextCard() {
        frame.getCardButton().nextCard();
    }

    public void nextPlayer() {
        model.checkGameStatus();
        
        if(model.isGameComplete()) {
            completeGame(); 
       }
        
        chooseNextPlayer();

        model.getCurrentPlayer().changeCurrent();
        frame.updateList();

        if (!(model.getCurrentPlayer().isHuman())) {
            computerTurns();
        }

        frame.snapToCurrentPlayer();
        frame.updateInformationPanel();
        frame.updateList();
        frame.getDrawCardButton().setEnabled(true);
        frame.getPlayCard().setEnabled(false);
        frame.getMove().setEnabled(false);

    }

    public void chooseNextPlayer() {
        for (int i = 0; i < model.getPlayers().length; i++) {
            if (model.getPlayers()[i].isCurrent()) {
                model.getCurrentPlayer().changeCurrent();
                if (i == 2) {
                    Player nextPlayer = (model.getPlayers())[i - 2];
                    model.setCurrentPlayer(nextPlayer);
                } else {
                    Player nextPlayer = (model.getPlayers())[i + 1];
                    model.setCurrentPlayer(nextPlayer);
                }
            }
        }
    }

    public void computerTurns() {
        drawCard();
        Random rand = new Random();
        Room desiredRoom = null;
        Card desiredCard = null;

        HashSet<Room> possibleMoves = (model.getPossibleRooms(model.getCurrentPlayer().getRoom(), 3));
        LinkedList<Card> cards = model.getCurrentPlayer().getHand();
        SkillPoints playerSkillPoints = model.getCurrentPlayer().getSkillPoints();

        for (Room room : possibleMoves) {
            for (Card card : cards) {
                if (card.getLocations().contains(room) && playerSkillPoints.equals(card.getskillPointsPreReq())) {
                    desiredRoom = room;
                    desiredCard = card;
                }
            }
        }

        ArrayList<Room> roomSequence;
        if (desiredRoom != null && desiredCard != null) {
            roomSequence = model.findPathToRoom(model.getCurrentPlayer().getRoom(), desiredRoom);

            for (int i = 0; i < roomSequence.size(); i++) {
                frame.selectSpecificRoom(roomSequence.get(i));
                movePlayer();
            }
            frame.getCardButton().setCurrentCard(desiredCard);
        } else {
            int numberOfMoves = rand.nextInt(3) + 1;

            for (int i = 0; i < numberOfMoves; i++) {
                int roomChoice = rand.nextInt(frame.getMoveList().getModel().getSize());
                frame.getMoveList().setSelectedIndex(roomChoice);
                movePlayer();
            }
            int cardChoice = rand.nextInt(cards.size());
            frame.getCardButton().setCurrentCard(cards.get(cardChoice));
        }

        playCard();
    }

    public void loadGame() {
        if (gameFile.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream(gameFile));

                model = (GameModel) in.readObject();
                in.close();
                System.out.println("Game loaded.");
            } catch (IOException e) {
                System.out.println("Error processing file.");
            } catch (ClassNotFoundException c) {
                System.out.println("Class not found.");
            }
        }
    }

    public Sounds getBackgroundMusic() {
        return backgroundMusic;
    }
}
