package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card23 extends Card {

   public Card23() {
      image = new ImageIcon(("src/CardImagesYear1/MeetTheDean.png"));

      cardName = "Meet the Dean";
      locations.add(new Room("North Hall", 12));
      locations.add(new Room("South Hall", 15));
      skillPointsPreReq = new SkillPoints(3, 3, 3); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = 0;
//        cardReward = 1;
//        cardPenalty = -1;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 5, 1, null);
            return true;
         } else {
            DiscardCardDialog discardCardDialog = new DiscardCardDialog();
            Card chosenCard = discardCardDialog.showDiscardCardDialog(cPlayer.getHand(), this);
            cPlayer.discardCard(chosenCard);
            penalty = new Penalty(null, 0, new Card[]{chosenCard}, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
