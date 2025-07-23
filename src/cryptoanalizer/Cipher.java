package cryptoanalizer;

import java.util.ArrayList;

public class Cipher {
    private ArrayList<Character> alphabet;


    public Cipher(ArrayList<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (!alphabet.contains(symbol)) {
                result = result + symbol;
            } else {
                result = result + alphabet.get((alphabet.indexOf(symbol) + shift) % alphabet.size());
            }
        }
        return result;
    }

    public String decrypt(String encryptedText, int shift) {
        String result = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            char symbol = encryptedText.charAt(i);
            if (!alphabet.contains(symbol)) {
                result = result + symbol;
            } else {

                if ((alphabet.indexOf(symbol) - shift) % alphabet.size() < 0) {
                    result = result + alphabet.get(alphabet.size()+ (alphabet.indexOf(symbol) - shift) % alphabet.size());
                } else {
                    result = result + alphabet.get((alphabet.indexOf(symbol) - shift) % alphabet.size());

                }
            }
        }
        return result;
    }


}
