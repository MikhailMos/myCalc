import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyCalcTest {

    static Stream<Arguments> provideNumberForAdd() {
        return Stream.of(
                Arguments.of(new MyExpression(1.0, 2.0, "+"), 3.0),
                Arguments.of(new MyExpression(-1.0, 2.0, "+"), 1.0),
                Arguments.of(new MyExpression(1.0, -2.0, "+"), -1.0),
                Arguments.of(new MyExpression(-1.0, -2.0, "+"), -3.0),
                Arguments.of(new MyExpression(0.0, 0.0, "+"), 0.0)
        );
    }

    static Stream<Arguments> provideNumberForSubstraction() {
        return Stream.of(
                Arguments.of(new MyExpression(1.0, 2.0, "-"), -1.0),
                Arguments.of(new MyExpression(-1.0, 2.0, "-"), -3.0),
                Arguments.of(new MyExpression(1.0, -2.0, "-"), 3.0),
                Arguments.of(new MyExpression(-1.0, -2.0, "-"), 1.0),
                Arguments.of(new MyExpression(0.0, 0.0, "-"), 0.0)
        );
    }

    static Stream<Arguments> provideNumberForMult() {
        return Stream.of(
                Arguments.of(new MyExpression(2.0, 2.0, "*"), 4.0),
                Arguments.of(new MyExpression(-2.0, 2.0, "*"), -4.0),
                Arguments.of(new MyExpression(2.0, -2.0, "*"), -4.0),
                Arguments.of(new MyExpression(-2.0, -2.0, "*"), 4.0),
                Arguments.of(new MyExpression(0.0, 2.0, "*"), 0.0),
                Arguments.of(new MyExpression(2.0, 0.0, "*"), 0.0)
        );
    }

    static Stream<Arguments> provideNumberForDev() {
        return Stream.of(
                Arguments.of(new MyExpression(4.0, 2.0, "/"), 2.0),
                Arguments.of(new MyExpression(-4.0, 2.0, "/"), -2.0),
                Arguments.of(new MyExpression(4.0, -2.0, "/"), -2.0),
                Arguments.of(new MyExpression(-4.0, -2.0, "/"), 2.0),
                Arguments.of(new MyExpression(0.0, 2.0, "/"), 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumberForAdd")
    public void testCalculateAdd(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @ParameterizedTest
    @MethodSource("provideNumberForSubstraction")
    public void testCalculateSubstraction(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @ParameterizedTest
    @MethodSource("provideNumberForMult")
    public void testCalculateMult(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @ParameterizedTest
    @MethodSource("provideNumberForDev")
    public void testCalculateDev(MyExpression listOfExpressions, double result) {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(listOfExpressions);

        Assertions.assertEquals(result, MyCalc.calculate(list));
    }

    @Test
    public void testCalculateDevException() {
        ArrayList<MyExpression> list = new ArrayList<>(1);
        list.add(new MyExpression(2.0, 0.0, "/"));

        Exception exception = assertThrows(ArithmeticException.class, () -> MyCalc.calculate(list));

        Assertions.assertEquals("Ошбика: на ноль делить нельзя!", exception.getMessage());
    }

}