package CardClasses;

import GameClass.Player;
import GameClass.Room;
import GameClass.SkillPoints;
import javax.swing.ImageIcon;

public class Card33 extends Card {

   public Card33() {
      image = new ImageIcon(("src/CardImagesYear1/ResearchCompilers.png"));

      name = "Research Compilers";
      locations.add(new Room("Library"));
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
