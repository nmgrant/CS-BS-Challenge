package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card35 extends Card {

   public Card35() {
      image = new ImageIcon(("src/CardImagesYear1/SoccerGoalie.png"));

      cardName = "Soccer Goalie";
      locations.add(new Room("George Allen Field", 0));
      skillPointsPreReq = new SkillPoints(3, 3, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = 0;
//        cardReward = 1;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 5, 1, null);
            return true;
         } else {
            penalty = new Penalty(null, 0, null, new Room("Student Parking", 20));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
