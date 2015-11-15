package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card31 extends Card {

    public Card31() {
        image = new ImageIcon(("src/CardImagesYear1/ProfessorHoffman.png"));

        name = "Professor Hoffman";
        locations.add(new Room("Computer Lab"));
        locations.add(new Room("North Hall"));
        locations.add(new Room("Room of Retirement"));
        locations.add(new Room("ECS 302"));
        locations.add(new Room("Elevators"));
        locations.add(new Room("EAT Club"));
        locations.add(new Room("South Hall"));
        locations.add(new Room("ECS 308"));
        locations.add(new Room("CECS Conference Room"));
        skillPointsPreReq = new SkillPoints(3, 0, 0); // LCI
        skillRewardChoices = null;
        skillReward = new SkillPoints(0, 0, 0);
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 5;
        qualityPointsPenalty = -5;
        cardReward = 2;
        cardPenalty = 0;
    }

    @Override
    public boolean playCard(Player cPlayer) {
return true;
    }
}
