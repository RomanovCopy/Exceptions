package informationExtractor;

import myExceptions.InsufficientDataException;
import myExceptions.InvalidDataFormatException;

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
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String methodName = "not known";
        String answer="";
        if (stackTrace.length >= 3) {
            StackTraceElement caller = stackTrace[2];
            methodName = caller.getMethodName();
        }
        if(matcher.find()){

        }else {
            if(methodName.equals("extractGender")){
                
            }else if(methodName.equals("extractPhoneNumber")){
                
            } else if (methodName.equals("extractDateOfBirth")) {
                
            } else if (methodName.equals("extractFullName")) {
                
            }
            throw new InsufficientDataException("");
        }
        return true;
    }
}
