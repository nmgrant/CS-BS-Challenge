package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class Card02 extends Card {

   public Card02() {
      image = new ImageIcon(("src/CardImagesYear2/CECS201.png"));

      cardName = "CECS 201";
      locations.add(new Room("ECS 302", 14));
      locations.add(new Room("ECS 308", 17));
      locations.add(new Room("Computer Lab", 11));
      skillPointsPreReq = new SkillPoints(0, 8, 0); // LCI
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
      Random rand = new Random();
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(new SkillPoints(1, 1, 1), 0, 0, null);
            return true;
         } else {
            Card chosenCard;
            if (cPlayer.isHuman()) {
               DiscardCardDialog discardCardDialog = new DiscardCardDialog();
               chosenCard = discardCardDialog.showDiscardCardDialog(cPlayer.getHand(), this);
            } else {
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
