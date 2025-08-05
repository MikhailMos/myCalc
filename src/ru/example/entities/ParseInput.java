package ru.example.entities;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseInput {

    public static ArrayList<MyExpression> parse(String str) {
        ArrayList<MyExpression> list = new ArrayList<>(10);

        // any expression e.g.: 2 + 3 or 10-5
        String regexp = "(\\-?[0-9]+\\.?[0-9]*)\\s*([+\\-*/])\\s*(\\-?[0-9]+\\.?[0-9]*)";

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(str.trim());

        if (matcher.find() && matcher.groupCount() == 3) {

            double a = Double.parseDouble(matcher.group(1));
            String operator = matcher.group(2);
            double b = Double.parseDouble(matcher.group(3));

            list.add(new MyExpression(a, b, operator));

        } else {
            throw new IllegalArgumentException("Ошбика: неверный формат выражения. Ожидалось: число оператор число.");
        }

        return list;
    }

}
