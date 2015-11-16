package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import GameClasses.DiscardCardDialog;
import javax.swing.ImageIcon;

public class Card00 extends Card {

    public Card00() {
        image = new ImageIcon(("src/CardImagesYear1/ANewLaptop.png"));

        name = "A New Laptop";
        locations.add(new Room("Computer Lab"));
        skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
        skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
        skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
        skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsReward = 3;
        qualityPointsPenalty = 0;
        cardReward = 0;
        cardPenalty = 1;

    }

    @Override
    public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
                cPlayer.adjustQualityPoints(qualityPointsReward);
                RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
                SkillPoints reward = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
                cPlayer.setSkillPoints(reward);
                skillReward = reward;
                return true;
            } else {
                DiscardCardDialog discardCardDialog = new DiscardCardDialog();
                Card chosenCard = discardCardDialog.showDiscardCardDialog(cPlayer.getHand(), this);
                cPlayer.discardCard(chosenCard);
                return false;
            }
        } else {
            cPlayer.adjustQualityPoints(ROOM_REQ_PENALTY);
            return false;
        }
    }
}
