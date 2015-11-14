package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card01 extends Card {

    public Card01() {
        image = new ImageIcon(("src/CardImagesYear1/BuddyUp.png"));

        name = "Buddy Up";
        locations.add(new Room("George Allen Field"));
        locations.add(new Room("EAT Club"));
        skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 0); // Integrity
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
