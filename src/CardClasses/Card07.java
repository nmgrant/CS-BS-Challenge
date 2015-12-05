package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card07 extends Card {

   public Card07() {
      image = new ImageIcon(("src/CardImagesYear2/PHIL270.png"));

      cardName = "PHIL 270";
      locations.add(new Room("Library", 7));
      locations.add(new Room("LA 5", 8));
      skillPointsPreReq = new SkillPoints(0, 0, 7);
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
            reward = new Reward(new SkillPoints(1, 0, 0), 3, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -3, null, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
