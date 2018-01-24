/**
 * 2018 Mikhail Usov <musovx@gmail.com>
 *
 * For Spotify with <3
 *
 * Zipf’s Song
 */

package com.spotify.puzzles;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private List<Song> songs;

    public Album(List<Song> songs) {
        this.songs = songs;
    }

    /**
     * Keeping songs list immutable
     * @return List Songs
     */
    public List<Song> getSongs() {
        return new ArrayList<>(this.songs);
    }
}
