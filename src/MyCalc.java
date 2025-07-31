import java.util.ArrayList;

public class MyCalc {
    public static double calculate(ArrayList<MyExpression> listOfExpressions) throws IllegalArgumentException, ArithmeticException {

        double result = 0.0;

        for (MyExpression expression : listOfExpressions) {

            String operator = expression.getOperator();

            switch (operator) {
                case "+":
                    result += add(expression.getA(), expression.getB());
                    break;
                case "-":
                    result += substraction(expression.getA(), expression.getB());
                    break;
                case "*":
                    result += multiplication(expression.getA(), expression.getB());
                    break;
                case "/":
                    result += dev(expression.getA(), expression.getB());
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка: некорректный оператор " + operator);
            }

        }

        return result;
    }

    private static double add(double a, double b) {
        return (a + b);
    }

    private static double substraction (double a, double b) {
        return (a - b);
    }

    private static double multiplication (double a, double b) {
        return (a * b);
    }

    private static double dev (double a, double b) throws ArithmeticException {
        if (b == 0.0) { throw new ArithmeticException("Ошбика: на ноль делить нельзя!"); }
        return (a / b);
    }
}
