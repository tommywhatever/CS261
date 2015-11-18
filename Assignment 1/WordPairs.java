import java.util.ArrayList;

/**
 * Write a description of class WordPairs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPairs
{
    private ArrayList<Pair> pairs;
    private Pair tempPair;
    

    /**
     * Constructor for objects of class WordPairs
     */
    public WordPairs()
    {
        pairs = new ArrayList<Pair>();
        tempPair = new Pair();
    }

   private void setTemp(String string1, String string2)
   {
       tempPair.setWord1(string1);
       tempPair.setWord2(string2);
    }
    
    private void addPair(String string1, String string2)
    {
        pairs.add(new Pair(string1, string2));
    }
    
    /**
     * This method checks if a pair already exists in the array.
     */
    
    private boolean pairMatch(Pair pair1, Pair pair2)
    {
        boolean match = false;
        
        if (pair1.getWord1().contains(pair2.getWord1()) && pair1.getWord2().contains(pair2.getWord2()))
        {
            match = true;
        }
        
        return match;
    }
    
    public void searchPairs(String string1, String string2)
    {
        setTemp(string1, string2);
        boolean match = false;
        
        for (Pair pair : pairs)
        {
            if (pairMatch(tempPair, pair))
            {
                match = true;
                pair.addCount();
            }
        }
        
        if (!match)
        {
            addPair(string1, string2);
        }
        
    }
    
    public int getCount(String string1, String string2)
    {
        int count = 0;
        for (Pair pair : pairs)
        {
            if (pair.getWord1().contains(string1) && pair.getWord2().contains(string2))
            {
                count = pair.getCount();
            }
        }
        return count;
    }
    
    public int getScore(WordPairs ref)
    {
        int sampleScore = 0;
        int refScore = 0;
        int score = 0;
        
        for (Pair pair : pairs)
        {    
            sampleScore = getCount(pair.getWord1(), pair.getWord2());
            refScore = ref.getCount(pair.getWord1(), pair.getWord2());
            score = score + (sampleScore * refScore);
        }
        return score;
    }
    
    public void displayCount()
    {
        for (Pair pair: pairs)
        {
            pair.displayPair();
        }
    }
}
