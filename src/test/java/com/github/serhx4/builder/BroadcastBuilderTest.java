package com.github.serhx4.builder;

import com.github.serhx4.composite.Interview;
import com.github.serhx4.composite.Song;
import com.github.serhx4.host.GuestHost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BroadcastBuilderTest {

    private BroadcastBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new BroadcastBuilder(120, new GuestHost("", ""),"");
    }

    @Test
    void addChild() {
        builder.addChild(new Interview(60, ""));

        int expectedDuration = 120; // autofill empty 60 seconds left after calling getResult()
        int actualDuration = builder.getResult().getDuration();
        Assertions.assertEquals(expectedDuration, actualDuration);

        // shouldn't pass validation
        builder.addChild(new Song(120, "", ""));

        int currentDuration = builder.getResult().getDuration();
        Assertions.assertEquals(expectedDuration, currentDuration);
    }
}