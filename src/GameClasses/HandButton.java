
package GameClasses;
import CardClasses.Card;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.Action;

public class HandButton extends JButton {
    
    private ArrayList<Card> handOfCards;
    private Card currentCard;
    
    public HandButton() {}
    
    public HandButton(ArrayList<Card> hand) {
        super(hand.get(0).getImage());
        handOfCards = hand;
        currentCard = handOfCards.get(0);
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
        if (current == handOfCards.size() - 1)
            next = 0;
        else
            next = current + 1;
        this.setIcon(handOfCards.get(next).getImage());
        currentCard = handOfCards.get(next);
    }
}
