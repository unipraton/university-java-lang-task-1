package com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles;

import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.Color;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.exceptions.InvalidPriceException;

import java.io.Serializable;

public class BaseCar extends Car implements Serializable {

    private double fuelConsumption;

    private CarClass carClass;

    private int maxSpeed;

    private String name;

    private int enginePower;

    public BaseCar(String name, CarClass carClass, Color color, int price, int maxSpeed, double fuelConsumtion, int enginePower) {
        super(color, price);

        if (name == null) {
            throw new NullPointerException("name");
        }
        if (carClass == null) {
            throw new NullPointerException("carClass");
        }
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("maxSpeed must be greater or equals zero");
        }
        if (fuelConsumtion < 0) {
            throw new IllegalArgumentException("fuelConsumption must be greater or equals zero");
        }
        if (enginePower < 0) {
            throw new IllegalArgumentException("enginePower must be greater or equals zero");
        }

        this.name = name;
        this.carClass = carClass;
        this.maxSpeed = maxSpeed;
        this.fuelConsumption = fuelConsumtion;
        this.enginePower = enginePower;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    /**
     * Fuel consumption on 100 kilometr on city roads
     * @return fuelConsumption in liters
     */
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public int getEnginePower() {
        return enginePower;
    }

}
