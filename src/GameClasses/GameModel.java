package GameClasses;

import CardClasses.*;
import CardClasses.Deck;
import java.io.Serializable;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

public class GameModel implements Serializable {

    private Room[] rooms;
    private Player[] players;
    private Player humanPlayer;
    private Player currentPlayer;
    private Deck deckOfCards;
    private Deck discardDeck;
    private int totalQualityPoints;
    private int year;
    private boolean gameComplete;

    public GameModel() {
        deckOfCards = new Deck();
        discardDeck = new Deck();
        deckOfCards.initializeCards();
        initializeRooms();
        initializePlayers();
        year = 1;
        totalQualityPoints = 0;
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
        players[0] = new Player("Evan", new SkillPoints(2, 2, 2), rooms[17]);
        players[1] = new Player("Nick", new SkillPoints(3, 1, 2), rooms[17]);
        players[2] = new Player("BlAdam", new SkillPoints(0, 3, 3), rooms[17]);
        
        for (int i = 0; i < 3; i++) {
            players[i].setSpace(players[i].getRoom().getRoomSpace(i));
        }
       
        dealCards();

        Random rand = new Random();
        int human = rand.nextInt(3);
        players[human].setHuman();

        humanPlayer = players[human];
        currentPlayer = humanPlayer;
        currentPlayer.changeCurrent();
    }

    public void toSophomoreYear() {
        
        discardHands();
        reshuffleDeck();
        deckOfCards.removeCard(new CECS100());
        deckOfCards.removeCard(new Math122());
        deckOfCards.removeCard(new ProfMurgoloCECS174());
        deckOfCards.removeCard(new CECS105());
        deckOfCards.removeCard(new Math123());
        deckOfCards.removeCard(new Physics151());
        deckOfCards.removeCard(new KIN253());
        deckOfCards.removeCard(new PassSoccerClass());
        deckOfCards.removeCard(new ElectiveClass());
        deckOfCards.removeCard(new OralCommunication());
        deckOfCards.removeCard(new CHEM111());
        discardDeck.removeCard(new CECS100());
        discardDeck.removeCard(new Math122());
        discardDeck.removeCard(new ProfMurgoloCECS174());
        discardDeck.removeCard(new CECS105());
        discardDeck.removeCard(new Math123());
        discardDeck.removeCard(new Physics151());
        discardDeck.removeCard(new KIN253());
        discardDeck.removeCard(new PassSoccerClass());
        discardDeck.removeCard(new ElectiveClass());
        discardDeck.removeCard(new OralCommunication());
        discardDeck.removeCard(new CHEM111());
        deckOfCards.shuffleDeck(System.nanoTime());
        deckOfCards.addCard(new CECS274());
        deckOfCards.addCard(new CECS201());
        deckOfCards.addCard(new CECS277());
        deckOfCards.addCard(new CECS228());
        deckOfCards.addCard(new CECS285());
        deckOfCards.addCard(new GrabSomeLunch());
        deckOfCards.addCard(new PHIL270());
        deckOfCards.addCard(new ENGL317());
        deckOfCards.addCard(new Physics152());
        deckOfCards.addCard(new CarPool());
        deckOfCards.addCard(new LBSUvsUCI());
        deckOfCards.addCard(new AllNighter());
        deckOfCards.addCard(new CECS282());
        deckOfCards.addCard(new HaveASwim());
        dealCards();
    }

    public void discardHands() {
        for (Player player : players) {
            while (player.getHand().size() > 0) {
                Card discardedCard = player.getHand().getFirst();
                player.discardCard(discardedCard);
                addCardToDiscardDeck(discardedCard);
            }
        }
        reshuffleDeck();
    }

    public Room getRoom(int room) {
        return rooms[room];
    }

    public Room[] getRooms() {
        return rooms;
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
    
    public int getYear() {
        return year;
    }

    public void reshuffleDeck() {
        for (int i = 0; i < discardDeck.getNumberOfCards(); i++) {
            deckOfCards.addCard(discardDeck.getCard(i));
        }
        discardDeck.getDeckOfCards().removeAll(discardDeck.getDeckOfCards());
        deckOfCards.shuffleDeck(System.nanoTime());
    }

    public void checkToReshuffleDeck() {
        if (deckOfCards.isDeckEmpty()) {
            reshuffleDeck();
        }
    }

    public int getTotalQualityPoints() {
        return totalQualityPoints;
    }

    public void updateTotalQualityPoints() {
        totalQualityPoints = 0;
        for (Player player : players) {
            totalQualityPoints += player.getQualityPoints();
        }
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

    public HashSet<Room> getPossibleRooms(Room room, int moves) {
        HashSet<Room> possibleRooms = new HashSet<>();

        for (int roomNumber : room.getAdjacentRooms()) {
            possibleRooms.add(getRoom(roomNumber));
        }
        HashSet<Room> temp = new HashSet<>();
        for (Room adjacentRooms : possibleRooms) {
            for (int roomNumber : adjacentRooms.getAdjacentRooms()) {
                temp.add(getRoom(roomNumber));
            }
        }
        possibleRooms.addAll(temp);
        temp = new HashSet<>();
        for (Room adjacentRooms : possibleRooms) {
            for (int roomNumber : adjacentRooms.getAdjacentRooms()) {
                temp.add(getRoom(roomNumber));
            }
        }
        possibleRooms.addAll(temp);
        possibleRooms.remove(room);

        return possibleRooms;
    }

    public ArrayList<Room> findPathToRoom(Room currentRoom, Room desiredRoom) {
        ArrayList<Room> roomSequence = new ArrayList<>();
        ArrayList<Room> adjacentCurrentRooms = new ArrayList<>();

        for (int roomNumber : currentRoom.getAdjacentRooms()) {
            if ((getRoom(roomNumber)).equals(desiredRoom)) {
                roomSequence.add(desiredRoom);
                return roomSequence;
            }
            adjacentCurrentRooms.add(getRoom(roomNumber));
        }

        ArrayList<Room> adjacentDesiredRooms = new ArrayList<>();

        for (int roomNumber : desiredRoom.getAdjacentRooms()) {
            adjacentDesiredRooms.add(getRoom(roomNumber));
        }

        for (Room adjacentCurrentRoom : adjacentCurrentRooms) {

            for (Room adjacentDesiredRoom : adjacentDesiredRooms) {
                if (adjacentCurrentRoom.equals(adjacentDesiredRoom)) {
                    roomSequence.add(adjacentCurrentRoom);
                    roomSequence.add(desiredRoom);
                    return roomSequence;
                }
                if (adjacentCurrentRoom.isAdjacentTo(adjacentDesiredRoom)) {
                    roomSequence.add(adjacentCurrentRoom);
                    roomSequence.add(adjacentDesiredRoom);
                    roomSequence.add(desiredRoom);
                }
            }
        }
        return roomSequence;
    }

    public void dealCards() {
        reshuffleDeck();
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                Card drawnCard = deckOfCards.getTopCard();
                player.pickUpCard(drawnCard);
                deckOfCards.removeCard(drawnCard);
            }
        }
    }

    public void checkGameStatus() {
        for (Player player : players) {
            if (player.isWinner()) {
                gameComplete = true;
            }
        }
        if (totalQualityPoints >= 60 && year == 1) {
            year = 2;
            toSophomoreYear();
        }
    }

    public boolean isGameComplete() {
        return gameComplete;
    }
}
