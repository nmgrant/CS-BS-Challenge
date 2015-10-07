
import java.awt.event.*;
import java.util.Random;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JLayeredPane;

public class GameController {

   private GameModel model;
   private GameFrame frame;

   public GameController(GameModel model, GameFrame frame) {
      this.model = model;
      this.frame = frame;
      frame.addPlayCardActionPerformed(new PlayCardActionPerformed());
      frame.addMoveActionPerformed(new MoveActionPerformed());
      frame.addCardButtonActionPerformed(new CardButtonActionPerformed());
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

   public class CardButtonActionPerformed implements ActionListener {

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

   public void movePlayer() {
      if (model.getCurrentPlayer().getMoves() > 0) {

         GameModel.Room currentPlayerRoom
         = model.getRoom(model.getCurrentPlayer().getRoomNumber());
         Point currentPlayerSpace = model.getCurrentPlayer().getSpace();
         currentPlayerRoom.setSpaceAvailability(currentPlayerSpace);

         GameModel.Room selectedRoom
         = (GameModel.Room) frame.getMoveList().getSelectedValue();

         model.getCurrentPlayer().setRoom(selectedRoom.getRoomNumber());
         model.getCurrentPlayer().setSpace(selectedRoom.findAvailableSpace());
         selectedRoom.setSpaceAvailability(model.getCurrentPlayer().getSpace());
         frame.updatePlayerPosition((JLabel) model.getCurrentPlayer());
         frame.updateList();

         model.getCurrentPlayer().decreaseMoves();

         if (model.getCurrentPlayer().getMoves() == 0) {
            frame.getMove().setEnabled(false);
         }
      }
   }

   public void nextCard() {

   }

   public void nextPlayer() {
      for (int i = 0; i < model.getPlayers().length; i++) {
         if (model.getPlayers()[i].isCurrent()) {
            model.getCurrentPlayer().changeCurrent();
            if (i == 2) {
               GameModel.Player nextPlayer = (model.getPlayers())[i - 2];
               model.setCurrentPlayer(nextPlayer);
            } else {
               GameModel.Player nextPlayer = (model.getPlayers())[i + 1];
               model.setCurrentPlayer(nextPlayer);
            }
         }
      }
      model.getCurrentPlayer().changeCurrent();
      frame.updateList();
      frame.updateCurrent();

      if (!(model.getCurrentPlayer().isHuman())) {
         computerTurn();
      }
   }

   public void computerTurn() {
      Random rand = new Random();
      int numberOfMoves = rand.nextInt(4);

      for (int i = 0; i < numberOfMoves; i++) {
         int roomChoice = rand.nextInt(frame.getMoveList().getModel().getSize());
         frame.getMoveList().setSelectedIndex(roomChoice);
         frame.getMove().doClick();
      }
      frame.getPlayCard().doClick();
   }
}
