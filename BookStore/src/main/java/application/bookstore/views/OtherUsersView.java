package application.bookstore.views;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;


public class OtherUsersView implements DatabaseConnector {

    private User currentAdmin;
    //testing

    private ObservableList<User> users=FXCollections.observableArrayList();
    private Button addLibrarianButton;
    private Button addManagerButton;
    private Button removeUserButton;
    private UsersTableView usersTableView;

    public OtherUsersView(){}

    public OtherUsersView(User admin) {

        this.currentAdmin = admin;
        //Here we get the existing users from the database
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            //!!!!!!!!!!!note when the admin passes the role make sure it is in lowercase in the options

            while (resultSet.next()) {
                //#TODO
                //make sure not duplicated usernames
                if(!(resultSet.getString("username").equals(currentAdmin.getUsername())))
                    users.add(new User(
                            new SimpleStringProperty(resultSet.getString("firstName")),
                            new SimpleStringProperty(resultSet.getString("lastName")),
                            new SimpleStringProperty(resultSet.getString("email")),
                            new SimpleStringProperty(resultSet.getString("username")),
                            new SimpleStringProperty(resultSet.getString("password")),
                            new SimpleStringProperty(resultSet.getString("gender")),
                            new SimpleStringProperty(resultSet.getString("Role"))
                    ));
                }
        }catch (SQLException ex) {
            System.out.println("Did not sign in to DB");
            ex.printStackTrace();
        }
    }
    public Scene showView(Stage stage) {

        BorderPane borderPane=new BorderPane();

        stage.setTitle("User Information");

        usersTableView=new UsersTableView(users);

        borderPane.setTop(usersTableView);

        Scene scene = new Scene(borderPane, 1000, 700);

        return scene;
    }


    public ObservableList<User> getUsers()
    {
        return users;
    }

}
