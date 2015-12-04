package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card09 extends Card {

   public Card09() {
      image = new ImageIcon(("src/CardImagesYear1/Physics152.png"));

      cardName = "Physics 152";
      locations.add(new Room("ECS 302", 14));
      skillPointsPreReq = new SkillPoints(2, 4, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = -3;
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
            penalty = new Penalty(null, -5, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
