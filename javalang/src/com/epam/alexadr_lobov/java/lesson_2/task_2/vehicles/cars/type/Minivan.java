package com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.cars.type;

import com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_2.task_2.vehicles.cars.properties.Color;

public abstract class Minivan extends Car {

    protected Minivan(Color color, int price) {
        super(color, price);
    }

    @Override
    public CarClass getCarClass() {
        return CarClass.MINIVAN;
    }
}
