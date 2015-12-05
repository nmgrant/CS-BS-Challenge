package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card12 extends Card {

   public Card12() {
      image = new ImageIcon(("src/CardImagesYear2/AllNighter.png"));

      cardName = "All Nighter";
      locations.add(new Room("Library", 7));
      skillPointsPreReq = new SkillPoints(4, 4, 4); // LCI
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
            reward = new Reward(null, 15, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, -15, null, new Room("Room of Retirement", 13));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
