package exceptions;

public class InvalidGender extends BaseDataValidationException{
    public InvalidGender(String message) {
        super("Gender can be only male or female: "+message);
    }
}
