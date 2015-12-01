package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class LoudBuzzing extends Card {

   public LoudBuzzing() {
      image = new ImageIcon(("src/CardImagesYear1/LoudBuzzing.png"));

      cardName = "Loud Buzzing";
      locations.add(new Room("EAT Club", 18));
      skillPointsPreReq = new SkillPoints(0, 3, 0); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = -2;
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
            penalty = new Penalty(null, -2, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
