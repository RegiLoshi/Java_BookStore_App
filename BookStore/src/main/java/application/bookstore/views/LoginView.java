package application.bookstore.views;

//The admin log in info will be given at the beginning by the programmers
//Than the admin can change the username and password if they wish to

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.controllers.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



public class LoginView implements DatabaseConnector {
    private GridPane grid;
    private Button btn;
    private TextField userTextField;
    private PasswordField passwordField;
    public Scene showView(Stage stage)
    {
        stage.setTitle("JavaFX Login");
        grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text welcomeMessage = new Text("Welcome to the Bookstore");
        welcomeMessage.setTextAlignment(TextAlignment.CENTER);
        welcomeMessage.setFont(Font.font("Arial", FontWeight.NORMAL, 50));
        grid.add(welcomeMessage,0,0,2,2);

        Label userName = new Label("Username:");
        userName.setFont(Font.font(20));
        grid.add(userName, 0,4 );

         userTextField = new TextField();
        grid.add(userTextField, 1, 4);

        Label password_label = new Label("Password:");
        password_label.setFont(Font.font(20));
        grid.add(password_label, 0, 5);

        passwordField = new PasswordField();
        grid.add(passwordField, 1, 5);

         btn = new Button("Log in");
        btn.setFont(Font.font(20));
        HBox hbtn=new HBox(btn);
        hbtn.setAlignment(Pos.CENTER);
        grid.add(hbtn, 0, 7,2,1);

        stage.setTitle("Log in");

        new LoginController(this,stage);

        grid.setStyle(
                "-fx-font-family: 'JetBrains Mono'; " +
                        "-fx-font-size: 20px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-color: #FFF9E9; " +
                "-fx-background-repeat: no-repeat; " +
                        "-fx-background-size: stretch;"
        );

        return new Scene(grid,1000,700);
    }


    public  GridPane getMainPane()
    {
    return this.grid;
    }

    public Button getBtn()
    {
        return btn;
    }

    public TextField getUserTextField()
    {
        return userTextField;
    }
    public PasswordField getPasswordField()
    {
        return passwordField;
    }
}
