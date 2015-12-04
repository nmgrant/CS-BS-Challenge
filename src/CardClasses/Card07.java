package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card07 extends Card {

   public Card07() {
      image = new ImageIcon(("src/CardImagesYear1/PHIL270.png"));

      cardName = "PHIL 270";
      locations.add(new Room("The Pyramid", 3));
      locations.add(new Room("Rec Center", 5));
      locations.add(new Room("Library", 7));
      locations.add(new Room("LA 5", 8));
      locations.add(new Room("Bratwurst Hall", 9));
      skillPointsPreReq = new SkillPoints(6, 0, 0);
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
            reward = new Reward(new SkillPoints(0, 1, 1), 0, 0, null);
            return true;
         } else {
            penalty = new Penalty(new SkillPoints(-2, 0, 0), 0, null, new Room("Lactation Lounge", 20));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
