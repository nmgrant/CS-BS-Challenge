package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class ParkingViolation extends Card {

    public ParkingViolation() {
        image = new ImageIcon(("src/CardImagesYear1/ParkingViolation.png"));

        cardName = "Parking Violation";
        locations.add(new Room("Forbidden Parking", 6));
        skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
        skillRewardChoices = null;
//        skillReward = new SkillPoints(1, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 0;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 0;
    }

    @Override
    public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            reward = new Reward(new SkillPoints(2, 0, 0), 0, -1, null);
            Card chosenCard;
            if (cPlayer.isHuman()) {
                DiscardCardDialog discardCardDialog = new DiscardCardDialog();
                chosenCard = discardCardDialog.showDiscardCardDialog(cPlayer.getHand(), this);
            } else {
                Random rand = new Random();
                int randomCard = rand.nextInt(cPlayer.getHand().size());
                chosenCard = cPlayer.getHand().get(randomCard);
            }
            reward.setTradeInCard(chosenCard);
            return true;
        } else {
            penalty = new Penalty();
            return false;
        }
    }
}
