package application.bookstore.views;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.Role;
import application.bookstore.models.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class OtherUsersView implements DatabaseConnector {

    //testing
    private final ObservableList<User> users = FXCollections.observableArrayList(
            new User(new SimpleStringProperty("Alvin"), new SimpleStringProperty("Kollcaku"),
                    new SimpleStringProperty("a@"), new SimpleStringProperty("alvin"),
                    new SimpleStringProperty("aa"), new SimpleStringProperty("male"),
                    Role.LIBRARIAN),
            new User(new SimpleStringProperty("Regi"), new SimpleStringProperty("Loshi"),
                    new SimpleStringProperty("reg@"), new SimpleStringProperty("regi"),
                    new SimpleStringProperty("rr"), new SimpleStringProperty("male"),
                    Role.MANAGER));
    private Button addLibrarianButton;
    private Button addManagerButton;
    private Button removeUserButton;
    public Scene showView(Stage stage) {

        BorderPane borderPane=new BorderPane();

        stage.setTitle("User Information");

        TableView<User> tableView = createTableView();
        tableView.prefHeightProperty().bind((tableView.widthProperty().multiply(0.1)));
        tableView.setItems(users);//the observableList is set to the tableview

        VBox vbox = new VBox(tableView);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(15);
        gridPane.setVgap(15);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Button addManager=new Button("Add manager");
        addManager.setFont(Font.font(20));
        gridPane.add(addManager,0,0);


        Button removeManager=new Button("Remove manager");
        removeManager.setFont(Font.font(20));
        gridPane.add(removeManager,1,0);

        Button addLibrarian=new Button("Add librarian");
        addLibrarian.setFont(Font.font(20));
        gridPane.add(addLibrarian,0,1);

        Button removeLibrarian=new Button("Remove librarian");
        removeLibrarian.setFont(Font.font(20));
        gridPane.add(removeLibrarian,1,1);

        borderPane.setCenter(gridPane);
        borderPane.setTop(vbox);


        Scene scene = new Scene(borderPane, 1000, 700);

        return scene;
    }

    private TableView<User> createTableView() {
        TableView<User> tableView = new TableView<>();

        TableColumn<User, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());

        TableColumn<User, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        TableColumn<User, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());

        TableColumn<User, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setCellValueFactory(cellData -> cellData.getValue().passwordProperty());

        TableColumn<User, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());

        TableColumn<User, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(cellData -> cellData.getValue().getRoleStringProperty());

        tableView.setStyle("-fx-font-size: 16;");

        // Adjusting column widths
        //prefWidth is the width is a dimension that I can set
        //Here it the width of each column is bound to the tableView width
        //multiply(≈1/7) so that all columns have the same width

        firstNameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));
        lastNameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));
        emailColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));
        usernameColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));
        passwordColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));
        genderColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));
        roleColumn.prefWidthProperty().bind(tableView.widthProperty().multiply(0.1423));


        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn,
                usernameColumn, passwordColumn,genderColumn,roleColumn);

        return tableView;
    }

}
