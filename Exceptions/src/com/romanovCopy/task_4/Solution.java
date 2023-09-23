package task_4;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Solution {

    public Solution() {
        inputString();
    }

    private void inputString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        try {
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            }
            System.out.println("Вы ввели: " + input);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.toString());
        }
    }

}
