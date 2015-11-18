package library;

import java.util.*;

class Movie
    extends Item
{
    private String director;
    private int sceneNum;
    private Set<String> actorList;

    Movie(String title, String director, int numScenes, String... keywords) 
    {
        super(title, keywords);
        this.director = director;
        sceneNum = numScenes;
    }

    public String getDirector() 
    {
        return director;
    }

    public Collection<String> getActors() 
    {
        return actorList;
    }
    
    public void editActors(String... actors) 
    {
        actorList = new TreeSet<String>(Arrays.asList(actors));
    }

    @Override
    public String toString() 
    {
        StringBuilder movieString = new StringBuilder();
        Iterator<String> it = keywords.iterator();
        Iterator<String> actors = actorList.iterator();

        movieString     .append("-Movie-  ")
                        .append('\n')
                        
                        .append("director: ")               //Print director
                        .append(director)
                        .append('\n')
                        
                        .append("# scenes: ")               //Print number of scenes
                        .append(sceneNum)
                        .append('\n')
                        
                        .append("cast:     ");              
                        
        while (actors.hasNext())                            //Loop to print the cast
        {
            String s = actors.next();
            movieString.append(s);
            
            if (actors.hasNext()) {
                movieString .append(',')
                            .append(' ');
            }
        }
        
        movieString     .append('\n')
                        
                        .append("title:    ")               //Print the title
                        .append(title)
                        .append('\n')
                        
                        .append("keywords: ");              
                        
        while (it.hasNext()) {                              //Loop to print keywords
            String s = it.next();
            movieString.append(s);
            
            if (it.hasNext()) {
                movieString .append(',')
                            .append(' ');
            }
            
        }
        movieString     .append('\n')
                        .append('\n');
                        
        return movieString.toString();
    }
}
