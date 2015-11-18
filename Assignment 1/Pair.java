
/**
 * Write a description of class Pair here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pair
{
    // instance variables - replace the example below with your own
    private String word1;
    private String word2;
    private int count;

    /**
     * Constructor for objects of class Pair
     */
    public Pair()
    {
        // initialise instance variables
        word1 = "";
        word2 = "";
        count = 0;
    }
    
    public Pair(String string1, String string2)
    {
        word1 = string1;
        word2 = string2;
        count = 1;
    }
    
    public void addCount()
    {
        count++;
    }
    
    public int getCount()
    {
        return count;
    }
    
    public String getWord1()
    {
        return word1;
    }
    
    public String getWord2()
    {
        return word2;
    }
    
    public void setWord1(String string)
    {
     this.word1 = string;
    }
    
    public void setWord2(String string)
    {
        this.word2 = string;
    }
    
    public void displayPair()
    {
        System.out.println(word1 + " - " + word2 + " Count= " + count);
    }
    
}
