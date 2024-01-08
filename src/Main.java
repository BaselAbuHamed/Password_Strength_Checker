import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        printInitialHint();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: \n");
        String password = scanner.nextLine();

        double entropy = PasswordStrengthChecker.calculateEntropy(password);
        double variance = PasswordStrengthChecker.calculateVariance(password);

        String strength = PasswordStrengthChecker.assessStrength(password);

        System.out.println("Entropy: " + entropy);
        System.out.println("Variance: " + variance);
        System.out.println("Password strength: " + strength + getEmojiForStrength(strength));

        PasswordStrengthChecker.providePasswordGuidance(strength);
    }

    public static void printInitialHint() {
        System.out.println("\nWelcome to the Password Strength Checker!");
        System.out.println("Please follow the guidelines to create a strong password:");
        System.out.println("Guidance: Provide a password with a mix of uppercase and lowercase letters," +
                " numbers, and special characters.");
        System.out.println("Hint: Avoid using common words or sequences.");
        System.out.println("Let's get started!\n");
    }

    public static String getEmojiForStrength(String strength) {
        return switch (strength) {
            case "Strong" -> " 💪";
            case "Medium" -> " 🙂";
            default -> " 😕";
        };
    }
}