package informationExtractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class UserInformationExtractor {

    private final Pattern FULL_NAME_PATTERN = Pattern.compile("[А-ЯЁа-яё]+ [А-ЯЁа-яё]+ [А-ЯЁа-яё]+");
    private final Pattern DATE_OF_BIRTH_PATTERN = Pattern.compile("\\d{2}\\.\\d{2}\\.\\d{4}");
    private final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("\\+\\d{10}");
    private final Pattern GENDER_PATTERN = Pattern.compile("[fm]");

    public UserInformationExtractor() {

    }



    /**
     * вычленение Фамилии, Имени и Отчества из текста
     * @param text  введенный текст
     * @return найденные Фамилия Имя и Отчество
     */
    private String extractFullName(String text) {

        Matcher matcher = FULL_NAME_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /**
     * вычленение даты рождения из введенного текста
     * @param text введенный текст
     * @return дата рождения
     */
    private String extractDateOfBirth(String text) {

        Matcher matcher = DATE_OF_BIRTH_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /**
     * вычленение номера телефона из текста
     * @param text введенный текст
     * @return номер телефона
     */
    private String extractPhoneNumber(String text) {

        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }

    /**
     * вычленение пола человека из введенного текста
     * @param text введенный текст
     * @return пол: f - female; m - man.
     */
    private String extractGender(String text) {

        Matcher matcher = GENDER_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }

        return null;
    }
}
