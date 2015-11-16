package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card04 extends Card {

    public Card04() {
        image = new ImageIcon(("src/CardImagesYear1/CHEM111.png"));

        cardName = "CHEM 111";
        locations.add(new Room("The Pyramid"));
        locations.add(new Room("Rec Center"));
        locations.add(new Room("Library"));
        locations.add(new Room("LA 5"));
        locations.add(new Room("Bratwurst Hall"));
        skillPointsPreReq = new SkillPoints(0, 6, 0);
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 0, 0);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 5;
        qualityPointsPenalty = 0;
        cardReward = 0;
        cardPenalty = 0;
    }

    @Override
    public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
                cPlayer.adjustQualityPoints(qualityPointsReward);
                return true;
            } else {
                teleportRoom = new Room("Student Parking");
                return false;
            }
        } else {
            cPlayer.adjustQualityPoints(ROOM_REQ_PENALTY);
            return false;
        }
    }
}
