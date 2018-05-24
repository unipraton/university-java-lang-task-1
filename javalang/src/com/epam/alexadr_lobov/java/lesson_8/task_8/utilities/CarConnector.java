package com.epam.alexadr_lobov.java.lesson_8.task_8.utilities;

import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.ChevroletRezzo;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.KiaSorento;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.MazdaMPV;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.UAZPatriot;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.Color;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

public class CarConnector {

    String path;

    public CarConnector(String path) {
        if (path == null) {
            throw new NullPointerException("path");
        }
        this.path = path;
    }

    public Car[] loadCars() throws IOException, SAXException, ParserConfigurationException {
        CarXmlParser carParser = new CarXmlParser(new File(path));
        return carParser.parse();
    }

    public boolean saveCars(Car[] cars) {
        if (cars == null) {
            throw new NullPointerException("cars");
        }
        return true;
    }
}
