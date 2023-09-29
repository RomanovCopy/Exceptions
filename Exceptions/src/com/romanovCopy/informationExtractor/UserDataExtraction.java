package src.com.romanovCopy.informationExtractor;

import src.com.romanovCopy.myExceptions.*;

import java.io.IOException;

/**
 * класс отвечающий за отправку запросов, получение и сохранение результатов
 */
public class UserDataExtraction {

    private String fullName;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;
    private String data;

    /**
     * отправка запросов, получение результатов, обработка исключений
     * возникающих в приложении
     * @param text исходный текст
     */
    public UserDataExtraction(String text) {
        try {
            if(text!=null && !text.equals("")){
                UserInformationExtractor extractor=new UserInformationExtractor();
                fullName=extractor.extractFullName(text);
                dateOfBirth=extractor.extractDateOfBirth(text);
                phoneNumber=extractor.extractPhoneNumber(text);
                gender=extractor.extractGender(text);
                data = createUserDataFile(fullName,dateOfBirth,phoneNumber,gender);
                UserDataFileHandler fileHandler=new UserDataFileHandler();
                fileHandler.writeUserDataToFile(fullName,data);
            }else {
                throw new InvalidDataFormatException("Данные не получены, т.к. строка " +
                        "не введена.");
            }
        } catch (InvalidDataFormatException e) {
            System.out.println(e.getMessage());
        } catch (InsufficientDataException e) {
            System.out.println(e.getMessage());
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * создание результирующей строки для сохранения
     * @param fullName фамилия, имя и отчество
     * @param dateOfBirth дата рождения
     * @param phoneNumber номер телефона
     * @param gender пол
     * @return
     */
    private String createUserDataFile(String fullName, String dateOfBirth,
                                           String phoneNumber, String gender){
        String maket="< >";
        String data="";
        StringBuilder builder=new StringBuilder(data);
        for(String name:fullName.split(" ")){
            if(name!=null && name.length()>0){
                builder.append("<"+name+">");
            }
        }
        builder.append("<"+dateOfBirth+">");
        builder.append("<"+phoneNumber+">");
        builder.append("<"+gender+">");
        data= builder.toString();
        return data;
    }


}
