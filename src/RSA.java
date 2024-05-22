import java.math.BigInteger;

public class RSA //Class where encryption/decryption occurs
{
    private int p; // Prime number P
    private int q; // Prime number Q
    private int e; // Part of public key E
    private int d; // Private key D
    private int n; // Part of public key N

    public RSA(int p, int q, int e) //Default constructor
    {
        this.p = p;
        this.q = q;
        this.e = e;
        this.d = calcPrivateKey(); //we call private key calculation method
        this.n = p * q;
    }

    public RSA(int n) //Constructor for decryption of ciphertext with intercepted value of n
    {
        Prime prime = new Prime(n); //we create new obj based on Prime class
        this.n = n;
        this.p = prime.getP(); //getting P after calculations from Prime class
        this.q = prime.getQ(); //getting Q after calculations from Prime class
        this.e = prime.getE(); //getting E after calculations from Prime class
        this.d = calcPrivateKey();
    }

    public RSA(int n, int e) //Constructor for decryption of ciphertext with intercepted value of n and e
    {
        Prime prime = new Prime(n);
        this.n = n;
        this.p = prime.getP();
        this.q = prime.getQ();
        this.e = e;
        this.d = calcPrivateKey();
    }

    private int calcPrivateKey() //Method for calculating private key
    {
        int phi = (p - 1) * (q - 1); //Phi is used in generating private key
        BigInteger eBigInteger = BigInteger.valueOf(e);
        BigInteger phiBigInteger = BigInteger.valueOf(phi);
        BigInteger dBigInteger = eBigInteger.modInverse(phiBigInteger); // d = e^-1 mod phi(n)
        //assigning e, phi and d to BigInteger since we work with huge numbers

        return dBigInteger.intValue();
    }

    public String encrypt(String message) //Method for encryption
    {
        StringBuilder cyphertext = new StringBuilder();

        for (int i = 0; i < message.length(); i++)
        {
            char c = message.charAt(i); //getting character from plaintext
            BigInteger m = BigInteger.valueOf((int) c); //Assigning char of plaintext for encryption
            BigInteger encrypted = m.modPow(BigInteger.valueOf(e), BigInteger.valueOf(n)); // C = P^e mod n
            cyphertext.append(String.format("%03d", encrypted));
            //since we have no spaces between encrypted chars, we have to use format 000 to decrypt
            //ciphertext properly(for example, 78 will be 078)
        }

        return cyphertext.toString();
    }

    public String decrypt(String ciphertext)
    {
        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 3)
            //since we have format 000, we need to "take 3 steps"
        {
            String encryptedBlock = ciphertext.substring(i, i + 3);
            BigInteger encrypted = new BigInteger(encryptedBlock);
            BigInteger decrypted = encrypted.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
            //P = C^d mod n
            plaintext.append((char) decrypted.intValue());
        }

        return plaintext.toString();
    }

    public void setP(int p) {this.p = p;}

    public void setQ(int q) {this.q = q;}
    //i forgor where it is used
}
