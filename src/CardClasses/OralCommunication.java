package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class OralCommunication extends Card {

    public OralCommunication() {
        image = new ImageIcon(("src/CardImagesYear1/OralCommunication.png"));

        cardName = "Oral Communication";
        locations.add(new Room("The Pyramid", 3));
        locations.add(new Room("Rec Center", 5));
        locations.add(new Room("Library", 7));
        locations.add(new Room("LA 5", 8));
        locations.add(new Room("Bratwurst Hall", 9));
        skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 4;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = -1;
    }

    @Override
    public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
                SkillPoints chosenReward;
                if (cPlayer.isHuman()) {
                    RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
                    chosenReward = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
                } else {
                    Random rand = new Random();
                    int randomReward = rand.nextInt(skillRewardChoices.length);
                    chosenReward = new SkillPoints(randomReward);
                }
                reward = new Reward(chosenReward, 4, 0, null);
                return true;
            } else {
                Card chosenCard;
                if (cPlayer.isHuman()) {
                    DiscardCardDialog discardCardDialog = new DiscardCardDialog();
                    chosenCard = discardCardDialog.showDiscardCardDialog(cPlayer.getHand(), this);
                } else {
                    Random rand = new Random();
                    int randomCard = rand.nextInt(cPlayer.getHand().size());
                    chosenCard = cPlayer.getHand().get(randomCard);
                }
                penalty = new Penalty(null, 0, new Card[]{chosenCard}, null);
                return false;
            }
        } else {
            penalty = new Penalty();
            return false;
        }
    }
}
