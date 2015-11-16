package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card36 extends Card {

    public Card36() {
        image = new ImageIcon(("src/CardImagesYear1/StudentParking.png"));

        cardName = "Student Parking";
        locations.add(new Room("Student Parking"));
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
    public boolean playCard(Player cPlayer) {
return true;
    }
}
