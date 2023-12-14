package exceptions;

public class InvalidStatus extends BaseDataValidationException{
    public InvalidStatus(String message) {
        super("Status can be only active or inactive: "+message);
    }
}
