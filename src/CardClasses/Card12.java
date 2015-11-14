package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card12 extends Card {

    public Card12() {
        image = new ImageIcon(("src/CardImagesYear1/GoodbyeProfessor.png"));

        name = "Goodbye, Professor";
        locations.add(new Room("Room of Retirement"));
        skillPointsPreReq = new SkillPoints(6, 6, 6); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 0, 0);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 10;
        qualityPointsPenalty = 0;
        cardReward = 0;
        cardPenalty = -1;
    }

    @Override
    public void playCard(Player cPlayer) {

    }
}
