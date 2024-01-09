package application.bookstore.controllers;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookList implements DatabaseConnector {
    ArrayList<Book> books;
    /*public Book(String ISBN, String name, String author,
              String category, int supplierid, String description,
              String bookURL, double originalPrice, double sellingPrice, int quantity){

     */
    public ArrayList<Book> getBooks() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Book");

            while (resultSet.next()) {
                books.add(new Book(resultSet.getString("ISBN"), resultSet.getString("name"),
                        resultSet.getString("author"), resultSet.getString("category"),
                        resultSet.getInt("supplier") ,resultSet.getString("description"),
                        resultSet.getString("bookURL"), resultSet.getDouble("originalPrice"),
                        resultSet.getDouble("sellingPrice"), resultSet.getInt("quantity")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}

