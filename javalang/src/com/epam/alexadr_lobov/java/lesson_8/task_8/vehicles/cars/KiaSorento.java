package com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars;

import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.type.Suv;

import java.io.Serializable;

public class KiaSorento extends Suv implements Serializable {

    public KiaSorento(Color color, int price) {
        super(color, price);
    }

    @Override
    public String getName() {
        return "KIA Sorento";
    }

    @Override
    public int getMaxSpeed() {
        return 195;
    }

    @Override
    public int getEnginePower() {
        return 188;
    }

    @Override
    public double getFuelConsumption() {
        return 30.0;
    }
}
