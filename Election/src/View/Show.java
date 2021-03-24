package View;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Show {
	private Button exit;
	private Stage stage;
	private ComboBox<String> ballot;

	public Show(Stage stage,String theTitle,String showString) {//show citizens window	
		this.stage=stage;
		stage.initModality(Modality.APPLICATION_MODAL);

		Text title=new Text(theTitle);
		title.setFont(Font.font ("times new roman", 30));

		Text theText=new Text(showString);
		theText.setFont(Font.font ("times new roman", 16));
		VBox vb=new VBox();
		exit=new Button("exit");
		exit.setFont(Font.font ("times new roman", 20));
		vb.getChildren().addAll(title,theText,exit);	
		vb.setAlignment(Pos.CENTER);
		VBox.setMargin(theText, new Insets(30, 0, 0, 0) );
		VBox.setMargin(exit, new Insets(10, 0, 0, 0) );
		if(theTitle.equals("All Citizens:")) {
			Scene scene=new Scene(vb,1000,1000);
			stage.setScene(scene);
			stage.show();
		}
		else {
			Scene scene=new Scene(vb,700,700);
			stage.setScene(scene);
			stage.show();
		}
	}


	public void addEventToExit(EventHandler<ActionEvent> event) {
		exit.setOnAction(event);
	}

	public void closeStage() {
		stage.close();
	}


}
