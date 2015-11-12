package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card30 extends Card {

   public Card30() {
      image = new ImageIcon(("src/CardImagesYear1/ProfessorEnglert.png"));

      name = "Professor Englert";
      locations.add(new Room("CECS Conference Room"));
      skillPointsPreReq = new SkillPoints(0, 0, 3); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = -1;
   }

   public void playCard() {

   }
}
