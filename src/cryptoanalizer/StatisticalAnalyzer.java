package cryptoanalizer;

import java.util.ArrayList;

public class StatisticalAnalyzer {
    public int findMostLikelyShift(String encryptedText,
                                   ArrayList<Character> alphabet, String representativeText) {
        double min = Double.MAX_VALUE;
        int key = -1;
        CaesarCipher caesarCipher = new CaesarCipher();
        double[] starterSet = caesarCipher.getFrequencies(representativeText, alphabet);
        Cipher cipher = new Cipher(alphabet);

        for (int i = 1; i < alphabet.size() - 1; i++) {

            String textBadNew = cipher.decrypt(encryptedText, i);

            double[] resultSet = caesarCipher.getFrequencies(textBadNew, alphabet);
            double delta = caesarCipher.getDelta(starterSet, resultSet);

            if (delta < min) {
                min = delta;
                key = i;


            }

        }
        return key;
    }
}