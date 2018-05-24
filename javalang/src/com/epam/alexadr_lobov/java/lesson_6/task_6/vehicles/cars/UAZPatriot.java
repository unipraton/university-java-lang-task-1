package com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars;

import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.type.Suv;

import java.io.Serializable;

public class UAZPatriot extends Suv implements Serializable {

    public UAZPatriot(Color color, int price) {
        super(color, price);
    }

    @Override
    public String getName() {
        return "UAZ Patriot";
    }

    @Override
    public int getMaxSpeed() {
        return 150;
    }

    @Override
    public int getEnginePower() {
        return 135;
    }

    @Override
    public double getFuelConsumption() {
        return 14.0;
    }
}
