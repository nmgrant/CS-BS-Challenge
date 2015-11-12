package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card20 extends Card {

   public Card20() {
      image = new ImageIcon(("src/CardImagesYear1/MATH123.png"));

      name = "Math 123";
      locations.add(new Room("ECS 302"));
      locations.add(new Room("ECS 308"));
      skillPointsPreReq = new SkillPoints(5, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      qualityPointsPenalty = -3;
      cardReward = 0;
      cardPenalty = -1;
   }

   public void playCard() {

   }
}
