package application.bookstore.views;
import java.io.FileInputStream;

import application.bookstore.models.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminView {
	private User user;
	private ImageView[] buttonImages = new ImageView[5];
	private BorderPane frame;
	private VBox options;
	private Scene scene;
	private Button profile_button;
	private Button other_users_buttons;
	private Button bookstore_button;
	private Button statistics_button;
	private Button log_out_button;
	private FileInputStream image;
	private Image img;
	private Alert alert;
	private VBox center;
	private Label welcome_user;

	public AdminView(User user){
		this.user = user;
	}
	public Scene showView(Stage stage) throws Exception {

		frame = new BorderPane(); // Main Frame that will hold every component and pane
		frame.setStyle("-fx-background-color: #FFF9E9;");

		getButtonImages();//call function that will get the images required for the side options


		options = new VBox();
		options.setStyle("-fx-background-color: #D2B48C;");
		options.setPrefWidth(200);
		options.setSpacing(30);

		profile_button = new Button("",buttonImages[0]);
		profile_button.setPrefHeight(120);
		profile_button.setPrefWidth(150);
		profile_button.setBackground(null);


		profile_button.setOnAction(e -> {
			Stage popup = new Stage();
			ProfileView profileView = new ProfileView(user);
			popup.setScene(profileView.showView(popup));
			popup.show();
		});


		other_users_buttons = new Button("",buttonImages[1]);
		other_users_buttons.setPrefHeight(120);
		other_users_buttons.setPrefWidth(150);
		other_users_buttons.setBackground(null);

		bookstore_button = new Button("",buttonImages[2]);
		bookstore_button.setPrefHeight(120);
		bookstore_button.setPrefWidth(150);
		bookstore_button.setBackground(null);

		bookstore_button.setOnAction( e -> {
			BookView bookview = new BookView(user.getRole() , user);
			stage.setScene(bookview.showView(stage));
		});

		statistics_button = new Button("",buttonImages[3]);
		statistics_button.setPrefHeight(120);
		statistics_button.setPrefWidth(150);
		statistics_button.setBackground(null);

		log_out_button = new Button("",buttonImages[4]);
		log_out_button.setPrefHeight(120);
		log_out_button.setPrefWidth(150);
		log_out_button.setBackground(null);

		options.getChildren().addAll(profile_button, other_users_buttons , bookstore_button , statistics_button , log_out_button);
		options.setAlignment(Pos.CENTER);

		//event handlers for the buttons
		other_users_buttons.setOnAction(e->{
			OtherUsersView otherUsersView=new OtherUsersView(user);
			stage.setScene(otherUsersView.showView(stage));
		});

		statistics_button.setOnAction(e-> {
			StatisticsView statisticsView=new StatisticsView(user);
			stage.setScene(statisticsView.showView(stage));
				}
		);

		center = new VBox();

		welcome_user = new Label("Welcome " + user.getFirstName() + " " + user.getLastName()); 												//!!!!!!!!!!!! Replace with the class.getUsername(); to make it Dynamic depending on which users logs in
		welcome_user.setStyle(
				"-fx-font-size: 40px;" + // Set font size to 24 pixels							//!!!!!!! Not Finished yet the style will be changed to match background and look better
						"-fx-font-family: 'Arial';" + // Set font family to Arial
						"-fx-text-fill: black;" // Set text color to white
		);

		center.getChildren().add(welcome_user);
		center.setAlignment(Pos.TOP_CENTER);

		frame.setLeft(options);
		frame.setCenter(center);

		// create scene

		stage.setTitle("Admin Window");
		return new Scene(frame , 1000 , 700 );
	}

	private void getButtonImages() {
		/*image is a fileinputstream which is used to get the png files into the code,
		 then we use that to create a imageview and store it into buttonImages array of imageviews which is latter used to get the icons for buttons
		 */
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {
			for(int i=0; i<5; i++) {
				try {
					switch (i) {
						case 0:
							image = new FileInputStream("C:\\Users\\alvin\\OneDrive\\Desktop\\BookStoreJavafx\\BookStore\\Images\\profile_icon.png");
							img = new Image(image);
							buttonImages[0] = new ImageView(img);
							buttonImages[0].setFitHeight(100);
							buttonImages[0].setFitWidth(100);
							break;
						case 1:
							image = new FileInputStream("C:\\Users\\alvin\\OneDrive\\Desktop\\BookStoreJavafx\\BookStore\\Images\\other_users.png");
							img = new Image(image);
							buttonImages[1] = new ImageView(img);
							buttonImages[1].setFitHeight(100);
							buttonImages[1].setFitWidth(100);
							break;
						case 2:
							image = new FileInputStream("C:\\Users\\alvin\\OneDrive\\Desktop\\BookStoreJavafx\\BookStore\\Images\\book.png");
							img = new Image(image);
							buttonImages[2] = new ImageView(img);
							buttonImages[2].setFitHeight(120);
							buttonImages[2].setFitWidth(120);
							break;
						case 3:
							image = new FileInputStream("C:\\Users\\alvin\\OneDrive\\Desktop\\BookStoreJavafx\\BookStore\\Images\\statistics.png");
							img = new Image(image);
							buttonImages[3] = new ImageView(img);
							buttonImages[3].setFitHeight(140);
							buttonImages[3].setFitWidth(140);
							break;
						case 4:
							image = new FileInputStream("C:\\Users\\alvin\\OneDrive\\Desktop\\BookStoreJavafx\\BookStore\\Images\\log_out.png");
							img = new Image(image);
							buttonImages[4] = new ImageView(img);
							buttonImages[4].setFitHeight(100);
							buttonImages[4].setFitWidth(100);
							break;
					}
				}catch(java.io.FileNotFoundException e) {
					//Alert notifying user if there is an error regarding loading picture
					//!!!!!!! Alert shows under the stage, needs to be fixed!
					alert = new Alert(AlertType.ERROR);
					alert.setContentText("Resources Missing!Contact your Admin!\nErrorCode:104");
					alert.show();
					e.printStackTrace();
				}
			}
		} else if (os.contains("mac")) {
			for(int i=0; i<5; i++) {
				try {
					switch(i) {
						case 0:
							image = new FileInputStream("/Users/regiloshi/IdeaProjects/BookStore_Javafx/BookStore/Images/profile_icon.png");
							img = new Image(image);
							buttonImages[0] = new ImageView(img);
							buttonImages[0].setFitHeight(100);
							buttonImages[0].setFitWidth(100);
							break;
						case 1:
							image = new FileInputStream("/Users/regiloshi/IdeaProjects/BookStore_Javafx/BookStore/Images/other_users.png");
							img = new Image(image);
							buttonImages[1] = new ImageView(img);
							buttonImages[1].setFitHeight(100);
							buttonImages[1].setFitWidth(100);
							break;
						case 2:
							image = new FileInputStream("/Users/regiloshi/IdeaProjects/BookStore_Javafx/BookStore/Images/book.png");
							img = new Image(image);
							buttonImages[2] = new ImageView(img);
							buttonImages[2].setFitHeight(120);
							buttonImages[2].setFitWidth(120);
							break;
						case 3:
							image = new FileInputStream("/Users/regiloshi/IdeaProjects/BookStore_Javafx/BookStore/Images/statistics.png");
							img = new Image(image);
							buttonImages[3] = new ImageView(img);
							buttonImages[3].setFitHeight(140);
							buttonImages[3].setFitWidth(140);
							break;
						case 4:
							image = new FileInputStream("/Users/regiloshi/IdeaProjects/BookStore_Javafx/BookStore/Images/log_out.png");
							img = new Image(image);
							buttonImages[4] = new ImageView(img);
							buttonImages[4].setFitHeight(100);
							buttonImages[4].setFitWidth(100);
							break;
					}
				}catch(java.io.FileNotFoundException e) {
					//Alert notifying user if there is an error regarding loading picture
					//!!!!!!! Alert shows under the stage, needs to be fixed!
					alert = new Alert(AlertType.ERROR);
					alert.setContentText("Resources Missing!Contact your Admin!\nErrorCode:104");
					alert.show();
					e.printStackTrace();
				}
			}
		}
	}
}