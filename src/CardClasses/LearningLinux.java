package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class LearningLinux extends Card {

   public LearningLinux() {
      image = new ImageIcon(("src/CardImagesYear1/LearningLinux.png"));

      cardName = "Learning Linux";
      locations.add(new Room("Computer Lab", 11));
      skillPointsPreReq = new SkillPoints(0, 2, 3); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
//        skillReward = new SkillPoints(0, 2, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 3;
//        qualityPointsPenalty = -1;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      Random rand = new Random();
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            SkillPoints chosenReward;
            if (cPlayer.isHuman()) {
               RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
               chosenReward = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
            } else {
               int randomReward = rand.nextInt(skillRewardChoices.length);
               chosenReward = new SkillPoints(randomReward);
            }
            reward = new Reward(chosenReward, 3, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -1, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
