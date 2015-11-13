package CardClasses;

import GameClass.Player;
import GameClass.Room;
import GameClass.SkillPoints;
import javax.swing.ImageIcon;

public class Card32 extends Card {

   public Card32() {
      image = new ImageIcon(("src/CardImagesYear1/ProgramCrashes.png"));

      name = "Program Crashes";
      locations.add(new Room("Lactation Lounge"));
      skillPointsPreReq = new SkillPoints(2, 0, 0); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
      skillReward = new SkillPoints(0, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 5;
      qualityPointsPenalty = 0;
      cardReward = 0;
      cardPenalty = -1;
   }

   @Override
    void playCard(Player cPlayer) {
        
    }
}
