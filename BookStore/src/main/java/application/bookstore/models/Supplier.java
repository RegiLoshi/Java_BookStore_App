package application.bookstore.models;

import application.bookstore.auxiliaries.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;

public class Supplier implements DatabaseConnector {
    private int supplierId;
    private String name,email,phoneNumber,address;

    private ArrayList<Book> booksProvided;

    public Supplier(int supplierId ,String name, String email, String phoneNumber, String address) {
        booksProvided=new ArrayList<>();
        this.supplierId = supplierId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public static Supplier getSupplierDB(int supplierId) {
            Supplier supplier = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Supplier where id = " + supplierId);
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    String address = resultSet.getString("address");

                    supplier = new Supplier(supplierId , name, email, phoneNumber, address);
                }
                connection.close();
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return supplier;
        }
        public void setSupplierId(int id){ this.supplierId = id;}

    public int getSupplierId () {
                return supplierId;
            }

            public String getName () {
                return name;
            }

            public void setName (String name){
                this.name = name;
            }

            public String getEmail () {
                return email;
            }

            public void setEmail (String email){
                this.email = email;
            }

            public String getPhoneNumber () {
                return phoneNumber;
            }

            public void setPhoneNumber (String phoneNumber){
                this.phoneNumber = phoneNumber;
            }

            public String getAddress () {
                return address;
            }

            public void setAddress (String address){
                this.address = address;
            }
            public void addBookToSupplier (Book b)
            {
                booksProvided.add(b);
            }
        }
