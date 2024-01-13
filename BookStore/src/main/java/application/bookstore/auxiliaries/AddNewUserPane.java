package application.bookstore.auxiliaries;

import application.bookstore.models.Role;
import application.bookstore.models.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewUserPane extends GridPane implements DatabaseConnector{
    private Label firstNameL;
    private TextField firstNameField;
    private Label LastNameL;
    private TextField LastNameField;
    private Label EmailL;
    private TextField EmailField;
    private Label Username;
    private TextField UsernameField;
    private Label PasswordL;
    private PasswordField passF;
    private Label VPasswordL;
    private PasswordField VpassF;
    private Label genderL;
    private RadioButton male;
    private RadioButton female;
    private RadioButton other;
    private Label role;
    private RadioButton admin;
    private RadioButton manager;
    private RadioButton librarian;
    private ObservableList<User> users;
    Stage stage;

    public AddNewUserPane(ObservableList<User> users,Stage st)
    {
        this.stage=st;
        this.users=users;
        createPane();
    }

    public void createPane()
    {
        setHgap(10);
        setVgap(10);

        firstNameL = new Label("First Name");
        firstNameField = new TextField();
        firstNameL.setFont(Font.font(25));
        firstNameField.setFont(Font.font(25));
        add(firstNameL, 0, 0);
        add(firstNameField, 1, 0);

        LastNameL = new Label("Last Name");
        LastNameField = new TextField();
        LastNameL.setFont(Font.font(25));
        LastNameField.setFont(Font.font(25));
        add(LastNameL, 0, 1);
        add(LastNameField, 1, 1);

        EmailL = new Label("Email");
        EmailField = new TextField();
        EmailL.setFont(Font.font(25));
        EmailField.setFont(Font.font(25));
        add(EmailL, 0, 2);
        add(EmailField, 1, 2);

        Username=new Label("Username");
        UsernameField=new TextField();
        Username.setFont(Font.font(25));
        UsernameField.setFont(Font.font(25));
        add(Username,0,3);
        add(UsernameField,1,3);

        PasswordL = new Label("Password");
        passF = new PasswordField();
        PasswordL.setFont(Font.font(25));
        passF.setFont(Font.font(25));
        add(PasswordL, 0, 4);
        add(passF, 1, 4);

        VPasswordL = new Label("Verify Password");
        VpassF = new PasswordField();
        VPasswordL.setFont(Font.font(25));
        VpassF.setFont(Font.font(25));
        add(VPasswordL, 0, 5);
        add(VpassF, 1, 5);

        ToggleGroup tg = new ToggleGroup();
        genderL = new Label("Gender");
        male = new RadioButton("Male");
        female = new RadioButton("Female");
        other = new RadioButton("Other");
        genderL.setFont(Font.font(25));
        male.setFont(Font.font(22));
        female.setFont(Font.font(22));
        other.setFont(Font.font(22));
        male.setToggleGroup(tg);
        female.setToggleGroup(tg);
        other.setToggleGroup(tg);

        add(genderL, 0, 6);
        HBox genderButtons = new HBox(male,female,other);
        genderButtons.setSpacing(10);
        add(genderButtons, 1, 6);

        role = new Label("Role");
        role.setFont(Font.font(25));
        ToggleGroup tg2 = new ToggleGroup();
        admin = new RadioButton("Admin");
        manager = new RadioButton("Manager");
        librarian = new RadioButton("Librarian");
        admin.setFont(Font.font(22));
        manager.setFont(Font.font(22));
        librarian.setFont(Font.font(22));
        admin.setToggleGroup(tg2);
        manager.setToggleGroup(tg2);
        librarian.setToggleGroup(tg2);

        add(role,0,7);
        HBox roleButtons=new HBox(admin,manager,librarian);
        roleButtons.setSpacing(10);
        add(roleButtons,1,7);

        HBox hBox=new HBox();
        hBox.setSpacing(15);
        Button button=new Button("Add");
        Button button1=new Button("Cancel");

        button.setFont(Font.font(25));
        button.setPrefWidth(200);
        button1.setFont(Font.font(25));
        button1.setPrefWidth(200);
        hBox.setPadding(new Insets(20,10,10,10));

        button1.setOnAction(e->
        {
            User newUser=new User(
                    new SimpleStringProperty(getFirstName()),
                    new SimpleStringProperty(getLastName()),
                    new SimpleStringProperty(getEmail()),
                    new SimpleStringProperty(getUsername()),
                    new SimpleStringProperty(getPassword()),
                    new SimpleStringProperty(getGender()),
                    new SimpleStringProperty(getRole()));

            users.add(newUser);
            //Inserting the new User in the database
            String insertSQL = "INSERT INTO user (firstName, lastName, email, userName, password, gender, Role) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (
                    Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)
            ) {
                preparedStatement.setString(1, newUser.getFirstName());
                preparedStatement.setString(2, newUser.getLastName());
                preparedStatement.setString(3, newUser.getEmail());
                preparedStatement.setString(4, newUser.getUsername());
                preparedStatement.setString(5, newUser.getPassword());
                preparedStatement.setString(6, newUser.getGender());
                preparedStatement.setString(7, newUser.getRoleString());

                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println("Rows affected: " + rowsAffected);
            } catch (SQLException ex) {
                System.out.println("Failed to insert into the database");
                ex.printStackTrace();
            }
            stage.close();
        });

        button1.setOnAction(e->
        {
            stage.close();
        });

        hBox.getChildren().addAll(button,button1);

        add(hBox, 1, 8);
    }

    public String getFirstName()
    {
        return firstNameField.getText();
    }
    public String getLastName()
    {
        return LastNameField.getText();
    }
    public String getEmail()
    {
        return EmailField.getText();
    }

    public String getUsername()
    {
        return UsernameField.getText();
    }
    public String getPassword()
    {
        return passF.getText();
    }

    public String getRole()
    {
        if(admin.isSelected())
            return "admin";
        else if(manager.isSelected())
            return "manager";

        return "librarian";
    }
    public String getGender()
    {
        if(male.isSelected())
            return "M";
        else if(female.isSelected())
            return "F";

        return "O";
    }


}
