import java.math.BigInteger;

public class Exceptions
{
    Prime prime = new Prime(999); // 999 because error occurs for some reason

    public void checkPrime(int n)
    {
        if (n <= 0) {throw new IllegalArgumentException("Number " + n + " cannot be equal to or less than 0");}
        if (!prime.isPrime(n)) {throw new IllegalArgumentException("Number " + n + " is not a prime");}
        //uses isPrime from Prime class
    }

    public void checkE(int n) {
        int phi = prime.getPhi();
        if (BigInteger.valueOf(n).gcd(BigInteger.valueOf(phi)).intValue() != 1)
            // uses findE statement from Prime class
        {
            throw new IllegalArgumentException("Invalid exponent (e): BigInteger not invertible");
        }
    }
}
