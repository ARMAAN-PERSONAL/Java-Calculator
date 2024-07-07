public class Calculator {
    public static void main(String[] args) {
        System.out.println("Welcome to Calculator App by Armaan Singh");
        System.out.println("Equations are in the form num1 operator num2 =\nWhere num1 and num2 must be integers.");
        System.out.println("operator is one of +, -, / or *");
        System.out.println("Enter 0 = to quit.");

        CalculatorEngine calculatorEngine = new CalculatorEngine();
        CalculatorInput calculatorInput = new CalculatorInput();

        while (true) {
            try {
                String input = calculatorInput.getInput();

                if (input.equals("0 =")) {
                    System.out.println("Program exiting.");
                    break;
                }

                int result = calculatorEngine.calculate(input);
                System.out.println("The answer is: " + result);

            } catch (NumberFormatException e) {
                System.out.println("Error: Input is not a valid integer. " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
