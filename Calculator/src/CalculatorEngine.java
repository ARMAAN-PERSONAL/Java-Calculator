public class CalculatorEngine {
    public int calculate(String input) {
        String[] tokens = input.split("\\s+");
        
        if (tokens.length != 3) {
            throw new IllegalArgumentException("Invalid equation format. Please use the format num1 operator num2");
        }

        int num1, num2;

        try {
            num1 = Integer.parseInt(tokens[0]);
            num2 = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input. Both operands must be integers.");
        }

        String operator = tokens[1];

        switch (operator) {
            case "+":
                return add(num1, num2);
            case "-":
                return subtract(num1, num2);
            case "*":
                return multiply(num1, num2);
            case "/":
                return divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operator. Valid operators are +, -, /, and *.");
        }
    }

    private int add(int num1, int num2) {
        return num1 + num2;
    }

    private int subtract(int num1, int num2) {
        return num1 - num2;
    }

    private int multiply(int num1, int num2) {
        return num1 * num2;
    }

    private int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return num1 / num2;
    }
}
