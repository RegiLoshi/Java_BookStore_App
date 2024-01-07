package application.bookstore.views;

import application.bookstore.auxiliaries.AddNewUserPane;
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
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;


public class OtherUsersView implements DatabaseConnector {

    private User admin;
    private User manager;
    private User librarian;
    //testing
    private ObservableList<User> users = FXCollections.observableArrayList(
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

    public OtherUsersView(){}

    public OtherUsersView(User admin) {
        this.admin = admin;

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user where Role='librarian'");
            //!!!!!!!!!!!note when the admin passes the role make sure it is in lowercase in the options

            if (resultSet.next()) {
                if(resultSet.getString("role").
                        equalsIgnoreCase("librarian")) {
                    librarian = new User(
                            new SimpleStringProperty(resultSet.getString("firstName")),
                            new SimpleStringProperty(resultSet.getString("lastName")),
                            new SimpleStringProperty(resultSet.getString("email")),
                            new SimpleStringProperty(resultSet.getString("username")),
                            new SimpleStringProperty(resultSet.getString("password")),
                            new SimpleStringProperty(resultSet.getString("gender")),
                            Role.LIBRARIAN
                    );
                } else {
                    resultSet=statement.executeQuery("SELECT * FROM user WHERE Role='manager'");
                    if (resultSet.getString("role").
                            equalsIgnoreCase("manager")) {
                        manager = new User(
                                new SimpleStringProperty(resultSet.getString("firstName")),
                                new SimpleStringProperty(resultSet.getString("lastName")),
                                new SimpleStringProperty(resultSet.getString("email")),
                                new SimpleStringProperty(resultSet.getString("username")),
                                new SimpleStringProperty(resultSet.getString("password")),
                                new SimpleStringProperty(resultSet.getString("gender")),
                                Role.MANAGER
                        );
                    }
                }
            }
        }catch (SQLException ex) {
            System.out.println("Did not sign in to DB");
            ex.printStackTrace();
        }
    }
    public Scene showView(Stage stage) {

        BorderPane borderPane=new BorderPane();

        stage.setTitle("User Information");

        TableView<User> tableView = createTableView();
        tableView.setItems(users);//the observableList is set to the tableview

        VBox tableViewVbox = new VBox(tableView);
        StackPane addUser=new StackPane();


        VBox buttonsVbox = new VBox();
        buttonsVbox.setSpacing(20);
        buttonsVbox.setPadding(new Insets(40,30,30,30));

        Button addManager=new Button("Add manager");
        addManager.setFont(Font.font(20));

        Button removeManager=new Button("Remove manager");
        removeManager.setFont(Font.font(20));

        Button addLibrarian=new Button("Add librarian");
        addLibrarian.setFont(Font.font(20));

        Button removeLibrarian=new Button("Remove librarian");
        removeLibrarian.setFont(Font.font(20));

        buttonsVbox.getChildren().addAll(addLibrarian,removeLibrarian,addManager,removeManager);

        borderPane.setTop(tableViewVbox);
        borderPane.setLeft(buttonsVbox);
        borderPane.setCenter(addUser);

        addLibrarian.setOnAction(e -> {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                int rowsAffected =statement.executeUpdate("DELETE  FROM user where Role='manager'");
            } catch (SQLException ex) {
                System.out.println("Did not sign in to DB");
                ex.printStackTrace();
            }
            AddNewUserPane addNewUserPane=new AddNewUserPane(Role.LIBRARIAN);
            addUser.getChildren().addAll(addNewUserPane);//for display purposes
            addUser.setPadding(new Insets(20, 20, 20, 20));
        });

        addManager.setOnAction(e -> {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                int rowsAffected =statement.executeUpdate("DELETE  FROM user where Role='manager'");
            } catch (SQLException ex) {
                System.out.println("Did not sign in to DB");
                ex.printStackTrace();
            }
            AddNewUserPane addNewUserPane=new AddNewUserPane(Role.MANAGER);
            addUser.getChildren().addAll(addNewUserPane);//for display purposes
            addUser.setPadding(new Insets(20, 20, 20, 20));
        });

        removeManager.setOnAction(e -> {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                int rowsAffected =statement.executeUpdate("DELETE  FROM user where Role='manager'");
                //exceuteUpdate need to be used for DELETE, UPDATE, or INSERT not executeQuery
            } catch (SQLException ex) {
                System.out.println("Did not sign in to DB");
                ex.printStackTrace();
            }
        });

        removeLibrarian.setOnAction(e -> {
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                int rowsAffected =statement.executeUpdate("DELETE FROM user where Role='librarian'");
            } catch (SQLException ex) {
                System.out.println("Did not sign in to DB");
                ex.printStackTrace();
            }
        });

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

        tableView.setPrefHeight(100);

        tableView.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn,
                usernameColumn, passwordColumn,genderColumn,roleColumn);

        return tableView;
    }

    public void getUsers()
    {
        users= FXCollections.observableArrayList(
        );
    }

}
