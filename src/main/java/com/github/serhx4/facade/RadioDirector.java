package com.github.serhx4.facade;

import com.github.serhx4.builder.BroadcastBuilder;
import com.github.serhx4.composite.BroadcastType;
import com.github.serhx4.data.RandomData;
import com.github.serhx4.host.GuestHost;
import com.github.serhx4.host.RadioHost;

import static com.github.serhx4.composite.BroadcastType.*;

public class RadioDirector {
    /* Director for Builder pattern but in the same time looks like Facade pattern
     * Allows to create and manage broadcasts of Radio station
     * Simplifies code for Client
     */

    public static void startStream(
            int duration, String name, String hostName, BroadcastType type, int broadcastNumber) {

        new BroadcastBuilder(duration, new RadioHost(hostName, 1), name)
                .fillBroadcast(type.name() + " part", broadcastNumber, type)
                .getResult().broadcast();
    }

    public static void startBalancedStream(int duration, String name, String hostName) {

        new BroadcastBuilder(duration, new GuestHost(hostName, "empty.."), name)

                .addChild(RandomData.getRandom(INTERVIEW))

                .startComposite("Music part")
                    .addChild(RandomData.getRandom(SONG))
                    .addChild(RandomData.getRandom(SONG))
                    .addChild(RandomData.getRandom(SONG))

                        .startComposite("Ad pause")
                            .addChild(RandomData.getRandom(ADVERTISEMENT))
                            .addChild(RandomData.getRandom(ADVERTISEMENT))
                            .addChild(RandomData.getRandom(ADVERTISEMENT))
                        .endComposite()

                    .addChild(RandomData.getRandom(SONG))
                    .addChild(RandomData.getRandom(SONG))
                .endComposite()

                .startComposite("Interviews")
                    .addChild(RandomData.getRandom(INTERVIEW))
                    .addChild(RandomData.getRandom(ADVERTISEMENT))
                    .addChild(RandomData.getRandom(INTERVIEW))
                .endComposite()

                .getResult().broadcast();
    }
}
