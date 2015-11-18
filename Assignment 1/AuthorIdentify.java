import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// In BlueJ, specify the command line argument when you call main().
//
// In Eclipse, specify the command line argument in the project's "Run Configuration."

public class AuthorIdentify
{
    // returns an InputStream that gets data from the named file
    private static InputStream getFileInputStream(String fileName) throws Exception
    {
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(new File(fileName));
        }
        catch (FileNotFoundException e) {       // no file with this name exists
            inputStream = null;
            throw new Exception("unable to open the file -- " + e.getMessage());
        }
        return inputStream;
    }

    private static void countWordPairs(InputStream is, WordPairs pairs)
    {
        Scanner sc = null;  
        String word = null;
        String previousWord = null;

        sc = new Scanner(is);
        word = null;
        previousWord = null;

        while (sc.hasNext())
        {
            word = sc.next();
            if (previousWord != null)
            {
                pairs.searchPairs(previousWord, word);
            }
            previousWord = word;
        }
        sc.close();
    }

    private static int getCount(WordPairs pairs, String firstWord, String secondWord)
    {
        int count = 0;

        count = pairs.getCount(firstWord, secondWord);
        
        return(count);      
    }
            
    public static void main(String[] args)
    {
        if (args.length != 4)
        {
            System.out.println("USage: AuthorIdentify <ref1> <ref2> <ref3> <sample>");
            System.exit(1);
        }

        try
        {
            System.out.printf("CS261 - AuthorIdentify - Tommy Childers%n%n");

            // Create an input stream for reading the data for each of the 
            // reference documents and the sample document.  If any of the
            // file opens fail an exception will be thrown.

            InputStream ref1 = getFileInputStream(args[0]);
            InputStream ref2 = getFileInputStream(args[1]);
            InputStream ref3 = getFileInputStream(args[2]);
            InputStream samp = getFileInputStream(args[3]);

            // The general idea is to create a word-pair frequency count for each
            // reference text.  Then we'll read the sample text and find the reference
            // text with the best match on word pair frequency.

            WordPairs ref1Counts = new WordPairs();
            WordPairs ref2Counts = new WordPairs();
            WordPairs ref3Counts = new WordPairs();
            WordPairs sampleCounts = new WordPairs();
            
            countWordPairs(ref1, ref1Counts);
            countWordPairs(ref2, ref2Counts);
            countWordPairs(ref3, ref3Counts);
            countWordPairs(samp, sampleCounts);
            
            // Now calculate the score for each reference document.  The score is calculated as follows:
            // 
            // sampleCount = the number of times a particular word pair occurs in the sample document
            // refCount = the number of times a particular word pair occurs in the reference document
            // refScore = for all word pairs in the sample, refScore = refScore + (sampleCount * refCount)
            //
            // The refCount and refScore are calculated for each of the reference documents (so you have three of them).
            // In the end we will pick the reference with the highest score.
            
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
                      
            score1 = sampleCounts.getScore(ref1Counts);
            score2 = sampleCounts.getScore(ref2Counts);
            score3 = sampleCounts.getScore(ref3Counts);
            
            
            // Pick the reference winner
            String winner = null;
            if (score1 > score2 && score1 > score3)
            {
                winner = args[0];
            }
            if (score2 > score1 && score2 > score3)
            {
                winner = args[1];
            }
            if (score3 > score2 && score3 > score1)
            {
                winner = args[2];
            }
            System.out.println("Score1 (" + args[0] + "): " + score1);
            System.out.println("Score2 (" + args[1] + "): " + score2);
            System.out.println("Score3 (" + args[2] + "): " + score3);
            System.out.println("The sample most closely resembles " + winner);          

        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


