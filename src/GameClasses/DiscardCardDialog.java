package GameClasses;

import CardClasses.Card;
import CardClasses.Card;
import CardClasses.CardButton;
import CardClasses.CardButton;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiscardCardDialog extends JDialog {

    private LinkedList<CardButton> cardButtons;
    private LinkedList<Card> handOfCards;

    public Card choice;

    public DiscardCardDialog() {
        super();
    }

    public Card showDiscardCardDialog(LinkedList<Card> handOfCards) {
        this.handOfCards = handOfCards;
        setTitle("Discard A Card");
        setLocation(0, 400);
        initializeComponents();
        
        setModal(true);
        pack();
        setVisible(true);

        return choice;
    }

    public void initializeComponents() {
        getContentPane().setLayout(new FlowLayout());
        cardButtons = new LinkedList<>();
        for (Card card : handOfCards) {
            cardButtons.add(new CardButton(card));
        }

        for (CardButton cardButton : cardButtons) {
            cardButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    choice = cardButton.getCard();
                    setVisible(false);
                    dispose();
                }
            });
            getContentPane().add(cardButton);
        }
    }
}
