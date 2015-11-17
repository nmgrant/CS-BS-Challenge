package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card24 extends Card {

   public Card24() {
      image = new ImageIcon(("src/CardImagesYear1/OralCommunication.png"));

      cardName = "Oral Communication";
      locations.add(new Room("The Pyramid"));
      locations.add(new Room("Rec Center"));
      locations.add(new Room("Library"));
      locations.add(new Room("LA 5"));
      locations.add(new Room("Bratwurst Hall"));
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
            RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
            SkillPoints choice = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
            reward = new Reward(choice, 4, 0, null);
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
