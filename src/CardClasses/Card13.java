package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card13 extends Card {

    public Card13() {
        image = new ImageIcon(("src/CardImagesYear1/KIN253.png"));

        cardName = "KIN 253";
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
    public boolean playCard(Player cPlayer) {
return true;
    }
}
