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
}

class BifidCipherEncrypt extends PolybiusSquare {

}

class BifidCipherDecrypt extends PolybiusSquare {

}

// Klasa kryesore që përdor kodimin dhe dekodimin
public class BifidCipher {
    public static void main(String[] args) {
    }
}