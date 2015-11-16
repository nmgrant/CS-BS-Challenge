package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card05 extends Card {

    public Card05() {
        image = new ImageIcon(("src/CardImages/Year1/ChoosingAMajor.png"));

        name = "Choosing a Major";
        locations.add(new Room("CECS Conference Room"));
        skillPointsPreReq = new SkillPoints(0, 0, 3); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 0, 0);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 5;
        qualityPointsPenalty = -3;
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
                cPlayer.adjustQualityPoints(qualityPointsPenalty);
                return false;
            }
        } else {
            cPlayer.adjustQualityPoints(ROOM_REQ_PENALTY);
            return false;
        }
    }
}
