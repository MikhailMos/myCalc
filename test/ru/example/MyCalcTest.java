package ru.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.example.dataForTests.ArgumentsForAdd;
import ru.example.dataForTests.ArgumentsForDivision;
import ru.example.dataForTests.ArgumentsForMultiplication;
import ru.example.dataForTests.ArgumentsForSubstraction;
import ru.example.entities.MyCalc;
import ru.example.entities.MyExpression;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MyCalcTest {

    @DisplayName("Addition tests")
    @ParameterizedTest
    @ArgumentsSource(ArgumentsForAdd.class)
    public void testCalculateAdd(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @DisplayName("Substraction tests")
    @ParameterizedTest
    @ArgumentsSource(ArgumentsForSubstraction.class)
    public void testCalculateSubstraction(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @DisplayName("Multiplication tests")
    @ParameterizedTest
    @ArgumentsSource(ArgumentsForMultiplication.class)
    public void testCalculateMult(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @DisplayName("Division tests")
    @ParameterizedTest
    @ArgumentsSource(ArgumentsForDivision.class)
    public void testCalculateDev(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @DisplayName("Division by zero (exception expected)")
    @Test
    public void testCalculateDevException() {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(new MyExpression(2.0, 0.0, "/"));

        Exception exception = assertThrows(ArithmeticException.class, () -> MyCalc.calculate(list));

        Assertions.assertEquals("Ошбика: на ноль делить нельзя!", exception.getMessage());
    }

}