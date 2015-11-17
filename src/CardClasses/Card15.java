package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card15 extends Card {

   public Card15() {
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
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
            SkillPoints choice = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
            reward = new Reward(choice, 3, 0, null);
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
