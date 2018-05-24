package com.epam.alexadr_lobov.java.lesson_6.task_6;

import com.epam.alexadr_lobov.java.lesson_6.task_6.utilities.CarConnector;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.Sellable;
import com.epam.alexadr_lobov.java.lesson_6.task_6.utilities.ArrayUtility;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.ChevroletRezzo;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.KiaSorento;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.MazdaMPV;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.UAZPatriot;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.properties.Color;

import java.util.Arrays;
import java.util.Comparator;


/**
 * Лобов Александр Андреевич 531 группа
 * Lesson 4 Task 4, Serialization'
 */
public class Autopark {

    public static void main(String[] args) {
        new Autopark().run();
    }

    static int getTotalPrice(Sellable[] sellables) {

        if (sellables == null) {
            throw new NullPointerException("sellables");
        }

        int totalPrice = 0;
        for (Sellable item : sellables) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    private static void showPrices(Car[] cars) {

        if (cars == null) {
            throw new NullPointerException("cars");
        }

        System.out.println("Prices:");
        for (Car car : cars) {
            System.out.println("\t" + car.getColor() + " " + car.getName() + ": " + car.getPrice());
        }

        System.out.println("TotalPrice: " + getTotalPrice(cars));
    }

    private static void showSortedByFuelConsumtion(Car[] cars) {

        if (cars == null) {
            throw new NullPointerException("cars");
        }

        cars = cars.clone();
        Arrays.sort(cars, Comparator.comparingDouble(Car::getFuelConsumption));
        System.out.println("Sorted by fuel consumption:");
        for (Car car : cars) {
            System.out.println("\t" + car.getColor() + " " + car.getName() + ": " + car.getFuelConsumption());
        }
    }

    /**
     * Check is value in range [lowerBound, upperBound)
     *
     * @param value      is value to check
     * @param lowerBound is the lower bound inclusive
     * @param upperBound is the upper bound exclusive
     * @return
     */
    private static boolean isInRange(double value, double lowerBound, double upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException("lowerBound must be less or equals upperBound");
        }
        return value >= lowerBound && value < upperBound;
    }

    private static void showCarWithParameters(Car[] cars) {

        if (cars == null) {
            throw new NullPointerException("cars");
        }

        int fuelConsumptionLowerBound = 10;
        int fuelConsumptionUpperBound = 20;
        int indexOfRedCarWithLowFuelConsumption = ArrayUtility.indexOf(
                cars, 0,
                cars.length,
                (car) -> car.getColor() == Color.RED && isInRange(
                        car.getFuelConsumption(),
                        fuelConsumptionLowerBound,
                        fuelConsumptionUpperBound));
        if (indexOfRedCarWithLowFuelConsumption < 0) {
            System.out.println(
                    "There are no red car with fuel consumption in range ["
                    + fuelConsumptionLowerBound
                    + ", "
                    + fuelConsumptionUpperBound
                    + ") litres by kilometer");
        } else {
            System.out.println(
                    cars[indexOfRedCarWithLowFuelConsumption].getName()
                    + " is a red car with fuel consumption in range ["
                    + fuelConsumptionLowerBound
                    + ", "
                    + fuelConsumptionUpperBound
                    + ") litres by kilometer");
        }
    }

    private void run() {

        try {

            CarConnector connector = new CarConnector("cars.jso");

            Car[] cars = connector.loadCars();

            showPrices(cars);
            System.out.println();
            showSortedByFuelConsumtion(cars);
            System.out.println();
            showCarWithParameters(cars);

            connector.saveCars(cars);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
