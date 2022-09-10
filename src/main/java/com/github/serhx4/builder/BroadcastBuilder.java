package com.github.serhx4.builder;

import com.github.serhx4.composite.Broadcasting;
import com.github.serhx4.composite.CompoundBroadcasting;
import com.github.serhx4.composite.ContentType;
import com.github.serhx4.composite.Song;
import com.github.serhx4.host.Host;

public class BroadcastBuilder extends Builder{
    /* Example of realization Builder pattern
     * Inside this builder we control total duration of broadcast,
     * don't allow to exceed 50% for paid content,
     * fill empty broadcast time left with RadioMix from our MC
     */
    private int summTime = 0;
    private int paidTime = 0;

    public BroadcastBuilder(int duration, Host host, String name) {
        super(duration, host, name);
    }

    @Override
    public Builder addChild(Broadcasting broadcasting) {
        if (validated(broadcasting)) {
            updateStatus(broadcasting);
            super.addChild(broadcasting);
        }
        return this;
    }

    @Override
    public CompoundBroadcasting getResult() {
        fillBroadcasting();
        super.getHost().addBroadcast(super.getResult()); // update broadcast list for host
        return super.getResult();
    }

    // Update current time variables
    private void updateStatus(Broadcasting broadcasting) {
        int currentDuration = broadcasting.getDuration();
        summTime += currentDuration;

        if (broadcasting.getType().equals(ContentType.PAID)) {
            paidTime += currentDuration;
        }

    }

    // Checkings
    private boolean validated(Broadcasting broadcasting) {

        return checkDuration(broadcasting) && checkPaidContent(broadcasting);
    }
    private boolean checkDuration(Broadcasting broadcasting) {
        int predictTime = summTime + broadcasting.getDuration();

        return predictTime <= getDuration();
    }
    private boolean checkPaidContent(Broadcasting broadcasting) {

        if (broadcasting.getType().equals(ContentType.PAID)) {
            int predictPaidTime = paidTime + broadcasting.getDuration();
            return predictPaidTime <= (getDuration() / 2);   // paid content shouldn't exceed 50% of total time
        } else return true;

    }

    // Fill empty broadcast time
    private void fillBroadcasting() {
        int emptyTime = getDuration() - summTime;
        if (emptyTime > 0) {
            addChild(new Song(emptyTime,"MC " + super.getHost().getName(), "Fresh Radio Mix"));
        }
    }
}
