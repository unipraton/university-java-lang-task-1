package com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.type;

import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.Car;

import java.io.Serializable;

public abstract class Suv extends Car implements Serializable {

    protected Suv(Color color, int price) {
        super(color, price);
    }

    @Override
    public CarClass getCarClass() {
        return CarClass.SUV;
    }
}
