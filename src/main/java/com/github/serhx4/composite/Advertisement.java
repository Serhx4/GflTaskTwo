package com.github.serhx4.composite;

public class Advertisement extends Broadcasting {
    private final String productName;
    private final static int SECOND_PRICE = 5;

    public Advertisement(int duration, String productName) {
        super(duration);
        this.productName = productName;
        super.setType(ContentType.PAID);
    }

    @Override
    public int getDuration() {
        return super.getDuration();
    }

    @Override
    public void broadcast() {
        System.out.println("Ad time: " + productName);
    }

    @Override
    public int getProfit() {
        return getDuration() * SECOND_PRICE;
    }
}
