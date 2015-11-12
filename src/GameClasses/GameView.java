
package GameClasses;

import CardClasses.Card;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameView extends javax.swing.JFrame {

   private GameModel model;
   private Player currentPlayer;
   private Card currentCard;

   /**
    * Creates new form GameFrame
    */
   public GameView(GameModel model) {
      this.model = model;
      currentPlayer = model.getCurrentPlayer();
      initComponents();
      initPlayerPosition(player1Label);
      initPlayerPosition(player2Label);
      initPlayerPosition(player3Label);
      snapToCurrentPlayer();
      //Sounds backgroundMusic = new Sounds("/Sounds/PokemonRoute1.wav");
      //backgroundMusic.loop();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      chooseSkillPoints = new javax.swing.JDialog();
      learningChip = new javax.swing.JButton();
      craftChip = new javax.swing.JButton();
      integrityChip = new javax.swing.JButton();
      gamePanel = new javax.swing.JPanel();
      moveButton = new javax.swing.JButton();
      boardWindow = new javax.swing.JScrollPane();
      boardWindowPanel = new javax.swing.JLayeredPane();
      player1Label = (model.getPlayers())[0];
      player2Label = (model.getPlayers())[1];
      player3Label = (model.getPlayers())[2];
      boardLabel = new javax.swing.JLabel();
      playCardButton = new javax.swing.JButton();
      drawCardButton = new javax.swing.JButton();
      moveListWindow = new javax.swing.JScrollPane();
      moveList = new javax.swing.JList();
      cardButton = new javax.swing.JButton();
      humanInfoScrollPane = new javax.swing.JScrollPane();
      playerInfo = new javax.swing.JTextArea();
      gameInfoScrollPane = new javax.swing.JScrollPane();
      gameInfo = new javax.swing.JTextArea();

      learningChip.setText("jButton1");

      craftChip.setText("jButton1");

      integrityChip.setText("jButton2");

      javax.swing.GroupLayout chooseSkillPointsLayout = new javax.swing.GroupLayout(chooseSkillPoints.getContentPane());
      chooseSkillPoints.getContentPane().setLayout(chooseSkillPointsLayout);
      chooseSkillPointsLayout.setHorizontalGroup(
         chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 400, Short.MAX_VALUE)
         .addGroup(chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseSkillPointsLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(learningChip)
               .addGap(0, 0, Short.MAX_VALUE)))
         .addGroup(chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseSkillPointsLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(craftChip)
               .addGap(0, 0, Short.MAX_VALUE)))
         .addGroup(chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseSkillPointsLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(integrityChip)
               .addGap(0, 0, Short.MAX_VALUE)))
      );
      chooseSkillPointsLayout.setVerticalGroup(
         chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 300, Short.MAX_VALUE)
         .addGroup(chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseSkillPointsLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(learningChip)
               .addGap(0, 0, Short.MAX_VALUE)))
         .addGroup(chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseSkillPointsLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(craftChip)
               .addGap(0, 0, Short.MAX_VALUE)))
         .addGroup(chooseSkillPointsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseSkillPointsLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(integrityChip)
               .addGap(0, 0, Short.MAX_VALUE)))
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      gamePanel.setBackground(new java.awt.Color(204, 204, 204));

      moveButton.setText("Move");

      boardWindow.setAutoscrolls(true);

      player1Label.setFont(new java.awt.Font("Imprint MT Shadow", 0, 48)); // NOI18N
      player1Label.setForeground(new java.awt.Color(0, 255, 0));
      player1Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
      player1Label.setText(player1Label.getName());
      player1Label.setAlignmentX(0.5F);
      player1Label.setAutoscrolls(true);
      player1Label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

      player2Label.setFont(new java.awt.Font("Imprint MT Shadow", 0, 48)); // NOI18N
      player2Label.setForeground(new java.awt.Color(0, 0, 255));
      player2Label.setText(player2Label.getName());
      player2Label.setAlignmentX(0.5F);
      player2Label.setAutoscrolls(true);
      player2Label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

      player3Label.setFont(new java.awt.Font("Imprint MT Shadow", 0, 48)); // NOI18N
      player3Label.setForeground(new java.awt.Color(255, 0, 0));
      player3Label.setText(player3Label.getName());
      player3Label.setAlignmentX(0.5F);
      player3Label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

      boardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/boardMap.png"))); // NOI18N

      javax.swing.GroupLayout boardWindowPanelLayout = new javax.swing.GroupLayout(boardWindowPanel);
      boardWindowPanel.setLayout(boardWindowPanelLayout);
      boardWindowPanelLayout.setHorizontalGroup(
         boardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(boardWindowPanelLayout.createSequentialGroup()
            .addGap(506, 506, 506)
            .addComponent(player1Label)
            .addGap(34, 34, 34)
            .addComponent(player2Label)
            .addContainerGap(590, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boardWindowPanelLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(player3Label)
            .addGap(669, 669, 669))
         .addGroup(boardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardWindowPanelLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(boardLabel)
               .addGap(0, 0, Short.MAX_VALUE)))
      );
      boardWindowPanelLayout.setVerticalGroup(
         boardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(boardWindowPanelLayout.createSequentialGroup()
            .addContainerGap(1059, Short.MAX_VALUE)
            .addComponent(player3Label)
            .addGap(43, 43, 43)
            .addGroup(boardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(player2Label)
               .addComponent(player1Label))
            .addGap(791, 791, 791))
         .addGroup(boardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardWindowPanelLayout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(boardLabel)
               .addGap(0, 0, Short.MAX_VALUE)))
      );
      boardWindowPanel.setLayer(player1Label, javax.swing.JLayeredPane.DRAG_LAYER);
      boardWindowPanel.setLayer(player2Label, javax.swing.JLayeredPane.DRAG_LAYER);
      boardWindowPanel.setLayer(player3Label, javax.swing.JLayeredPane.DRAG_LAYER);
      boardWindowPanel.setLayer(boardLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

      boardWindow.setViewportView(boardWindowPanel);

      playCardButton.setText("Play Card");

      drawCardButton.setText("Draw Card");

      Room currentRoom = currentPlayer.getRoom();
      moveList.setModel(new javax.swing.AbstractListModel() {
         public Room[] initializeList() {
            Room[] rooms = new Room[currentRoom.getAdjacentRooms().length];
            for (int i = 0; i < rooms.length; i++) {
               rooms[i] = currentRoom.getAdjacentRooms()[i];
            }
            return rooms;
         }
         public int getSize() { return rooms.length; }
         public Object getElementAt(int i) { return rooms[i]; }
         Room[] rooms = initializeList();
      });
      moveList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      moveListWindow.setViewportView(moveList);

      cardButton.setIcon(model.getCurrentPlayer().getHand().getFirst().getImage());

      playerInfo.setEditable(false);
      playerInfo.setColumns(20);
      playerInfo.setRows(5);
      playerInfo.setText(" You are " +model.getHumanPlayer().getName() +"\n");
      humanInfoScrollPane.setViewportView(playerInfo);

      gameInfo.setEditable(false);
      gameInfo.setColumns(20);
      gameInfo.setRows(5);
      gameInfoScrollPane.setViewportView(gameInfo);

      javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
      gamePanel.setLayout(gamePanelLayout);
      gamePanelLayout.setHorizontalGroup(
         gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(boardWindow)
         .addGroup(gamePanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(playCardButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(moveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(drawCardButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
               .addComponent(moveListWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29)
            .addComponent(cardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(39, 39, 39)
            .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(humanInfoScrollPane)
               .addComponent(gameInfoScrollPane))
            .addContainerGap())
      );
      gamePanelLayout.setVerticalGroup(
         gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(gamePanelLayout.createSequentialGroup()
            .addComponent(boardWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 2003, Short.MAX_VALUE)
            .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(gamePanelLayout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(drawCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playCardButton)
                        .addGap(18, 18, 18)
                        .addComponent(moveListWindow, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(gameInfoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(humanInfoScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
               .addGroup(gamePanelLayout.createSequentialGroup()
                  .addGap(15, 15, 15)
                  .addComponent(cardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      boardWindow.getVerticalScrollBar().setUnitIncrement(25);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 1674, Short.MAX_VALUE)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 2317, Short.MAX_VALUE)
         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   public void initPlayerPosition(JLabel player) {
      boardWindowPanel.remove(player);
      player.setLocation(((Player) player).getSpace());
      boardWindowPanel.add(player);
      boardWindowPanel.repaint();

      updateList();
   }

   public void updatePlayerPosition(JLabel player) {

      boardWindowPanel.remove(player);
      player.setLocation(model.getCurrentPlayer().getSpace());
      boardWindowPanel.add(player);
      boardWindowPanel.repaint();

      snapToCurrentPlayer();
      updateList();
   }

   public void updateList() {
      currentPlayer = model.getCurrentPlayer();
      
      Room currentRoom = currentPlayer.getRoom();
      if (currentPlayer.getMoves() > 0) {
        moveList.setModel(new javax.swing.AbstractListModel() {
           Room[] rooms = currentRoom.getAdjacentRooms();
           
           @Override
           public int getSize() {
              return rooms.length;
           }

           @Override
           public Object getElementAt(int i) {
              return rooms[i];
           }
        });
      }
      else {
         moveList.setModel(new javax.swing.AbstractListModel() {
           Room[] rooms = new Room[0];
             
           @Override
           public int getSize() {
              return rooms.length;
           }

           @Override
           public Object getElementAt(int i) {
              return rooms[i];
           }
        }); 
      }
   }
   
   public void updateCardButton(Card card) {
       cardButton.setIcon(card.getImage());
       currentCard = card;
   }

   public void updateBottomConsole(String message) {
      playerInfo.append(message);
      playerInfo.setCaretPosition(playerInfo.getDocument().getLength());
   }

   public void snapToCurrentPlayer() {
      boardWindow.getViewport().setViewPosition(currentPlayer.getLocation());
   }

   public void addPlayCardActionPerformed(ActionListener l) {
      playCardButton.addActionListener(l);
   }

   public void addMoveActionPerformed(ActionListener l) {
      moveButton.addActionListener(l);
   }

   public void addCardButtonActionPerformed(ActionListener l) {
      cardButton.addActionListener(l);
   }
   
   public void addDrawButtonActionPerformed(ActionListener l) {
       drawCardButton.addActionListener(l);
   }

   public JButton getMove() {
      return moveButton;
   }

   public JButton getPlayCard() {
      return playCardButton;
   }

   public JList getMoveList() {
      return moveList;
   }

   public JLayeredPane getBoardWindow() {
      return boardWindowPanel;
   }
   
   public Card getCurrentCard() {
       return currentCard;
   }

   public void setCurrentPlayer(Player player) {
      currentPlayer = player;
   }
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JLabel boardLabel;
   private javax.swing.JScrollPane boardWindow;
   private javax.swing.JLayeredPane boardWindowPanel;
   private javax.swing.JButton cardButton;
   private javax.swing.JDialog chooseSkillPoints;
   private javax.swing.JButton craftChip;
   private javax.swing.JButton drawCardButton;
   private javax.swing.JTextArea gameInfo;
   private javax.swing.JScrollPane gameInfoScrollPane;
   private javax.swing.JPanel gamePanel;
   private javax.swing.JScrollPane humanInfoScrollPane;
   private javax.swing.JButton integrityChip;
   private javax.swing.JButton learningChip;
   private javax.swing.JButton moveButton;
   private javax.swing.JList moveList;
   private javax.swing.JScrollPane moveListWindow;
   private javax.swing.JButton playCardButton;
   private javax.swing.JLabel player1Label;
   private javax.swing.JLabel player2Label;
   private javax.swing.JLabel player3Label;
   private javax.swing.JTextArea playerInfo;
   // End of variables declaration//GEN-END:variables
}
