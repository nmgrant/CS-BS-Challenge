package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card29 extends Card {

   public Card29() {
      image = new ImageIcon(("src/CardImagesYear1/ProfMurgoloCECS174.png"));

      cardName = "Professor Murgolo's CECS 174 Class";
      locations.add(new Room("ECS 302", 14));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
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
         reward = new Reward(new SkillPoints(1, 0, 0), 0, 0, null);
         return true;
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
