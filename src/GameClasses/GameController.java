package GameClasses;

import CardClasses.Card;
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
          Card discardedCard = model.getCurrentPlayer().getDiscardedCard();
          model.addCardToDiscardDeck(discardedCard);
      }
      
      String result = model.getCurrentPlayer().getName() + " played " +
       chosenCard.getName();
      
      if (success) {
          result += " and received " + chosenCard.getSkillReward()
           + ", " + chosenCard.getQualityPointsReward() + " quality points ";
          if (chosenCard.getCardReward() != 0)
              result += ", and drew a card";
          if (chosenCard.getRoomReward() != null)
              result += ", and teleported to " + chosenCard.getRoomReward();
      }
      else {
          result += " and failed.";
      }
      frame.updateBottomConsole(result);
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
      frame.getCardButton().drawCard();
      frame.updateCardButton();
      model.removeCardFromDeck(drawnCard);
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
