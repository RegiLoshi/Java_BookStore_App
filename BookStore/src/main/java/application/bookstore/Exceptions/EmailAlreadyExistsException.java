package application.bookstore.Exceptions;

public class EmailAlreadyExistsException extends Exception{
    // Custom exception for email collision
    public EmailAlreadyExistsException() {
        super("Email already exists for another user.");
    }
}
