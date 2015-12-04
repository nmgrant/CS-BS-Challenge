package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;

public class Card10 extends Card {

   public Card10() {
      image = new ImageIcon(("src/CardImagesYear1/MeetUpWithAFriend.png"));

      cardName = "Meet Up With a Friend";
      locations.add(new Room("The Pyramid", 3));
      locations.add(new Room("Rec Center", 5));
      locations.add(new Room("Library", 7));
      locations.add(new Room("LA 5", 8));
      locations.add(new Room("Bratwurst Hall", 9));
      locations.add(new Room("Computer Lab", 11));
      locations.add(new Room("North Hall", 12));
      locations.add(new Room("Room of Retirement", 13));
      locations.add(new Room("ECS 302", 14));
      locations.add(new Room("South Hall", 15));
      locations.add(new Room("Elevators", 16));
      locations.add(new Room("ECS 308", 17));
      locations.add(new Room("EAT Club", 18));
      locations.add(new Room("CECS Conference Room", 19));
      locations.add(new Room("Lactation Lounge", 20));
      skillPointsPreReq = new SkillPoints(0, 0, 0); // LCI
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
      Room chosenPlayerRoomName;
      int chosenPlayerRoomNum;
      if (locations.contains(cPlayer.getRoom())) {
         reward = new Reward(null, 0, 0, null);
         return true;
      } else {
         penalty = new Penalty();
         return false;
      }
   }
}
