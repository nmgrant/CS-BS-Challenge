package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card04 extends Card {

   public Card04() {
      image = new ImageIcon(("src/CardImagesYear1/CECS228.png"));

      cardName = "CECS 228";
      locations.add(new Room("Computer Lab", 11));
      skillPointsPreReq = new SkillPoints(3, 0, 3); // LCI
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
            reward = new Reward(new SkillPoints(0, 1, 0), 0, 1, null);
            return true;
         } else {
            penalty = new Penalty(new SkillPoints(-1, 0, -1), 5, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
