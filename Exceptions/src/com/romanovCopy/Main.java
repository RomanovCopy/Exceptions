import informationExtractor.UserDataExtraction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите данные о себе в любой последоватеьности через " +
                "пробел.");
        if(scanner.hasNextLine()){
            String text= scanner.nextLine();
            new UserDataExtraction(text);
        }

    }

}
