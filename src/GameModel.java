import java.util.Random;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Point;

public class GameModel {
    
    private Room[] rooms;
    private Player[] players;
    
    public class Room {
        
        private String name;
        private int locationNumber;
        private int[] adjacentRooms;
        
        public Room(String name, int locationNumber, 
         int[] adjacentRooms) {
            
            this.name = name;
            this.locationNumber = locationNumber;
            this.adjacentRooms = adjacentRooms; 
        }
        
        public int[] getAdjacentRooms() {
            return adjacentRooms;
        }
    }
    
    public GameModel() {
        initializeRooms();
        initializePlayers();
    }
    
    private void initializeRooms() {
        rooms = new Room[21];
        rooms[0] = new Room("George Allen Field", 0, new int[]{1, 3, 4, 5});
        rooms[1] = new Room("Japanese Garden", 0, new int[]{0, 2, 3});
        rooms[2] = new Room("Student Parking", 0, new int[]{1, 3, 5, 6});
        rooms[3] = new Room("The Pyramid", 0, new int[]{0, 1, 2, 5});
        rooms[4] = new Room("West Walkway", 0, new int[]{5, 7, 12});
        rooms[5] = new Room("Health Center", 0, new int[]{0, 2, 3, 4, 6});
        rooms[6] = new Room("Forbidden Parking", 0, new int[]{2, 10});
        rooms[7] = new Room("Library", 0, new int[]{4, 8});
        rooms[8] = new Room("LA 5", 0, new int[]{7, 9, 16});
        rooms[9] = new Room("Brotman Hall", 0, new int[]{10});
        rooms[10] = new Room("East Walkway", 0, new int[]{6, 9, 15});
        rooms[11] = new Room("Computer Lab", 0, new int[]{12});
        rooms[12] = new Room("North Hall", 0, new int[]{4, 11, 13, 14, 16});
        rooms[13] = new Room("Room of Retirement", 0, new int[]{12});
        rooms[14] = new Room("ECS 302", 0, new int[]{12, 15});
        rooms[15] = new Room("South Hall", 0, new int[]{10, 14, 17, 18, 19, 20});
        rooms[16] = new Room("Elevators", 0, new int[]{8, 12});
        rooms[17] = new Room("ECS 308", 0, new int[]{15});
        rooms[18] = new Room("EAT Club", 0, new int[]{15});
        rooms[19] = new Room("CECS Conference Room", 0, new int[]{15});
        rooms[20] = new Room("Lactation Room", 0, new int[]{20});
    }
    
    private void initializePlayers() {
        players = new Player[3];
        players[0] = new Player("Evan", new int[]{2, 2, 2});
        players[1] = new Player("Nick", new int[]{3, 1, 2});
        players[2] = new Player("Steven", new int[]{0, 3, 3});
        
        players[0].setLocation(new Point(840, 1400));
        players[1].setLocation(new Point(840, 1450));
        players[2].setLocation(new Point(840, 1500));
        
        Random rand = new Random();
        players[rand.nextInt(3)].setHuman();
    }
    
    public Room getRoom(int room) {
        return rooms[room];
    }
    
    public Player getPlayer(int player) {
        return players[player - 1];
    }
}
