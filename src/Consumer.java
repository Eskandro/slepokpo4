import java.io.*;
import java.util.Scanner;

public class Consumer {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            scanner.nextLine();
            System.out.println("Процесс потребитель");
            scanner.nextLine();
            System.out.println("P(SРазрЧт)");
            outerLoop:
            while (true) {
                File file = new File("SРазрЧт");
                writeZero(file);
                break outerLoop;
            }

            scanner.nextLine();
            System.out.println("P(SВзИскл)");

            outerLoop:
            while (true) {
                File file = new File("SВзИскл");
                writeZero(file);
                break outerLoop;
            }

            scanner.nextLine();
            System.out.println("Вход в крит участок");
            scanner.nextLine();
            System.out.println("Выход из крит участка");
            scanner.nextLine();

            System.out.println("V(SВзИскл)");
            outerLoop:
            while (true) {
                File file = new File("SВзИскл");
                writeOne(file);
                break outerLoop;
            }
            scanner.nextLine();
            System.out.println("V(SРазрЗап)");
            outerLoop:
            while (true) {
                File file = new File("SРазрЗап");
                writeOne(file);
                break outerLoop;
            }
        }
    }

    public static void writeZero(File file) {

        try {
            // Чтение файла
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            boolean containsOne = false;

            while ((line = reader.readLine()) != null) {
                // Проверка, содержится ли "1" в строке
                if (line.contains("1")) {
                    containsOne = true;
                    // Замена "1" на "0"
                    line = line.replace("1", "0");
                }
                content.append(line).append("\n");
            }

            reader.close();

            // Запись изменений обратно в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            if (containsOne) {
                System.out.println("Процесс заблокирован");
            } else {
                System.out.println("Ожидание на семафоре");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }

    public static void writeOne(File file) {
        try {
            // Чтение файла
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            boolean containsOne = false;

            while ((line = reader.readLine()) != null) {
                // Проверка, содержится ли "0" в строке
                if (line.contains("0")) {
                    containsOne = true;
                    // Замена "0" на "1"
                    line = line.replace("0", "1");
                }
                content.append(line).append("\n");
            }

            reader.close();

            // Запись изменений обратно в файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();

            if (containsOne) {
                System.out.println("Процесс разблокирован");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}