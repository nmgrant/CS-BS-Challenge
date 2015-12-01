package CardClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck implements Serializable {

   private ArrayList<Card> deckOfCards;

   public Deck() {
      deckOfCards = new ArrayList<>();
   }

   public void initializeCards() {
      deckOfCards.add(new ANewLaptop());
      deckOfCards.add(new BuddyUp());
      deckOfCards.add(new CECS100());
      deckOfCards.add(new CECS105());
      deckOfCards.add(new CHEM111());
      deckOfCards.add(new ChoosingAMajor());
      deckOfCards.add(new ElectiveClass());
      deckOfCards.add(new EnjoyingNature());
      deckOfCards.add(new EnjoyingThePeace());
      deckOfCards.add(new ExercisingMindAndBody());
      deckOfCards.add(new FallInThePond());
      deckOfCards.add(new FindingTheLab());
      deckOfCards.add(new GoodbyeProfessor());
      deckOfCards.add(new KIN253());
      deckOfCards.add(new LateForClass());
      deckOfCards.add(new LearningLinux());
      deckOfCards.add(new LearningNetbeans());
      deckOfCards.add(new LoudBuzzing());
      deckOfCards.add(new LunchAtBratwurstHall());
      deckOfCards.add(new Math122());
      deckOfCards.add(new Math123());
      deckOfCards.add(new MakeAFriend());
      deckOfCards.add(new MakeDeanList());
      deckOfCards.add(new MeetTheDean());
      deckOfCards.add(new OralCommunication());
      deckOfCards.add(new ParkingViolation());
      deckOfCards.add(new PassSoccerClass());
      deckOfCards.add(new Physics151());
      deckOfCards.add(new PressTheRightFloor());
      deckOfCards.add(new ProfMurgoloCECS174());
      deckOfCards.add(new ProfessorEnglert());
      deckOfCards.add(new ProfessorHoffman());
      deckOfCards.add(new ProgramCrashes());
      deckOfCards.add(new ResearchCompilers());
      deckOfCards.add(new ScoreAGoal());
      deckOfCards.add(new SoccerGoalie());
      deckOfCards.add(new StudentParking());
      deckOfCards.add(new TheBigGame());
      deckOfCards.add(new TheOutpost());

      long seed = System.nanoTime();

      shuffleDeck(seed);
      shuffleDeck(seed);
   }

   public ArrayList<Card> getDeckOfCards() {
      return deckOfCards;
   }
   
   public boolean isDeckEmpty() {
      return deckOfCards.isEmpty();
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

   public void shuffleDeck(long randomSeed) {
      Collections.shuffle(deckOfCards, new Random(randomSeed));
   }
}
