package exceptions;

public class UserExists extends BaseDataValidationException {
    public UserExists(String message) {
        super("The user with the same email exists: "+message);
    }
}
