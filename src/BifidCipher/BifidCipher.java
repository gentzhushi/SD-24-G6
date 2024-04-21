package BifidCipher;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class PolybiusSquare {
    protected final char[][] SQUARE = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'},
            {'q', 'r', 's', 't', 'u'},
            {'v', 'w', 'x', 'y', 'z'}
    };
    protected final HashMap<Character, int[]> charToCoord = new HashMap<>();
    public PolybiusSquare() {
        for (int i = 0; i < SQUARE.length; i++) {
            for (int j = 0; j < SQUARE[i].length; j++) {
                charToCoord.put(SQUARE[i][j], new int[]{i + 1, j + 1});
            }
        }
    }
    public int[] letterToNumbers(char letter) {
        if (letter == 'j') {
            letter = 'i'; // trajto 'j' si 'i'
        }

        int[] indexes = charToCoord.get(letter); // marrja e koordinatave
        if (indexes == null) { // nëse nuk është gjetur në hartë
            throw new IllegalArgumentException("Karakteri '" + letter + "' nuk u gjet në tabelën Polybius.");
        }

        return indexes;
    }

    public char numbersToLetter(int index1, int index2) {
        return SQUARE[index1 - 1][index2 - 1]; // kthimi nga 1-based në 0-based
    }

}

// Klasa per enkriptim
class BifidCipherEncrypt extends PolybiusSquare {
    public String encrypt(String message) {
        message = message.toLowerCase().replaceAll("\\s+", "").replace("j", "i");

        ArrayList<Integer> firstStepRow = new ArrayList<>();
        ArrayList<Integer> firstStepCol = new ArrayList<>();

        for (char letter : message.toCharArray()) {
            int[] indexes = letterToNumbers(letter);
            firstStepRow.add(indexes[0]);
            firstStepCol.add(indexes[1]);
        }

        ArrayList<Integer> secondStep = new ArrayList<>();
        secondStep.addAll(firstStepRow);
        secondStep.addAll(firstStepCol);

        StringBuilder encryptedMessage = new StringBuilder();
        for (int i = 0; i < secondStep.size(); i += 2) {
            int index1 = secondStep.get(i);
            int index2 = secondStep.get(i + 1);
            encryptedMessage.append(numbersToLetter(index1, index2));
        }

        return encryptedMessage.toString();
    }
}

// Klasa per dekriptim
class BifidCipherDecrypt extends PolybiusSquare {
    public String decrypt(String message) {
        message = message.toLowerCase().replaceAll("\\s+", "").replace("j", "i");

        ArrayList<Integer> firstStep = new ArrayList<>();
        for (char letter : message.toCharArray()) {
            int[] indexes = letterToNumbers(letter);
            firstStep.add(indexes[0]);
            firstStep.add(indexes[1]);
        }

        int half = firstStep.size() / 2;
        ArrayList<Integer> rowIndexes = new ArrayList<>(firstStep.subList(0, half));
        ArrayList<Integer> colIndexes = new ArrayList<>(firstStep.subList(half, firstStep.size()));

        StringBuilder decryptedMessage = new StringBuilder();
        for (int i = 0; i < rowIndexes.size(); i++) {
            int index1 = rowIndexes.get(i);
            int index2 = colIndexes.get(i);
            decryptedMessage.append(numbersToLetter(index1, index2));
        }

        return decryptedMessage.toString();
    }
}

// Klasa kryesore që përdor kodimin dhe dekodimin
public class BifidCipher {
    public static void main(String[] args) {

    }
}