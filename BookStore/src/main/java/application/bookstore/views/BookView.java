package application.bookstore.views;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.controllers.BookList;
import application.bookstore.models.Book;
import application.bookstore.models.Role;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class BookView implements DatabaseConnector {
    BorderPane pane;
    Role role;
    private Label search_label;
    private TextField search_field;
    private HBox hbox;

    public BookView(Role role) {
        this.role = role;
    }

    public Scene showView(Stage stage)
    {
        pane = new BorderPane();

        search_label = new Label("Search for a book title: ");
        search_label.setMinHeight(40);

        search_field = new TextField();
        search_field.setPromptText("Enter a book title...");
        search_field.setMinWidth(600);
        search_field.setMinHeight(40);



        hbox = new HBox();
        hbox.getChildren().addAll(search_label, search_field);
        hbox.setSpacing(30);

        TableView<Book> tableView = new TableView<>();

        TableColumn<Book, Long> isbnCol = new TableColumn<>("ISBN");
        isbnCol.setCellValueFactory(
                new PropertyValueFactory<>("ISBN"));
        isbnCol.setMinWidth(115);


        TableColumn<Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        titleCol.setMinWidth(115);
        titleCol.setCellFactory(col -> {
            TableCell<Book, String> cell = new TableCell<Book, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        Text text = new Text(item);
                        text.wrappingWidthProperty().bind(titleCol.widthProperty());
                        setGraphic(text);
                        setWrapText(true);
                    }
                }
            };
            return cell;
        });

        TableColumn<Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(
                new PropertyValueFactory<>("author"));
        authorCol.setMinWidth(115);

        TableColumn<Book, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        categoryCol.setMinWidth(115);

        TableColumn<Book, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(
                new PropertyValueFactory<>("description"));
        descriptionCol.setCellFactory(col -> {
            TableCell<Book, String> cell = new TableCell<Book, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        Text text = new Text(item);
                        text.wrappingWidthProperty().bind(descriptionCol.widthProperty());
                        setGraphic(text);
                        setWrapText(true);
                    }
                }
            };
            return cell;
        });

        descriptionCol.setMinWidth(160);

        TableColumn<Book, ImageView> imageCol = getBookImageViewTableColumn();

        TableColumn<Book, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        quantityCol.setMinWidth(115);

        tableView.getColumns().addAll(isbnCol , titleCol , authorCol ,
                categoryCol , descriptionCol , imageCol  , quantityCol);

        BookList bookList = new BookList();
        ArrayList <Book> books = bookList.getBooks();
        tableView.getItems().addAll(books);

        pane.setCenter(tableView);
        pane.setTop(hbox);
        stage.setTitle("Books");
        return new Scene(pane, 1000 , 700 );
    }

    private static TableColumn<Book, ImageView> getBookImageViewTableColumn() {
        TableColumn<Book, ImageView> imageCol = new TableColumn<>("Image");
        imageCol.setCellValueFactory(new PropertyValueFactory<>("bookImageProperty"));
        imageCol.setCellFactory(col -> new TableCell<Book, ImageView>() {
            @Override
            protected void updateItem(ImageView item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    item.setFitWidth(50);
                    item.setFitHeight(50);

                    setGraphic(item);
                }
            }
        });
        imageCol.setMinWidth(160);
        return imageCol;
    }
}
