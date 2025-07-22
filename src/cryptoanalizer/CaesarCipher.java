package cryptoanalizer;

import java.util.Scanner;

public class CaesarCipher {

    static String rus = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    static String eng = "abcdefghijklmnopqrstuvwxyz";
    static String cypher = "1234567890";
    static String z = "!@#$%^&*()[]{}";

    private static final String ALPHABET = rus + eng + rus.toUpperCase() + eng.toUpperCase() + cypher + z;

    // Методы для шифрования, расшифровки, brute force, статистического анализа

    public void encrypt(String inputFile, String outputFile, int key) {
        // Реализация шифрования
    }

    public void decrypt(String inputFile, String outputFile, int key) {
        // Реализация расшифровки
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
        CaesarCipher cipher = new CaesarCipher();
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


                cipher.encrypt(inputNameFile, outputNameFile, key);


            } else if (s.equals("2")) {
                System.out.print("Введите файл, где находится Ваш текст: ");
                String inputNameFile = scanner.nextLine();
                System.out.print("Введите файл, куда нужно записать результат: ");
                String outputNameFile = scanner.nextLine();
                System.out.print("Введите значение ключа: ");
                int key = scanner.nextInt();


                cipher.decrypt(inputNameFile, outputNameFile, key);
            } else if (s.equals("3")) {

            } else if (s.equals("4")) {

            }

        }

    }
}
