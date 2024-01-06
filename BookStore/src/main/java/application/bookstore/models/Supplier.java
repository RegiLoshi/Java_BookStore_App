package application.bookstore.models;

import java.util.ArrayList;

public class Supplier {
    private int supplierId;
    private String name,email,phoneNumber,address;

    private ArrayList<Book> booksProvided;

    public Supplier(String name, String email, String phoneNumber, String address) {
        booksProvided=new ArrayList<>();
        this.supplierId++;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void addBookToSupplier(Book b)
    {
        booksProvided.add(b);
    }
}