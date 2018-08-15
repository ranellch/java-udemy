package com.udemy;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String title;
    private String artist;
    private SongList songList;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songList.addSong(title, duration);
    }

    public Song findSong(String title) {
        return songList.findSong(title);
    }

    public String getTitle() {
        return title;
    }


    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public boolean addSong(String title, double duration) {
            if (findSong(title) != null) {
                return false;
            }
            return songs.add(new Song(title, duration));
        }

        public Song findSong(String title) {
            for(int i=0; i<songs.size(); i++) {
                Song thisSong = songs.get(i);
                if (thisSong.getTitle().equals(title)) {
                    return thisSong;
                }
            }
            return null;
        }
    }
}
