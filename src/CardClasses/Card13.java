package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card13 extends Card {

   public Card13() {
      image = new ImageIcon(("src/CardImagesYear1/KIN253.png"));

      cardName = "KIN 253";
      locations.add(new Room("Goerge Allen Field", 0));
      skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 2, 0);
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
            penalty = new Penalty(null, 0, null, new Room("Room of Retirement", 13));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
