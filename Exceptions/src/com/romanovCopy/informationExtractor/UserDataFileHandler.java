package src.com.romanovCopy.informationExtractor;

import java.io.*;

/**
 * Данный класс осуществляет запись и считывание данных с диска
 */
public class UserDataFileHandler {
    public UserDataFileHandler() {

    }

    /**
     * запись данных в файл
     * @param fullName путь к файлу
     * @param userData данные
     * @throws IOException проброс ошибки
     */
    public void writeUserDataToFile(String fullName, String userData) throws IOException {
        String fileName=fullName.split(" ")[0].trim();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(userData);
            writer.newLine();
            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи данных в файл: " + fileName);
            throw e;
        }
    }

    /**
     * чтение данных с файла
     * @param fileName путь к файлу
     * @throws IOException проброс ошибки
     */
    public void readUserDataFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении данных из файла: " + fileName);
            throw e;
        }
    }
}
