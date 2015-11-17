package GameClasses;

import CardClasses.Card;
import java.awt.Point;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.LinkedList;

public class Player extends JLabel {

   private final int MAX_MOVES = 3;
   private String name;
   private SkillPoints skillPoints;
   private int qualityPoints;
   private int numOfRemovedCards;
   private LinkedList<Card> handOfCards;
   private Room room;
   private boolean human, current;
   private boolean handIsFull, hasDiscardedCard;
   private ArrayList<Card> discardedCards;
   private ArrayList<Room> possibleRooms;
   private int moves;
   private Point space;

   public Player(String name, SkillPoints skillPoints, Room room) {
      this.name = name;
      this.skillPoints = skillPoints;
      qualityPoints = 0;
      numOfRemovedCards = 0;
      this.room = room;
      human = false;
      moves = MAX_MOVES;
      current = false;
      hasDiscardedCard = false;
      discardedCards = null;
      handIsFull = false;
      handOfCards = new LinkedList<>();
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
   
   public int getQualityPoints() {
       return qualityPoints;
   }

   public void setSkillPoints(SkillPoints skillPoints) {
      this.skillPoints = skillPoints;
   }

   public void adjustQualityPoints(int qualityPoints) {
      this.qualityPoints += qualityPoints;
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
         handOfCards.addFirst(card);
      }
   }

   public boolean hasDiscardedCard() {
       return hasDiscardedCard;
   }
   
   public ArrayList<Card> getDiscardedCard() {
       return discardedCards;
   }
   
   public void discardCard(Card card) {
       handOfCards.remove(card);
       discardedCards.add(card);
       hasDiscardedCard = true;
   }

   public LinkedList<Card> getHand() {
      return handOfCards;
   }

   public boolean handIsFull() {
      return handIsFull;
   }

   public void changeCurrent() {
      current = !current;
   }
}
