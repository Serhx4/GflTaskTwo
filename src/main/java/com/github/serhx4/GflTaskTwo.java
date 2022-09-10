package com.github.serhx4;

import com.github.serhx4.composite.BroadcastType;
import com.github.serhx4.facade.RadioDirector;

public class GflTaskTwo {
    public static void main(String[] args) {
        GflTaskTwo taskTwo = new GflTaskTwo();
        taskTwo.complete();
    }

    private void complete() {
        // auto-filling broadcast with randomly choosed types
        RadioDirector.startStream(
                3600, "Morning mix","J-Jones",
                BroadcastType.RANDOM, 15);

        // filling stream with Ads + musicMix by RadioHost
        RadioDirector.startStream(
                1200, "Ad block", "Aloha",
                BroadcastType.ADVERTISEMENT, 10);

        // method to show Builder and Composition synergy
        RadioDirector.startBalancedStream(3600, "Daily broadcast", "J-Jones");
    }
}
