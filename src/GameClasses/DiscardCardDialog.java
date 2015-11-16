package GameClasses;

import CardClasses.Card;
import CardClasses.CardButton;
import java.awt.GridLayout;
import javax.swing.JDialog;
import java.util.LinkedList;
import java.awt.Dimension;

public class DiscardCardDialog extends JDialog {

    private LinkedList<CardButton> cardButtons;
    private LinkedList<Card> handOfCards;

    public Card choice;
    public Card playedCard;

    public DiscardCardDialog() {
        super();
    }

    public Card showDiscardCardDialog(LinkedList<Card> handOfCards, Card playedCard) {
        this.handOfCards = handOfCards;
        this.playedCard = playedCard;
        setTitle("Discard A Card");
        setLocation(275, 100);
        setPreferredSize(new Dimension(630, 580));
        initializeComponents();
        
        setModal(true);
        pack();
        setVisible(true);

        return choice;
    }

    public void initializeComponents() {
        //JScrollPane scrollPane = new JScrollPane();
        getContentPane().setLayout(new GridLayout(2, 4));
        cardButtons = new LinkedList<>();
        for (Card card : handOfCards) {
            if (!card.equals(playedCard)) {
                cardButtons.add(new CardButton(card));
            }
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
        //getContentPane().add(scrollPane);
    }
}
