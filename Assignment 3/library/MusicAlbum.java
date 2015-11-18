package library;

import java.util.*;

class MusicAlbum
    extends Item
{
    private String bandName;
    private int nSongs;
    private Set<String> bandMembers;

    MusicAlbum(String title, String band, int numSongs, String... keywords) 
    {
        super(title, keywords);
        bandName = band;
        nSongs = numSongs;
    }

    public void addMembers(String... keywords) 
    {
        bandMembers = new TreeSet<String>(Arrays.asList(keywords));
    }

    public Collection<String> getBandMembers() 
    {
        return bandMembers;
    }

    public String getBandName() 
    {
        return bandName;
    }

    @Override
    public String toString() 
    {
        StringBuilder albumString = new StringBuilder();
        Iterator<String> it = keywords.iterator();
        Iterator<String> members = bandMembers.iterator();

        albumString     .append("-Music Album- ")
                        .append('\n')
                        
                        .append("band:     ")           //Print Band
                        .append(bandName)
                        .append('\n')
                        
                        .append("# songs:  ")           //Print number of songs
                        .append(nSongs)
                        .append('\n')

                        .append("members:  ");
                        
        while (members.hasNext())                       //Loop to print members
        {
            String s = members.next();
            albumString.append(s);
            if (members.hasNext()) 
            {
                albumString .append(',')
                            .append(' ');
            }
        }
        
        albumString     .append('\n')

                        .append("title:    ")
                        .append(title)
                        .append('\n')

                        .append("keywords: ");
                        
        while (it.hasNext())                            //Loop to print keywords
        {
            String s = it.next();
            albumString.append(s);
            if (it.hasNext()) 
            {
                albumString .append(',')
                            .append(' ');
            }
        }
        
        albumString     .append('\n')
                        .append('\n');
                        
        return albumString.toString();
    }
}
