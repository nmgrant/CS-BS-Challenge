package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card06 extends Card {

   public Card06() {
      image = new ImageIcon(("src/CardImagesYear1/ElectiveClass.png"));

      cardName = "Elective Class";
      locations.add(new Room("Library"));
      skillPointsPreReq = new SkillPoints(2, 0, 0); // LCI
      skillRewardChoices = null;
      skillReward = new SkillPoints(1, 0, 0);
      skillPenalty = new SkillPoints(0, 0, 0);
      qualityPointsReward = 0;
      qualityPointsPenalty = -2;
      cardReward = 1;
      cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
                cPlayer.setSkillPoints(skillReward);
                return true;
            } else {
                cPlayer.adjustQualityPoints(qualityPointsPenalty);
                return false;
            }
        } else {
            cPlayer.adjustQualityPoints(ROOM_REQ_PENALTY);
            return false;
        }
   }
}
