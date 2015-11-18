package library;

import java.util.*;

class Book
    extends Item
{
    private String author;
    private int pageNum;

    Book(String title, String newAuthor, int pages, String... keywords) 
    {
        super(title, keywords);
        author = newAuthor;
        pageNum = pages;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String toString() 
    {
        StringBuilder bookString = new StringBuilder();
        Iterator<String> it = keywords.iterator();

        bookString  .append("-Book- ")          
                    .append('\n')
                    
                    .append("author:  ")        //Print Author
                    .append(author)
                    .append('\n')
                    
                    .append("# pages:  ")       //Print Number of Pages
                    .append(pageNum)
                    .append('\n')
                    
                    .append("title:    ")       //Print Title
                    .append(title)
                    .append('\n')
                    
                    .append("keywords: ");   
                    
        while (it.hasNext())                    //Loop to print keywords
        {
            String s = it.next();
            bookString.append(s);
            
            if (it.hasNext()) 
            {
                bookString  .append(',')
                            .append(' ');
            }
        }
        bookString  .append('\n')
                    .append('\n');
                    
        return bookString.toString();
    }
}
