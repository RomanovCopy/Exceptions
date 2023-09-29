package src.com.romanovCopy.informationExtractor;

import src.com.romanovCopy.myExceptions.InsufficientDataException;
import src.com.romanovCopy.myExceptions.InvalidDataFormatException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * класс выполняющий парсинг данных из текста, а так же их валидацию и
 * контроль полноты данных
 */
public class UserInformationExtractor {

    /**
     * регулярные выражения
     */
    private final Pattern FULL_NAME_PATTERN = Pattern.compile("[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+");
    private final Pattern DATE_OF_BIRTH_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
    private final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d{11}");
    private final Pattern GENDER_PATTERN = Pattern.compile("\\b[fm]\\b");

    /**
     * словарь для сбора совпадений
     */
    HashMap<Integer, String>matches;

    public UserInformationExtractor() {
        matches=new HashMap<>();
    }



    /**
     * вычленение Фамилии, Имени и Отчества из текста
     * @param text  введенный текст
     * @return найденные Фамилия Имя и Отчество
     */
    public String extractFullName(String text)
            throws InsufficientDataException, InvalidDataFormatException {

        Matcher matcher = FULL_NAME_PATTERN.matcher(text);
        matches.clear();

        if (validate(matcher)) {
            String value=null;
            for(int key:matches.keySet()){value=matches.get(key);}
            return value;
        }
        return null;
    }

    /**
     * вычленение даты рождения из введенного текста
     * @param text введенный текст
     * @return дата рождения
     */
    public String extractDateOfBirth(String text)
            throws InsufficientDataException, InvalidDataFormatException {

        Matcher matcher = DATE_OF_BIRTH_PATTERN.matcher(text);
        matches.clear();

        if (validate(matcher)) {
            String value=null;
            for(int key:matches.keySet()){value=matches.get(key);}
            return value;
        }

        return null;
    }

    /**
     * вычленение номера телефона из текста
     * @param text введенный текст
     * @return номер телефона
     */
    public String extractPhoneNumber(String text)
            throws InsufficientDataException, InvalidDataFormatException {

        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(text);
        matches.clear();


        if (validate(matcher)) {
            String value=null;
            for(int key:matches.keySet()){value=matches.get(key);}
            return value;
        }

        return null;
    }

    /**
     * вычленение пола человека из введенного текста
     * @param text введенный текст
     * @return пол: f - female; m - man.
     */
    public String extractGender(String text)
            throws InsufficientDataException, InvalidDataFormatException {

        Matcher matcher = GENDER_PATTERN.matcher(text);
        matches.clear();


        if (validate(matcher)) {
            String value=null;
            for(int key:matches.keySet()){value=matches.get(key);}
            return value;
        }

        return null;
    }

    /**
     * валидация распарсенных данных и выброс исключений при ошибках
     * @param matcher объект Matcher
     * @return  True - успешно False - ошибка(вместо вывода False всегда будет
     * генерироваться исключение)
     * @throws InsufficientDataException данных недостаточно
     * @throws InvalidDataFormatException данные повторяются
     */
    private boolean validate(Matcher matcher)
            throws InsufficientDataException, InvalidDataFormatException {
        Pattern pattern=matcher.pattern();
        while (matcher.find()){
            matches.put(matcher.start(), matcher.group());
        }
        int size= matches.size();
        if(size!=1){
            if(size==0){
                throw new InvalidDataFormatException(generatingATextMessage(pattern,matches));
            }else {
                throw new InsufficientDataException(generatingATextMessage(pattern,matches));
            }
        }
        return true;
    }

    /**
     * генерация сообщения об ошибке
     * @param pattern паттерн рег. выражения при работе с которым произошла ошибка
     * @param matches словарь совпадений для паттерна
     * @return строка сообщения об ошибке
     */
    private String generatingATextMessage(Pattern pattern,
                                          HashMap<Integer,String> matches){
        StringBuilder message=new StringBuilder("Данные о ");
        String text=matches.size()==0?"не найдены или указаны не верно ":
                "найдены в нескольких позициях представленного текста: \n";
        if(pattern.equals(FULL_NAME_PATTERN)){
            message.append("Фамилии Имени и Отчеству ").append(text);
        }else if(pattern.equals(DATE_OF_BIRTH_PATTERN)){
            message.append("дате рождения ").append(text);
        } else if (pattern.equals(PHONE_NUMBER_PATTERN)) {
            message.append("номере телефона ").append(text);
        } else if (pattern.equals(GENDER_PATTERN)) {
            message.append("поле ").append(text);
        }
        for(int pos:matches.keySet()){
            message.append(pos + "\t -> "+matches.get(pos)+"\t\n");
        }
        return message.toString();
    }
}
