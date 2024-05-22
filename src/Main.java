import java.util.Scanner;

public class Main
{
    static boolean continueExecution = true; // used for continuous loop

    public static void main(String[] args)
    {
        Main main = new Main(); // we call Main class
        Scanner scanner = new Scanner(System.in); // we call scanner for user input

        System.out.println("RSAcrack.exe"); //hacknet reference
        do
        {
            System.out.println("Choose a method:");
            System.out.println("1. Encryption");
            System.out.println("2. Decryption");
            System.out.println("0. Exit");

            int methodChoice = scanner.nextInt();
            scanner.nextLine();

            switch (methodChoice) // based on user's choice
            {
                case 1:
                    main.encryption(scanner); // calls encryption method from Main
                    continueExecution = askToContinue(scanner);
                    // calls askToContinue if user would like to do something else
                    break;
                case 2:
                    main.decryption(scanner); // calls decryption method from Main
                    continueExecution = askToContinue(scanner);
                    break;
                case 0:
                    System.out.println("Shutting down"); //exiting program
                    continueExecution = false;
                    break;
                default:
                    System.out.println("Choose a proper method of work"); //if user input something else
            }
        }
        while (continueExecution); // continue loop
    }

    static int p, q, e;
    public void encryption(Scanner scanner) // encryption method
    {
        System.out.print("Enter P: ");
        p = scanner.nextInt();

        System.out.print("Enter Q: ");
        q = scanner.nextInt();

        System.out.print("Enter E: ");
        e = scanner.nextInt();
        // getting all values from user

        scanner.nextLine();
        System.out.println("Enter a message to encrypt: ");
        String message = scanner.nextLine();
        // getting message from user

        RSA rsaEnc = new RSA(p, q, e);
        // creating rsaEnc object from RSA class with default constructor
        String encrypted = rsaEnc.encrypt(message); // encrypting message
        System.out.println("Encrypted message: " + encrypted);
    }

    public void decryption(Scanner scanner) // decryption method
    {
        System.out.println("Enter a mode of decryption: ");
        System.out.println("1. Standard");
        System.out.println("2. Bruteforce");
        System.out.println("0. Exit");

        int modeChoice = scanner.nextInt();
        scanner.nextLine();

        switch (modeChoice)
        {
            case 1:
                standardDecryption(scanner);
                break;
            case 2:
                bruteforceDecryption(scanner);
                break;
            case 0:
                System.out.println("Shutting down");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid mode choice");
        }
    }

    public void standardDecryption(Scanner scanner)
    {
        int p, q, e;
        System.out.print("Enter P: ");
        p = scanner.nextInt();

        System.out.print("Enter Q: ");
        q = scanner.nextInt();

        System.out.print("Enter E: ");
        e = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter a message to decrypt: ");
        String message = scanner.nextLine();

        RSA rsaDec = new RSA(p, q, e);
        String decrypted = rsaDec.decrypt(message);
        System.out.println("Decrypted message: " + decrypted);
    }

    public void bruteforceDecryption(Scanner scanner)
    {
        System.out.println("Enter a method of bruteforce: ");
        System.out.println("1. Intercepted values of n and e");
        System.out.println("2. Intercepted value of n");
        System.out.println("0. Exit");

        int bruteforceMethodChoice = scanner.nextInt();
        scanner.nextLine();

        switch (bruteforceMethodChoice)
        {
            case 1:
                bruteForceNandE(scanner);
                break;
            case 2:
                bruteForceN(scanner);
                break;
            case 0:
                System.out.println("Shutting down");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid mode choice");
        }
    }

    public void bruteForceNandE(Scanner scanner)
    {
        int n, e;
        System.out.print("Enter N: ");
        n = scanner.nextInt();

        System.out.print("Enter E: ");
        e = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter a message to decrypt: ");
        String message = scanner.nextLine();

        RSA rsaDecBNE = new RSA(n, e);
        String decrypted = rsaDecBNE.decrypt(message);
        System.out.println("Decrypted message: " + decrypted);
    }

    public void bruteForceN(Scanner scanner)
    {
        int n;
        System.out.print("Enter N: ");
        n = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Enter a message to decrypt: ");
        String message = scanner.nextLine();

        RSA rsaDecBN = new RSA(n);
        String decrypted = rsaDecBN.decrypt(message);
        System.out.println("Decrypted message: " + decrypted);
    }

    public static boolean askToContinue(Scanner scanner)
    {
        System.out.println("Do you want to continue? (Y/N)");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("N"))
        {
            System.out.println("Bye bye, shutting down");
            return false;
        }
        else {return choice.equals("Y");}
    }
}
