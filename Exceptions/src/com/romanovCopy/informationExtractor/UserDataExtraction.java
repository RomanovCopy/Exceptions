package informationExtractor;

import myExceptions.InsufficientDataException;
import myExceptions.InvalidDataFormatException;

import java.io.IOException;

public class UserDataExtraction {

    private String fullName;
    private String dateOfBirth;
    private String phoneNumber;
    private String gender;
    private String data;

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
        }  catch (Exception e) {
            System.out.println(e.getMessage());
        }

        createUserDataFile("Романов Сергей Михайлович", "11.12.1971", "79252980064", "m");
    }

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
