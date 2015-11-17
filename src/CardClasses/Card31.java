package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card31 extends Card {

   public Card31() {
      image = new ImageIcon(("src/CardImagesYear1/ProfessorHoffman.png"));

      cardName = "Professor Hoffman";
      locations.add(new Room("Computer Lab", 11));
      locations.add(new Room("North Hall", 12));
      locations.add(new Room("Room of Retirement", 13));
      locations.add(new Room("ECS 302", 14));
      locations.add(new Room("Elevators", 16));
      locations.add(new Room("EAT Club", 17));
      locations.add(new Room("South Hall", 15));
      locations.add(new Room("ECS 308", 18));
      locations.add(new Room("CECS Conference Room", 19));
      skillPointsPreReq = new SkillPoints(3, 0, 0); // LCI
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
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 5, 2, null);
            return true;
         } else {
            penalty = new Penalty(null, -5, null, new Room("Lactation Lounge", 20));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
