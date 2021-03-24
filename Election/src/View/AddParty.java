package View;

import Model.Ballot;
import Model.PoliticalParty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddParty {
	private TextField PartyName;
	private RadioButton right,left ;
	private DatePicker date;
	private Button submit;
	private Stage stage;

	public AddParty(Stage stage) {
		this.stage=stage;
		submit=new Button("submit");
		Text title=new Text("Add Party");
		title.setFont(Font.font ("Verdana", 20));
		PartyName=new TextField();
		stage.initModality(Modality.APPLICATION_MODAL);
		ToggleGroup tg = new ToggleGroup();
		right = new RadioButton("right");
		right.setToggleGroup(tg);
		right.setSelected(true);
		left = new RadioButton("left");
		left.setToggleGroup(tg);
		
		Text nameText=new Text("Enter party name");
		
		Text dateT=new Text("date of establishment:");
		date=new DatePicker();
		Text partyText=new Text("choose party stram type");
		nameText.setFont(Font.font ("Verdana", 20));
		HBox hb1=new HBox();
		hb1.getChildren().addAll(nameText,PartyName);
		HBox.setMargin(nameText, new Insets(0,20,0,0));
		hb1.setAlignment(Pos.CENTER);
		HBox hb2=new HBox();
		hb2.getChildren().addAll(right,left);
		hb2.setAlignment(Pos.CENTER);
		HBox.setMargin(right, new Insets(0,20,0,0));
		HBox.setMargin(left, new Insets(0,20,0,0));
		VBox vb=new VBox();
		vb.setAlignment(Pos.CENTER);
		submit.setAlignment(Pos.BOTTOM_RIGHT);
		vb.getChildren().addAll(title,hb1,dateT,date,partyText,hb2,submit);
		VBox.setMargin(title, new Insets(0,0,60,10));
		VBox.setMargin(hb1, new Insets(0,0,40,10));
		VBox.setMargin(date, new Insets(10, 0, 0, 0) );
		VBox.setMargin(partyText, new Insets(0,0,10,10));
		VBox.setMargin(hb2, new Insets(0,0,20,0));
		Scene scene=new Scene(vb,500,500);
		stage.setScene(scene);
		stage.show();
	}

	public PoliticalParty createParty() {
		if(right.isSelected())
			return new PoliticalParty(PartyName.getText(),"right",date.getValue());
		if(left.isSelected())
			return new PoliticalParty(PartyName.getText(),"left",date.getValue());
		return null;
	}

	public void addEventToSubmit(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
	}

	public void closeStage() {
		stage.close();
	}
}

