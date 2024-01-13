package application.bookstore.models;


import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Date;

public class Book  {

  private int supplierid;
  private String ISBN,title,author,category,
        description;

  private SimpleObjectProperty<ImageView> bookImageProperty = new SimpleObjectProperty<>();

    private Date purchaseDate;

    private double purchasedPrice, originalPrice,sellingPrice;
    private int quantity;

    private Supplier supplier;
    private final IntegerProperty chosenQuantity = new SimpleIntegerProperty(0);

    //Constructor made for Book object which will be added to table , so purchased date and purchased price are not needed
  public Book(String ISBN, String name, String author,
              String category, int supplierid, String description,
              Image image, double originalPrice, double sellingPrice, int quantity) {
    this.ISBN = ISBN;
    this.title = name;
    this.author = author;
    this.category = category;
    supplier = Supplier.getSupplierDB(supplierid);
    this.description = description;
    setBookImageProperty(image);
    this.originalPrice = originalPrice;
    this.sellingPrice = sellingPrice;
    this.quantity = quantity;
  }

  //Constructor made for Book object which will be bought
  public Book(String ISBN, String name, String author,
              String category, Supplier supplier, String description,
              Image image, Date purchaseDate, double purchasedPrice,
              double originalPrice, double sellingPrice, int quantity) {
    this.ISBN = ISBN;
    this.title = name;
    this.author = author;
    this.category = category;
    this.supplier = supplier;
    this.description = description;
    setBookImageProperty(image);
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String name) {
    this.title = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ImageView getBookImageProperty() {
    return bookImageProperty.get();
  }

  public void setBookImageProperty(Image image) {
    this.bookImageProperty.set(new ImageView(image));
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public double getPurchasedPrice() {
    return purchasedPrice;
  }

  public void setPurchasedPrice(double purchasedPrice) {
    this.purchasedPrice = purchasedPrice;
  }

  public double getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(double originalPrice) {
    this.originalPrice = originalPrice;
  }

  public double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void decrementQuantity(int x)
  {
    this.quantity-=x;
  }

  public final IntegerProperty chosenQuantityProperty() {
    return this.chosenQuantity;
  }

  public final int getChosenQuantity() {
    return this.chosenQuantityProperty().get();
  }

  public final void setChosenQuantity(int chosenQuantity) {
    this.chosenQuantityProperty().set(chosenQuantity);
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
            ", purchaseDate=" + purchaseDate +
            ", purchasedPrice=" + purchasedPrice +
            ", originalPrice=" + originalPrice +
            ", sellingPrice=" + sellingPrice +
            ", quantity=" + quantity +
            '}';
  }
}


