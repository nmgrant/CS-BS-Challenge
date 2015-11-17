package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class Card20 extends Card {

    public Card20() {
        image = new ImageIcon(("src/CardImagesYear1/MATH123.png"));

        cardName = "Math 123";
        locations.add(new Room("ECS 302", 14));
        locations.add(new Room("ECS 308", 17));
        skillPointsPreReq = new SkillPoints(5, 0, 0); // LCI
        skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = -3;
//        cardReward = 0;
//        cardPenalty = -1;
    }

    @Override
    public boolean playCard(Player cPlayer) {
        if (locations.contains(cPlayer.getRoom())) {
            if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
                reward = new Reward(null, 5, 0, null);
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
                penalty = new Penalty(null, -3, new Card[]{chosenCard}, null);
                return false;
            }
        } else {
            penalty = new Penalty();
            return false;
        }
    }
}
