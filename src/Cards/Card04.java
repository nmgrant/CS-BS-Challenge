package Cards;

import main.Room;
import main.SkillPoints;
import javax.swing.ImageIcon;

public class Card04 extends Card {

   public Card04() {
      image = new ImageIcon(("src/CardImages/Year1/CHEM111.png"));

      name = "CHEM 111";
      locations.add(new Room("George Allen Field"));
      locations.add(new Room("Japense Garden"));
      locations.add(new Room("Student Parking"));
      locations.add(new Room("The Pyramid"));
      locations.add(new Room("West Walkway"));
      locations.add(new Room("Rec Center"));
      locations.add(new Room("Forbidden Parking"));
      locations.add(new Room("Library"));
      locations.add(new Room("LA 5"));
      locations.add(new Room("Bratwurst Hall"));
      locations.add(new Room("Easy Walkway"));
      skillPointsPreReq = new SkillPoints(0, 6, 0);
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      cardReward = 0;
      cardPenalty = 0;
      qualityPointsPenalty = 0;
   }

   public void playCard() {

   }
}
