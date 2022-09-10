package com.github.serhx4.composite;

import com.github.serhx4.host.Host;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundBroadcasting extends Broadcasting{
    private String broadcastName;
    private List<Broadcast> broadcastList = new ArrayList<>();

    public CompoundBroadcasting(int duration, Host host, String name) {
        super(duration, host);
        this.broadcastName = name;
    }
    public CompoundBroadcasting(String broadcastName) {
        super(0);
        this.broadcastName = broadcastName;
    }


    public void add(Broadcast broadcast) {
        broadcastList.add(broadcast);
    }
    public void add(Broadcast... broadcasts) {
        broadcastList.addAll(Arrays.asList(broadcasts));
    }

    @Override
    public int getDuration() {
        return broadcastList.stream().mapToInt(Broadcast::getDuration).sum();
    }

    @Override
    public void broadcast() {
        if(getHost() != null) getHost().introduce();
        System.out.println("ONLINE: " + broadcastName);

        broadcastList.forEach(Broadcast::broadcast);

        if (getHost() != null) {
            System.out.println("SUMMARY:");
            System.out.println("Length: ~" + getDuration()/60 + " mins");
            System.out.println("Profit: " + getProfit() + " euro");
        }
    }

    @Override
    public int getProfit() {
        return broadcastList.stream().mapToInt(Broadcast::getProfit).sum();
    }
}