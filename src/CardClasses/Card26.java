package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card26 extends Card {

    public Card26() {
        image = new ImageIcon(("src/CardImagesYear1/PassSoccerClass.png"));

        name = "Pass Soccer Class";
        locations.add(new Room("George Allen Field"));
        skillPointsPreReq = new SkillPoints(0, 5, 0); // LCI
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
return true;
    }
}
