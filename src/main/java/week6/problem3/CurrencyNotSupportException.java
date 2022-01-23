package week6.problem3;

public class CurrencyNotSupportException extends Exception {

    public CurrencyNotSupportException(String message, Throwable cause) {
        super(message, cause);
    }

    public CurrencyNotSupportException(String message) {
        super(message);
    }
}
