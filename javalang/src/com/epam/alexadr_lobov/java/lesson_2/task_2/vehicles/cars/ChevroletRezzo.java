package com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.cars;

import com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.cars.type.Minivan;

public class ChevroletRezzo extends Minivan {

    public ChevroletRezzo(Color color, int price) {
        super(color, price);
    }

    @Override
    public String getName() {
        return "Chevrolet Rezzo";
    }

    @Override
    public int getMaxSpeed() {
        return 167;
    }

    @Override
    public int getEnginePower() {
        return 90;
    }

    @Override
    public double getFuelConsumption() {
        return 12.0;
    }
}
