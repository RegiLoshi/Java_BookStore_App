package application.bookstore.models;


import java.util.Date;

public class Book {

    private String ISBN,category,bookName,author,bookCategory,
          bookSupplier,bookDescription,bookURL;

    private Date purchaseDate;

    private double purchasedPrice, originalPrice,sellingPrice;
    private int bookQuantity;

    public Book(){}//to be called by SoldProduct

  public Book(String ISBN, String category, String bookName, String author,
              String bookCategory, String bookSupplier, String bookDescription,
              String bookURL, Date purchaseDate, double purchasedPrice,
              double originalPrice, double sellingPrice, int bookQuantity) {
    this.ISBN = ISBN;
    this.category = category;
    this.bookName = bookName;
    this.author = author;
    this.bookCategory = bookCategory;
    this.bookSupplier = bookSupplier;
    this.bookDescription = bookDescription;
    this.bookURL = bookURL;
    this.purchaseDate = purchaseDate;
    this.purchasedPrice = purchasedPrice;
    this.originalPrice = originalPrice;
    this.sellingPrice = sellingPrice;
    this.bookQuantity = bookQuantity;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getbookName() {
    return bookName;
  }

  public void setbookName(String bookName) {
    this.bookName = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getbookCategory() {
    return bookCategory;
  }

  public void setbookCategory(String bookCategory) {
    this.bookCategory = bookCategory;
  }

  public String getbookSupplier() {
    return bookSupplier;
  }

  public void setbookSupplier(String bookSupplier) {
    this.bookSupplier = bookSupplier;
  }

  public String getbookDescription() {
    return bookDescription;
  }

  public void setbookDescription(String bookDescription) {
    this.bookDescription = bookDescription;
  }

  public String getbookURL() {
    return bookURL;
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

  public int getbookQuantity() {
    return bookQuantity;
  }

  public void setbookQuantity(int bookQuantity) {
    this.bookQuantity = bookQuantity;
  }

  @Override
  public String toString() {
    return "Book{" +
            "ISBN='" + ISBN + '\'' +
            ", category='" + category + '\'' +
            ", bookName='" + bookName + '\'' +
            ", author='" + author + '\'' +
            ", bookCategory='" + bookCategory + '\'' +
            ", bookSupplier='" + bookSupplier + '\'' +
            ", bookDescription='" + bookDescription + '\'' +
            ", bookURL='" + bookURL + '\'' +
            ", purchaseDate=" + purchaseDate +
            ", purchasedPrice=" + purchasedPrice +
            ", originalPrice=" + originalPrice +
            ", sellingPrice=" + sellingPrice +
            ", bookQuantity=" + bookQuantity +
            '}';
  }
}


