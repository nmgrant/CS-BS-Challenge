package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card08 extends Card {

   public Card08() {
      image = new ImageIcon(("src/CardImagesYear2/ENGL317.png"));

      cardName = "ENGL 317";
      locations.add(new Room("LA 5", 8));
      skillPointsPreReq = new SkillPoints(4, 0, 0);
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
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
            penalty = new Penalty(null, 0, null, new Room("Japanese Garden", 1));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
