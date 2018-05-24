package com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars;

import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.type.Minivan;

import java.io.Serializable;

public class MazdaMPV extends Minivan implements Serializable {

    public MazdaMPV(Color color, int price) {
        super(color, price);
    }

    @Override
    public String getName() {
        return "Mazda MPV";
    }

    @Override
    public int getMaxSpeed() {
        return 180;
    }

    @Override
    public int getEnginePower() {
        return 163;
    }

    @Override
    public double getFuelConsumption() {
        return 17.5;
    }
}
