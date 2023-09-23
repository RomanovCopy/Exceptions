package task_3;

public class Solution {

    /* Исходный код */

//    public static void main(String[] args) throws Exception {
//        try {
//            int a = 90;
//            int b = 3;
//            System.out.println(a / b);
//            printSum(23, 234);
//            int[] abc = { 1, 2 };
//            abc[3] = 9;
//        } catch (Throwable ex) {
//            System.out.println("Что-то пошло не так...");
//        } catch (NullPointerException ex) {
//            System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//            System.out.println("Массив выходит за пределы своего размера!");
//        }
//    }
//    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//        System.out.println(a + b);
//    }

    /* Ошибки */

    //Кроме того, что методы должны быть заключены в тело класса, есть и другие ошибки.

//  1  Массив abc имеет длину в 2 элемента, но далее вызывается элемент с индексом 3.
//     Будет вызвано исключение: ArrayIndexOutOfBoundsException.
//  2  В методе printSum указано, что он может выбросить исключение
//    FileNotFoundException, но внутри метода нет кода, который мог бы вызвать это
//    исключение. Если исключение не выбрасывается в методе, то его объявление в сигнатуре
//    метода не требуется.
//  3  В блоке catch в методе main идут несколько catch блоков, но они расположены в
//    неправильном порядке. Блок catch (Throwable ex) должен быть последним,
//    так как Throwable является родительским классом для всех исключений.
//    Если блок catch (Throwable ex) будет первым, то остальные блоки catch станут
//    недостижимыми.
//  4  В блоке catch (NullPointerException ex) и  catch (IndexOutOfBoundsException ex)
//    выводится сообщение об ошибке, но не выводится информация об исключении.
//    Чтобы получить информацию об исключении, можно использовать метод ex.getMessage()
//    или ex.toString().

    /* Исправленный код */

    public class Main {
        public static void main(String[] args) {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null! " +
                        ex.getMessage());
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера! " +
                        ex.getMessage());
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так... " + ex.getMessage());
            }
        }

        public static void printSum(Integer a, Integer b) {
            System.out.println(a + b);
        }
    }

}
