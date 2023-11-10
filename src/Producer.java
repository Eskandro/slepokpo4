import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producer {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);


            scanner.nextLine();
            System.out.println("Процесс производитель");
            scanner.nextLine();
            System.out.println("P(SРазрЗап)");
            outerLoop:

            while (true) {
                String file = "SРазрЗап";
                try {

                    // Создаем объект FileReader и BufferedReader для чтения файла
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder newContent = new StringBuilder();
                    String line;

                    // Бесконечный цикл
                    outerParam:
                    while (true) {
                        // Читаем файл построчно
                        while ((line = bufferedReader.readLine()) != null) {
                            // Если в файле записан "0", выводим "Ожидание"
                            if ("0".equals(line.trim())) {
                                System.out.println("Ожидание на семафоре");
                                scanner.nextLine();

                            } else if ("1".equals(line.trim())) {
                                replaceTextInFile(file, "1", "0");
                                System.out.println("Процесс заблокирован");
                                break outerParam;
                            } else {
                                // Добавьте обработку других значений, если необходимо
                                System.out.println("Неожиданное значение в файле: " + line);
                            }
                        }

                        // Сбрасываем указатель в начало файла, чтобы можно было снова читать его с начала
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break outerLoop;
            }
            scanner.nextLine();
            System.out.println("P(SВзИскл)");
            outerLoop:
            while (true) {
                String file = "SВзИскл";
                try {

                    // Создаем объект FileReader и BufferedReader для чтения файла
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder newContent = new StringBuilder();
                    String line;

                    // Бесконечный цикл
                    outerParam:
                    while (true) {
                        // Читаем файл построчно
                        while ((line = bufferedReader.readLine()) != null) {
                            // Если в файле записан "0", выводим "Ожидание"
                            if ("0".equals(line.trim())) {
                                System.out.println("Ожидание на семафоре");
                                scanner.nextLine();

                            } else if ("1".equals(line.trim())) {
                                replaceTextInFile(file, "1", "0");
                                System.out.println("Процесс заблокирован");
                                break outerParam;
                            } else {
                                // Добавьте обработку других значений, если необходимо
                                System.out.println("Неожиданное значение в файле: " + line);
                            }
                        }

                        // Сбрасываем указатель в начало файла, чтобы можно было снова читать его с начала
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                String file = "SВзИскл";
                try {

                    // Создаем объект FileReader и BufferedReader для чтения файла
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder newContent = new StringBuilder();
                    String line;

                    // Бесконечный цикл
                    outerParam:
                    while (true) {
                        // Читаем файл построчно
                        while ((line = bufferedReader.readLine()) != null) {

                            //if ("0".equals(line.trim())) {
                            //        System.out.println("Ожидание на семафоре");
                            //        scanner.nextLine();
                            //}
                            if ("0".equals(line.trim())) {
                                replaceTextInFile(file, "0", "1");
                                System.out.println("Процесс разблокирован");
                                break outerParam;
                            }
                        }

                        // Сбрасываем указатель в начало файла, чтобы можно было снова читать его с начала
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break outerLoop;
            }
            scanner.nextLine();
            System.out.println("V(SРазрЧт)");
            outerLoop:
            while (true) {
                String file = "SРазрЧт";
                try {

                    // Создаем объект FileReader и BufferedReader для чтения файла
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder newContent = new StringBuilder();
                    String line;

                    // Бесконечный цикл
                    outerParam:
                    while (true) {
                        // Читаем файл построчно
                        while ((line = bufferedReader.readLine()) != null) {

                            //if ("0".equals(line.trim())) {
                            //        System.out.println("Ожидание на семафоре");
                            //        scanner.nextLine();
                            //}
                            if ("0".equals(line.trim())) {
                                replaceTextInFile(file, "0", "1");
                                System.out.println("Процесс разблокирован");
                                break outerParam;
                            }
                        }

                        // Сбрасываем указатель в начало файла, чтобы можно было снова читать его с начала
                        fileReader = new FileReader(file);
                        bufferedReader = new BufferedReader(fileReader);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break outerLoop;
            }
        }
    }
    private static void replaceTextInFile(String filename, String oldText, String newText) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }

            reader.close();

            String updatedContent = content.toString().replaceFirst(oldText, newText);

            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(updatedContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}