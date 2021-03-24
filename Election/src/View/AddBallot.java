package View;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Model.Ballot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AddBallot {
	private TextField ballotAdd;
	private RadioButton regular, corona, army,armyCorona ;
	private Button submit;
	private Stage stage;
	
	public AddBallot(Stage stage) {
		this.stage=stage;
		submit=new Button("submit");
		Text title=new Text("Add Ballot");
		title.setFont(Font.font ("Verdana", 20));
		ballotAdd=new TextField();
		stage.initModality(Modality.APPLICATION_MODAL);
		ToggleGroup tg = new ToggleGroup();
		regular = new RadioButton("regular");
		regular.setToggleGroup(tg);
		regular.setSelected(true);
		corona = new RadioButton("corona");
		corona.setToggleGroup(tg);
		army = new RadioButton("army");
		army.setToggleGroup(tg);
		armyCorona = new RadioButton("armyc orona");
		armyCorona.setToggleGroup(tg);
		Text addText=new Text("Enter ballot address");
		Text ballotText=new Text("choose ballot type");
		addText.setFont(Font.font ("Verdana", 20));
		HBox hb1=new HBox();
		hb1.getChildren().addAll(addText,ballotAdd);
		HBox.setMargin(addText, new Insets(0,20,0,0));
		hb1.setAlignment(Pos.CENTER);
		HBox hb2=new HBox();
		hb2.getChildren().addAll(regular,corona,army,armyCorona);
		hb2.setAlignment(Pos.CENTER);
		HBox.setMargin(regular, new Insets(0,20,0,0));
		HBox.setMargin(corona, new Insets(0,20,0,0));
		HBox.setMargin(army, new Insets(0,20,0,0));
		HBox.setMargin(armyCorona, new Insets(0,20,0,0));
		VBox vb=new VBox();
		vb.setAlignment(Pos.CENTER);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		vb.getChildren().addAll(title,hb1,ballotText,hb2,submit);
		VBox.setMargin(title, new Insets(0,0,60,10));
		VBox.setMargin(hb1, new Insets(0,0,40,10));
		VBox.setMargin(ballotText, new Insets(0,0,10,10));
		VBox.setMargin(hb2, new Insets(0,0,20,0));
		Scene scene=new Scene(vb,500,500);
		stage.setScene(scene);
		stage.show();
	}
	
	public Ballot createBallot() {
		if(regular.isSelected())
			return new Ballot(ballotAdd.getText(),"REGULAR");
		if(corona.isSelected())
			return new Ballot(ballotAdd.getText(),"CORONA");
		if(army.isSelected())
			return new Ballot(ballotAdd.getText(),"ARMY");
		if(armyCorona.isSelected())
			return new Ballot(ballotAdd.getText(),"ARMYCORONA");
		return null;
	}
	
	public void addEventToSubmit(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
	}
	
	public void closeStage() {
		stage.close();
	}
}
