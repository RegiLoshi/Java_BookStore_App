package application.bookstore.Exceptions;

public class UsernameAlreadyExistsException extends Exception{
    // Custom exception for username collision
    public UsernameAlreadyExistsException() {
        super("Username already exists for another user.");
    }
}
