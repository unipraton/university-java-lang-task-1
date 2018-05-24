package com.epam.alexadr_lobov.java.lesson_4.task_4.vehicles.cars.type;

import com.epam.alexadr_lobov.java.lesson_4.task_4.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_4.task_4.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_4.task_4.vehicles.cars.properties.Color;

public abstract class Suv extends Car {

    protected Suv(Color color, int price) {
        super(color, price);
    }

    @Override
    public CarClass getCarClass() {
        return CarClass.SUV;
    }
}
