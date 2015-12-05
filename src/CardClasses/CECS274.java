package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class CECS274 extends Card {

   public CECS274() {
      image = new ImageIcon(("src/CardImagesYear2/CECS274.png"));

      cardName = "CECS 274";
      locations.add(new Room("ECS 302", 14));
      locations.add(new Room("ECS 308", 17));
      locations.add(new Room("Computer Lab", 11));
      skillPointsPreReq = new SkillPoints(7, 0, 0); // LCI
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
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 5, 1, null);
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
