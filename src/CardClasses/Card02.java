package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card02 extends Card {

   public Card02() {
      image = new ImageIcon(("src/CardImagesYear1/CECS201.png"));

      cardName = "CECS 201";
      locations.add(new Room("ECS 302", 14));
      skillPointsPreReq = new SkillPoints(0, 3, 0); // LCI
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
            reward = new Reward(new SkillPoints(0, 2, 0), 0, 0, null);
            return true;
         } else {
            penalty = new Penalty(new SkillPoints(0, -1, 0), 0, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
