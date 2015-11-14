package GameClasses;

import java.awt.Point;
import java.util.Objects;

public class Room {

   private final int PIXEL_HEIGHT_MULTIPLIER = 50;
   private String name;
   private Room[] adjacentRooms;
   private Point[] roomSpaces;
   private boolean[] isSpaceAvailable = new boolean[3];

   public Room(String name) {
      this.name = name;
   }

   public String getRoomName() {
      return name;
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
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
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
        final Room other = (Room) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

   @Override
   public String toString() {
      return name;
   }
}
