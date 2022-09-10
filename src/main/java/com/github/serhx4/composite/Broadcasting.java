package com.github.serhx4.composite;

import com.github.serhx4.host.Host;

public abstract class Broadcasting implements Broadcast {
    /* Realization of Composite pattern
     * This pattern is very useful to complete a lot of tasks of the project including:
     * - saving all parts of broadcast according to their order
     * - calculation of profit from current broadcast including nested parts
     * - printing all parts of broadcasting including nested ones
     */
    private final int duration;
    private Host host;
    private ContentType type = ContentType.FREE;

    public Broadcasting(int duration) {
        this.duration = duration;
    }

    public Broadcasting(int duration, Host host) {
        this.duration = duration;
        this.host = host;
    }

    public int getDuration() {
        return duration;
    }

    public Host getHost() {
        return host;
    }

    public ContentType getType() {
        return type;
    }

    public void setType(ContentType type) {
        this.type = type;
    }
}
