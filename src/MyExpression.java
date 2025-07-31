public class MyExpression {
    private double a, b;
    private String operator;

    MyExpression() {}

    MyExpression(double a, double b, String operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    MyExpression(double a, String operator, double b) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public String toString() {
        return (Double.toString(a) + " " + operator + " " + Double.toString(b) + " = ");
    }
}
