package cryptoanalizer;

public class Cipher {
    private char[] alphabet;

    public Cipher(char[] alphabet) {
        this.alphabet = alphabet;
    }

    public String encrypt(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);

            System.out.println(text.charAt(i));
        }
        return result;
    }

    public String decrypt(String encryptedText, int shift) {
        String result = "";
        return result;
    }


}