package com.epam.alexadr_lobov.java.lesson_1.task_1;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String NUMBER = "(-|\\+)?[0-9]+(\\.[0-9]*)?";
    private static final String SPACES = "\\s*";

    private static final String ADD =
            SPACES + NUMBER + SPACES + "\\+" + SPACES + NUMBER + SPACES;
    private static final String SUBTRACT =
            SPACES + NUMBER + SPACES + "-" + SPACES + NUMBER + SPACES;
    private static final String MULTIPLY =
            SPACES + NUMBER + SPACES + "\\*" + SPACES + NUMBER + SPACES;
    private static final String DIVIDE =
            SPACES + NUMBER + SPACES + "/" + SPACES + NUMBER + SPACES;

    private static List<BigDecimal> parseNumbers(String text) {
        Pattern pattern = Pattern.compile(NUMBER);
        Matcher matcher = pattern.matcher(text);
        List<BigDecimal> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(new BigDecimal(text.substring(matcher.start(), matcher.end())));
        }
        return list;
    }

    private static String add(String text) {
        List<BigDecimal> values = parseNumbers(text);
        return (values.get(0).add(values.get(1))).toString();
    }

    private static String subtract(String text) {
        List<BigDecimal> values = parseNumbers(text);
        return (values.get(0).subtract(values.get(1))).toString();
    }

    private static String multiply(String text) {
        List<BigDecimal> values = parseNumbers(text);
        return (values.get(0).multiply(values.get(1))).toString();
    }

    private static String divide(String text) {
        List<BigDecimal> values = parseNumbers(text);
        return (values.get(0).divide(values.get(1), 10, BigDecimal.ROUND_HALF_DOWN)).toString();
    }

    public static String calculate(String text) {
        if (text.matches(ADD)) {
            return add(text);
        } else if (text.matches(SUBTRACT)) {
            return subtract(text);
        } else if (text.matches(MULTIPLY)) {
            return multiply(text);
        } else if (text.matches(DIVIDE)) {
            return divide(text);
        } else {
            throw new IllegalArgumentException("Input string is not value");
        }
    }

}
