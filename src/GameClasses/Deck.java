package GameClasses;

import CardClasses.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {

   private ArrayList<Card> deckOfCards;
   private ArrayList<Card> discardDeck;

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

   public Card getTopCard() {
      return deckOfCards.get(0);
   }
}
