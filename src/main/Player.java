package main;


import java.awt.Point;
import javax.swing.JLabel;
import java.util.LinkedList;
import Cards.*;

public class Player extends JLabel {

    private final int MAX_MOVES = 3;
    private String name;
    private int[] skillPoints;
    private int qualityPoints;
    private LinkedList<Card> handOfCards;
    private Room room;
    private boolean human, current;
    private boolean handIsFull;
    private int moves;
    private Point space;

    public Player(String name, int[] skillPoints, Room room) {
        this.name = name;
        this.skillPoints = skillPoints;
        qualityPoints = 0;
        this.room = room;
        human = false;
        moves = MAX_MOVES;
        current = false;
        handOfCards = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public Room getRoom() {
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

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setSpace(Point space) {
        this.space = space;
        room.setSpaceAvailability(space);
    }
    
    public void addCard(Card card) {
        if (handOfCards.size() >= 7)
            handIsFull = true;
        else
            handOfCards.add(card);
    }
    
    public LinkedList<Card> getHand() {
        return handOfCards;
    }
    
    public boolean handIsFull() {
        return handIsFull;
    }

    public void changeCurrent() {
        current = !current;
    }
}
