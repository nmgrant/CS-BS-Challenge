package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card19 extends Card {

   public Card19() {
      image = new ImageIcon(("src/CardImagesYear1/MATH122.png"));

      cardName = "Math 122";
      locations.add(new Room("Library"));
      skillPointsPreReq = new SkillPoints(0, 0, 2); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 0, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
         SkillPoints choice = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
         reward = new Reward(choice, 0, 0, null);
         return true;
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
