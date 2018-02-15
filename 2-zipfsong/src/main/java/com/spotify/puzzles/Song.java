/**
 * 2018 Mikhail Usov <musovx@gmail.com>
 *
 * For Spotify with <3
 *
 * Zipf’s Song
 */

package com.spotify.puzzles;

public class Song {
    private int position;
    private String title;
    private int playsCount;
    private int zipfsCount;
    private int zipfsScore;

    public Song(int position, String title, int playsCount, int zipfsCount) {
        this.position = position;
        this.title = title;
        this.playsCount = playsCount;
        this.zipfsCount = zipfsCount;
        this.zipfsScore = playsCount - zipfsCount;
    }

    public Song(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public int getZipfsScore() {
        return zipfsScore;
    }
}
