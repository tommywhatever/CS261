package library;

import java.io.PrintStream;
import java.util.*;

public class Library
{
    private Map<String, TreeSet<Item>> keywordIndex;
    private Map<String, TreeSet<Item>> authorIndex;
    private Map<String, TreeSet<Item>> bandIndex, musicianIndex;
    private Map<String, TreeSet<Item>> directorIndex, actorIndex;
    private TreeMap<String,Item> aBookIndex, aMovieIndex, aAlbumIndex;
    
    public Library()
    {
        keywordIndex = new HashMap<String, TreeSet<Item>>();
        authorIndex = new HashMap<String, TreeSet<Item>>();
        bandIndex = new HashMap<String, TreeSet<Item>>();
        musicianIndex = new HashMap<String, TreeSet<Item>>();
        directorIndex = new HashMap<String, TreeSet<Item>>();
        actorIndex = new HashMap<String, TreeSet<Item>>();
        aBookIndex = new TreeMap<String, Item>();
        aMovieIndex = new TreeMap<String, Item>();
        aAlbumIndex = new TreeMap<String, Item>();
    }
    
	// general methods
	
	public void index(Map<String, TreeSet<Item>> index, Item newItem, String... varags) {
        for(String s: varags) {
            if(!(index.containsKey(s))) {
                TreeSet<Item> tempSet = new TreeSet<Item>();
                tempSet.add(newItem);
                index.put(s, tempSet);
            }
            else {
                TreeSet<Item> temp = index.get(s);
                temp.add(newItem);
                index.put(s, temp);
            }
        }

    }
	
	
	// returns all of the items which have the specified keyword
	public Collection<Item> itemsForKeyword(String keyword)
	{         
		return keywordIndex.get(keyword);
	}
	
	// print an item from this library to the output stream provided
	public void printItem(PrintStream out, Item item)
	{
	    out.print(item.toString());
	}
	
	// book-related methods
	
	// adds a book to the library
	public Item addBook(String title, String author, int nPages, String... keywords)
	{
		Item newBook = new Book(title, author, nPages, keywords);
        aBookIndex.put(title, newBook);
        index(authorIndex, newBook, author);
        index(keywordIndex, newBook, keywords);
        return newBook;
	}
	
	// removes a book from the library
	public boolean removeBook(String title)
	{
		boolean deleted = false;
        if (aBookIndex.containsKey(title)) {
            Item tempBook = aBookIndex.remove(title);
            authorIndex.remove(((Book)tempBook).getAuthor());
            for (String s: tempBook.keywords) {
                keywordIndex.get(s).remove(tempBook);
            }
            deleted = true;
        }
        return deleted;
	}
	
	// returns all of the books by the specified author
	public Collection<Item> booksByAuthor(String author)
	{
		return authorIndex.get(author);
	}
	
	// returns all of the books in the library
	public Collection<Item> books()
	{
		return aBookIndex.values();
	}
	
	// music-related methods
	
	// adds a music album to the library
	public Item addMusicAlbum(String title, String band, int nSongs, String... keywords)
	{
		MusicAlbum newAlbum = new MusicAlbum(title, band, nSongs, keywords);
        aAlbumIndex.put(title, newAlbum);
        index(bandIndex, newAlbum, band);
        index(keywordIndex, newAlbum, keywords);
        return newAlbum;
	}

	// adds the specified band members to a music album
	public void addBandMembers(Item album, String... members)
	{
	    ((MusicAlbum)album).addMembers(members);
        index(musicianIndex, album, members);
	}
	
	// removes a music album from the library
	public boolean removeMusicAlbum(String title)
	{
		boolean deleted = false;
        if (aAlbumIndex.containsKey(title)) {
            Item tempAlbum = aAlbumIndex.remove(title);
            bandIndex.get(((MusicAlbum)tempAlbum).getBandName()).remove(tempAlbum);
            for (String s: ((MusicAlbum) tempAlbum).getBandMembers()) {
                musicianIndex.get(s).remove(tempAlbum);
            }
            for (String s: tempAlbum.keywords) {
                keywordIndex.get(s).remove(tempAlbum);
            }
            deleted = true;
        }
        return deleted;
	}

	// returns all of the music albums by the specified band
	public Collection<Item> musicByBand(String band)
	{
		return bandIndex.get(band);
	}
	
	// returns all of the music albums by the specified musician
	public Collection<Item> musicByMusician(String musician)
	{
		return musicianIndex.get(musician);
	}
	
	// returns all of the music albums in the library
	public Collection<Item> musicAlbums()
	{
		return aAlbumIndex.values();
	}
	
	// movie-related methods
	
	// adds a movie to the library
	public Item addMovie(String title, String director, int nScenes, String... keywords)
	{
        Movie newMovie = new Movie(title, director, nScenes, keywords);
        aMovieIndex.put(title, newMovie);
        index(directorIndex, newMovie, director);
        index(keywordIndex, newMovie, keywords);
		return newMovie;
	}

	// adds the specified actors to a movie
	public void addCast(Item movie, String... members)
	{
	   ((Movie) movie).editActors(members);
       index(actorIndex, movie, members);
	}

	// removes a movie from the library
	public boolean removeMovie(String title)
	{
		boolean deleted = false;
        if (aMovieIndex.containsKey(title)) {
            Item tempMovie = aMovieIndex.remove(title);
            directorIndex.remove(((Movie)tempMovie).getDirector());
            for (String s: ((Movie) tempMovie).getActors()) {
                actorIndex.get(s).remove(tempMovie);
            }
            for (String s: tempMovie.keywords) {
                keywordIndex.get(s).remove(tempMovie);
            }
            deleted = true;
        }
        return deleted;
	}
	
	// returns all of the movies by the specified director
	public Collection<Item> moviesByDirector(String director)
	{
		return directorIndex.get(director);
	}
	
	// returns all of the movies by the specified actor
	public Collection<Item> moviesByActor(String actor)
	{
		return actorIndex.get(actor);
	}
	
	// returns all of the movies in the library
	public Collection<Item> movies()
	{
		return aMovieIndex.values();
	}	
}
