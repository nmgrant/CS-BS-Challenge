package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class CHEM111 extends Card {

   public CHEM111() {
      image = new ImageIcon(("src/CardImagesYear1/CHEM111.png"));

      cardName = "CHEM 111";
      locations.add(new Room("The Pyramid", 3));
      locations.add(new Room("Rec Center", 5));
      locations.add(new Room("Library", 7));
      locations.add(new Room("LA 5", 8));
      locations.add(new Room("Bratwurst Hall", 9));
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
