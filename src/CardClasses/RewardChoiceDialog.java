package CardClasses;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import GameClasses.SkillPoints;

/**
 *
 * @author Nicholas Grant
 */
public class RewardChoiceDialog extends JDialog {
    
    private final int LEARNING_BUTTON = 0;
    private final int CRAFT_BUTTON = 1;
    private final int INTEGRITY_BUTTON = 2;
    
    private JButton learningButton;
    private JButton craftButton;
    private JButton integrityButton;
    
    private final JButton[] buttons = 
     {learningButton, craftButton, integrityButton};
    
    private JLabel chooseReward;
    
    public RewardChoiceDialog(SkillPoints[] skillRewardChoices) {
        initializeComponents();
        enableButtons(skillRewardChoices);

//<editor-fold defaultstate="collapsed" desc="Set dialog layout">
        javax.swing.GroupLayout rewardChoiceDialogLayout = new javax.swing.GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(rewardChoiceDialogLayout);
        rewardChoiceDialogLayout.setHorizontalGroup(
                rewardChoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rewardChoiceDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(rewardChoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chooseReward)
                                .addGroup(rewardChoiceDialogLayout.createSequentialGroup()
                                        .addComponent(learningButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(integrityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(craftButton)
                        .addContainerGap(13, Short.MAX_VALUE))
        );
        rewardChoiceDialogLayout.setVerticalGroup(
                rewardChoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(rewardChoiceDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(chooseReward)
                        .addGap(11, 11, 11)
                        .addGroup(rewardChoiceDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(learningButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(integrityButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(craftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
//</editor-fold>

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        this.setModal(true);
    }
    
    private void enableButtons(SkillPoints[] skillRewardChoices) {
        for (int i = 0; i < skillRewardChoices.length; i++) {
            if (skillRewardChoices[i] == new SkillPoints(i)) {
                buttons[i].setEnabled(true);
            }
        }
    }
    private void initializeComponents() {
        learningButton = new JButton();
        craftButton = new JButton();
        integrityButton = new JButton();
        chooseReward = new JLabel();
        
        learningButton.setText("Learning Chip");
        learningButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                learningButtonActionPerformed(evt);
            }
        });
        
        craftButton.setText("Integrity Chip");
        craftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                craftButtonActionPerformed(evt);
            }
        });
        
        integrityButton.setText("Craft Chip");
        integrityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                integrityButtonActionPerformed(evt);
            }
        });
        chooseReward.setText("Choose your reward");
        
        learningButton.setEnabled(false);
        craftButton.setEnabled(false);
        integrityButton.setEnabled(false);
    }
    
    private SkillPoints learningButtonActionPerformed(ActionEvent evt) {
        return new SkillPoints(1, 0, 0);
    }
    
    private SkillPoints craftButtonActionPerformed(ActionEvent evt) {
        return new SkillPoints(0, 1, 0);
    }
    
    private SkillPoints integrityButtonActionPerformed(ActionEvent evt) {
        return new SkillPoints(0, 0, 1);
    }
}
