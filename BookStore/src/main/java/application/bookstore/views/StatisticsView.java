package application.bookstore.views;

import application.bookstore.auxiliaries.DatabaseConnector;
import application.bookstore.models.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StatisticsView implements DatabaseConnector {

    private User currentUser;

    public StatisticsView(User u)
    {
        this.currentUser=u;
    }

    public Scene showView(Stage stage)
    {
        return new Scene(new Button("ok"),1000,700);
    }
}
