package application.bookstore.models;

import java.util.ArrayList;
import java.util.Date;

public class Bill {
    private ArrayList<SoldBook> booksSold;
    private double amount = 0;
    protected Date dateIssued;

    public Bill(ArrayList<SoldBook> booksSold,Date date) {
        this.booksSold = booksSold;
        for(SoldBook soldBook:booksSold)
            amount += soldBook.getsellingPrice() * soldBook.getSoldQuantity();
        this.dateIssued=date;
    }

    public double getTotalAmount() {
        return amount;
    }

    public ArrayList<SoldBook> getBooksSold() {
        return booksSold;
    }

    public Date getDateIssued() {
        return dateIssued;
    }
}
