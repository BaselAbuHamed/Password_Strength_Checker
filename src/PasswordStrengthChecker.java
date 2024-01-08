import java.util.HashMap;

public class PasswordStrengthChecker {

    public static double calculateEntropy(String password) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (char c : password.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

//        System.out.println(charCounts);

        double entropy = 0;
        for (int count : charCounts.values()) {
            double p = (double) count / password.length();
            entropy -= p * Math.log(p) / Math.log(2);
        }

        return entropy;
    }

    public static double calculateVariance(String password) {
        int length = password.length();
        int uniqueCharacters = (int) password.chars().distinct().count();
        double entropy = calculateEntropy(password);
        return (entropy / Math.log(2)) * length / uniqueCharacters;
    }

    public static String assessStrength(String password) {
        int length = password.length();

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());

        boolean hasNumbers = password.matches(".*\\d.*");
        boolean hasSymbols = !password.matches("[a-zA-Z0-9]*");

        double entropy = calculateEntropy(password);
        double variance = calculateVariance(password);

        if (length >= 8 && hasUppercase && hasLowercase && hasNumbers &&
                hasSymbols && entropy > 2.5 && variance > 1.5) {
            return "Strong";
        } else if (length >= 8 && hasUppercase && hasLowercase &&
                (hasNumbers || hasSymbols) && entropy > 1.5 && variance > 0.5) {
            return "Medium";
        } else {
            return "Weak";
        }
    }
    public static void providePasswordGuidance(String strength) {
        switch (strength) {
            case "Weak":
                System.out.println("Suggestion: Add special characters, use a mix of uppercase and" +
                        " lowercase letters, include numbers.");
                break;
            case "Medium":
                System.out.println("Suggestion: Consider adding more variety, such as special " +
                        "characters or increasing the length.");
                break;
            case "Strong":
                System.out.println("Your password is strong. Well done!");
                break;
        }
    }
}