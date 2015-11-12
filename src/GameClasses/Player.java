package GameClasses;

import CardClasses.Card;
import java.awt.Point;
import javax.swing.JLabel;
import java.util.ArrayList;

public class Player extends JLabel {

   private final int MAX_MOVES = 3;
   private String name;
   private SkillPoints skillPoints;
   private SkillPoints[] skillRewardChoices;
   private int qualityPoints;
   private ArrayList<Card> handOfCards;
   private Room room;
   private boolean human, current;
   private boolean handIsFull;
   private int moves;
   private Point space;

   public Player(String name, SkillPoints skillPoints, Room room) {
      this.name = name;
      this.skillPoints = skillPoints;
      qualityPoints = 0;
      this.room = room;
      human = false;
      moves = MAX_MOVES;
      current = false;
      handOfCards = new ArrayList<>();
   }

   public String getName() {
      return name;
   }

   @Override
   public String toString() {
      return name;
   }

   public Room getRoom() {
      return room;
   }

   public SkillPoints getSkillPoints() {
      return skillPoints;
   }
   
   public void setSkillPoints(SkillPoints skillPoints) {
      this.skillPoints = skillPoints;
   }
   
   public void setQualityPoints(int qualityPoints) {
      this.qualityPoints += qualityPoints;
   }
   
   public SkillPoints[] getSkillPointsRewardChoices() {
      return skillRewardChoices;
   }
   
   public void setSkillRewardChoices(SkillPoints[] skillRewardChoices) {
      this.skillRewardChoices = skillRewardChoices;
   }
   
   public int getMoves() {
      return moves;
   }

   public Point getSpace() {
      return space;
   }

   public boolean isHuman() {
      return human;
   }

   public boolean isCurrent() {
      return current;
   }

   public void decreaseMoves() {
      moves--;
   }

   public void resetMoves() {
      moves = MAX_MOVES;
   }

   public void setHuman() {
      this.human = true;
   }

   public void setRoom(Room room) {
      this.room = room;
   }

   public void setSpace(Point space) {
      this.space = space;
      room.setSpaceAvailability(space);
   }

   public void pickUpCard(Card card) {
      if (handOfCards.size() >= 7) {
         handIsFull = true;
      } else {
         handOfCards.add(card);
      }
   }

   public void setDiscardCard (Card card) {
      
   }
   
   public ArrayList<Card> getHand() {
      return handOfCards;
   }

   public boolean handIsFull() {
      return handIsFull;
   }

   public void changeCurrent() {
      current = !current;
   }
}
