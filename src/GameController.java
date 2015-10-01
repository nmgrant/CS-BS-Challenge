import java.awt.event.*;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JLayeredPane;

public class GameController {
    
    private GameModel model;
    private GameFrame frame;
    GameModel.Player currentPlayer;
    GameModel.Player[] players;
    
    public GameController(GameModel model, GameFrame frame) {
        this.model = model;
        this.frame = frame;
        currentPlayer = model.getCurrentPlayer();
        players = model.getPlayers();
        frame.addPlayCardActionPerformed(new PlayCardActionPerformed());
        frame.addMoveActionPerformed(new MoveActionPerformed());
    }
    
    public class PlayCardActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            currentPlayer.resetMoves();
            nextPlayer();
            
            frame.getMove().setEnabled(true);
        }
    }
    
    public class MoveActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
             
            if (currentPlayer.getMoves() > 0) {
                
                GameModel.Room currentPlayerRoom = model.getRoom(currentPlayer.getRoomNumber());
                Point currentPlayerSpace = currentPlayer.getSpace();
                currentPlayerRoom.setSpaceAvailability(currentPlayerSpace);

                GameModel.Room selectedRoom = (GameModel.Room)frame.getMoveList().getSelectedValue();

                currentPlayer.setRoom(selectedRoom.getRoomNumber());
                selectedRoom.setSpaceAvailability(currentPlayer.getSpace());
                frame.updatePlayerPosition((JLabel)currentPlayer);
                frame.updateList();

                currentPlayer.decreaseMoves();

                if (currentPlayer.getMoves() == 0) {
                    frame.getMove().setEnabled(false);
                    nextPlayer();
                }
            } 
        }
    }
    
    public void nextPlayer() {
        for (int i = 0; i < players.length; i++) {
            if (players[i].isCurrent()) {
                if (i == 2) {
                    model.getCurrentPlayer().changeCurrent();
                    model.setCurrentPlayer(players[i - 2]);
                }
                else {
                    model.getCurrentPlayer().changeCurrent();
                    model.setCurrentPlayer(players[i + 1]);
                }
                model.getCurrentPlayer().changeCurrent();
            }
        }
        currentPlayer = model.getCurrentPlayer();
        frame.updateList();
    }
    /*
    private void MoveActionPerformed(java.awt.event.ActionEvent evt) {                                     
        if (humanPlayer.getMoves() > 0) {
            GameModel.Room selectedRoom = (GameModel.Room)MoveList.getSelectedValue();
            humanPlayer.setRoom(selectedRoom.getRoomNumber());
            updatePlayer(humanPlayer);
            updateList();
            humanPlayer.decreaseMoves();
            if (humanPlayer.getMoves() == 0)
                Move.setEnabled(false);
        }
    } 
    */
}
