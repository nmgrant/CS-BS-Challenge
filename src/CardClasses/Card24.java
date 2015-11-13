package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card24 extends Card {

   public Card24() {
      image = new ImageIcon(("src/CardImagesYear1/OralCommunication.png"));

      name = "Oral Communication";
      locations.add(new Room("The Pyramid"));
      locations.add(new Room("Rec Center"));
      locations.add(new Room("Library"));
      locations.add(new Room("LA 5"));
      locations.add(new Room("Bratwurst Hall"));
      skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 4;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = -1;
   }

   @Override
    void playCard(Player cPlayer) {
        
    }
}
