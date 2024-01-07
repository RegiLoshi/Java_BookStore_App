package application.bookstore.auxiliaries;

import application.bookstore.models.Role;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class AddNewUserPane extends GridPane {
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
    private String role;

    public AddNewUserPane(Role role){
        if(role.equals(Role.MANAGER))
            this.role="Manager";
        else if(role.equals(Role.LIBRARIAN))
            this.role="Librarian";

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
        HBox b = new HBox();
        b.getChildren().addAll(male, female, other);
        add(b, 1, 6);

        HBox hBox=new HBox();
        hBox.setSpacing(15);
        Button button=new Button();
        Button button1=new Button("Cancel");

        if(role.equalsIgnoreCase("librarian"))
            button = new Button("Add Librarian");
        else if(role.equalsIgnoreCase("manager"))
            button=new Button("Add Manager");

        button.setFont(Font.font(25));
        button1.setFont(Font.font(25));

        hBox.getChildren().addAll(button,button1);

        add(hBox, 1, 7);
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
    public char getGender()
    {
        if(male.isSelected())
            return 'M';
        else if(female.isSelected())
            return 'F';

        return 'U'; //by
    }
}
