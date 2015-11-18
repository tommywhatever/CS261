import java.util.List;
import java.util.ArrayList;

public class Dealer
{
    private static List<Hand> table = new ArrayList<Hand>();
    
    public static void Deal(int nGames, int nHands, int cardsPerHand, int cardsPerLine, boolean shuffle)
    {
        for (int i = 0; i < nHands; i++)            //For each player/hand
        {
            Hand playerHand = new Hand();           //Initialize hand
            table.add(playerHand);
        }
        
        if(shuffle)
        {
            Deck.shuffle();
        }
        
        Deck.printDeck(cardsPerLine);               //Display Deck
        
        for (int i = 0; i < nGames; i++)            //For each game
        {
            for(int x = 0; x < cardsPerHand; x++)   //For each card per hand
            {
                for(int y = 0; y < nHands; y++)     //For each hand
                {
                    Card card = Deck.getCard();     //Deal card from deck
                    table.get(y).addCard(card);
                }
            }
            
            System.out.printf("=== Game " + (i + 1) + " ===\n\n");  //Print Game
        
            for (int x = 0; x < nHands; x++)        //For each hand
            {
                System.out.printf("--- Hand " + (x + 1) + " ---\n\n");
                
                table.get(x).showHand(cardsPerLine);                //Print cards in hand
                table.get(x).clearHand();
            }
        }
        
        System.out.printf("=== Games Complete ===\n");
    }
}
