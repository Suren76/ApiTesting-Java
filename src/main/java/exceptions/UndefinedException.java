package exceptions;

public class UndefinedException extends BaseDataValidationException{
    public UndefinedException(String message) {
        super("Undefined exception caused by response: "+message);
    }
}
