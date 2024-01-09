package application.bookstore.views;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.Book;
import application.bookstore.models.Role;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


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
        descriptionCol.setMinWidth(160);

        TableColumn<Book, ImageView> imageCol = new TableColumn<>("Image");
        imageCol.setCellValueFactory(
                new PropertyValueFactory<>("bookURL"));
        imageCol.setMinWidth(160);

        TableColumn<Book, Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<>("quantity"));
        quantityCol.setMinWidth(115);

        tableView.getColumns().addAll(isbnCol , titleCol , authorCol , quantityCol ,
                categoryCol , descriptionCol , imageCol  , quantityCol);

        pane.setCenter(tableView);
        pane.setTop(hbox);
        stage.setTitle("Books");
        return new Scene(pane, 1000 , 700 );
    }
}
