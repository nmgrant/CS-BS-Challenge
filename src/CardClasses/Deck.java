package CardClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

   private ArrayList<Card> deckOfCards;

   public Deck() {
      deckOfCards = new ArrayList<>();
   }

   public void initializeCards() {
      deckOfCards.add(new Card00());
      deckOfCards.add(new Card01());
      deckOfCards.add(new Card02());
      deckOfCards.add(new Card03());
      deckOfCards.add(new Card04());
      deckOfCards.add(new Card05());
      deckOfCards.add(new Card06());
      deckOfCards.add(new Card07());
      deckOfCards.add(new Card08());
      deckOfCards.add(new Card09());
      deckOfCards.add(new Card10());
      deckOfCards.add(new Card11());
      deckOfCards.add(new Card12());
      deckOfCards.add(new Card13());
      deckOfCards.add(new Card14());
      deckOfCards.add(new Card15());
      deckOfCards.add(new Card16());
      deckOfCards.add(new Card17());
      deckOfCards.add(new Card18());
      deckOfCards.add(new Card19());
      deckOfCards.add(new Card20());
      deckOfCards.add(new Card21());
      deckOfCards.add(new Card22());
      deckOfCards.add(new Card23());
      deckOfCards.add(new Card24());
      deckOfCards.add(new Card25());
      deckOfCards.add(new Card26());
      deckOfCards.add(new Card27());
      deckOfCards.add(new Card28());
      deckOfCards.add(new Card29());
      deckOfCards.add(new Card30());
      deckOfCards.add(new Card31());
      deckOfCards.add(new Card32());
      deckOfCards.add(new Card33());
      deckOfCards.add(new Card34());
      deckOfCards.add(new Card35());
      deckOfCards.add(new Card36());
      deckOfCards.add(new Card37());
      deckOfCards.add(new Card38());

      long seed = System.nanoTime();

      shuffleDeck(deckOfCards, seed);
      shuffleDeck(deckOfCards, seed);
   }

   public ArrayList<Card> getDeckOfCards() {
      return deckOfCards;
   }

   public Card getCard(int index) {
      return deckOfCards.get(index);
   }
   
   public void addCard(Card card) {
       deckOfCards.add(card);
   }

   public void removeCard(Card card) {
    deckOfCards.remove(card);
   }

   public Card getTopCard() {
      return deckOfCards.get(0);
   }
   
   public int getNumberOfCards() {
       return deckOfCards.size();
   }

   public void shuffleDeck(ArrayList<Card> deckOfCards, long randomSeed) {
      Collections.shuffle(deckOfCards, new Random(randomSeed));
   }
}
