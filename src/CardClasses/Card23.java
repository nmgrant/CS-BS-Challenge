package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card23 extends Card {

    public Card23() {
        image = new ImageIcon(("src/CardImagesYear1/MeetTheDean.png"));

        name = "Meet the Dean";
        locations.add(new Room("North Hall"));
        locations.add(new Room("South Hall"));
        skillPointsPreReq = new SkillPoints(3, 3, 3); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 0, 0);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 5;
        qualityPointsPenalty = 0;
        cardReward = 1;
        cardPenalty = -1;
    }

    @Override
    public boolean playCard(Player cPlayer) {
return true;
    }
}
