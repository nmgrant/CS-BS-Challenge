package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card18 extends Card {

    public Card18() {
        image = new ImageIcon(("src/CardImagesYear1/LunchAtBratwurstHall.png"));

        name = "Lunch at Bratwurst Hall";
        locations.add(new Room("Bratwurst Hall"));
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
    public void playCard(Player cPlayer) {

    }
}
