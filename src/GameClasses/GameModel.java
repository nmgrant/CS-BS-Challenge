package GameClasses;

import CardClasses.Card;
import CardClasses.Card00;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Point;
import java.util.Map;
import java.util.SortedMap;
import java.util.Collections;

public class GameModel {

    private Room[] rooms;
    private Player[] players;
    private Player humanPlayer;
    private Player currentPlayer;
    private ArrayList<Card> deckOfCards;
    private ArrayList<Card> discardDeck;

    public GameModel() {
        initializeRooms();
        initializeCards();
        initializePlayers();
    }

    private void initializeRooms() {
        rooms = new Room[21];

        rooms[0] = new Room("George Allen Field");
        rooms[0].setRoomSpaces(70, 90);

        rooms[1] = new Room("Japanese Garden");
        rooms[1].setRoomSpaces(450, 35);

        rooms[2] = new Room("Student Parking");
        rooms[2].setRoomSpaces(1050, 90);

        rooms[3] = new Room("The Pyramid");
        rooms[3].setRoomSpaces(450, 280);

        rooms[4] = new Room("West Walkway");
        rooms[4].setRoomSpaces(70, 660);

        rooms[5] = new Room("Rec Center");
        rooms[5].setRoomSpaces(470, 570);

        rooms[6] = new Room("Forbidden Parking");
        rooms[6].setRoomSpaces(1040, 570);

        rooms[7] = new Room("Library");
        rooms[7].setRoomSpaces(70, 1740);

        rooms[8] = new Room("LA 5");
        rooms[8].setRoomSpaces(500, 1800);

        rooms[9] = new Room("Bratwurst Hall");
        rooms[9].setRoomSpaces(1180, 1700);

        rooms[10] = new Room("East Walkway");
        rooms[10].setRoomSpaces(1470, 960);

        rooms[11] = new Room("Computer Lab");
        rooms[11].setRoomSpaces(190, 890);

        rooms[12] = new Room("North Hall");
        rooms[12].setRoomSpaces(190, 1150);

        rooms[13] = new Room("Room of Retirement");
        rooms[13].setRoomSpaces(190, 1350);

        rooms[14] = new Room("ECS 302");
        rooms[14].setRoomSpaces(610, 890);

        rooms[15] = new Room("South Hall");
        rooms[15].setRoomSpaces(840, 1150);

        rooms[16] = new Room("Elevators");
        rooms[16].setRoomSpaces(610, 1390);

        rooms[17] = new Room("ECS 308");
        rooms[17].setRoomSpaces(840, 1370);

        rooms[18] = new Room("EAT Club");
        rooms[18].setRoomSpaces(1040, 890);

        rooms[19] = new Room("CECS Conference Room");
        rooms[19].setRoomSpaces(1260, 890);

        rooms[20] = new Room("Lactation Lounge");
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
        players[0] = new Player("Evan", new int[]{2, 2, 2}, rooms[17]);
        players[1] = new Player("Nick", new int[]{3, 1, 2}, rooms[17]);
        players[2] = new Player("BlAdam", new int[]{0, 3, 3}, rooms[17]);

        for (int i = 0; i < 3; i++) {
            players[i].setSpace(players[i].getRoom().getRoomSpace(i));
        }

        for (int i = 0; i < 5; i++) {
            players[0].addCard(deckOfCards.get(i));
            deckOfCards.remove(i);
        }

        for (int i = 0; i < 5; i++) {
            players[1].addCard(deckOfCards.get(i));
            deckOfCards.remove(i);
        }

        for (int i = 0; i < 5; i++) {
            players[2].addCard(deckOfCards.get(i));
            deckOfCards.remove(i);
        }

        Random rand = new Random();
        int human = rand.nextInt(3);
        players[human].setHuman();

        humanPlayer = players[human];
        currentPlayer = humanPlayer;
        currentPlayer.changeCurrent();
    }

    public void initializeCards() {
        deckOfCards = new ArrayList<Card>();
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());
        deckOfCards.add(new Card00());

//        deckOfCards.add(new Card1());
//        deckOfCards.add(new Card2());
//        deckOfCards.add(new Card3());
//        deckOfCards.add(new Card4());
//        deckOfCards.add(new Card5());
//        deckOfCards.add(new Card6());
//        deckOfCards.add(new Card7());
//        deckOfCards.add(new Card8());
//        deckOfCards.add(new Card9());
//        deckOfCards.add(new Card10());
//        deckOfCards.add(new Card11());
//        deckOfCards.add(new Card12());
//        deckOfCards.add(new Card13());
//        deckOfCards.add(new Card14());
//        deckOfCards.add(new Card15());
//        deckOfCards.add(new Card16());
//        deckOfCards.add(new Card17());
//        deckOfCards.add(new Card18());
//        deckOfCards.add(new Card19());
//        deckOfCards.add(new Card20());
//        deckOfCards.add(new Card21());
//        deckOfCards.add(new Card22());
//        deckOfCards.add(new Card23());
//        deckOfCards.add(new Card24());
//        deckOfCards.add(new Card25());
//        deckOfCards.add(new Card26());
//        deckOfCards.add(new Card27());
//        deckOfCards.add(new Card28());
//        deckOfCards.add(new Card29());
//        deckOfCards.add(new Card30());
//        deckOfCards.add(new Card31());
//        deckOfCards.add(new Card32());
//        deckOfCards.add(new Card33());
//        deckOfCards.add(new Card34());
//        deckOfCards.add(new Card35());
//        deckOfCards.add(new Card36());
//        deckOfCards.add(new Card37());
//        deckOfCards.add(new Card38());
        long seed = System.nanoTime();

        Collections.shuffle(deckOfCards, new Random(seed));
        Collections.shuffle(deckOfCards, new Random(seed));
    }

    public Room getRoom(int room) {
        return rooms[room];
    }

    public Player[] getPlayers() {
        return players;
    }

    public Card getTopCard() {
        return deckOfCards.get(0);
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
