package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class HaveASwim extends Card {

   public HaveASwim() {
      image = new ImageIcon(("src/CardImagesYear2/HaveASwim.png"));

      cardName = "HaveASwim";
      locations.add(new Room("Rec Center", 5));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = -5;
//        cardReward = 2;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      Random rand = new Random();
      if (locations.contains(cPlayer.getRoom())) {
         SkillPoints chosenReward;
         if (cPlayer.isHuman()) {
            RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
            chosenReward = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
         } else {
            int randomReward = rand.nextInt(skillRewardChoices.length);
            chosenReward = new SkillPoints(randomReward);
         }
         reward = new Reward(chosenReward, 0, 0, null);
         return true;
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
