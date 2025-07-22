package cryptoanalizer;

import java.util.ArrayList;

public class Validator {
    public boolean isValidKey(int key, ArrayList<Character> alphabet) {
       int n =alphabet.size();
        if (key==0){
            return false;
        }if (key==n){
            return false;
        }if (key<0){
            return false;
        }
        return true;
    }
    public boolean isFileExists(String filePath) {
        return true;
    }
}