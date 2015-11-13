package CardClasses;

import GameClass.Player;
import GameClass.Room;
import GameClass.SkillPoints;
import javax.swing.ImageIcon;

public class Card14 extends Card {

   public Card14() {
      image = new ImageIcon(("src/CardImagesYear1/LateForClass.png"));

      name = "Late for Class";
      locations.add(new Room("George Allen Field"));
      locations.add(new Room("Japense Garden"));
      locations.add(new Room("The Pyramid"));
      locations.add(new Room("Student Parking"));
      locations.add(new Room("Rec Center"));
      locations.add(new Room("West Walkway"));
      locations.add(new Room("Library"));
      locations.add(new Room("LA 5"));
      locations.add(new Room("Bratwurst Hall"));
      locations.add(new Room("Easy Walkway"));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 1, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = 0;
   }

    @Override
    void playCard(Player cPlayer) {
        
    }
}
