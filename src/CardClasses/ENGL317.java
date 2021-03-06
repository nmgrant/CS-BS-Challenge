package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class ENGL317 extends Card {

   public ENGL317() {
      image = new ImageIcon(("src/CardImagesYear2/ENGL317.png"));

      cardName = "ENGL 317";
      locations.add(new Room("LA 5", 8));
      skillPointsPreReq = new SkillPoints(0, 6, 0);
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 5, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, 0, null, new Room("Student Parking", 2));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
