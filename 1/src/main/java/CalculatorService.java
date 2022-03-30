public class CalculatorService {
    public int add(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Arguments 'a' and 'b' are required.");
        }
        double aDouble = Double.parseDouble(a);
        double bDouble = Double.parseDouble(b);
        return Math.addExact((int) aDouble, (int) bDouble);
    }
}