package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card35 extends Card {

   public Card35() {
      image = new ImageIcon(("src/CardImagesYear1/SoccerGoalie.png"));

      name = "Soccer Goalie";
      locations.add(new Room("George Allen Field"));
      skillPointsPreReq = new SkillPoints(3, 3, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      qualityPointsPenalty = 0;
      cardReward = 1;
      cardPenalty = 0;
   }

   public void playCard() {

   }
}
