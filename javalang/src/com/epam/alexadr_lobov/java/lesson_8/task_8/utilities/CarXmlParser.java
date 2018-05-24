package com.epam.alexadr_lobov.java.lesson_8.task_8.utilities;

import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.BaseCar;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.Car;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.CarClass;
import com.epam.alexadr_lobov.java.lesson_8.task_8.vehicles.cars.properties.Color;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import sun.misc.Regexp;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class CarXmlParser {

    private enum Action {
        READ_ROOT,
        READ_CAR,
        READ_CAR_ATTRIBUTE_BEGIN,
        READ_CAR_ATTRIBUTE_END
    }

    private File file;

    public CarXmlParser(File file) {
        if (file == null) {
            throw new NullPointerException("document");
        }
        this.file = file;
    }

    private static <T> boolean isEnumValueName(T enumValue, String name) {
        String value = enumValue.toString().replaceAll("[\\-_\\s]", "").toLowerCase();
        name = name.replaceAll("[\\-_\\s]", "").toLowerCase();
        return value.equalsIgnoreCase(name);
    }

    private static <T> T find(T[] enumValues, String name) {
        for (T value : enumValues) {
            if (isEnumValueName(value, name)) {
                return value;
            }
        }
        return null;
    }

    public Car[] parse() throws ParserConfigurationException, SAXException, IOException {

        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        List<Car> cars = new ArrayList<>();
        parser.parse(file, new DefaultHandler() {

            Action action = Action.READ_ROOT;

            Map<String, String> carFields = new TreeMap<>();
            String attribute = null;
            String attributeValue = null;

            void processCar() throws SAXException {
                String name = carFields.getOrDefault("name", null);
                String fuelConsumptionNode = carFields.getOrDefault("fuelconsumption", null);
                double fuelConsumption = 0.0;
                String maxSpeedNode = carFields.getOrDefault("maxspeed", null);
                int maxSpeed = 0;
                String colorNode = carFields.getOrDefault("color", null);
                Color color = null;
                String typeNode = carFields.getOrDefault("type", null);
                CarClass carType = null;
                String coastNode = carFields.getOrDefault("coast", null);
                int coast = 0;
                String enginePowerNode = carFields.getOrDefault("enginepower", null);
                int enginePower = 0;
                if (name == null) {
                    throw new SAXException("There are no Name node in Car node");
                }
                if (fuelConsumptionNode == null) {
                    throw new SAXException("There are no FuelConsumption node in Car node");
                } else {
                    try {
                        fuelConsumption = Double.parseDouble(fuelConsumptionNode);
                        if (fuelConsumption < 0) {
                            throw new SAXException("FuelConsumtion be real number greater or equals zero");
                        }
                    } catch (NumberFormatException ex) {
                        throw new SAXException("FuelConsumtion must be real number. Not like " + fuelConsumptionNode);
                    }
                }
                if (maxSpeedNode == null) {
                    throw new SAXException("There are no MaxSpeed node in Car node");
                } else {
                    try {
                        maxSpeed = Integer.parseUnsignedInt(maxSpeedNode);
                    } catch (NumberFormatException ex) {
                        throw new SAXException("MaxSpeed must be non negative integer");
                    }
                }
                if (colorNode == null) {
                    throw new SAXException("There are no Color node in Car node");
                } else {
                    color = find(Color.values(), colorNode);
                    if (color == null) {
                        throw new SAXException(colorNode + " is not valid color value. Use something from list " + Arrays.toString(Color.values()));
                    }
                }
                if (typeNode == null) {
                    throw new SAXException("There are no Type node in Car node");
                } else {
                    carType = find(CarClass.values(), typeNode);
                    if (carType == null) {
                        throw new SAXException(colorNode + " is not valid color value. Use something from list " + Arrays.toString(CarClass.values()));
                    }
                }
                if (coastNode == null) {
                    throw new SAXException("There are no Coast node in Car node");
                } else {
                    try {
                        coast = Integer.parseUnsignedInt(coastNode);
                    } catch (NumberFormatException ex) {
                        throw new SAXException("Coast must be non negative integer");
                    }
                }
                if (enginePowerNode == null) {
                    throw new SAXException("There are no EnginePower node in Car node");
                } else {
                    try {
                        enginePower = Integer.parseUnsignedInt(enginePowerNode);
                    } catch (NumberFormatException ex) {
                        throw new SAXException("EnginePower must be non negative integer");
                    }
                }
                cars.add(new BaseCar(name, carType, color, coast, maxSpeed, fuelConsumption, enginePower));
            }

            boolean isCorrectNode(String node) {
                return "coast".equalsIgnoreCase(node)
                        || "type".equalsIgnoreCase(node)
                        || "color".equalsIgnoreCase(node)
                        || "maxspeed".equalsIgnoreCase(node)
                        || "fuelconsumption".equalsIgnoreCase(node)
                        || "name".equalsIgnoreCase(node)
                        || "enginepower".equalsIgnoreCase(node);
            }

            void processValue() throws SAXException {
                if (!isCorrectNode(attribute)) {
                    throw new SAXException("Incorrect node");
                } else {
                    int left = 0;
                    int right = attributeValue.length();
                    while (left < right && Character.isWhitespace(attributeValue.charAt(left))) {
                        ++left;
                    }
                    while (right > left && Character.isWhitespace(attributeValue.charAt(right - 1))) {
                        --right;
                    }
                    carFields.put(attribute, attributeValue.substring(left, right));
                }
            }

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                switch (action) {
                    case READ_ROOT: {
                        if (qName.equalsIgnoreCase("cars")) {
                            action = Action.READ_CAR;
                        } else {
                            throw new SAXException("Root node must be 'Cars'");
                        }
                    }
                    break;
                    case READ_CAR: {
                        if (qName.equalsIgnoreCase("car")) {
                            carFields.clear();
                            action = Action.READ_CAR_ATTRIBUTE_BEGIN;
                        } else {
                            throw new SAXException("Root node must contain only 'Car' subnodes");
                        }
                    }
                    break;
                    case READ_CAR_ATTRIBUTE_BEGIN: {
                        attribute = qName.replaceAll("[\\s\\-_]", "").toLowerCase();
                        if (!qName.equalsIgnoreCase("technicalcharacteristics")) {
                            action = Action.READ_CAR_ATTRIBUTE_END;
                        }
                    }
                    break;
                    case READ_CAR_ATTRIBUTE_END: {
                        throw new SAXException("Car subnodes must contain only values");
                    }
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                switch (action) {
                    case READ_ROOT: {
                        throw new SAXException("Close attribute before opened");
                    }
                    case READ_CAR: {
                        action = Action.READ_ROOT;
                    }
                    break;
                    case READ_CAR_ATTRIBUTE_BEGIN: {
                        if (!qName.equalsIgnoreCase("technicalcharacteristics")) {
                            processCar();
                            action = Action.READ_CAR;
                        }
                    }
                    break;
                    case READ_CAR_ATTRIBUTE_END: {
                        processValue();
                        action = Action.READ_CAR_ATTRIBUTE_BEGIN;
                    }
                    break;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (action == Action.READ_CAR_ATTRIBUTE_END) {
                    this.attributeValue = new String(ch, start, length);
                }
            }

        });
        Car[] carArray = new Car[cars.size()];
        cars.toArray(carArray);
        return carArray;

    }

}
