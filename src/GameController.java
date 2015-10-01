import java.awt.event.*;

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
    }
    
    public class PlayCardActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            currentPlayer.resetMoves();
            for (int i = 0; i < players.length; i++) {
                if (players[i].isCurrent()) {
                    if (i == 2)
                        model.setCurrentPlayer(players[i - 2]);
                    else
                        model.setCurrentPlayer(players[i + 1]);
                }
            }
            
            frame.getMove().setEnabled(true);
        }
    }
    
    /*public class MoveActionPerformed implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
             
            if (currentPlayer.getMoves() > 0) {
            GameModel.Room selectedRoom = (GameModel.Room)MoveList.getSelectedValue();
            humanPlayer.setRoom(selectedRoom.getRoomNumber());
            updatePlayer(humanPlayer);
            updateList();
            humanPlayer.decreaseMoves();
            if (humanPlayer.getMoves() == 0)
                Move.setEnabled(false);
        } 
        }
    }*/
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
