package com.github.serhx4.host;

import com.github.serhx4.composite.Broadcasting;

import java.util.ArrayList;
import java.util.List;

public class RadioHost extends Host {

    private double experience;

    public RadioHost(String name, double experience) {
        super(name);
        this.experience = experience;
    }
}
