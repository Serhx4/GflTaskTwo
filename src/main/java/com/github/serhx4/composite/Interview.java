package com.github.serhx4.composite;

public class Interview extends Broadcasting {
    private final String interviewee;
    private final static int MINUTE_PRICE = 30;

    public Interview(int duration, String interviewee) {
        super(duration);
        this.interviewee = interviewee;
        super.setType(ContentType.PAID);
    }

    @Override
    public void broadcast() {
        System.out.println("Welcome our guest: " + interviewee);
    }

    @Override
    public int getProfit() {
        return getDuration()/60 * MINUTE_PRICE;
    }
}
