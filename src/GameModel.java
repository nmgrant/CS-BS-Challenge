
public class GameModel {
    
    private Room[] rooms;
    
    private class Room {
        
        private String name;
        private int locationNumber;
        private int[] adjacentRooms;
        
        public Room(String name, int locationNumber, 
         int[] adjacentRooms) {
            
            this.name = name;
            this.locationNumber = locationNumber;
            this.adjacentRooms = adjacentRooms;
            
        }
        
    }
    
    public GameModel() {
        initializeRoomArray();
    }
    
    private void initializeRoomArray() {
        rooms = new Room[20];
        rooms[0] = new Room("George Allen Field", 0, new int[]{1, 3, 4, 5});
    }
}
