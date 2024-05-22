import java.math.BigInteger;

public class Prime
{
    private int n;
    private int p;
    private int q;
    private int e;
    private int phi;

    public Prime(int n) //for bruteforce with only N
    {
        this.n = n;
        this.p = findP(n);
        this.q = n / p;
        this.phi = (p - 1) * (q - 1);
        this.e = findE(this.phi);
    }

    public Prime(int n, int e) //for bruteforce with N an E
    {
        this.n = n;
        this.p = findP(n);
        this.q = n / p;
        this.e = e;
    }

    protected boolean isPrime(int num) //checks if number is prime(it is necessary)
    {
        for (int i = 2; i <= Math.sqrt(num); i++) //Math.sqrt for optimization of work
        {
            if (num % i == 0) {return false;}
        }
        return true;
    }

    private int findP(int n)
    {
        for (int i = 2; i <= Math.sqrt(n); i++) //1 is always prime, so we start from 2
        {
            if (n % i == 0 && isPrime(i)) {p=i;}
        }
        return p;
    }

    private int findE(int phi)
    {
        int e = 3; //E starts from 3 usually
        while (BigInteger.valueOf(e).gcd(BigInteger.valueOf(phi)).intValue() != 1) {e += 2;}
        // program tries to find the smallest E for GCD. e += 2 is used for optimization since first E
        // numbers are 3,5,7...
        return e;
    }

    public int getP() {return p;}

    public int getQ() {return q;}

    public int getE() {return e;}

    public int getPhi() {return phi;}
}
