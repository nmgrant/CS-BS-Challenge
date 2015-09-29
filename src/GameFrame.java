
import javax.swing.*;
import java.awt.Point;

public class GameFrame extends javax.swing.JFrame {
    
    private GameModel model;
  
    /**
     * Creates new form GameFrame
     */
    
    public GameFrame() {
        model = new GameModel();
        initComponents();
        BoardWindowPanel.remove(Player1);
        java.awt.Point player1 = Player1.getLocation();
        System.out.println(player1);
        System.out.println(Player1.getLocation());
        Player1.setLocation(new Point(800, 1400));
        System.out.println(Player1.getLocation());
        BoardWindowPanel.add(Player1);
        System.out.println(Player1.getLocation());
        BoardWindowPanel.repaint();
        System.out.println(Player1.getLocation());
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
        Player1 = model.getPlayer(1);
        jLabel1 = new javax.swing.JLabel();
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
        Move.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveActionPerformed(evt);
            }
        });

        BoardWindow.setAutoscrolls(true);

        Player1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        Player1.setForeground(new java.awt.Color(0, 153, 0));
        Player1.setText(Player1.getName()
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boardMap.png"))); // NOI18N

        javax.swing.GroupLayout BoardWindowPanelLayout = new javax.swing.GroupLayout(BoardWindowPanel);
        BoardWindowPanel.setLayout(BoardWindowPanelLayout);
        BoardWindowPanelLayout.setHorizontalGroup(
            BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoardWindowPanelLayout.createSequentialGroup()
                .addContainerGap(758, Short.MAX_VALUE)
                .addComponent(Player1)
                .addGap(626, 626, 626))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BoardWindowPanelLayout.setVerticalGroup(
            BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BoardWindowPanelLayout.createSequentialGroup()
                .addContainerGap(1224, Short.MAX_VALUE)
                .addComponent(Player1)
                .addGap(718, 718, 718))
            .addGroup(BoardWindowPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BoardWindowPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BoardWindowPanel.setLayer(Player1, javax.swing.JLayeredPane.DRAG_LAYER);
        BoardWindowPanel.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        BoardWindow.setViewportView(BoardWindowPanel);

        PlayCard.setText("Play Card");
        PlayCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayCardActionPerformed(evt);
            }
        });

        DrawCard.setText("Draw Card");

        MoveList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        MoveListWindow.setViewportView(MoveList);

        GameInfo.setText("jTextField1");
        GameInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameInfoActionPerformed(evt);
            }
        });

        Player.setText("jTextField2");

        Card.setIcon(new javax.swing.ImageIcon(getClass().getResource("/card.PNG"))); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GameInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                    .addComponent(Player))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void PlayCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayCardActionPerformed

    private void MoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveActionPerformed
        BoardWindowPanel.remove(Player1);
        Player1.setLocation(Player1.getLocation());
        BoardWindowPanel.add(Player1);
        
    }//GEN-LAST:event_MoveActionPerformed

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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameFrame().setVisible(true);
            }  
        });
    }
                
                
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel Player1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
