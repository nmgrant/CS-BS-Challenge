
import java.util.Random;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Point;
import java.util.Map;
import java.util.SortedMap;

public class GameModel {

   private Room[] rooms;
   private Player[] players;
   private Player humanPlayer;
   private Player currentPlayer;
   private String[] cardImages;

   public GameModel() {
      initializeRooms();
      initializePlayers();
      initializeCardImages();
   }

   public class Player extends JLabel {

      private final int STARTING_ROOM = 17;
      private final int MAX_MOVES = 3;
      private String name;
      private int[] skillPoints;
      private int qualityPoints;
      private int room;
      private boolean human, current;
      private int moves;
      private Point space;

      public Player(String name, int[] skillPoints) {
         this.name = name;
         this.skillPoints = skillPoints;
         qualityPoints = 0;
         room = STARTING_ROOM;
         human = false;
         moves = MAX_MOVES;
         current = false;
      }

      public String getName() {
         return name;
      }

      public int getRoomNumber() {
         return room;
      }

      public int getMoves() {
         return moves;
      }

      public Point getSpace() {
         return space;
      }

      public boolean isHuman() {
         return human;
      }

      public boolean isCurrent() {
         return current;
      }

      public void decreaseMoves() {
         moves--;
      }

      public void resetMoves() {
         moves = MAX_MOVES;
      }

      public void setHuman() {
         this.human = true;
      }

      public void setRoom(int room) {
         this.room = room;
      }

      public void setSpace(Point space) {
         this.space = space;
      }

      public void changeCurrent() {
         current = !current;
      }
   }

   public class Room {

      private final int PIXEL_HEIGHT_MULTIPLIER = 50;
      private String name;
      private int locationNumber;
      private Room[] adjacentRooms;
      private Point[] roomSpaces;
      private boolean[] isSpaceAvailable = new boolean[3];

      public Room(String name, int locationNumber) {
         this.name = name;
         this.locationNumber = locationNumber;
      }

      public String getRoomName() {
         return name;
      }

      public int getRoomNumber() {
         return locationNumber;
      }

      public Room[] getAdjacentRooms() {
         return adjacentRooms;
      }

      public Point getRoomSpace(int space) {
         return roomSpaces[space];
      }

      public void setAdjacentRooms(Room[] adjacentRooms) {
         this.adjacentRooms = adjacentRooms;
      }

      public Point findAvailableSpace() {
         for (int i = 0; i < isSpaceAvailable.length; i++) {
            if (isSpaceAvailable[i]) {
               return roomSpaces[i];
            }
         }
         return null;
      }

      public void setSpaceAvailability(Point space) {
         for (int i = 0; i < roomSpaces.length; i++) {
            if (roomSpaces[i] == space) {
               isSpaceAvailable[i] = !isSpaceAvailable[i];
            }
         }
      }

      public void setRoomSpaces(int x, int y) {
         roomSpaces = new Point[3];
         for (int i = 0; i < roomSpaces.length; i++) {
            roomSpaces[i] = new Point(x, y + PIXEL_HEIGHT_MULTIPLIER * (i));
            isSpaceAvailable[i] = true;
         }
      }

      @Override
      public String toString() {
         return name;
      }
   }

