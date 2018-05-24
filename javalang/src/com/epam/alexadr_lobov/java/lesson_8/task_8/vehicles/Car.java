package com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles;

import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.exceptions.InvalidPriceException;

import java.io.Serializable;

public abstract class Car implements Vehicle, Sellable, Nameable, Serializable {

    private Color color;
    private int price;

    protected Car(Color color, int price) {

        if (color == null) {
            throw new NullPointerException("color");
        }

        if (price < 0) {
            throw new InvalidPriceException("price must be greater or equals zero");
        }

        this.color = color;
        this.price = price;
    }

    public abstract CarClass getCarClass();

    public Color getColor() {
        return color;
    }

    @Override
    public int getPrice() { return price; }

    /**
     * Fuel consumption on 100 kilometr on city roads
     * @return fuelConsumption in liters
     */
    public abstract double getFuelConsumption();

}
