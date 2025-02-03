"Red Snake", or RSA_Encryptor, is a tool for encrypting/decrypting messages and files with the RSA algorithm.

RSA is a public-key cryptosystem, one of the oldest widely used for secure data transmission. In a public-key cryptosystem, the encryption key is public and distinct from the decryption key, which is kept secret (private). An RSA user creates and publishes a public key based on two large prime numbers, along with an auxiliary value. The prime numbers are kept secret. Messages can be encrypted by anyone via the public key but can only be decrypted by someone who knows the private key.
However, Red Snake might break a private key and decrypt the message.

PLAN OF DEVELOPMENT (e.g., extension of the program)
Right now this is a working prototype that can encrypt/decrypt messages; however, there is much more to improve/add/expand.

1. USER-FRIENDLY INTERFACE: The commands might not be understandable. I will rename and expand an interface of the program.

2. EXCEPTIONS: Right now, the user can type almost every number to p, q, or e he desires; however, it may occur in a problem with encryption. I will add proper exceptions.

3. RANDOM KEYS GENERATION: Right now, the user manually types p and q. However, the user might not know the technical part of the algorithm, so the program can create it randomly. Several not major fixes were included. I will create a key generator for that purpose.

4. "INCESSANT ATTACK": Right now, the program stops working when the message is decrypted, even if it's decrypted wrong. I will add continuous decryption, which will stop automatically (?) or manually by the user.

5. DICTIONARY: part of 4. Not sure how, but I will try a dictionary so the program can recognise words (which would be used in the decryption method).

6. FILES: That's right, encrypt/decrypt files too.

