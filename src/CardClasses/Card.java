package CardClasses;

import GameClasses.Player;
import GameClasses.Room;
import GameClasses.SkillPoints;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Card {

    protected ImageIcon image;

    protected String name;
    protected ArrayList<Room> locations = new ArrayList<>();
    protected final int ROOM_REQ_PENALTY = -2;
    protected SkillPoints skillPointsPreReq;
    protected SkillPoints[] skillRewardChoices = new SkillPoints[3];
    protected SkillPoints skillReward;
    protected SkillPoints skillPenalty;
    protected int qualityPointsReward;
    protected int qualityPointsPenalty;
    protected int cardReward;
    protected int cardPenalty;
    protected Room teleportRoom;

    public abstract boolean playCard(Player cPlayer);

    public ImageIcon getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public SkillPoints getSkillReward() {
        return skillReward;
    }

    public int getQualityPointsReward() {
        return qualityPointsReward;
    }

    public int getCardReward() {
        return cardReward;
    }

    public Room getTeleportRoom() {
        return teleportRoom;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.image);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }
}
