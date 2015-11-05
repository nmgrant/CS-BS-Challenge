package Cards;

import main.SkillPoints;
import javax.swing.ImageIcon;

public class Card0 extends Card {
    
    public Card0() {
        name = "A New Laptop";
        location = "Computer Lab";
        skillRewardChoices = new SkillPoints[3];
        skillRewardChoices[0] = new SkillPoints(1, 0, 0);
        skillRewardChoices[1] = new SkillPoints(0, 1, 0);
        skillRewardChoices[2] = new SkillPoints(0, 0, 1);
        qualityPointsReward = 3;
        cardReward = 0;
        skillPenalty = new SkillPoints(0, 0, 0);
        qualityPointsPenalty = 0;
        cardPenalty = 1;
        image = new ImageIcon(("src/CardImages/Year1/ANewLaptop.png"));
    }
    
    public void playCard() {
        
    }
}
