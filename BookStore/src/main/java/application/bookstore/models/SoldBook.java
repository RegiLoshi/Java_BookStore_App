package application.bookstore.models;

import java.util.Date;

public class SoldBook extends Book{
    private int orderId;
    private int  soldQuantity;
    private Date dateOfTransaction;
    private Book soldBook;

    public SoldBook(int soldQuantity,Date date,Book soldBook)
    {
        this.orderId++;
        this.soldQuantity=soldQuantity;
        this.dateOfTransaction=date;
        this.soldBook=soldBook;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public Book getSoldBook() {
        return soldBook;
    }

    public void setSoldBook(Book soldBook) {
        this.soldBook = soldBook;
    }
}
