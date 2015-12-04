package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card06 extends Card {

   public Card06() {
      image = new ImageIcon(("src/CardImagesYear1/CECS282.png"));

      cardName = "CECS 282";
      locations.add(new Room("EAT Club", 18));
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
         if (cPlayer.getQualityPoints() == 30) {
            reward = new Reward(new SkillPoints(1, 1, 1), 0, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -5, null, new Room("Elevators", 16));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
