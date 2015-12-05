package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class CECS285 extends Card {

   public CECS285() {
      image = new ImageIcon(("src/CardImagesYear2/CECS285.png"));

      cardName = "CECS 285";
      locations.add(new Room("Japanese Garden", 1));
      locations.add(new Room("EAT Club", 18));
      skillPointsPreReq = new SkillPoints(6, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(1, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = 0;
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
            reward = new Reward(chosenReward, 5, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -3, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
