import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        do {
            System.out.print("Welcome to the Random Password Generator Program: ");
            System.out.print("\n\nEnter the desired password length: ");
            int length = scanner.nextInt();

            int complexity;
            do {
                System.out.print("\nEnter the desired complexity level (1, 2, or 3):");
                System.out.print("\n1. Low Complexity");
                System.out.print("\n2. Medium Complexity");
                System.out.print("\n3. High Complexity\n");
                complexity = scanner.nextInt();

                if (complexity < 1 || complexity > 3) {
                    System.out.println("Invalid complexity level. Please enter a valid value (1, 2, or 3).");
                }
            } while (complexity < 1 || complexity > 3);

            String password = generateRandomPassword(length, complexity, random);
            System.out.println("Generated Password: " + password);

            System.out.print("\nDo you want to generate another password? (yes/no): ");
            String response = scanner.next();

            if (!response.equalsIgnoreCase("yes")) {
                break;
            }

        } while (true);
        System.out.println("Thank You Visit Again!!!");

        scanner.close();
    }

    public static String generateRandomPassword(int length, int complexity, Random random) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numericChars = "0123456789";
        String specialChars = "!@#$%^&*()";

        StringBuilder password = new StringBuilder();

        // Determine the characters to be included based on complexity level
        String validChars = lowercaseChars + uppercaseChars;
        if (complexity >= 2) {
            validChars += numericChars;
        }
        if (complexity >= 3) {
            validChars += specialChars;
        }

        // Generate the password by randomly selecting characters from the valid characters
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            char randomChar = validChars.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}

