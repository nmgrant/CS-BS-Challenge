package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card21 extends Card {

    public Card21() {
        image = new ImageIcon(("src/CardImagesYear1/MakeAFriend.png"));

        cardName = "Make a Friend";
        locations.add(new Room("North Hall"));
        locations.add(new Room("South Hall"));
        skillPointsPreReq = new SkillPoints(0, 0, 2); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
        skillReward = new SkillPoints(0, 0, 0);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 3;
        qualityPointsPenalty = 0;
        cardReward = 0;
        cardPenalty = -1;
    }

    @Override
    public boolean playCard(Player cPlayer) {
return true;
    }
}
