package com.github.serhx4.composite;

public class Song extends Broadcasting {
    private final String singer;
    private final String name;

    public Song(int duration, String singer, String name) {
        super(duration);
        this.singer = singer;
        this.name = name;
        super.setType(ContentType.FREE);
    }

    @Override
    public void broadcast() {
        System.out.println("Playing: " + name + " by " + singer);
    }

    @Override
    public int getProfit() {
        return 0;
    }
}
