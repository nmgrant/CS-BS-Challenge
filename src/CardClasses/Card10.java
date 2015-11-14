package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card10 extends Card {

    public Card10() {
        image = new ImageIcon(("src/CardImagesYear1/FallInThePond.png"));

        name = "Fall in the Pond";
        locations.add(new Room("Japense Garden"));
        skillPointsPreReq = new SkillPoints(3, 0, 0); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 1, 1);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 0;
        qualityPointsPenalty = 0;
        cardReward = 0;
        cardPenalty = 0;
    }

    @Override
    public void playCard(Player cPlayer) {

    }
}
