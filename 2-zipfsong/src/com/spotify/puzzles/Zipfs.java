package com.spotify.puzzles;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class Zipfs {

    private static int limit = 0;

    public static void main(String[] args) {

        // Get album from input
        Album album = getAlbumFromInput();
        printTitles(zipfsSort(album.getSongs(), limit));

    }

    public static List<Song> zipfsSort(List<Song> songs, int limit) {
        List<Song> sortedSongs = new LinkedList<>(songs);
        Comparator<Song> byZipfs = Comparator.comparing(song -> song.getZipfsScore(), Comparator.reverseOrder());
        Comparator<Song> byPosition = Comparator.comparing(song -> song.getPosition());
        return sortedSongs.stream().sorted(byZipfs.thenComparing(byPosition)).limit(limit).collect(toList());
    }

    private static Album getAlbumFromInput() {
        List<Song> songs = new LinkedList<>();

        try {
            Scanner in = new Scanner(System.in);
            int c = in.nextInt();
            limit = in.nextInt();

            in.nextLine();

            int f = 1;

            for (int i = 1; i <= c; i++) {
                String s = in.nextLine();
                int plays = Integer.parseInt(s.split(" ")[0]);
                String title = s.split(" ")[1];
                if (i == 1) {
                    f = plays;
                }
                Song song = new Song(i, title, plays, f / i);
                songs.add(song);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong input format: " + e.getMessage());
        }

        Album album = new Album(songs);

        return album;
    }

    private static void printTitles(List<Song> songs) {
        for (Song song : songs) {
            System.out.println(song.getTitle());
        }
    }

}
