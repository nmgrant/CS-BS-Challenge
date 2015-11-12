package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card16 extends Card {

   public Card16() {
      image = new ImageIcon(("src/CardImagesYear1/LearningNetbeans.png"));

      name = "Learning Netbeans";
      locations.add(new Room("Lactation Lounge"));
      skillPointsPreReq = new SkillPoints(3, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      qualityPointsPenalty = -3;
      cardReward = 0;
      cardPenalty = 0;
   }

   public void playCard() {

   }
}
