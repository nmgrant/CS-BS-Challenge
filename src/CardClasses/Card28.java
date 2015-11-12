package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card28 extends Card {

   public Card28() {
      image = new ImageIcon(("src/CardImagesYear1/PressTheRightFloor.png"));

      name = "Press the Right Floor";
      locations.add(new Room("Elevators"));
      skillPointsPreReq = new SkillPoints(4, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 2, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      qualityPointsPenalty = -2;
      cardReward = 0;
      cardPenalty = 0;
   }

   public void playCard() {

   }
}
