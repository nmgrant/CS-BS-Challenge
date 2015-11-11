package CardClasses.Year1;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card08 extends Card {

   public Card08() {
      image = new ImageIcon(("src/CardImages/Year1/EnjoyingThePeace.png"));

      name = "Enjoying the Peace";
      locations.add(new Room("Japense Garden"));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(1, 0, 1);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      cardReward = 0;
      cardPenalty = 0;
      qualityPointsPenalty = 0;
   }

   public void playCard() {

   }
}
