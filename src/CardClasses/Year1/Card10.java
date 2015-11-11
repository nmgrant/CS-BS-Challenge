package CardClasses.Year1;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card10 extends Card {

   public Card10() {
      image = new ImageIcon(("src/CardImages/Year1/FindingTheLab.png"));

      name = "Finding the Lab";
      locations.add(new Room("Elevators"));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 1);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      cardReward = 0;
      cardPenalty = 0;
      qualityPointsPenalty = 0;
   }

   public void playCard() {

   }
}
