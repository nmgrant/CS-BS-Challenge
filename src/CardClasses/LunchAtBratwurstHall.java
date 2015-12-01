package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class LunchAtBratwurstHall extends Card {

   public LunchAtBratwurstHall() {
      image = new ImageIcon(("src/CardImagesYear1/LunchAtBratwurstHall.png"));

      cardName = "Lunch at Bratwurst Hall";
      locations.add(new Room("Bratwurst Hall", 9));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 1, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         reward = new Reward(new SkillPoints(0, 1, 0), 0, 0, null);
         return true;
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
