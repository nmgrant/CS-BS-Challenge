package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;
import java.util.ArrayList;

public abstract class Card {
   protected ImageIcon image;

   protected String name;
   protected ArrayList<Room> locations = new ArrayList<>();
   protected final int ROOM_REQ_PENALTY = -2;
   protected SkillPoints skillPointsPreReq;
   protected SkillPoints[] skillRewardChoices = new SkillPoints[3];
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
