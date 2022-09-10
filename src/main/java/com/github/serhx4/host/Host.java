package com.github.serhx4.host;

import com.github.serhx4.composite.Broadcasting;

import java.util.ArrayList;
import java.util.List;

public abstract class Host {
    private final String name;
    private List<Broadcasting> broadcastingList = new ArrayList<>();

    public Host(String name) {
        this.name = name;
    }

    public void addBroadcast(Broadcasting broadcasting) {
        broadcastingList.add(broadcasting);
    }

    public void introduce() {
        System.out.println("\nHere's your host: " + name + " live in 5..4..3..2..1!");
    }

    public String getName() {
        return name;
    }
}
