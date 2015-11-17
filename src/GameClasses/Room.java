package GameClasses;

import CardClasses.Card;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Objects;

public class Room {

    private final int PIXEL_HEIGHT_MULTIPLIER = 50;
    private String name;
    private int[] adjacentRooms;
    private int roomNumber;
    private Point[] roomSpaces;
    private boolean[] isSpaceAvailable = new boolean[3];
    private ArrayList<Card> roomCards;

    public Room(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
        roomCards = new ArrayList<>();
        initializeRoomProperties();
    }

    public String getRoomName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public ArrayList<Card> getRoomCards() {
       return roomCards;
    }
    
    public void placeCardInRoom(Card playedCard) {
       roomCards.add(playedCard);
    }
    
    public Card pickUpCardInRoom() {
       return roomCards.remove(0);
    }
    
    public int[] getAdjacentRooms() {
        return adjacentRooms;
    }

    public Point getRoomSpace(int space) {
        return roomSpaces[space];
    }

    public void setAdjacentRooms(int[] adjacentRooms) {
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

    public void initializeRoomProperties() {
        switch (roomNumber) {
            case 0:
                setRoomSpaces(70, 90);
                setAdjacentRooms(new int[]{1, 3});
                break;
            case 1:
                setRoomSpaces(450, 35);
                setAdjacentRooms(new int[]{0, 2, 3});
                break;
            case 2:
                setRoomSpaces(1050, 90);
                setAdjacentRooms(new int[]{1, 3, 5, 6});
                break;
            case 3:
                setRoomSpaces(450, 280);
                setAdjacentRooms(new int[]{0, 1, 2, 5});
                break;
            case 4:
                setRoomSpaces(70, 660);
                setAdjacentRooms(new int[]{5, 7, 12});
                break;
            case 5:
                setRoomSpaces(470, 570);
                setAdjacentRooms(new int[]{2, 3, 4, 6});
                break;
            case 6:
                setRoomSpaces(1040, 570);
                setAdjacentRooms(new int[]{2, 5, 10});
                break;
            case 7:
                setRoomSpaces(70, 1740);
                setAdjacentRooms(new int[]{4, 8});
                break;
            case 8:
                setRoomSpaces(500, 1800);
                setAdjacentRooms(new int[]{7, 9, 16});
                break;
            case 9:
                setRoomSpaces(1180, 1700);
                setAdjacentRooms(new int[]{8, 10});
                break;
            case 10:
                setRoomSpaces(1470, 960);
                setAdjacentRooms(new int[]{6, 9, 15});
                break;
            case 11:
                setRoomSpaces(190, 890);
                setAdjacentRooms(new int[]{12});
                break;
            case 12:
                setRoomSpaces(190, 1150);
                setAdjacentRooms(new int[]{4, 11, 13, 14, 15, 16});
                break;
            case 13:
                setRoomSpaces(190, 1350);
                setAdjacentRooms(new int[]{12});
                break;
            case 14:
                setRoomSpaces(610, 890);
                setAdjacentRooms(new int[]{12, 15});
                break;
            case 15:
                setRoomSpaces(840, 1150);
                setAdjacentRooms(new int[]{10, 12, 14, 17, 18, 19, 20});
                break;
            case 16:
                setRoomSpaces(610, 1390);
                setAdjacentRooms(new int[]{8, 12});
                break;
            case 17:
                setRoomSpaces(840, 1370);
                setAdjacentRooms(new int[]{15});
                break;
            case 18:
                setRoomSpaces(1040, 890);
                setAdjacentRooms(new int[]{15});
                break;
            case 19:
                setRoomSpaces(1260, 890);
                setAdjacentRooms(new int[]{15});
                break;
            case 20:
                setRoomSpaces(1230, 1420);
                setAdjacentRooms(new int[]{15});
                break;
        }
    }
}
