package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card08 extends Card {

   public Card08() {
      image = new ImageIcon(("src/CardImagesYear1/EnjoyingThePeace.png"));

      name = "Enjoying the Peace";
      locations.add(new Room("Japense Garden"));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 0, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = 0;
   }

   public void playCard() {

   }
}
