package CardClasses;

import GameClasses.SkillPoints;

public class Penalties {

    private SkillPoints skillPenalty;
    private int qualityPointsPenalty;
    private int cardPenalty;
    private int roomPenalty;

    public Penalties(SkillPoints sPenalty) {
        
    }
    
    public SkillPoints getPenalty() {
        return skillPenalty;
    }

    public int getQualityPointsPenalty() {
        return qualityPointsPenalty;
    }

    public int getCardPenalty() {
        return cardPenalty;
    }

    public int getRoomPenalty() {
        return roomPenalty;
    }

}
