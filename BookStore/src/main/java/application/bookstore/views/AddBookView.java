package application.bookstore.views;

import application.bookstore.models.Book;
import application.bookstore.models.Supplier;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class AddBookView {
    private GridPane pane;
    private BorderPane mainpane;
    private HBox hbox;
    private Button addBook;
    private Button cancelButton;

    private Label isbnLabel;
    private Label titleLabel;
    private Label authorLabel;
    private Label categoryLabel;
    private Label descriptionLabel;
    private Label originalPriceLabel;
    private Label sellingPriceLabel;
    private Label quantityLabel;

    private Label supplierNameLabel;
    private Label supplierEmailLabel;
    private Label supplierPhoneLabel;
    private Label supplierAddressLabel;

    private TextField isbnTextField;
    private TextField titleTextField;
    private TextField authorTextField;
    private TextField categoryTextField;
    private TextField descriptionTextField;
    private TextField originalPriceTextField;
    private TextField sellingPriceTextField;
    private TextField quantityTextField;

    private TextField supplierNameTextField;
    private TextField supplierEmailTextField;
    private TextField supplierPhoneTextField;
    private TextField supplierAddressTextField;
    private ImageView imageView;
    private File selectedImageFile;
    private Label image_label;
    private Book book;

    public Scene showView(Stage stage) throws Exception {
        mainpane = new BorderPane();
        pane = createBookEntryForm();
        hbox = new HBox();
        addBook = new Button("Add Book");
        addBook.setMinHeight(50);
        addBook.setMinWidth(150);
        addBook.setOnAction(e -> {createBook(); stage.close();});
        cancelButton = new Button("Cancel");
        cancelButton.setMinHeight(50);
        cancelButton.setMinWidth(150);
        cancelButton.setOnAction(e -> stage.close());

        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(30);
        hbox.getChildren().addAll(addBook, cancelButton);

        mainpane.setBottom(hbox);
        mainpane.setCenter(pane);

        mainpane.setStyle("-fx-background-color: #f0f0f0;");
        mainpane.setPadding(new Insets(50));

        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(20));

        addBook.setStyle("-fx-font-size: 18;");
        cancelButton.setStyle("-fx-font-size: 18;");

        stage.setTitle("Add Book");
        return new Scene(mainpane, 800, 800);
    }

    private GridPane createBookEntryForm() {
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(15);
        pane.setHgap(15);

        isbnLabel = new Label("ISBN:");
        titleLabel = new Label("Title:");
        authorLabel = new Label("Author:");
        categoryLabel = new Label("Category:");
        descriptionLabel = new Label("Description:");
        originalPriceLabel = new Label("Original Price:");
        sellingPriceLabel = new Label("Selling Price:");
        quantityLabel = new Label("Quantity:");

        supplierNameLabel = new Label("Supplier Name:");
        supplierEmailLabel = new Label("Supplier Email:");
        supplierPhoneLabel = new Label("Supplier Phone:");
        supplierAddressLabel = new Label("Supplier Address:");
        image_label = new Label("Book Image:");

        isbnLabel.setStyle("-fx-font-size: 16;");
        titleLabel.setStyle("-fx-font-size: 16;");
        authorLabel.setStyle("-fx-font-size: 16;");
        categoryLabel.setStyle("-fx-font-size: 16;");
        descriptionLabel.setStyle("-fx-font-size: 16;");
        originalPriceLabel.setStyle("-fx-font-size: 16;");
        sellingPriceLabel.setStyle("-fx-font-size: 16;");
        quantityLabel.setStyle("-fx-font-size: 16;");
        supplierNameLabel.setStyle("-fx-font-size: 16;");
        supplierEmailLabel.setStyle("-fx-font-size: 16;");
        supplierPhoneLabel.setStyle("-fx-font-size: 16;");
        supplierAddressLabel.setStyle("-fx-font-size: 16;");
        image_label.setStyle("-fx-font-size: 16;");

        isbnTextField = new TextField();
        titleTextField = new TextField();
        authorTextField = new TextField();
        categoryTextField = new TextField();
        descriptionTextField = new TextField();
        originalPriceTextField = new TextField();
        sellingPriceTextField = new TextField();
        quantityTextField = new TextField();

        supplierNameTextField = new TextField();
        supplierEmailTextField = new TextField();
        supplierPhoneTextField = new TextField();
        supplierAddressTextField = new TextField();

        imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        
        Button chooseImageButton = new Button("Choose Image");
        chooseImageButton.setMinHeight(50);
        chooseImageButton.setMinWidth(150);
        chooseImageButton.setOnAction(e -> chooseImage());


        pane.addRow(0, isbnLabel, isbnTextField);
        pane.addRow(1, titleLabel, titleTextField);
        pane.addRow(2, authorLabel, authorTextField);
        pane.addRow(3, categoryLabel, categoryTextField);
        pane.addRow(4, descriptionLabel, descriptionTextField);
        pane.addRow(5, originalPriceLabel, originalPriceTextField);
        pane.addRow(6, sellingPriceLabel, sellingPriceTextField);
        pane.addRow(7, quantityLabel, quantityTextField);
        pane.addRow(8, supplierNameLabel, supplierNameTextField);
        pane.addRow(9, supplierEmailLabel, supplierEmailTextField);
        pane.addRow(10, supplierPhoneLabel, supplierPhoneTextField);
        pane.addRow(11, supplierAddressLabel, supplierAddressTextField);
        pane.addRow(12,image_label , imageView, chooseImageButton);

        return pane;
    }
    private void chooseImage() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Book Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        selectedImageFile = fileChooser.showOpenDialog(null);

        if (selectedImageFile != null) {
            Image image = new Image(selectedImageFile.toURI().toString());
            imageView.setImage(image);
        }
    }
    public Book createBook() {
        try {
            Supplier supplier = new Supplier(supplierNameTextField.getText() , supplierEmailTextField.getText() ,
                    supplierPhoneLabel.getText() , supplierAddressTextField.getText());
            supplier.findSupplierId();
            if(!(supplier.supplierExists(supplier.getSupplierId()))) {
                supplier.saveToDatabase();
            }
            book = new Book(
                    isbnTextField.getText(),
                    titleTextField.getText(),
                    authorTextField.getText(),
                    categoryTextField.getText(),
                    supplier.getSupplierId(),
                    descriptionTextField.getText(),
                    Double.parseDouble(originalPriceTextField.getText()),
                    Double.parseDouble(sellingPriceTextField.getText()),
                    Integer.parseInt(quantityTextField.getText())
            );
            book.saveImageLocally(selectedImageFile);
            book.saveToDatabase();

            return book;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getAddedBook() {
        return book;
    }
}



