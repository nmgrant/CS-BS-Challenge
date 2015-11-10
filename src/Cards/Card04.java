package Cards;

import main.SkillPoints;
import javax.swing.ImageIcon;
import main.Room;

public class Card04 extends Card {

   public Card04() {
      image = new ImageIcon(("src/CardImages/Year1/CHEM111.png"));

      name = "CHEM 111";
      locations.add(new Room("ECS 302"));
      locations.add(new Room("ECS 308"));
      skillRewardChoices = null;
      skillReward = new SkillPoints(1, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      cardReward = 0;
      cardPenalty = 0;
      qualityPointsPenalty = 0;
   }

   public void playCard() {

   }
}
