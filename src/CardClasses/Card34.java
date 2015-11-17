package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card34 extends Card {

   public Card34() {
      image = new ImageIcon(("src/CardImagesYear1/ScoreAGoal.png"));

      cardName = "Score a Goal!";
      locations.add(new Room("George Allen Field"));
      skillPointsPreReq = new SkillPoints(0, 3, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 1);
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
            reward = new Reward(new SkillPoints(0, 0, 1), 5, 0, null);
            return true;
         } else {
            penalty = new Penalty(null, 0, null, new Room("Student Parking"));
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
