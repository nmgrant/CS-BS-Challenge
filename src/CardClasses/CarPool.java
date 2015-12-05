package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class CarPool extends Card {

   public CarPool() {
      image = new ImageIcon(("src/CardImagesYear2/CarPool.png"));

      cardName = "Car Pool";
      locations.add(new Room("Student Parking", 2));
      locations.add(new Room("Forbidden Parking", 6));
      skillPointsPreReq = new SkillPoints(0, 0, 5); // LCI
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
            reward = new Reward(null, 3, 1, null);
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
