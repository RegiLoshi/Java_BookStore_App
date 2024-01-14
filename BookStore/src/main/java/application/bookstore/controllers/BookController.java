package application.bookstore.controllers;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.Book;
import application.bookstore.models.User;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BookController implements DatabaseConnector {

    public static void generateBill(User user, ObservableList<Book> selectedBooks, double amount) {
        File billsFolder = new File("bills");
        if (!billsFolder.exists()) {
            billsFolder.mkdir();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String fileName = "bills/bill_" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Sold by: " + user.getFirstName() + " " + user.getLastName() + " Role: " + user.getRoleString() + "\n\n");
            writer.write("Books:\n");
            for (Book book : selectedBooks) {
                String bookInfo = book.getTitle() + " - $" + book.getSellingPrice() + "\n";
                writer.write("- " + book.getTitle() + " (Chosen Quantity: " + book.getChosenQuantity() + "): $" + book.getSellingPrice());
                writer.write(bookInfo);
            }
            writer.write("\nTotal Amount: $" + amount);
            updateQuantity(selectedBooks);

            System.out.println("Bill generated successfully. Filename: " + fileName);

        } catch (IOException e) {
            System.err.println("Error generating bill: " + e.getMessage());
        }
    }

    public static void updateQuantity(ObservableList<Book> selectedBooks) {
        for (Book book : selectedBooks) {
            String updateSQL = "UPDATE book SET quantity = ? WHERE ISBN = ?";
            try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                int newQuantity = book.getQuantity() - book.getChosenQuantity();
                preparedStatement.setInt(1, newQuantity);
                preparedStatement.setString(2, book.getISBN());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
