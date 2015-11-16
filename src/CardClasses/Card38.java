package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card38 extends Card {

    public Card38() {
        image = new ImageIcon(("src/CardImagesYear1/TheOutpost.png"));

        cardName = "The Outpost";
        locations.add(new Room("George Allen Field"));
        locations.add(new Room("Japense Garden"));
        locations.add(new Room("The Pyramid"));
        locations.add(new Room("Student Parking"));
        locations.add(new Room("Rec Center"));
        locations.add(new Room("West Walkway"));
        locations.add(new Room("Library"));
        locations.add(new Room("LA 5"));
        locations.add(new Room("Bratwurst Hall"));
        locations.add(new Room("Easy Walkway"));
        skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
        skillReward = new SkillPoints(0, 0, 0);
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
