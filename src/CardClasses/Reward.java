package CardClasses;

import GameClasses.SkillPoints;
import GameClasses.Room;
import java.io.Serializable;

public class Reward implements Serializable {

   private SkillPoints skill;
   private int qualityPoints;
   private int card;
   private Room room;
   private Card tradeInCard;

   public Reward(SkillPoints sRewards, int qpRewards, int cRewards,
   Room rRewards) {
      this.skill = sRewards;
      this.qualityPoints = qpRewards;
      this.card = cRewards;
      this.room = rRewards;
   }

   public SkillPoints getSkillReward() {
      return skill;
   }

   public int getQualityPointsReward() {
      return qualityPoints;
   }

   public int getCardReward() {
      return card;
   }

   public Room getRoomReward() {
      return room;
   }
   
   public Card getTradeInCard() {
       return tradeInCard;
   }
   
   public void setTradeInCard(Card card) {
       tradeInCard = card;
   }

}
