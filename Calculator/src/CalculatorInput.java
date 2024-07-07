import java.util.Scanner;

public class CalculatorInput {
    private Scanner keyboard;

    public CalculatorInput() {
        this.keyboard = new Scanner(System.in);
    }

    public String getInput() {
        System.out.print("Enter your equation: ");
        String buffer = keyboard.nextLine();

        try (Scanner input = new Scanner(buffer)) {
            int num1, num2;
            String operator, equals;

            if (!input.hasNextInt()) {
                throw new IllegalArgumentException("First number is missing or not an integer.");
            }
            num1 = input.nextInt();

            if (!input.hasNext()) {
                throw new IllegalArgumentException("Equation incomplete. Operator is missing.");
            }
            operator = input.next();

            if (!input.hasNextInt()) {
                throw new IllegalArgumentException("Second number is missing or not an integer.");
            }
            num2 = input.nextInt();

            if (!input.hasNext("=")) {
                throw new IllegalArgumentException("Equation incomplete. Equation must end with '='.");
            }
            equals = input.next();

            // Returning the valid equation without the equals sign
            return num1 + " " + operator + " " + num2;

        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input. " + e.getMessage());
        }
    }
}
