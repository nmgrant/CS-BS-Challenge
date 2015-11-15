
package CardClasses;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardButton extends JButton {
    
    private Card card;
    
    public CardButton(Card card) {
        super(card.getImage());
        this.card = card;
    }
    
    public Card getCard() {
        return card;
    }
    
    @Override
    public void addActionListener(ActionListener l) {
        super.addActionListener(l);
    }
}
