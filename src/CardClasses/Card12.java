package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card12 extends Card {

   public Card12() {
      image = new ImageIcon(("src/CardImagesYear1/GoodbyeProfessor.png"));

      cardName = "Goodbye, Professor";
      locations.add(new Room("Room of Retirement", 13));
      skillPointsPreReq = new SkillPoints(6, 6, 6); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 10;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = -1;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 10, 0, null);
            return true;
         } else {
            DiscardCardDialog discardCardDialog = new DiscardCardDialog();
            Card chosenCard = discardCardDialog.showDiscardCardDialog(cPlayer.getHand(), this);
            cPlayer.discardCard(chosenCard);
            penalty = new Penalty(null, 0, new Card[]{chosenCard}, null);
            leaveCard = true;
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
