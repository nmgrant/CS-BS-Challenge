package GameClasses;

import CardClasses.Card;
import java.util.LinkedList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.Action;

public class HandButton extends JButton {

   private LinkedList<Card> handOfCards;
   private Card currentCard;

   public HandButton() {
      super();
   }

   public HandButton(LinkedList<Card> hand) {
      super(hand.getFirst().getImage());
      handOfCards = hand;
      currentCard = handOfCards.getFirst();
   }

   public Card getCurrentCard() {
      return currentCard;
   }

   @Override
   public void addActionListener(ActionListener l) {
      super.addActionListener(l);
   }

   public void nextCard() {
      int next;
      int current = handOfCards.indexOf(currentCard);
      if (current == handOfCards.size() - 1) {
         next = 0;
      } else {
         next = current + 1;
      }
      setIcon(handOfCards.get(next).getImage());
      currentCard = handOfCards.get(next);
   }
   
   public void drawCard() {
       currentCard = handOfCards.getFirst();
       setIcon(currentCard.getImage());
   }
}
