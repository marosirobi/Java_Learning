package model.exercise1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name,artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){
        if(songs.findSong(title) == null){
            songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        if(songs.findSong(trackNumber) == null)
            return false;
        playList.add(songs.findSong(trackNumber));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        if(songs.findSong(title) == null)
            return false;
        playlist.add(songs.findSong(title));
        return true;
    }

    public static class SongList{
        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<>();
        }

        private boolean add(Song song){
            if(findSong(song.getTitle()) == null){
                songs.add(song);
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

        private Song findSong(int trackNumber){
            if(songs.size() > trackNumber-1){
                return songs.get(trackNumber-1);
            }
            return null;
        }
    }

}

