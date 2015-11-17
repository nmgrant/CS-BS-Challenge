package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card10 extends Card {

   public Card10() {
      image = new ImageIcon(("src/CardImagesYear1/FallInThePond.png"));

      cardName = "Fall in the Pond";
      locations.add(new Room("Japanese Garden", 1));
      skillPointsPreReq = new SkillPoints(3, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 1, 1);
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
            reward = new Reward(new SkillPoints(0, 1, 1), 0, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, 0, null, new Room("Lactation Lounge", 20));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
