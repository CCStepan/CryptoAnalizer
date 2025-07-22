package cryptoanalizer;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher {

    static String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static String eng = "abcdefghijklmnopqrstuvwxyz";
    static String cypher = "1234567890";
    static String z = "!@#$%^&*()[]{}";

    private static final String ALPHABET = rus + eng + rus.toUpperCase() + eng.toUpperCase() + cypher + z;

    public static final String TXT_FOLDER = System.getProperty("user.dir") + File.separator + "text" + File.separator;
    // Методы для шифрования, расшифровки, brute force, статистического анализа

    public void encrypt(String inputFile, String outputFile, int key) {
        Validator validator = new Validator();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < ALPHABET.length(); i++) {


            alphabet.add(ALPHABET.charAt(i));
        }
        if (validator.isValidKey(key, alphabet) && validator.isFileExists(inputFile)) {
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
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabet.set(i, ALPHABET.charAt(i));
        }
        if (validator.isValidKey(key, alphabet) && validator.isFileExists(inputFile)) {
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
        // Реализация brute force
    }

    public void statisticalAnalysis(String inputFile,
                                    String outputFile, String optionalSampleFile) {
        // Реализация статистического анализа
    }

    // Вспомогательные методы: validateInput(), createAlphabet(), shiftCharacter(), readFile(), writeFile()

    public static void main(String[] args) {


        CaesarCipher cipherCipher = new CaesarCipher();
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Логика меню
                1. Шифрование
                2. Расшифровка с ключом
                3. Brute force
                4. Статистический анализ
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

            } else if (s.equals("4")) {

            }

        }

    }
}
