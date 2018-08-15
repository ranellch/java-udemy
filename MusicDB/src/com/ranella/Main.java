package com.ranella;

import com.ranella.model.Artist;
import com.ranella.model.Datasource;
import com.ranella.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List<Artist> artists = datasource.queryArtists(Datasource.ORDER_BY_DESC);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }

        for(Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist =
                datasource.queryAlbumsForArtist("Pink Floyd",Datasource.ORDER_BY_DESC);

        for(String album : albumsForArtist) {
            System.out.println(album);
        }

        datasource.querySongsMetadata();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song title: ");
//        String title = scanner.nextLine();
//
//        List<SongArtist> songArtists = datasource.querySongInfoView(title);
//        if(songArtists.isEmpty()) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//
//        for(SongArtist artist : songArtists) {
//            System.out.println("Artist name = " + artist.getArtistName() +
//                    " Album name = " + artist.getAlbumName() +
//                    " Track = " + artist.getTrack());
//        }

        datasource.insertSong("Dammit", "Blink 182", "Dude Ranch", 1);
        datasource.close();
    }
}
