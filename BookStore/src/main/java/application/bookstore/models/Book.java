package application.bookstore.models;


import javafx.scene.image.ImageView;

import java.util.Date;

public class Book  {

  private int supplierid;
  private String ISBN,title,author,category,
        description,bookURL;

    private Date purchaseDate;

    private double purchasedPrice, originalPrice,sellingPrice;
    private int quantity;

    private Supplier supplier;

    //Constructor made for Book object which will be added to table , so purchased date and purchased price are not needed
  public Book(String ISBN, String name, String author,
              String category, int supplierid, String description,
              String bookURL, double originalPrice, double sellingPrice, int quantity) {
    this.ISBN = ISBN;
    this.title = name;
    this.author = author;
    this.category = category;
    supplier = Supplier.getSupplierDB(supplierid);
    this.description = description;
    ImageView image = new ImageView(bookURL);
    this.originalPrice = originalPrice;
    this.sellingPrice = sellingPrice;
    this.quantity = quantity;
  }

  //Constructor made for Book object which will be bought
  public Book(String ISBN, String name, String author,
              String category, Supplier supplier, String description,
              String bookURL, Date purchaseDate, double purchasedPrice,
              double originalPrice, double sellingPrice, int quantity) {
    this.ISBN = ISBN;
    this.title = name;
    this.author = author;
    this.category = category;
    this.supplier = supplier;
    this.description = description;
    this.bookURL = bookURL;
    this.purchaseDate = purchaseDate;
    this.purchasedPrice = purchasedPrice;
    this.originalPrice = originalPrice;
    this.sellingPrice = sellingPrice;
    this.quantity = quantity;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String gettitle() {
    return title;
  }

  public void settitle(String name) {
    this.title = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getcategory() {
    return category;
  }

  public void setcategory(String category) {
    this.category = category;
  }

  public Supplier getsupplier() {
    return supplier;
  }

  public void setsupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public String getdescription() {
    return description;
  }

  public void setdescription(String description) {
    this.description = description;
  }

  public ImageView getbookURL() {
    return new ImageView(bookURL);
  }

  public void setbookURL(String bookURL) {
    this.bookURL = bookURL;
  }

  public Date getpurchaseDate() {
    return purchaseDate;
  }

  public void setpurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public double getpurchasedPrice() {
    return purchasedPrice;
  }

  public void setpurchasedPrice(double purchasedPrice) {
    this.purchasedPrice = purchasedPrice;
  }

  public double getoriginalPrice() {
    return originalPrice;
  }

  public void setoriginalPrice(double originalPrice) {
    this.originalPrice = originalPrice;
  }

  public double getsellingPrice() {
    return sellingPrice;
  }

  public void setsellingPrice(double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public int getquantity() {
    return quantity;
  }

  public void setquantity(int quantity) {
    this.quantity = quantity;
  }

  public void decrementQuantity(int x)
  {
    this.quantity-=x;
  }

  @Override
  public String toString() {
    return "Book{" +
            "ISBN='" + ISBN + '\'' +
            ", category='" + category + '\'' +
            ", name='" + title + '\'' +
            ", author='" + author + '\'' +
            ", category='" + category + '\'' +
            ", supplier='" + supplier + '\'' +
            ", description='" + description + '\'' +
            ", bookURL='" + bookURL + '\'' +
            ", purchaseDate=" + purchaseDate +
            ", purchasedPrice=" + purchasedPrice +
            ", originalPrice=" + originalPrice +
            ", sellingPrice=" + sellingPrice +
            ", quantity=" + quantity +
            '}';
  }
}


