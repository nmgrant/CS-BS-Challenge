
import java.awt.Point;
import javax.swing.JLabel;

public class Player extends JLabel {
        
    private final int STARTING_ROOM = 17;
    private final Point DEFAULT_LOCATION = new Point(840, 1400);
    private String name;
    private int[] skillPoints;
    private int qualityPoints;
    private int room;
    private boolean human;

    public Player(String name, int[] skillPoints) {
        this.name = name;
        this.skillPoints = skillPoints;
        qualityPoints = 0;
        room = STARTING_ROOM;
        human = false;
        setText(name);
        setLocation(DEFAULT_LOCATION);
    }
    
    public String getName() {
        return name;
    }
    
    public void setHuman() {
        this.human = true;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}