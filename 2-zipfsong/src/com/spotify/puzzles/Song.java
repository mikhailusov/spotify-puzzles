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

    public int getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public int getZipfsScore() {
        return zipfsScore;
    }

    @Override
    public String toString() {
        return "Song{" +
                "position=" + position +
                ", title='" + title + '\'' +
                ", playsCount=" + playsCount +
                ", zipfsCount=" + zipfsCount +
                ", zipfsScore=" + zipfsScore +
                '}';
    }
}
