## Running the Program

To run the Bifid Cipher program, follow these steps:

1. **Clone the Repository**
   - Clone the GitHub repository to your local machine using Git:
     ```bash
     git clone <repository-url>
     ```

2. **Open the Project in IntelliJ IDEA**
   - Open IntelliJ IDEA and navigate to the cloned project.
   - Open the `BifidCipher` package and locate the `BifidCipher.java` file.

3. **Run the Program**
   - Click the "Run" button in IntelliJ IDEA to execute the program.
   - Alternatively, you can use the following command in your terminal to compile and run the program:
     ```bash
     javac BifidCipher/BifidCipher.java
     java BifidCipher.BifidCipher
     ```

4. **Select Encrypt or Decrypt Mode**
   - When prompted, choose `encrypt` to encrypt a message or `decrypt` to decrypt a message.

5. **Provide Input for Encryption/Decryption**
   - If you choose `encrypt`, enter the message to encrypt.
   - If you choose `decrypt`, enter the encrypted message to decrypt.

6. **View the Output**
   - After providing the input, the program will display the encrypted or decrypted message accordingly.
  
# Bifid Cipher Algorithm

The Bifid cipher is a polygraphic substitution cipher which was invented by Félix Delastelle in around 1901. The Bifid Cipher is an encryption algorithm that uses the Polybius square to encode and decode messages. This algorithm combines substitution and transposition to achieve a higher level of security.

## How Bifid Cipher Works

1. **Polybius Square**:
   - The algorithm uses a 5x5 square containing the alphabet, where the letter 'j' is typically treated as 'i' to fit all letters.
   - Each letter has specific coordinates in the square (row and column).

2. **Encoding**:
   - During encoding, the message to be encrypted is translated into coordinates from the Polybius square.
   - The letter coordinates are separated into two groups: rows and columns.
   - All row coordinates are concatenated, followed by all column coordinates.
   - Using these mixed coordinates, an encoded message is created by converting back to letters from the Polybius square.

3. **Decoding**:
   - During decoding, the encoded message is translated into a list of coordinates.
   - The coordinates are divided into two groups: the first half represents rows, and the second half represents columns.
   - The coordinates are reassembled into pairs (row and column) to reconstruct the original letters from the Polybius square.
   - This process yields the decoded message, which represents the original text.

The Bifid Cipher provides a complex yet straightforward method for encrypting and decrypting messages.

# Examples from execution 

  ![encrypt](https://github.com/gentzhushi/SD-24-G6/assets/147100017/514d4880-7a65-46a7-b5e2-9183c5d09396)

  ![decrypt](https://github.com/gentzhushi/SD-24-G6/assets/147100017/f0b91354-b0ad-40c4-9596-8d8a4a919174)
