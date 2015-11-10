package Cards;

import main.SkillPoints;
import javax.swing.ImageIcon;
import main.Room;

public class Card00 extends Card {

   public Card00() {
      image = new ImageIcon(("src/CardImages/Year1/ANewLaptop.png"));
      
      name = "A New Laptop";
      locations.add(new Room("Computer Lab"));
      skillRewardChoices = new SkillPoints[3];
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 3;
      cardReward = 0;
      cardPenalty = -1;
      qualityPointsPenalty = 0;
   }

   public void playCard() {

   }
}
