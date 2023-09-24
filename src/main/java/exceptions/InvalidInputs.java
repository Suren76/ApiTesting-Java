package exceptions;

import models.response.InvalidResponse;

import java.util.List;

public class InvalidInputs extends RuntimeException{
    public InvalidInputs(List<InvalidResponse> exceptionList) {
        super("Yo bro, you are write wrong inputs in post request body, check error message: \n"+format(exceptionList));
    }

    private static String format(List<InvalidResponse> e) {
        StringBuilder message = new StringBuilder();
        for (var exceptionItem: e) {
            message.append(InvalidResponse.getException(exceptionItem)).append("\n");
        }
        return message.toString();
    }
}
