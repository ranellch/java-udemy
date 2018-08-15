package com.udemy;

import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String title;
    private String artist;
    private LinkedList<Song> songs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new LinkedList<Song>();
    }

    public void addSong(String title, double duration) {
        songs.add(new Song(title, duration));
    }

    public String getTitle() {
        return title;
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }
}
