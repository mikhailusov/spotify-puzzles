/**
 * 2018 Mikhail Usov <musovx@gmail.com>
 *
 * For Spotify with <3
 *
 * Zipf’s Song
 */

package com.spotify.puzzles;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

public class Zipfs {

    private static int limit = 0;

    public static void main(String[] args) {
        Album album = getAlbumFromInput(new Scanner(System.in));
        printTitles(zipfsSort(album.getSongs(), limit));

    }

    public static List<Song> zipfsSort(List<Song> songs, int limit) {
        Comparator<Song> byZipfs = Comparator.comparing(song -> song.getZipfsScore(), Comparator.reverseOrder());
        Comparator<Song> byPosition = Comparator.comparing(song -> song.getPosition());
        return songs.stream().sorted(byZipfs.thenComparing(byPosition)).limit(limit).collect(toList());
    }

    protected static Album getAlbumFromInput(Scanner in) {
        List<Song> songs = new LinkedList<>();
        try {
            int c = in.nextInt();
            limit = in.nextInt();

            in.nextLine();

            int firstSongPlaysCount = 0;

            for (int i = 1; i <= c; i++) {
                String s = in.nextLine();
                int plays = Integer.parseInt(s.split(" ")[0]);
                String title = s.split(" ")[1];

                if (i == 1) {
                    firstSongPlaysCount = plays;
                }

                int zipfsCount = firstSongPlaysCount / i;

                Song song = new Song(i, title, plays, zipfsCount);
                songs.add(song);
            }

        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong input format: " + e.getMessage());
        }

        return new Album(songs);
    }

    private static void printTitles(List<Song> songs) {
        for (Song song : songs) {
            System.out.println(song.getTitle());
        }
    }

}
