package application.bookstore.models;


import java.util.Date;

public class Book {

    private String ISBN,name,author,category,
        description,bookURL;

    private Date purchaseDate;

    private double purchasedPrice, originalPrice,sellingPrice;
    private int quantity;

    private Supplier supplier;

  public Book(String ISBN, String name, String author,
              String category, Supplier supplier, String description,
              String bookURL, Date purchaseDate, double purchasedPrice,
              double originalPrice, double sellingPrice, int quantity) {
    this.ISBN = ISBN;
    this.name = name;
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

  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
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
            ", name='" + name + '\'' +
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


