package cryptoanalizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class CaesarCipher {

    static String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static String eng = "abcdefghijklmnopqrstuvwxyz";
    static String cypher = "1234567890";
    static String z = "!@#$%^&*()[]{} ";
    private static final String ALPHABET = rus + eng + rus.toUpperCase() + eng.toUpperCase() + cypher + z;

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    // Методы для шифрования, расшифровки, brute force, статистического анализа

    public void encrypt(String inputFile, String outputFile, int key) {
        Validator validator = new Validator();
        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabet.add(ALPHABET.charAt(i));
        }
        if (validator.isValidKey(key, alphabet) && validator.isFileExists(TXT_FOLDER + inputFile)) {
            Cipher cipher = new Cipher(alphabet);
            FileManager fileManager = new FileManager();


            String text = cipher.encrypt(fileManager.readFile(TXT_FOLDER + inputFile), key);
            fileManager.writeFile(text, TXT_FOLDER + outputFile);

        } else {
            System.out.println("Ключ недействителен или файла не существует");
        }
    }

    public void decrypt(String inputFile, String outputFile, int key) {
        Validator validator = new Validator();
        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabet.add(ALPHABET.charAt(i));
        }

        if (validator.isValidKey(key, alphabet) && validator.isFileExists(TXT_FOLDER + inputFile)) {
            Cipher cipher = new Cipher(alphabet);
            FileManager fileManager = new FileManager();


            String text = cipher.decrypt(fileManager.readFile(TXT_FOLDER + inputFile), key);
            fileManager.writeFile(text, TXT_FOLDER + outputFile);

        } else {
            System.out.println("Ключ недействителен или файла не существует");
        }
    }

    public void bruteForce(String inputFile, String outputFile,
                           String optionalSampleFile) {
        Validator validator = new Validator();
        ArrayList<Character> alphabet = new ArrayList<>();

        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabet.add(ALPHABET.charAt(i));
        }
        if (validator.isFileExists(TXT_FOLDER + inputFile) &&

                validator.isFileExists(TXT_FOLDER + optionalSampleFile)) {

            FileManager fileManager = new FileManager();
            String text = fileManager.readFile(TXT_FOLDER + optionalSampleFile);
            String textBad = fileManager.readFile(TXT_FOLDER + inputFile);
            Cipher cipher = new Cipher(alphabet);


            StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();
            int key = statisticalAnalyzer.findMostLikelyShift(textBad, alphabet, text);

            String result = cipher.decrypt(textBad, key);
            System.out.println(key + " " + result);
            fileManager.writeFile(text, TXT_FOLDER + outputFile);

        } else {
            System.out.println("Одного из Ваших файлов нет");
        }
    }

    public double[] getFrequencies(String text, ArrayList<Character> alph) {
        double[] result = new double[alph.size()];
        for (int i = 0; i < alph.size(); i++) {
            result[i] = symbolFrequency(text, alph.get(i));
        }

        return result;
    }

    public double getDelta(double[] arr1, double[] arr2) {
        double result = 0;

        for (int i = 0; i < arr1.length; i++) {
            result += Math.pow(arr1[i] - arr2[i], 2);

        }
        return Math.sqrt(result);
    }

    public double symbolFrequency(String str, char symbol) {

        double result = 0.0d;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == symbol) {
                result++;
            }
        }
        return result / str.length();
    }


    public static void main(String[] args) {


        CaesarCipher cipherCipher = new CaesarCipher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Логика меню
                1. Шифрование
                2. Расшифровка с ключом
                3. Brute force
                0. Выход
                """);
        while (true) {
            System.out.print("Введите Вашу команду: ");
            String s = scanner.nextLine();

            if (s.equals("0")) {
                break;
            } else if (s.equals("1")) {
                System.out.print("Введите файл, где находится Ваш текст: ");
                String inputNameFile = scanner.nextLine();
                System.out.print("Введите файл, куда нужно записать результат: ");
                String outputNameFile = scanner.nextLine();
                System.out.print("Введите значение ключа: ");
                int key = scanner.nextInt();


                cipherCipher.encrypt(inputNameFile, outputNameFile, key);


            } else if (s.equals("2")) {
                System.out.print("Введите файл, где находится Ваш текст: ");
                String inputNameFile = scanner.nextLine();
                System.out.print("Введите файл, куда нужно записать результат: ");
                String outputNameFile = scanner.nextLine();
                System.out.print("Введите значение ключа: ");
                int key = scanner.nextInt();


                cipherCipher.decrypt(inputNameFile, outputNameFile, key);
            } else if (s.equals("3")) {
                System.out.print("Введите файл, где находится Ваш текст: ");
                String inputNameFile = scanner.nextLine();
                System.out.print("Введите файл, куда нужно записать результат: ");
                String outputNameFile = scanner.nextLine();
                System.out.print("Введите файл, где нужно записан пример: ");
                String optionalSampleFile = scanner.nextLine();

                cipherCipher.bruteForce(inputNameFile, outputNameFile, optionalSampleFile);
            }

        }

    }
}
