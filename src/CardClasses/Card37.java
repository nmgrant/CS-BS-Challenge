package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card37 extends Card {

   public Card37() {
      image = new ImageIcon(("src/CardImagesYear1/TheBigGame.png"));

      name = "The Big Game";
      locations.add(new Room("Pyramid"));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(0, 1, 0);
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
