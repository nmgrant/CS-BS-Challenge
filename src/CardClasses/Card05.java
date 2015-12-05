package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card05 extends Card {

   public Card05() {
      image = new ImageIcon(("src/CardImagesYear2/CECS285.png"));

      cardName = "CECS 285";
      locations.add(new Room("West Walkway", 4));
      locations.add(new Room("East Walkway", 10));
      skillPointsPreReq = new SkillPoints(0, 2, 0); // LCI
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
            reward = new Reward(null, 10, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, 0, null, new Room("George Allen Field", 0));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
