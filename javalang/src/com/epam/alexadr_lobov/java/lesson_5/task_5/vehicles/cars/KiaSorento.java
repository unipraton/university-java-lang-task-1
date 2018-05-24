package com.epam.alexadr_lobov.java.lesson_5.task_5.vehicles.cars;

import com.epam.alexadr_lobov.java.lesson_5.task_5.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_5.task_5.vehicles.cars.type.Suv;

public class KiaSorento extends Suv {

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
