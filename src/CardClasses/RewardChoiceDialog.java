package CardClasses;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import GameClasses.SkillPoints;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import sun.awt.AWTAccessor;

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

    private JButton[] buttons;

    private JLabel chooseReward;

    private SkillPoints choice;

    public RewardChoiceDialog(SkillPoints[] skillRewardChoices) {
        setTitle("Reward Choice");
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
                                        .addComponent(craftButton)))
                        .addGap(18, 18, 18)
                        .addComponent(integrityButton)
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        setModal(true);
        pack();
        setVisible(true);
    }

    private void enableButtons(SkillPoints[] skillRewardChoices) {
        for (int i = 0; i < skillRewardChoices.length; i++) {
            if (skillRewardChoices[i].equals(new SkillPoints(i))) {
                buttons[i].setEnabled(true);
            }
        }
    }

    private void initializeComponents() {
        learningButton = new JButton();
        craftButton = new JButton();
        integrityButton = new JButton();
        chooseReward = new JLabel();

        buttons = new JButton[3];
        buttons[LEARNING_BUTTON] = learningButton;
        buttons[CRAFT_BUTTON] = craftButton;
        buttons[INTEGRITY_BUTTON] = integrityButton;

        learningButton.setText("Learning");
        learningButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice = new SkillPoints(LEARNING_BUTTON);
                setVisible(false);
                dispose();
            }
        });

        craftButton.setText("Craft");
        craftButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice = new SkillPoints(CRAFT_BUTTON);
                setVisible(false);
                dispose();
            }
        });

        integrityButton.setText("Integrity");
        integrityButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choice = new SkillPoints(INTEGRITY_BUTTON);
                setVisible(false);
                dispose();
            }
        });
        chooseReward.setText("Choose your reward");

        learningButton.setEnabled(false);
        craftButton.setEnabled(false);
        integrityButton.setEnabled(false);

        getContentPane().add(learningButton);
        getContentPane().add(craftButton);
        getContentPane().add(integrityButton);
        getContentPane().add(chooseReward);
    }

    public SkillPoints getChoice() {
        return choice;
    }
}
