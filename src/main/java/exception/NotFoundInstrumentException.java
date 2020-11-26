package exception;

public class NotFoundInstrumentException extends RuntimeException{

    public NotFoundInstrumentException(String errorMessage) {
        super(errorMessage);
    }
}
