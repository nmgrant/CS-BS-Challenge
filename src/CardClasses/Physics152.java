package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class Physics152 extends Card {

   public Physics152() {
      image = new ImageIcon(("src/CardImagesYear2/Physics152.png"));

      cardName = "Physics 152";
      locations.add(new Room("Library", 7));
      locations.add(new Room("LA 5", 8));
      skillPointsPreReq = new SkillPoints(0, 0, 7); // LCI
      skillRewardChoices = null;
//        skillReward = new SkillPoints(0, 0, 0);
//        skillPenalty = new SkillPoints(0, 0, 0);
//        qualityPointsReward = 5;
//        qualityPointsPenalty = -3;
//        cardReward = 0;
//        cardPenalty = 0;
   }

   @Override
   public boolean playCard(Player cPlayer) {
      Random rand = new Random();
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            SkillPoints chosenReward;
            if (cPlayer.isHuman()) {
               RewardChoiceDialog rewardChoiceDialog = new RewardChoiceDialog();
               chosenReward = rewardChoiceDialog.showRewardChoiceDialog(skillRewardChoices);
            } else {
               int randomReward = rand.nextInt(skillRewardChoices.length);
               chosenReward = new SkillPoints(randomReward);
            }
            reward = new Reward(chosenReward, 5, 0, null);
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
            penalty = new Penalty(null, 0, new Card[]{chosenCard}, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
