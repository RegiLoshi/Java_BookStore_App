package application.bookstore.models;

import java.util.Date;

//The SoldBooks class will hold a book type with the quantity being sold
//Example "Harry Potter Book" soldQuantity=5
//Now this book type will be written in the bill along with the sold quantity
public class SoldBookType{
    public int soldBooksID;
    private int  soldQuantity;
    private Date dateOfTransaction;
    private Book soldBook;

    public SoldBookType(int soldQuantity,Date date,Book soldBook)
    {
        this.soldBooksID++;
        this.soldQuantity=soldQuantity;
        this.dateOfTransaction=date;
        this.soldBook=soldBook;

        //Decrementing the book type quantity in the bookstore
        soldBook.decrementQuantity(soldQuantity);
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

    public int getSoldBookID()
    {
        return this.soldBooksID;
    }
}
