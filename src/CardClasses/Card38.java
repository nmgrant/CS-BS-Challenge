package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class Card38 extends Card {

    public Card38() {
        image = new ImageIcon(("src/CardImagesYear1/TheOutpost.png"));

        cardName = "The Outpost";
        locations.add(new Room("George Allen Field", 0));
        locations.add(new Room("Japanese Garden", 1));
        locations.add(new Room("The Pyramid", 3));
        locations.add(new Room("Student Parking", 2));
        locations.add(new Room("Rec Center", 5));
        locations.add(new Room("West Walkway", 4));
        locations.add(new Room("Library", 7));
        locations.add(new Room("LA 5", 8));
        locations.add(new Room("Bratwurst Hall", 9));
        locations.add(new Room("East Walkway", 10));
        skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 0;
    }

    @Override
    public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            SkillPoints chosenReward;
            if (cPlayer.isHuman()) {
                RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
                chosenReward = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
            } else {
                Random rand = new Random();
                int randomReward = rand.nextInt(skillRewardChoices.length);
                chosenReward = new SkillPoints(randomReward);
            }
            reward = new Reward(chosenReward, 0, 0, null);
            return true;
        } else {
            penalty = new Penalty();
            return false;
        }
    }
}
