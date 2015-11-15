package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card22 extends Card {

    public Card22() {
        image = new ImageIcon(("src/CardImagesYear1/MakeDeanList.png"));

        name = "Make the Dean's List";
        locations.add(new Room("North Hall"));
        locations.add(new Room("South Hall"));
        skillPointsPreReq = new SkillPoints(6, 0, 0); // LCI
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
return true;
    }
}
