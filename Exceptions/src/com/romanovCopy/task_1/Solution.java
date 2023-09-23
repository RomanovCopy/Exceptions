package task_1;

import java.util.Locale;
import java.util.Scanner;

public class Solution {
    Scanner scanner;
    public Solution() {
        Locale.setDefault(Locale.US);
        scanner=new Scanner(System.in);
        float number=0;

        number=getFloatInputUsingTryCatch();
//        number=getFloatInput();
        System.out.println("Введенное число: " + number);
        scanner.close();
    }

    /**
     * метод с использованием try-catch
     * @return
     */
    public float getFloatInputUsingTryCatch(){
        float number=0;
        boolean validInput=false;
        while (!validInput){
            System.out.println("Введите дробное число: ");
            try {
                number = Float.parseFloat(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
            }
        }
        return number;
    }


    /**
     * метод без использования блока try-catch
     * @return
     */
    public float getFloatInput() {
        float number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число: ");
            if (scanner.hasNextFloat()) {
                number = scanner.nextFloat();
                validInput = true;
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите дробное число.");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }
        return number;
    }
}
