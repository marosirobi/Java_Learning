package model.exercise2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name,artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String song, double duration){
        if(findSong(song) == null){
            songs.add(new Song(song,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (var song : songs){
            if(song.getTitle().equalsIgnoreCase(title)){
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        if(trackNumber-1 > songs.size() || trackNumber-1 < 0)
            return false;
        playList.add(songs.get(trackNumber-1));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        if(findSong(title) == null)
            return false;
        playlist.add(findSong(title));
        return true;
    }
}
