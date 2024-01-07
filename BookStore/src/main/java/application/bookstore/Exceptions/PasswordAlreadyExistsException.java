package application.bookstore.Exceptions;

public class PasswordAlreadyExistsException extends Exception{
    // Custom exception for password collision
    public PasswordAlreadyExistsException() {
        super("Password already exists for another user.");
    }
}

