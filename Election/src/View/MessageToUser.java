package View;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MessageToUser {
	private Text text;
	private Stage currentWindow;

	public MessageToUser(Stage stage,String mType) {
		currentWindow = new Stage();
		currentWindow.initOwner(stage);
		boolean newMes=true;
		if(mType=="added") {
			VBox vb=new VBox();
			text=new Text("Added Succesfully");
			text.setFill(Color.GREEN);
			vb.getChildren().addAll(text);
			vb.setAlignment(Pos.CENTER);
			currentWindow.initModality(Modality.APPLICATION_MODAL);
			Scene scene=new Scene(vb,400,200);
			currentWindow.setScene(scene);
			currentWindow.show();
			newMes=false;
		}
		if(mType=="InvalidID") {
			VBox vb=new VBox();
			text=new Text("Invalid ID");
			text.setFill(Color.RED);
			vb.getChildren().addAll(text);
			currentWindow.initModality(Modality.APPLICATION_MODAL);
			Scene scene=new Scene(vb,400,200);
			stage.setScene(scene);
			stage.show();
			newMes=false;
		}
		if(newMes==true) {
			VBox vb=new VBox();
			text=new Text(mType);
			vb.getChildren().addAll(text);
			vb.setAlignment(Pos.CENTER);
			currentWindow.initModality(Modality.APPLICATION_MODAL);
			Scene scene=new Scene(vb,400,200);
			stage.setScene(scene);
			stage.show();
		}
	}
}
