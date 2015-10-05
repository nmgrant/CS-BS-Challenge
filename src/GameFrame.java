
import javax.swing.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends javax.swing.JFrame {
    
    private GameModel model;
    private GameModel.Player currentPlayer;
    /**
     * Creates new form GameFrame
     */
    
    public GameFrame(GameModel model) {
        this.model = model;
        currentPlayer = model.getCurrentPlayer();
        initComponents();
        initPlayerPosition(player1Label);
        initPlayerPosition(player2Label);
        initPlayerPosition(player3Label);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GamePanel = new javax.swing.JPanel();
        Move = new javax.swing.JButton();
        BoardWindow = new javax.swing.JScrollPane();
        BoardWindowPanel = new javax.swing.JLayeredPane();
        player1Label = (model.getPlayers())[0];
        player2Label = (model.getPlayers())[1];
        player3Label = (model.getPlayers())[2];
        Board = new javax.swing.JLabel();
        PlayCard = new javax.swing.JButton();
        DrawCard = new javax.swing.JButton();
        MoveListWindow = new javax.swing.JScrollPane();
        MoveList = new javax.swing.JList();
        GameInfo = new javax.swing.JTextField();
        Player = new javax.swing.JTextField();
        Card = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GamePanel.setBackground(new java.awt.Color(204, 204, 204));

        Move.setText("Move");

        BoardWindow.setAutoscrolls(true);

        player1Label.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        player1Label.setForeground(new java.awt.Color(255, 51, 0));
        player1Label.setText(player1Label.getName());

        player2Label.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        player2Label.setForeground(new java.awt.Color(255, 51, 0));
        player2Label.setText(player2Label.getName());

        player3Label.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        player3Label.setForeground(new java.awt.Color(255, 51, 0));
        player3Label.setText(player3Label.getName());

        Board.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardMap.png"))); // NOI18N

        javax.swing.GroupLayout BoardWindowPanelLayout = new javax.swing.GroupLayout(BoardWindowPanel);
        BoardWindowPanel.setLayout(BoardWindowPanelLayout);
        BoardWindowPanelLayout.setHorizontalGroup(
            BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(player1Label)
                .addContainerGap(940, Short.MAX_VALUE))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Board)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(player2Label)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(player3Label)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BoardWindowPanelLayout.setVerticalGroup(
            BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoardWindowPanelLayout.createSequentialGroup()
                .addContainerGap(1166, Short.MAX_VALUE)
                .addComponent(player1Label)
                .addGap(776, 776, 776))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Board)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(player2Label)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(player3Label)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BoardWindowPanel.setLayer(player1Label, javax.swing.JLayeredPane.DRAG_LAYER);
        BoardWindowPanel.setLayer(player2Label, javax.swing.JLayeredPane.DRAG_LAYER);
        BoardWindowPanel.setLayer(player3Label, javax.swing.JLayeredPane.DRAG_LAYER);
        BoardWindowPanel.setLayer(Board, javax.swing.JLayeredPane.DEFAULT_LAYER);

        BoardWindow.setViewportView(BoardWindowPanel);

        PlayCard.setText("Play Card");

        DrawCard.setText("Draw Card");

        int playerRoom = currentPlayer.getRoomNumber();
        GameModel.Room currentRoom = model.getRoom(playerRoom);
        MoveList.setModel(new javax.swing.AbstractListModel() {
            public GameModel.Room[] initializeList() {
                GameModel.Room[] rooms = new GameModel.Room[currentRoom.getAdjacentRooms().length];
                for (int i = 0; i < rooms.length; i++) {
                    rooms[i] = currentRoom.getAdjacentRooms()[i];
                }
                return rooms;
            }
            public int getSize() { return rooms.length; }
            public Object getElementAt(int i) { return rooms[i]; }
            GameModel.Room[] rooms = initializeList();
        });
        MoveList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        MoveListWindow.setViewportView(MoveList);

        GameInfo.setText("jTextField1");
        GameInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameInfoActionPerformed(evt);
            }
        });

        Player.setText("Current player is " + model.getCurrentPlayer().getName());

        Card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/card.PNG"))); // NOI18N
        Card.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GamePanelLayout = new javax.swing.GroupLayout(GamePanel);
        GamePanel.setLayout(GamePanelLayout);
        GamePanelLayout.setHorizontalGroup(
            GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BoardWindow)
            .addGroup(GamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PlayCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Move, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DrawCard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                    .addComponent(MoveListWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Card, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Player)
                    .addComponent(GameInfo))
                .addContainerGap())
        );
        GamePanelLayout.setVerticalGroup(
            GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GamePanelLayout.createSequentialGroup()
                .addComponent(BoardWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 2003, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GamePanelLayout.createSequentialGroup()
                            .addComponent(DrawCard, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Move)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PlayCard)
                            .addGap(18, 18, 18)
                            .addComponent(MoveListWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(GamePanelLayout.createSequentialGroup()
                            .addComponent(GameInfo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Player, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Card, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        BoardWindow.getVerticalScrollBar().setUnitIncrement(25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1674, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2317, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(GamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**/
    private void CardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CardActionPerformed
        if (((ImageIcon) Card.getIcon()).getDescription().equals("card.PNG"))
            Card.setIcon(new ImageIcon("card2.PNG"));
        else
            Card.setIcon(new ImageIcon("card.PNG"));
    }//GEN-LAST:event_CardActionPerformed

    private void GameInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameInfoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GameInfoActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
/*        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }  
        });
    }*/
    public void initPlayerPosition(JLabel player) {
        BoardWindowPanel.remove(player);
        player.setLocation(((GameModel.Player)player).getSpace());
        BoardWindowPanel.add(player);
        BoardWindowPanel.repaint();
        
        updateList();
    }
    public void updatePlayerPosition(JLabel player) {
        
        BoardWindowPanel.remove(player);
        player.setLocation(model.getCurrentPlayer().getSpace());
        BoardWindowPanel.add(player);
        BoardWindowPanel.repaint();
        
        updateList();
    }
    
    public void updateList() {
        currentPlayer = model.getCurrentPlayer();
        int playerRoom = currentPlayer.getRoomNumber();
        GameModel.Room currentRoom = model.getRoom(playerRoom);
        MoveList.setModel(new javax.swing.AbstractListModel() {
            public GameModel.Room[] initializeList() {
                GameModel.Room[] rooms = new GameModel.Room[currentRoom.getAdjacentRooms().length];
                for (int i = 0; i < rooms.length; i++) {
                    rooms[i] = currentRoom.getAdjacentRooms()[i];
                }
                return rooms;
            }
            public int getSize() { return rooms.length; }
            public Object getElementAt(int i) { return rooms[i]; }
            GameModel.Room[] rooms = initializeList();
        });
    }
    
    public void updateCurrent() {
        Player.setText("Current player is " + model.getCurrentPlayer().getName());
    }
    
    public void addPlayCardActionPerformed(ActionListener l) {
        PlayCard.addActionListener(l);
    }
    
    public void addMoveActionPerformed(ActionListener l) {
        Move.addActionListener(l);
    }
    
    public JButton getMove() {
        return Move;
    }
    
    public JButton getPlayCard() {
        return PlayCard;
    }
    
    public JList getMoveList() {
        return MoveList;
    }
    
    public JLayeredPane getBoardWindow() {
        return BoardWindowPanel;
    }
    
    public void setCurrentPlayer(GameModel.Player player) {
        currentPlayer = player;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Board;
    private javax.swing.JScrollPane BoardWindow;
    private javax.swing.JLayeredPane BoardWindowPanel;
    private javax.swing.JButton Card;
    private javax.swing.JButton DrawCard;
    private javax.swing.JTextField GameInfo;
    private javax.swing.JPanel GamePanel;
    private javax.swing.JButton Move;
    private javax.swing.JList MoveList;
    private javax.swing.JScrollPane MoveListWindow;
    private javax.swing.JButton PlayCard;
    private javax.swing.JTextField Player;
    private javax.swing.JLabel player1Label;
    private javax.swing.JLabel player2Label;
    private javax.swing.JLabel player3Label;
    // End of variables declaration//GEN-END:variables
}
