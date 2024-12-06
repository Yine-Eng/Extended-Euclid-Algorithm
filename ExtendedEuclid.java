/**
 * This class implements the Extended Euclidean Algorithm to compute
 * the modular multiplicative inverse of two numbers.
 * The modular inverse of `b` mod `a` is a number `x` such that (b * x) % a = 1.
 */
public class ExtendedEuclid {
    private int a; // The modulus (always the larger number)
    private int b; // The number for which we want the modular inverse
    private int originalA; // Stores the original a for reference
    private int originalB; // Stores the original b for reference

    /**
     * Constructor to initialize the class with two numbers.
     * Ensures that `a` is the larger number and `b` is the smaller number.
     * 
     * @param a First number (modulus if larger).
     * @param b Second number (number for which we want the modular inverse).
     */
    public ExtendedEuclid(int a, int b) {
        this.originalA = a;
        this.originalB = b;
        this.a = Math.max(a, b); // Assign the larger value to a
        this.b = Math.min(a, b); // Assign the smaller value to b
    }

    /**
     * Computes the modular multiplicative inverse of `b` mod `a` using the Extended Euclidean Algorithm.
     * 
     * @return The modular inverse if it exists; otherwise, -1 if no inverse exists.
     */
    public int findMultiplicativeInverse() {
        int x0 = 0, x1 = 1; // Initial coefficients for the algorithm
        int tempA = a, tempB = b; // Temporary variables for calculations

        // Extended Euclidean Algorithm to find gcd and coefficients
        while (tempB != 0) {
            int q = tempA / tempB; // Calculate quotient
            int remainder = tempA % tempB;

            // Update a and b
            tempA = tempB;
            tempB = remainder;

            // Update coefficients
            int newX = x0 - q * x1;
            x0 = x1;
            x1 = newX;
        }

        // If gcd(a, b) is not 1, no modular inverse exists
        if (tempA != 1) {
            System.out.println("The multiplicative inverse of " + originalB + " mod " + originalA + " does not exist (DNE).");
            return -1;
        }

        // Ensure the result is positive
        int inverse = (x0 % a + a) % a; // Using x0 for the inverse
        System.out.println("The multiplicative inverse of " + originalB + " mod " + originalA + " is " + inverse);
        return inverse;
    }

    // main method
    public static void main(String[] args) {
        // Example input: Two numbers for which we compute the modular inverse
        int a = 53; // Larger number
        int b = 30; // Smaller number

        // Instantiate the class and compute the modular inverse
        ExtendedEuclid ee = new ExtendedEuclid(a, b);
        ee.findMultiplicativeInverse();
    }
}
