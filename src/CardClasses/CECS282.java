package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import java.util.Random;
import javax.swing.ImageIcon;

public class CECS282 extends Card {

   public CECS282() {
      image = new ImageIcon(("src/CardImagesYear2/CECS282.png"));

      cardName = "CECS 282";
      locations.add(new Room("Computer Lab", 11));
      locations.add(new Room("North Hall", 12));
      locations.add(new Room("Room of Retirement", 13));
      locations.add(new Room("ECS 302", 14));
      locations.add(new Room("Elevators", 16));
      locations.add(new Room("EAT Club", 17));
      locations.add(new Room("South Hall", 15));
      locations.add(new Room("ECS 308", 18));
      locations.add(new Room("CECS Conference Room", 19));
      locations.add(new Room("Lactation Lounge", 20));
      skillPointsPreReq = new SkillPoints(8, 8, 8); // LCI
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
            reward = new Reward(null, 5, 0, null);
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
            penalty = new Penalty(null, -2, new Card[]{chosenCard}, null);
            return false;
         }
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
