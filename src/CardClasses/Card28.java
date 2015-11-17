package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card28 extends Card {

   public Card28() {
      image = new ImageIcon(("src/CardImagesYear1/PressTheRightFloor.png"));

      cardName = "Press the Right Floor";
      locations.add(new Room("Elevators"));
      skillPointsPreReq = new SkillPoints(4, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 2, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = -2;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(new SkillPoints(0, 2, 0), 0, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -2, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
