package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card00 extends Card {

   public Card00() {
      image = new ImageIcon(("src/CardImagesYear1/ANewLaptop.png"));

      cardName = "A New Laptop";
      locations.add(new Room("Computer Lab"));
      skillPointsPreReq = new SkillPoints(0, 0, 4); // LCI
      skillRewardChoices[0] = new SkillPoints(1, 0, 0); // Learning 
      skillRewardChoices[1] = new SkillPoints(0, 1, 0); // Craft
      skillRewardChoices[2] = new SkillPoints(0, 0, 1); // Integrity
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 3;
//        qualityPointsPenalty = 0;
//        cardReward = 0;
//        cardPenalty = 1;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
            SkillPoints choice = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
            reward = new Reward(choice, 3, 0, null);
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
