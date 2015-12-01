package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class MakeDeanList extends Card {

   public MakeDeanList() {
      image = new ImageIcon(("src/CardImagesYear1/MakeDeanList.png"));

      cardName = "Make the Dean's List";
      locations.add(new Room("North Hall", 12));
      locations.add(new Room("South Hall", 15));
      skillPointsPreReq = new SkillPoints(6, 0, 0); // LCI
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
