package Cards;

import main.Room;
import main.SkillPoints;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public abstract class Card {
   protected ImageIcon image;
   
   protected String name;
   protected ArrayList<Room> locations = new ArrayList<> ();
   protected final int ROOM_REQ_PENALTY = -2;
   protected SkillPoints skillPointsPreReq;
   protected SkillPoints[] skillRewardChoices;
   protected SkillPoints skillReward;
   protected SkillPoints skillPenalty;
   protected int qualityPointsReward;
   protected int qualityPointsPenalty;
   protected int cardReward;
   protected int cardPenalty;

   abstract void playCard();

   public ImageIcon getImage() {
      return image;
   }
}
