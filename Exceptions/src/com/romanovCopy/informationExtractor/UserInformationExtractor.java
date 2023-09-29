package src.com.romanovCopy.informationExtractor;

import src.com.romanovCopy.myExceptions.InsufficientDataException;
import src.com.romanovCopy.myExceptions.InvalidDataFormatException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class UserInformationExtractor {

    private final Pattern FULL_NAME_PATTERN = Pattern.compile("[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+");
    private final Pattern DATE_OF_BIRTH_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
    private final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\d{11}");
    private final Pattern GENDER_PATTERN = Pattern.compile("\\b[fm]\\b");

    public UserInformationExtractor() {

    }



    /**
     * вычленение Фамилии, Имени и Отчества из текста
     * @param text  введенный текст
     * @return найденные Фамилия Имя и Отчество
     */
    public String extractFullName(String text)
            throws InsufficientDataException, InvalidDataFormatException {

        Matcher matcher = FULL_NAME_PATTERN.matcher(text);

        if (validate(matcher)) {
            return matcher.group();
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

        if (validate(matcher)) {
            return matcher.group();
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

        if (validate(matcher)) {
            return matcher.group();
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

        if (validate(matcher)) {
            return matcher.group();
        }

        return null;
    }

    private boolean validate(Matcher matcher)
            throws InsufficientDataException, InvalidDataFormatException {
        List<Integer> matchPositions=new ArrayList<>();
        while (matcher.find()){
            matchPositions.add(matcher.start());
        }
        int size= matchPositions.size();
        if(size!=1){
            if(size==0){
                throw new InvalidDataFormatException(generatingATextMessage(matcher,matchPositions));
            }else {
                throw new InsufficientDataException(generatingATextMessage(matcher,matchPositions));
            }
        }
        return true;
    }

    private String generatingATextMessage(Matcher matcher, List<Integer> matchPositions){
        StringBuilder message=new StringBuilder("Данные о ");
        String text=matchPositions.size()==0?"не найдены или указаны не верно ":
                "найдены в нескольких позициях представленного текста: ";
        if(matcher.pattern().equals(FULL_NAME_PATTERN)){
            message.append("Фамилии Имени и Отчеству ").append(text);
        }else if(matcher.pattern().equals(DATE_OF_BIRTH_PATTERN)){
            message.append("дате рождения ").append(text);
        } else if (matcher.pattern().equals(PHONE_NUMBER_PATTERN)) {
            message.append("номере телефона ").append(text);
        } else if (matcher.pattern().equals(GENDER_PATTERN)) {
            message.append("поле ").append(text);
        }
        for(int pos:matchPositions){
            message.append(pos + " ");
        }
        return message.toString();
    }
}
