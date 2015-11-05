package Cards;

import main.SkillPoints;
import javax.swing.ImageIcon;

public abstract class Card {
    protected String name;
    protected String location;
    protected SkillPoints[] skillRewardChoices;
    protected int qualityPointsReward;
    protected int cardReward;
    protected SkillPoints skillPenalty;
    protected int qualityPointsPenalty;
    protected int cardPenalty;
    protected ImageIcon image;
    
    abstract void playCard();
    
    public ImageIcon getImage() {
        return image;
    }
}
