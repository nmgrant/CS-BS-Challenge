package GameClasses;

import CardClasses.Card;
import CardClasses.Penalty;
import CardClasses.Reward;
import java.awt.event.*;
import java.util.Random;
import java.awt.Point;
import javax.swing.JLabel;

public class GameController {

    private GameModel model;
    private GameView frame;

    public GameController(GameModel model, GameView frame) {
        this.model = model;
        this.frame = frame;
        frame.addPlayCardActionPerformed(new PlayCardActionPerformed());
        frame.addMoveActionPerformed(new MoveActionPerformed());
        frame.addCardButtonActionPerformed(new CardActionPerformed());
        frame.addDrawCardButtonActionPerformed(new DrawCardButtonActionPerformed());
    }

    public class PlayCardActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            playCard();
        }
    }

    public class MoveActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            movePlayer();
        }
    }

    public class DrawCardButtonActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            drawCard();
        }
    }

    public class CardActionPerformed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt) {
            nextCard();
        }
    }

    public void playCard() {
        Card chosenCard = frame.getCardButton().getCurrentCard();
        boolean success = chosenCard.playCard(model.getCurrentPlayer());

        if (model.getCurrentPlayer().hasDiscardedCard()) {
            for (int i = 0; i < model.getCurrentPlayer().getDiscardedCard().size(); i++) {
                Card discardedCard = model.getCurrentPlayer().getDiscardedCard().get(i);
                model.addCardToDiscardDeck(discardedCard);
            }
        }

        String result = model.getCurrentPlayer().getName() + " played "
                + chosenCard.getCardName();

        if (success) {
            result += " and has received: ";
            result += applyReward(chosenCard.getReward());
        } else {
            result += " and has failed. Penalties: ";
            result += applyPenalty(chosenCard.getPenalty());
        }
        
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
            result += " Quality Points: " + qualityPoints;
        }
        if (skillPoints != null) {
            model.getCurrentPlayer().getSkillPoints().adjustSkillPoints(skillPoints);
            result += skillPoints;
        }
        if (cardsDrawn > 0) {
            for (int i = 0; i < cardsDrawn; i++) {
                model.getCurrentPlayer().pickUpCard(model.getDeckOfCards().getTopCard());
            }
            result += " Cards: " + cardsDrawn; 
        }
        if (room != null) {
            teleportPlayer(room);
            result += " and has moved to: " + room;
        }
        
        return result;
    }

    public String applyPenalty(Penalty penalty) {
        int qualityPoints = penalty.getQualityPointsPenalty();
        SkillPoints skillPoints = penalty.getSkillPenalty();
        Card[] cardsDrawn = penalty.getCardPenalty();
        Room room = penalty.getRoomPenalty();
        
        String result = "";
        if (qualityPoints > 0) {
            model.getCurrentPlayer().adjustQualityPoints(qualityPoints);
            result += " Quality Points: " + qualityPoints;
        }
        if (skillPoints != null) {
            model.getCurrentPlayer().getSkillPoints().adjustSkillPoints(skillPoints);
            result += skillPoints;
        }
        if (cardsDrawn.length > 0) {
            model.getCurrentPlayer().pickUpCard(model.getDeckOfCards().getTopCard());
            result += " Cards: " + cardsDrawn;
        }
        if (room != null) {
            teleportPlayer(room);
            result += " and has moved to: " + room;
        }
        
        return result;
    }

    public void movePlayer() {
        if (frame.getMoveList().getSelectedValue() == null) {
            frame.updateBottomConsole(" Move not selected. \n");
            return;
        }

        if (model.getCurrentPlayer().getMoves() > 0) {

            Room currentPlayerRoom
                    = model.getCurrentPlayer().getRoom();
            Point currentPlayerSpace = model.getCurrentPlayer().getSpace();
            currentPlayerRoom.setSpaceAvailability(currentPlayerSpace);

            Room selectedRoom
                    = (Room) frame.getMoveList().getSelectedValue();

            model.getCurrentPlayer().setRoom(selectedRoom);
            model.getCurrentPlayer().setSpace(selectedRoom.findAvailableSpace());
            model.getCurrentPlayer().decreaseMoves();

            frame.updatePlayerPosition((JLabel) model.getCurrentPlayer());
            frame.updateList();
        }
        frame.updateInformationPanel();
    }

    public void teleportPlayer(Room room) {
        Room currentPlayerRoom
                = model.getCurrentPlayer().getRoom();
        Point currentPlayerSpace = model.getCurrentPlayer().getSpace();
        currentPlayerRoom.setSpaceAvailability(currentPlayerSpace);

        model.getCurrentPlayer().setRoom(room);
        model.getCurrentPlayer().setSpace(room.findAvailableSpace());

        frame.updatePlayerPosition((JLabel) model.getCurrentPlayer());
        frame.updateList();

        frame.updateBottomConsole(" " + model.getCurrentPlayer() + " has teleported to "
                + room + "\n");
        frame.updateInformationPanel();
    }

    public void drawCard() {
        Card drawnCard = model.getDeckOfCards().getTopCard();
        model.getCurrentPlayer().pickUpCard(drawnCard);
        frame.getCardButton().drawCard();
        frame.updateCardButton();
        model.removeCardFromDeck(drawnCard);
        frame.updateInformationPanel();
    }

    public void nextCard() {
        frame.getCardButton().nextCard();
    }

    public void nextPlayer() {
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
        model.getCurrentPlayer().changeCurrent();
        frame.updateList();
        frame.updateBottomConsole(" Current player is "
                + model.getCurrentPlayer().getName() + "\n");

        if (!(model.getCurrentPlayer().isHuman())) {
            computerTurn();
        }

        frame.snapToCurrentPlayer();
    }

    public void computerTurn() {
        Random rand = new Random();
        int numberOfMoves = rand.nextInt(3) + 1;

        for (int i = 0; i < numberOfMoves; i++) {

            int roomChoice = rand.nextInt(frame.getMoveList().getModel().getSize());
            frame.getMoveList().setSelectedIndex(roomChoice);
            movePlayer();

        }
        playCard();
    }
}
