package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class EnjoyingNature extends Card {

   public EnjoyingNature() {
      image = new ImageIcon(("src/CardImagesYear1/EnjoyingNature.png"));

      cardName = "Enjoying Nature";
      locations.add(new Room("George Allen Field", 0));
      locations.add(new Room("Japanese Garden", 1));
      locations.add(new Room("The Pyramid", 3));
      locations.add(new Room("Student Parking", 2));
      locations.add(new Room("Rec Center", 5));
      locations.add(new Room("Forbidden Parking", 6));
      locations.add(new Room("West Walkway", 4));
      locations.add(new Room("Library", 7));
      locations.add(new Room("LA 5", 8));
      locations.add(new Room("Bratwurst Hall", 9));
      locations.add(new Room("East Walkway", 10));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 1, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         reward = new Reward(new SkillPoints(0, 1, 0), 0, 0, new Room("Lactation Lounge", 20));
         return true;
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
