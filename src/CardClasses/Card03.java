package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class Card03 extends Card {

   public Card03() {
      image = new ImageIcon(("src/CardImagesYear1/CECS277.png"));

      cardName = "CECS 277";
      locations.add(new Room("ECS 308", 14));
      skillPointsPreReq = new SkillPoints(5, 0, 0); // LCI
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
            reward = new Reward(chosenReward, 3, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -5, null, new Room("Computer Lab", 11));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
