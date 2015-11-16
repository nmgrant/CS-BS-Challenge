package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card33 extends Card {

    public Card33() {
        image = new ImageIcon(("src/CardImagesYear1/ResearchCompilers.png"));

        cardName = "Research Compilers";
        locations.add(new Room("Library"));
        skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(1, 0, 0);
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
