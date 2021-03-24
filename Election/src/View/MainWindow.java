package View;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainWindow {
	private Button AddBallot;
	private Button AddCitizen;
	private Button AddParty;
	private Button AddPartyMember;
	private Button ShowBallot;
	private Button ShowCitezens;
	private Button ShowParties;
	private Button Elections;
	private Button Results;
	private boolean enable=false;
	private Stage stage;

	public MainWindow(Stage stage) {//main window
		this.stage=stage;
		Text title=new Text("Elections 2020");
		title.setFont(Font.font ("Verdana", 30));
		
		AddBallot=new Button("Add ballot");
		AddBallot.setStyle("-fx-font-size: 1.5em; ");
		AddCitizen=new Button("Add citizen");
		AddCitizen.setStyle("-fx-font-size: 1.5em; ");
		AddParty=new Button("Add party");
		AddParty.setStyle("-fx-font-size: 1.5em; ");
		AddPartyMember=new Button("Add party member");
		AddPartyMember.setStyle("-fx-font-size: 1.5em; ");
		ShowBallot=new Button("Show all ballot");
		ShowBallot.setStyle("-fx-font-size: 1.5em; ");
		ShowCitezens=new Button("Show all citizens");
		ShowCitezens.setStyle("-fx-font-size: 1.5em; ");
		ShowParties=new Button("Show all parties");
		ShowParties.setStyle("-fx-font-size: 1.5em; ");
		Elections=new Button("Start elections");
		Elections.setStyle("-fx-font-size: 1.5em; ");
		Results=new Button("Show elections results");
		Results.setStyle("-fx-font-size: 1.5em; ");
		Results.setDisable(true);
		VBox vb=new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(title,AddBallot,AddCitizen,AddParty,AddPartyMember,ShowBallot,ShowCitezens,ShowParties,Elections,Results);
		VBox.setMargin(title, new Insets(0,0,30,0));
		VBox.setMargin(AddBallot, new Insets(0,0,10,0));
		VBox.setMargin(AddCitizen, new Insets(0,0,10,0));
		VBox.setMargin(AddParty, new Insets(0,0,10,0));
		VBox.setMargin(AddPartyMember, new Insets(0,0,10,0));
		VBox.setMargin(ShowBallot, new Insets(0,0,10,0));
		VBox.setMargin(ShowCitezens, new Insets(0,0,10,0));
		VBox.setMargin(ShowParties, new Insets(0,0,10,0));
		VBox.setMargin(Elections, new Insets(0,0,10,0));
		Scene scene=new Scene(vb,600,700);
		stage.setScene(scene);
		stage.show();
	}
	
	public void addEventToAddBallotButton(EventHandler<ActionEvent> event) {
		AddBallot.setOnAction(event);
	}
	
	public void addEventToAddCitizenButton(EventHandler<ActionEvent> event) {
		AddCitizen.setOnAction(event);
	}
	
	public void addEventToAddPartyMemberButton(EventHandler<ActionEvent> event) {
		AddPartyMember.setOnAction(event);
	}
	
	public void addEventToAddPartyButton(EventHandler<ActionEvent> event) {
		AddParty.setOnAction(event);	
	}
	
	public void addEventToShowCitizensButton(EventHandler<ActionEvent> event) {
		ShowCitezens.setOnAction(event);
	}

	public void addEventToShowPartiesButton(EventHandler<ActionEvent> event) {
		ShowParties.setOnAction(event);		
	}

	public void addEventToShowBallotssButton(EventHandler<ActionEvent> event) {
		ShowBallot.setOnAction(event);	
	}
	
	public void addEventToElectionsButton(EventHandler<ActionEvent> event) {
		Elections.setOnAction(event);
	}
	
	public void addEventToResultsButton(EventHandler<ActionEvent> event) {
		Results.setOnAction(event);	
	}
	public void votePress() {
		AddBallot.setDisable(true);
		AddCitizen.setDisable(true);
		AddParty.setDisable(true);
		AddPartyMember.setDisable(true);
		ShowBallot.setDisable(true);
		ShowCitezens.setDisable(true);
		ShowParties.setDisable(true);
		Elections.setDisable(true);
		Results.setDisable(false);
	}
	
	
	
}
