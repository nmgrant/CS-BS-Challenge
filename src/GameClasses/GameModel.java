package GameClasses;

import CardClasses.*;
import CardClasses.Deck;
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
    private Deck deckOfCards;
    private Deck discardDeck;

    public GameModel() {
        deckOfCards = new Deck();
        discardDeck = new Deck();
        deckOfCards.initializeCards();
        initializeRooms();
        initializePlayers();
    }

    private void initializeRooms() {
        rooms = new Room[21];

        rooms[0] = new Room("George Allen Field", 0);
        rooms[1] = new Room("Japanese Garden", 1);
        rooms[2] = new Room("Student Parking", 2);
        rooms[3] = new Room("The Pyramid", 3);
        rooms[4] = new Room("West Walkway", 4);
        rooms[5] = new Room("Rec Center", 5);
        rooms[6] = new Room("Forbidden Parking", 6);
        rooms[7] = new Room("Library", 7);
        rooms[8] = new Room("LA 5", 8);
        rooms[9] = new Room("Bratwurst Hall", 9);
        rooms[10] = new Room("East Walkway", 10);
        rooms[11] = new Room("Computer Lab", 11);
        rooms[12] = new Room("North Hall", 12);
        rooms[13] = new Room("Room of Retirement", 13);
        rooms[14] = new Room("ECS 302", 14);
        rooms[15] = new Room("South Hall", 15);
        rooms[16] = new Room("Elevators", 16);
        rooms[17] = new Room("ECS 308", 17);
        rooms[18] = new Room("EAT Club", 18);
        rooms[19] = new Room("CECS Conference Room", 19);
        rooms[20] = new Room("Lactation Lounge", 20);

    }

    private void initializePlayers() {
        players = new Player[3];
        players[0] = new Player("Evan", new SkillPoints(10, 10, 10), rooms[17]);
        players[1] = new Player("Nick", new SkillPoints(10, 10, 10), rooms[17]);
        players[2] = new Player("BlAdam", new SkillPoints(10, 10, 10), rooms[17]);

        for (int i = 0; i < 3; i++) {
            players[i].setSpace(players[i].getRoom().getRoomSpace(i));
        }

        for (int i = 0; i < 5; i++) {
            Card drawnCard = deckOfCards.getCard(i);
            players[0].pickUpCard(drawnCard);
            deckOfCards.removeCard(drawnCard);
        }

        for (int i = 0; i < 5; i++) {
            Card drawnCard = deckOfCards.getCard(i);
            players[1].pickUpCard(drawnCard);
            deckOfCards.removeCard(drawnCard);
        }

        for (int i = 0; i < 5; i++) {
            Card drawnCard = deckOfCards.getCard(i);
            players[2].pickUpCard(drawnCard);
            deckOfCards.removeCard(drawnCard);
        }

        Random rand = new Random();
        int human = rand.nextInt(3);
        players[human].setHuman();

        humanPlayer = players[human];
        currentPlayer = humanPlayer;
        currentPlayer.changeCurrent();
        currentPlayer.pickUpCard(new Card00());
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

    public Deck getDeckOfCards() {
        return deckOfCards;
    }

    public Deck getDiscardDeck() {
        return discardDeck;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player next) {
        currentPlayer = next;
    }

    public void removeCardFromDeck(Card card) {
        deckOfCards.removeCard(card);
    }

    public void addCardToDiscardDeck(Card card) {
        discardDeck.addCard(card);
    }

    public ArrayList<Room> getPossibleRooms(Room room, int moves) {
        ArrayList<Room> possibleRooms = new ArrayList<>();
        possibleRooms = getPossibleRoomsHelper(possibleRooms, room, moves);

        return possibleRooms;
    }

    public ArrayList<Room> getPossibleRoomsHelper(ArrayList<Room> rooms, Room room, int moves) {

        if (moves == 0) {
            return rooms;
        } else {
            for (int roomNumber : room.getAdjacentRooms()) {
                moves -= 1;
                rooms.add(getRoom(roomNumber));
                rooms = getPossibleRoomsHelper(rooms, getRoom(roomNumber), moves);
            }
        }

        return rooms;
    }
}
