package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class LearningNetbeans extends Card {

   public LearningNetbeans() {
      image = new ImageIcon(("src/CardImagesYear1/LearningNetbeans.png"));

      cardName = "Learning Netbeans";
      locations.add(new Room("Lactation Lounge", 20));
      skillPointsPreReq = new SkillPoints(3, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = -3;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(new SkillPoints(3, 0, 0), 5, 0, null);
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
