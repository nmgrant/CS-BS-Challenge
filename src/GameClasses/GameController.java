package GameClasses;

import CardClasses.Card;
import CardClasses.Deck;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class GameController {

    private GameModel model;
    private GameView frame;
    private Deck deck;

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
        model.getCurrentPlayer().resetMoves();
        nextPlayer();

        frame.getMove().setEnabled(true);
    }

    public void chooseSkillPoints() {
       
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

            frame.updateBottomConsole(" " + model.getCurrentPlayer() + " has moved to "
                    + selectedRoom + "\n");

            if (model.getCurrentPlayer().getMoves() == 0) {
                frame.getMove().setEnabled(false);
            }
        }
    }

    public void drawCard() {
        Card drawnCard = model.getDeckOfCards().getTopCard();
        model.getCurrentPlayer().pickUpCard(drawnCard);
        frame.updateCardButton();
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
