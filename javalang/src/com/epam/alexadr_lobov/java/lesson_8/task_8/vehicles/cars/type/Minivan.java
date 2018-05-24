package com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.type;

import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.Color;

import java.io.Serializable;

public abstract class Minivan extends Car implements Serializable {

    protected Minivan(Color color, int price) {
        super(color, price);
    }

    @Override
    public CarClass getCarClass() {
        return CarClass.MINIVAN;
    }
}
