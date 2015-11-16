package CardClasses;

import GameClasses.SkillPoints;
import GameClasses.Room;

public class Reward {

    private SkillPoints skill;
    private int qualityPoints;
    private int card;
    private Room room;

    public Reward(SkillPoints skill, int qualityPoints, int card, Room room) {
        this.skill = skill;
        this.qualityPoints = qualityPoints;
        this.card = card;
        this.room = room;
    }

    public SkillPoints getSkillReward() {
        return skill;
    }

    public int getQualityPointsReward() {
        return qualityPoints;
    }

    public int getCardReward() {
        return card;
    }

    public Room getRoomReward() {
        return room;
    }

}
