package exceptions;

public abstract class BaseDataValidationException extends RuntimeException{
    public BaseDataValidationException(String message) {
        super("Yo bro, there are the error in request, check error message \n"+message);
    }

}
