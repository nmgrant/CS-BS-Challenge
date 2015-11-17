package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Card {

   protected ImageIcon image;

   protected String cardName;
   protected ArrayList<Room> locations = new ArrayList<>();
   protected SkillPoints skillPointsPreReq;
   protected SkillPoints[] skillRewardChoices = new SkillPoints[3];
   protected Reward reward;
   protected Penalty penalty;

   protected boolean leaveCard = false;

   public abstract boolean playCard(Player cPlayer);

   public ImageIcon getImage() {
      return image;
   }

   public String getCardName() {
      return cardName;
   }

   public Reward getReward() {
      return reward;
   }

   public Penalty getPenalty() {
      return penalty;
   }

   public boolean isLeaveCard() {
      return leaveCard;
   }

   public ArrayList<Room> getLocations() {
      return locations;
   }
   
   public SkillPoints getskillPointsPreReq() {
       return skillPointsPreReq;
   }

   @Override
   public int hashCode() {
      int hash = 5;
      hash = 67 * hash + Objects.hashCode(this.image);
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Card other = (Card) obj;
      return Objects.equals(this.image, other.image);
   }
   
   @Override
   public String toString() {
       return cardName;
   }
}
