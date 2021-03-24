package View;

import javafx.stage.Modality;
import javafx.stage.Stage;


import java.util.List;
import Model.Ballot;
import Model.Citizen;
import Model.PoliticalParty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

public class AddCitizen {
	private TextField name;
	private TextField id;
	private DatePicker date;
	private ComboBox<String> ballot;
	private Button submit;
	private Stage stage;
	private RadioButton dontHaveCorona, HaveCorona;
	private ComboBox<String> allParties;
	private boolean partyMem;
	private TextField position;
	

	public AddCitizen(Stage stage,List<Ballot>allBallots,List<PoliticalParty>allPartiesList,boolean isPartyMem) {//add new citizen window
		
		this.stage=stage;
		stage.initModality(Modality.APPLICATION_MODAL);
		Text title;
		partyMem=isPartyMem;
		if(partyMem)
			title=new Text("Add Party Member");
		else title=new Text("Add Citizen");
		title.setFont(Font.font ("Verdana", 20));
		Text nameT=new Text("Name:");
		name=new TextField();
		HBox nameBox=new HBox();
		nameBox.getChildren().addAll(nameT,name);
		nameBox.setAlignment(Pos.CENTER);
		HBox.setMargin(nameT, new Insets(0, 20, 0, 0) );

		Text idT=new Text("ID:");
		id=new TextField();
		HBox idBox=new HBox();
		idBox.setAlignment(Pos.CENTER);
		idBox.getChildren().addAll(idT,id);
		HBox.setMargin(idT, new Insets(0, 42, 0, 0) );

		Text dateT=new Text("date of birth:");
		date=new DatePicker();
		Text corona=new Text("are you in isolation?");

		ToggleGroup tg = new ToggleGroup();
		dontHaveCorona=new RadioButton("no");
		dontHaveCorona.setToggleGroup(tg);
		HaveCorona=new RadioButton("yes");
		HaveCorona.setToggleGroup(tg);
		dontHaveCorona.setSelected(true);
		HBox coronaBox=new HBox();
		coronaBox.setAlignment(Pos.CENTER);
		coronaBox.getChildren().addAll(dontHaveCorona,HaveCorona);
		HBox.setMargin(dontHaveCorona, new Insets(0, 7, 0, 0) );

		Text ballotT=new Text("choose ballot");
		ballot=new ComboBox<>();
		ballotCBox(allBallots);
		VBox vb=new VBox();
		submit=new Button("submit");
		vb.getChildren().addAll(title,nameBox,idBox,dateT,date,corona,coronaBox,ballotT,ballot);


		vb.setAlignment(Pos.CENTER);
		VBox.setMargin(nameBox, new Insets(10, 0, 0, 0) );
		VBox.setMargin(idBox, new Insets(10, 0, 0, 0) );
		VBox.setMargin(date, new Insets(10, 0, 0, 0) );
		VBox.setMargin(corona, new Insets(10, 0, 0, 0) );
		VBox.setMargin(coronaBox, new Insets(10, 0, 0, 0) );
		VBox.setMargin(ballotT, new Insets(10, 0, 0, 0) );
		VBox.setMargin(ballot, new Insets(10, 0, 0, 0) );

		if(isPartyMem) {
			Text partyT=new Text("Choose party");
			allParties=new ComboBox<>(); 
			partiesCBox(allPartiesList);
			Text positionT1=new Text("Enter position-");
			positionT1.setFont(Font.font ("Verdana", 13));
			Text positionT2=new Text("0 will put you at last available possition \nany other number will move all the members from this position 1 spot lower ");
			positionT2.setFill(Color.RED);
			position=new TextField();
			HBox posBox=new HBox();
			posBox.getChildren().addAll(positionT1,position);
			HBox.setMargin(positionT1, new Insets(0, 10, 0, 0) );
			posBox.setAlignment(Pos.CENTER);
			vb.getChildren().addAll(partyT,allParties,posBox,positionT2);
			VBox.setMargin(posBox, new Insets(10, 0, 0, 0) );
			VBox.setMargin(partyT, new Insets(10, 0, 0, 0) );
			VBox.setMargin(allParties, new Insets(10, 0, 0, 0) );
			VBox.setMargin(posBox, new Insets(10, 0, 0, 0) );
			VBox.setMargin(positionT2, new Insets(10, 0, 0, 0) );
		}

		vb.getChildren().add(submit);
		VBox.setMargin(submit, new Insets(10, 0, 0, 0) );
		Scene scene=new Scene(vb,500,500);
		stage.setScene(scene);
		stage.show();
	}

	public void partiesCBox(List<PoliticalParty> p) {
		for(int i=0;i<p.size();i++) {
			allParties.getItems().add(p.get(i).getPoliticalPartyName());
		}
	}

	public void ballotCBox(List<Ballot> b) {
		for(int i=0;i<b.size();i++) {
			ballot.getItems().add(b.get(i).getBallotNum()+" "+b.get(i).getBallotAdd());
		}
	}

	public boolean isInIsolation() {
		if(HaveCorona.isSelected())
			return true;
		return false;
	}

	public Citizen createCitizen() {
		String chooseBallot=ballot.getValue();
		String index="";
		for(int i=0;i<chooseBallot.length();i++) {
			if(chooseBallot.charAt(i)!=' ')
				index+=chooseBallot.charAt(i);
			else
				break;
		}
		int ballotnum=Integer.parseInt(index); 
		Citizen c= new Citizen(name.getText(),id.getText(),date.getValue(),ballotnum);
		System.out.println(c);
		return c;
	}
	
	public String getPartyName() {
		return allParties.getValue();
	}
	
	public String getPosition() {
		return position.getText();
	}

	public void addEventToSubmit(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
	}

	public void closeStage() {
		stage.close();
	}
	

}
