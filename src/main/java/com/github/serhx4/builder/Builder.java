package com.github.serhx4.builder;

import com.github.serhx4.composite.BroadcastType;
import com.github.serhx4.composite.Broadcasting;
import com.github.serhx4.composite.CompoundBroadcasting;
import com.github.serhx4.data.RandomData;
import com.github.serhx4.host.Host;

public abstract class Builder {
    /* Builder pattern is kinda useful to build 'tree' structure of Composite pattern
     * start/endComposite() and addChild() methods
     * helps to create complicated structure of Composite easily
     * fillBroadcast() method of this Builder helps to fill broadcast automatically
     */
    private final int duration;
    private final Host host;

    private CompoundBroadcasting rootBroadcast;
    private CompoundBroadcasting currentBroadcast;

    public Builder(int duration, Host host, String name) {
        this.duration = duration;
        this.host = host;
        rootBroadcast = new CompoundBroadcasting(duration, host, name);
        currentBroadcast = rootBroadcast;
    }

    public Builder startComposite(String name) {
        currentBroadcast = new CompoundBroadcasting(name);
        rootBroadcast.add(currentBroadcast);
        return this;
    }

    public Builder endComposite() {
        currentBroadcast = rootBroadcast;
        return this;
    }

    public  Builder addChild(Broadcasting broadcasting) {
        currentBroadcast.add(broadcasting);
        return this;
    }

    public Builder fillBroadcast(String name, int number, BroadcastType type) {
        startComposite(name);

        while (number > 0) {
            addChild(RandomData.getRandom(type));
            number--;
        }

        endComposite();
        return this;
    }

    public CompoundBroadcasting getResult() {
        return rootBroadcast;
    }

    public int getDuration() {
        return duration;
    }

    public Host getHost() {
        return host;
    }
}
