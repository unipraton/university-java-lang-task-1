package com.epam.alexadr_lobov.java.lesson_6.task_6.utilities;

import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.ChevroletRezzo;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.KiaSorento;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.MazdaMPV;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.UAZPatriot;
import com.epam.alexadr_lobov.java.lesson_6.task_6.vehicles.cars.properties.Color;

import java.io.*;

public class CarConnector {

    String path;

    public CarConnector(String path) {
        if (path == null) {
            throw new NullPointerException("path");
        }
        this.path = path;
    }

    private static final Car[] DEFAULT_CARS = {
            new UAZPatriot(Color.WHITE, 980000),
            new MazdaMPV(Color.BLACK, 724000),
            new KiaSorento(Color.CYAN, 2000000),
            new UAZPatriot(Color.BLUE, 1100000),
            new ChevroletRezzo(Color.YELLOW, 820000),
            new MazdaMPV(Color.WHITE, 701000),
            new KiaSorento(Color.MAGENTA, 1800000),
            new ChevroletRezzo(Color.GREEN, 725000),
            new UAZPatriot(Color.RED, 875000)};

    public Car[] loadCars() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(path))) {
            return (Car[])input.readObject();
        } catch (Exception e) {
            return DEFAULT_CARS;
        }
    }

    public boolean saveCars(Car[] cars) {
        if (cars == null) {
            throw new NullPointerException("cars");
        }
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(path))) {
            output.writeObject(cars);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
