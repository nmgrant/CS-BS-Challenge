package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card19 extends Card {

    public Card19() {
        image = new ImageIcon(("src/CardImagesYear1/MATH122.png"));

        name = "Math 122";
        locations.add(new Room("Library"));
        skillPointsPreReq = new SkillPoints(0, 0, 2); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 0, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
        skillReward = new SkillPoints(0, 0, 0);
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
