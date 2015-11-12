package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card00 extends Card {

   public Card00() {
      image = new ImageIcon(("src/CardImagesYear1/ANewLaptop.png"));
      
      name = "A New Laptop";
      locations.add(new Room("Computer Lab"));
      skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 3;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = -1;
   }

   public void playCard() {

   }
}