   private void initializeRooms() {
      rooms = new Room[21];

      rooms[0] = new Room("George Allen Field", 0);
      rooms[0].setRoomSpaces(40, 90);

      rooms[1] = new Room("Japanese Garden", 1);
      rooms[1].setRoomSpaces(450, 50);

      rooms[2] = new Room("Student Parking", 2);
      rooms[2].setRoomSpaces(1050, 110);

      rooms[3] = new Room("The Pyramid", 3);
      rooms[3].setRoomSpaces(450, 300);

      rooms[4] = new Room("West Walkway", 4);
      rooms[4].setRoomSpaces(25, 660);

      rooms[5] = new Room("Rec Center", 5);
      rooms[5].setRoomSpaces(470, 570);

      rooms[6] = new Room("Forbidden Parking", 6);
      rooms[6].setRoomSpaces(1040, 570);

      rooms[7] = new Room("Library", 7);
      rooms[7].setRoomSpaces(50, 1740);

      rooms[8] = new Room("LA 5", 8);
      rooms[8].setRoomSpaces(500, 1800);

      rooms[9] = new Room("Brotman Hall", 9);
      rooms[9].setRoomSpaces(1180, 1700);

      rooms[10] = new Room("East Walkway", 10);
      rooms[10].setRoomSpaces(1470, 960);

      rooms[11] = new Room("Computer Lab", 11);
      rooms[11].setRoomSpaces(190, 890);

      rooms[12] = new Room("North Hall", 12);
      rooms[12].setRoomSpaces(190, 1150);

      rooms[13] = new Room("Room of Retirement", 13);
      rooms[13].setRoomSpaces(190, 1350);

      rooms[14] = new Room("ECS 302", 14);
      rooms[14].setRoomSpaces(610, 890);

      rooms[15] = new Room("South Hall", 15);
      rooms[15].setRoomSpaces(840, 1150);

      rooms[16] = new Room("Elevators", 16);
      rooms[16].setRoomSpaces(610, 1390);

      rooms[17] = new Room("ECS 308", 17);
      rooms[17].setRoomSpaces(840, 1370);

      rooms[18] = new Room("EAT Club", 18);
      rooms[18].setRoomSpaces(1040, 890);

      rooms[19] = new Room("CECS Conference Room", 19);
      rooms[19].setRoomSpaces(1260, 890);

      rooms[20] = new Room("Lactation Lounge", 20);
      rooms[20].setRoomSpaces(1230, 1420);

      rooms[0].setAdjacentRooms(new Room[]{rooms[1], rooms[3]});
      rooms[1].setAdjacentRooms(new Room[]{rooms[0], rooms[2], rooms[3]});
      rooms[2].setAdjacentRooms(new Room[]{rooms[1], rooms[3], rooms[5],
         rooms[6]});
      rooms[3].setAdjacentRooms(new Room[]{rooms[0], rooms[1], rooms[2],
         rooms[5]});
      rooms[4].setAdjacentRooms(new Room[]{rooms[5], rooms[7], rooms[12]});
      rooms[5].setAdjacentRooms(new Room[]{rooms[2], rooms[3], rooms[4],
         rooms[6]});
      rooms[6].setAdjacentRooms(new Room[]{rooms[2], rooms[5], rooms[10]});
      rooms[7].setAdjacentRooms(new Room[]{rooms[4], rooms[8]});
      rooms[8].setAdjacentRooms(new Room[]{rooms[7], rooms[9], rooms[16]});
      rooms[9].setAdjacentRooms(new Room[]{rooms[8], rooms[10]});
      rooms[10].setAdjacentRooms(new Room[]{rooms[6], rooms[9], rooms[15]});
      rooms[11].setAdjacentRooms(new Room[]{rooms[12]});
      rooms[12].setAdjacentRooms(new Room[]{rooms[4], rooms[11], rooms[13],
         rooms[14], rooms[15], rooms[16]});
      rooms[13].setAdjacentRooms(new Room[]{rooms[12]});
      rooms[14].setAdjacentRooms(new Room[]{rooms[12], rooms[15]});
      rooms[15].setAdjacentRooms(new Room[]{rooms[10], rooms[12], rooms[14],
         rooms[17], rooms[18], rooms[19], rooms[20]});
      rooms[16].setAdjacentRooms(new Room[]{rooms[8], rooms[12]});
      rooms[17].setAdjacentRooms(new Room[]{rooms[15]});
      rooms[18].setAdjacentRooms(new Room[]{rooms[15]});
      rooms[19].setAdjacentRooms(new Room[]{rooms[15]});
      rooms[20].setAdjacentRooms(new Room[]{rooms[15]});

   }

   private void initializePlayers() {
      players = new Player[3];
      players[0] = new Player("Evan", new int[]{2, 2, 2});
      players[1] = new Player("Nick", new int[]{3, 1, 2});
      players[2] = new Player("Steven", new int[]{0, 3, 3});

      players[0].setSpace(this.getRoom(17).getRoomSpace(0));
      getRoom(players[0].getRoomNumber()).setSpaceAvailability(players[0].getSpace());

      players[1].setSpace(this.getRoom(17).getRoomSpace(1));
      getRoom(players[1].getRoomNumber()).setSpaceAvailability(players[1].getSpace());

      players[2].setSpace(this.getRoom(17).getRoomSpace(2));
      getRoom(players[2].getRoomNumber()).setSpaceAvailability(players[2].getSpace());

      Random rand = new Random();
      int human = rand.nextInt(3);
      players[human].setHuman();

      humanPlayer = players[human];
      currentPlayer = humanPlayer;
      currentPlayer.changeCurrent();
   }

   public void initializeCardImages() {

   }

   public Room getRoom(int room) {
      return rooms[room];
   }

   public Player[] getPlayers() {
      return players;
   }

   public Player getHumanPlayer() {
      return humanPlayer;
   }

   public Player getCurrentPlayer() {
      return currentPlayer;
   }

   public void setCurrentPlayer(Player next) {
      currentPlayer = next;
   }
}
