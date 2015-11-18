import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
    private static final List<Card> protoDeck = new ArrayList<Card>();
    private static int index, i;

    // initialize prototype deck
    static {
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values())
                protoDeck.add(new Card(rank, suit));
        index = 0;
    }
    
    public static void shuffle()
    {
        Collections.shuffle(protoDeck);
    }
    
    public static Card getCard()
    {
        if(index >= protoDeck.size()) //If end of the deck
        {
            index = 0; //Return to top of deck
        }
        
        Card card = protoDeck.get(index);   //Get card at index
        index++;                            //Increase index marker
        return card;
    }
    
    public static void printDeck(int cardsPerLine)
    {
        i = 1; //cardsPerLine counter
        System.out.println("deck:");
        
        for (Card card : protoDeck)         //For each card in deck
        {
            System.out.printf(card.toString());         //Print card
            
            if (i % cardsPerLine == 0)      //If line is full
            {
                System.out.printf(",\n");               //New line
            }
            
            else if (i < protoDeck.size())  //If end of deck
            {
                System.out.printf(", ");                //New lines
            }
            
            else if (i == protoDeck.size()) //If not end of deck
            {
                System.out.printf("\n\n");              //Add comma
            }
            i++; //Increase count
        }
        
    }
}
        
