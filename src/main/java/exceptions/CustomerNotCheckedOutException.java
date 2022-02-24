package exceptions;

public class CustomerNotCheckedOutException extends Throwable {
    public CustomerNotCheckedOutException(String message) {super(message);
    }
}
