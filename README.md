# Password Strength Checker

## Overview

This Java application evaluates the strength of user-provided passwords based on predefined criteria. It considers factors such as length, character diversity, entropy, and variance to categorize passwords as Weak, Medium, or Strong.

## Variance and Entropy

### Variance

Variance is a statistical metric used to measure how much the members of a set (in this case, characters in a password) are scattered around their mean (average). The formula for calculating the variance (\(\sigma^2\)) is:

\[ \sigma_x^2 = E(x^2) - (\mu_x)^2 \]

Where:
- \(\sigma_x^2\) is the variance of the random variable x.
- \(E(x^2)\) is the expected value (mean) of the squared values of x.
- \((\mu_x)^2\) is the square of the expected value (mean) of x.

In practical terms, the variance is also commonly computed using the formula:

\[ \sigma^2 = \frac{1}{N} \sum_{i=1}^N (x_i - \mu)^2 \]

### How Variance Contributes

- A higher variance suggests that the characters in the password are distributed more evenly, contributing to increased complexity.

### Entropy

Entropy, in the realm of information theory, quantifies the uncertainty or randomness of a system. For password strength evaluation, entropy measures the number of bits needed to describe the characters in a password. The formula for entropy is:

\[ h = -p_1 \log(p_1) - p_2 \log(p_2) - \ldots - p_s \log(p_s) \]

Where:
- \( h \) is the entropy.
- \( p_i \) is the probability of using password \( s_i \).

Higher entropy values indicate a more diverse and unpredictable arrangement of characters, adding an extra layer of security.

## How to Use

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/password-strength-checker.git
    ```

2. Compile and run the application:

    ```bash
    cd password-strength-checker
    javac PasswordStrengthChecker.java
    java PasswordStrengthChecker
    ```

3. Follow the prompts to input your password and view the strength assessment.

## Password Strength Categories

- **Weak:** Does not meet recommended complexity standards.
- **Medium:** Adequate but could be improved for better security.
- **Strong:** Meets or exceeds recommended complexity standards.

## Suggestions for Improvement

If your password is categorized as Weak or Medium, consider the following improvements:

- Add special characters.
- Use a mix of uppercase and lowercase letters.
- Include numbers.

Feel free to customize the code and contribute to its enhancement!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
