package com.github.serhx4.composite;

import com.github.serhx4.host.GuestHost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompoundBroadcastingTest {
    private CompoundBroadcasting broadcasting;

    @BeforeEach
    void setUp() {
        broadcasting =
                new CompoundBroadcasting(360, new GuestHost("Aloha", ""), "test");
        broadcasting.add(
                new Advertisement(10, "?"),
                new Advertisement(10, "?"),
                new Advertisement(30, "?"),
                new Advertisement(10, "?"),
                new Song(180, "", ""),
                new Interview(115,"")
        );
    }

    @Test
    void getDuration() {
        int expected = 355;
        int actual = broadcasting.getDuration();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getProfit() {
        int expected = 60*5 + 30;
        int actual = broadcasting.getProfit();
        Assertions.assertEquals(expected, actual);
    }
}