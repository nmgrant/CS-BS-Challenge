package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card09 extends Card {

    public Card09() {
        image = new ImageIcon(("src/CardImagesYear1/ExercisingMindAndBody.png"));

        name = "Exercising Mind and Body";
        locations.add(new Room("Rec Center"));
        skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 0, 1);
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
