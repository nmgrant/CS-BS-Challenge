package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;
import java.io.Serializable;

public class Penalty implements Serializable {

   private final int ROOM_REQ_PENALTY = -2;

   private SkillPoints skillPoints;
   private int qualityPoints;
   private Card[] card;
   private Room room;

   public Penalty() {
      qualityPoints = ROOM_REQ_PENALTY;
   }

   public Penalty(SkillPoints sPenalty, int qpPenalty, Card[] cPenalty,
      Room rPenalty) {
      this.skillPoints = sPenalty;
      this.qualityPoints = qpPenalty;
      this.card = cPenalty;
      this.room = rPenalty;
   }

   public SkillPoints getSkillPenalty() {
      return skillPoints;
   }

   public int getQualityPointsPenalty() {
      return qualityPoints;
   }

   public Card[] getCardPenalty() {
      return card;
   }

   public Room getRoomPenalty() {
      return room;
   }

   public boolean checkLeaveCard(Card playedCard) {
      return playedCard.isLeaveCard();
   }
}
