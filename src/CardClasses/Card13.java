package CardClasses;

import GameClass.Player;
import GameClass.Room;
import GameClass.SkillPoints;
import javax.swing.ImageIcon;

public class Card13 extends Card {

   public Card13() {
      image = new ImageIcon(("src/CardImagesYear1/KIN253.png"));

      name = "KIN 253";
      locations.add(new Room("Goerge Allen Field"));
      skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 2, 0);
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
