package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card03 extends Card {

   public Card03() {
      image = new ImageIcon(("src/CardImagesYear1/CECS105.png"));

      name = "CECS 105";
      locations.add(new Room("ECS 302"));
      locations.add(new Room("ECS 308"));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(1, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = 0;
   }

   @Override
    void playCard(Player cPlayer) {
        
    }
}
