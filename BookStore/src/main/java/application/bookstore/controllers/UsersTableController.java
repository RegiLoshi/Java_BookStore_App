package application.bookstore.controllers;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.User;
import application.bookstore.views.UsersTableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class UsersTableController implements DatabaseConnector {
    private final Stage primaryStage;
    private TableView<User> tableView;
    private TableColumn<User, String> firstNameColumn;
    private TableColumn<User, String> lastNameColumn;
    private TableColumn<User, String> emailColumn;
    private TableColumn<User,String> userNameColumn;
    private TableColumn<User, String> passwordColumn;
    private TableColumn<User, String> genderColumn;
    private TableColumn<User, String> roleColumn;

    public UsersTableController(UsersTableView view,Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        addListener(view);
    }

    private void addListener(UsersTableView view)
    {

    }
}
