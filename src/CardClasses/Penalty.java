package CardClasses;

import GameClasses.Room;
import GameClasses.SkillPoints;

public class Penalty {
   
   private final int ROOM_REQ_PENALTY = -2;

   private SkillPoints skillPoints;
   private int qualityPoints;
   private int card;
   private Room room;

   public Penalty() {
      qualityPoints = ROOM_REQ_PENALTY;
   }
   
   public Penalty(SkillPoints sPenalty, int qpPenalty,
   int cPenalty, Room rPenalty) {
      this.skillPoints = sPenalty;
      this.qualityPoints = qpPenalty;
      this.card = cPenalty;
      this.room = rPenalty;
   }

   public SkillPoints getPenalty() {
      return skillPoints;
   }

   public int getQualityPointsPenalty() {
      return qualityPoints;
   }

   public int getCardPenalty() {
      return card;
   }

   public Room getRoomPenalty() {
      return room;
   }

}
