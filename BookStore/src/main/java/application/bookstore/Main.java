package application.bookstore;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.views.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.*;

public class Main extends Application implements DatabaseConnector {

    public void start(Stage stage)  {
        LoginView lg=new LoginView();
        stage.setTitle("Bookstore");

        stage.setScene(lg.showView(stage));
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }

}
