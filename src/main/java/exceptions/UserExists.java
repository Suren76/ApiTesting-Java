package exceptions;

public class UserExists extends RuntimeException{
    public UserExists(String message) {
        super("Yo bro, there are the user with the same email, check error message "+message);
    }
}
