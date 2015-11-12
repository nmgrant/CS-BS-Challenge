package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card34 extends Card {

   public Card34() {
      image = new ImageIcon(("src/CardImagesYear1/ScoreAGoal.png"));

      name = "Score a Goal!";
      locations.add(new Room("George Allen Field"));
      skillPointsPreReq = new SkillPoints(0, 3, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 1);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = 0;
   }

   public void playCard() {

   }
}
