package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class GoodbyeProfessor extends Card {

   public GoodbyeProfessor() {
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
      Random rand = new Random();
      if (locations.contains(cPlayer.getRoom())) {
         if (cPlayer.getSkillPoints().equals(skillPointsPreReq)) {
            reward = new Reward(null, 10, 0, null);
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
            leaveCard = true;
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
