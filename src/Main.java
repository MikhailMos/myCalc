import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("+---------------------------------------------------------------+");
        System.out.println("| Для выхода из программы наберите \"esc\" (регистронезависимо)! |");
        System.out.println("+---------------------------------------------------------------+");

        while (true) {
            try {

                System.out.println("Введите выражение из двух чисел, через пробел (например: 3 + 7):");

                String input = in.nextLine();

                // проверка выхода из цикла
                if (input.equalsIgnoreCase("Esc")) {
                    break;
                }

                ArrayList<MyExpression> listOfExpressions = ParseInput.result(input);
                double result = MyCalc.calculate(listOfExpressions);

                System.out.printf("Результат: %f\n", result);

            } catch (ArithmeticException | IllegalArgumentException  ex) {
                System.out.println(ex.getMessage());
            } catch (Exception ex) {
                System.out.println("ошбика: " + ex + "\n" + ex.getMessage());
            }
        }

        in.close();
        System.out.println("Выход из программы");

    }

}