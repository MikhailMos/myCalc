package ru.example.entities;

import java.util.ArrayList;

public class ParseInput {

    public static ArrayList<MyExpression> result (String str) throws IllegalArgumentException {
        String[] tokens = str.split(" ");

        ArrayList<MyExpression> list = new ArrayList<>(10);

        for (int i = 0; i < tokens.length; i += 3) {

            double a, b;
            String operator;

            try {
                a = Double.parseDouble(tokens[i]);
                b = Double.parseDouble(tokens[i + 2]);
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Ошбика: неверный формат выражения. Ожидалось: число оператор число.");
            }

            operator = tokens[i + 1];

            list.add(new MyExpression(a, b, operator));
        }

        return list;
    }

}
