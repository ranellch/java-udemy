package com.udemy;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();

    public static void main(String[] args) {
        Album dookie = new Album("Dookie", "Green Day");
        dookie.addSong("Having a Blast", 2.56);
        dookie.addSong("Longview", 3.14);
        dookie.addSong("F.O.D.", 3.32);
        if (!dookie.addSong("F.O.D.",3.11)) {
            System.out.println("Duplicate");
        }
        Album pureComedy = new Album("Pure Comedy", "Father John Misty");
        pureComedy.addSong("Pure Comedy", 2.56);
        pureComedy.addSong("Total Entertainment Forever", 3.03);
        albums.add(pureComedy);
        albums.add(dookie);
        addSong("Having a Blast", "Dookie");
        addSong("Pure Comedy","Pure Comedy");
        addSong("F.O.D.","Dookie");
        addSong("Jesus of Suburbia","American Idiot");
        printSongs();
        play();
    }

    private static boolean addSong(String songTitle, String albumTitle) {
        Song newSong = findSong(songTitle,albumTitle);
        if (newSong == null) {
            System.out.println("Song not found");
            return false;
        }

        ListIterator<Song> playlistIterator = playlist.listIterator();

        while(playlistIterator.hasNext()) {
            if(playlistIterator.next().equals(newSong)){
                //equal, do not add
                System.out.println(newSong.getTitle() + " is already included in playlsit");
                return false;
            }
        }
        playlistIterator.add(newSong);
        return true;
    }

    private static Song findSong(String songTitle, String albumTitle) {
        for(int i=0; i<albums.size(); i++) {
            Album thisAlbum =  albums.get(i);

            if(thisAlbum.getTitle().equals(albumTitle)) {
                return thisAlbum.findSong(songTitle);
            }
        }
        return null;
    }

    private static void play() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        Song currentSong;
        ListIterator<Song> listIterator = playlist.listIterator();

        if(playlist.isEmpty()) {
            System.out.println("No songs in playlist");
            return;
        } else {
            currentSong = listIterator.next();
            System.out.println("Now playing " + currentSong.getTitle());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("Quitting...");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        currentSong = listIterator.next();
                        System.out.println("Now playing " + currentSong.getTitle());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        currentSong = listIterator.previous();
                        System.out.println("Now playing " + currentSong.getTitle());
                    } else {
                        System.out.println("Reached the start of the playlist");
                        goingForward = true;
                    }
                    break;

                case 3:
                    System.out.println("Replaying " + currentSong.getTitle());
                    break;
                case 4:
                    listIterator.remove();
                    System.out.println(currentSong.getTitle() + " deleted from playlist");
                case 5:
                    printSongs();
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }

    }

    private static void printSongs() {
        System.out.println("======== Songs ========");
        Iterator<Song> i= playlist.iterator();
        int count = 1;
        while(i.hasNext()) {
            System.out.println(count + ". " + i.next().getTitle());
            count++;
        }
        System.out.println("=======================");
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - skip to next song\n" +
                "2 - skip to previous song\n" +
                "3 - replay current song\n" +
                "4 - remove song from playlist\n" +
                "5 - print list of songs\n" +
                "6 - print menu options");
    }

}
