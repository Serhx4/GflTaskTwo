package com.github.serhx4.data;

import com.github.serhx4.composite.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomData {
    /* Simple database simulation
     * If we use real database, pattern DAO wil be useful here
     * getRandom() method works with data tables and helps to automatically fill broadcasting
     */
    private static final List<String> SONGS =
            Arrays.asList("Popular song", "Rock hit", "Kids song", "Magic Symphony", "Heavy metal");
    private static final List<String> SINGERS =
            Arrays.asList("Rock star", "Rap star", "New Star", "Popular singer", "New singer");

    private static final List<String> PRODUCTS =
            Arrays.asList("Useless crap", "Useful but still crap", "One more crap", "Good crap");

    private static final List<String> INTERVIEWEES =
            Arrays.asList("John Gold", "Steve Jobs", "Lido Iacocca");

    public static Broadcasting getRandom(BroadcastType type) {
        // if RANDOM so randomly choose between SONG / AD / INTERVIEW
        if (type.equals(BroadcastType.RANDOM))
            type = BroadcastType.values()[random(BroadcastType.values().length-1)];

        if (type.equals(BroadcastType.ADVERTISEMENT)) {
            return new Advertisement(
                    random(10,30), PRODUCTS.get(random(PRODUCTS.size())));
        }

        else if(type.equals(BroadcastType.INTERVIEW)) {
            return new Interview(
                    random(300,1200), INTERVIEWEES.get(random(INTERVIEWEES.size())));
        }

        else {
            return new Song(
                    random(120,480),
                    SINGERS.get(random(SINGERS.size())),
                    SONGS.get(random(SONGS.size()))
            );
        }

    }
    private static int random(int max) {
        return new Random().nextInt(max);
    }
    private static int random(int min, int max) {
        return new Random().nextInt((max - min) + 1) + 1;
    }
}
