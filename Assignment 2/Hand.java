import java.util.ArrayList;
import java.util.List;

public class Hand
{
    private List<Card> hand = new ArrayList<Card>();
    
    public void addCard(Card card)
    {
        hand.add(card);
    }
    
    public int handScore()
    {
        int score = 0;
        
        for (Card card : hand)          //For each card in hand
        {
            score += card.getScore();   //Add score to total
        }
        
        return score;
    }
    
    public void showHand(int cardsPerLine)
    {
        int i = 1; //cardsPerLine counter
        
        for (Card card : hand)          //For each card in hand
        {
            System.out.printf(card.toString());     //Print card
            
            if (i % cardsPerLine == 0)  //If line is full
            {
                System.out.printf(",\n");           //New Line
            }
              
            else if (i == hand.size())  //If end of hand
            {
                System.out.printf("\n\n");          //New Lines
            }
            
            else if (i < hand.size())   //If not end of hand
            {
                System.out.printf(", ");            //Add comma
            }
            
            i++; //Increase count
        }
        
        System.out.printf("score = " + handScore() + "\n\n");
    }
    
    public void clearHand()
    {
        hand.clear();
    }
}
