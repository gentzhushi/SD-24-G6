package BifidCipher;

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

class BifidCipherEncrypt extends PolybiusSquare {

}

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
}

// Klasa kryesore që përdor kodimin dhe dekodimin
public class BifidCipher {
    public static void main(String[] args) {
    }
}