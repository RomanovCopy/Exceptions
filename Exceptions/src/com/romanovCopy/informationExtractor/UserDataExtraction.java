package informationExtractor;

import myExceptions.InsufficientDataException;
import myExceptions.InvalidDataFormatException;

public class UserDataExtraction {

    public UserDataExtraction(String text) {
        try{

        }catch (InvalidDataFormatException | InsufficientDataException | IOException e){

        }

        createUserDataFile("Романов Сергей Михайлович", "11.12.1971","79252980064" , "m");
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
