package task_2;

public class Solution {

    /* Исходный код */

    try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
    }

    /* Ошибки */

    // 1 Массив intArray не инициализирован, ошибка компиляции
    // 2 Переменная d инициализирована значением 0, что приведет к возникновению
    //  исключения ArithmeticException при попытке деления на ноль.
    // 3 Выводимое сообщение в блоке catch может быть более информативным,
    // чтобы помочь в диагностике и отладке проблемы.

    /*Исправленный код*/

    try {
        int[] intArray = new int[10];
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
        System.out.println("Caught exception: " + e.getMessage());
    }



}
