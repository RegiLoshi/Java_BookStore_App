package application.bookstore.views;

import application.bookstore.auxiliaries.AddNewUserPane;
import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.auxiliaries.UsersTableView;
import application.bookstore.models.Role;
import application.bookstore.models.User;
import javafx.beans.property.SimpleObjectProperty;
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

        borderPane.setTop(usersTableView);
        borderPane.setLeft(buttonsVbox);

        //-----------Handling the events
        Stage addUserStage = new Stage();
        addUserStage.setTitle("Add User");
        addLibrarian.setOnAction(e -> {
            /*
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                int rowsAffected =statement.executeUpdate("DELETE  FROM user where Role='manager'");
            } catch (SQLException ex) {
                System.out.println("Did not sign in to DB");
                ex.printStackTrace();

                 StackPane CenteringAddNewUserPane=new StackPane();
                  CenteringAddNewUserPane.getChildren().add(addNewUserPane);

            addUserStage.setScene(new Scene(CenteringAddNewUserPane,700,650));
            }

             */
             AddNewUserPane addNewUserPane=new AddNewUserPane(users,addUserStage);
            addNewUserPane.setAlignment(Pos.CENTER);

            addUserStage.setScene(new Scene(addNewUserPane,700,650));
            addUserStage.show();

        });

        removeManager.setOnAction(e -> {
            /*
            try {
                Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                Statement statement = connection.createStatement();
                int rowsAffected =statement.executeUpdate("DELETE  FROM user where Role='manager'");
                //exceuteUpdate need to be used for DELETE, UPDATE, or INSERT not executeQuery
            } catch (SQLException ex) {
                System.out.println("Did not sign in to DB");
                ex.printStackTrace();
            }

             */
            for (User u : users)
            {
                System.out.println(u);
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


    public ObservableList<User> getUsers()
    {
        return users;
    }

}
