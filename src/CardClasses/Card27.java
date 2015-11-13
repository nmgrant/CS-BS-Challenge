package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card27 extends Card {

   public Card27() {
      image = new ImageIcon(("src/CardImagesYear1/Physics151.png"));

      name = "Physics 151";
      locations.add(new Room("ECS 308"));
      skillPointsPreReq = new SkillPoints(0, 3, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      qualityPointsPenalty = -3;
      cardReward = 0;
      cardPenalty = 0;
   }

   @Override
    void playCard(Player cPlayer) {
        
    }
}
