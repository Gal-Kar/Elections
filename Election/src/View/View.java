package View;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;


import javafx.scene.layout.VBox;
import javafx.scene.control.Button;


public class View {
	Stage stage;
	Button AddBallot;
	Button AddCitizen;
	Button AddParty;
	Button AddPartyMember;
	Button ShowBallot;
	Button ShowCitezens;
	Button ShowParties;
	Button Elections;
	Button Results;
	VBox vb=new VBox();

	public View(Stage stage) {//main window
		this.stage=stage;
		Text title=new Text("Elections 2020");
		title.setFont(Font.font ("Verdana", 20));
		AddBallot=new Button("Add ballot");
		AddCitizen=new Button("Add citizen");
		AddParty=new Button("Add party");
		AddPartyMember=new Button("Add party member");
		ShowBallot=new Button("Show all ballot");
		ShowCitezens=new Button("Show all citizens");
		ShowParties=new Button("Show all parties");
		Elections=new Button("Start elections");
		Results=new Button("Show elections results");
		VBox vb=new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(title,AddBallot,AddCitizen,AddParty,AddPartyMember,ShowBallot,ShowCitezens,ShowParties,Elections,Results);
		vb.setMargin(title, new Insets(0,0,40,0));
		vb.setMargin(AddBallot, new Insets(0,0,10,0));
		vb.setMargin(AddCitizen, new Insets(0,0,10,0));
		vb.setMargin(AddParty, new Insets(0,0,10,0));
		vb.setMargin(AddPartyMember, new Insets(0,0,10,0));
		vb.setMargin(ShowBallot, new Insets(0,0,10,0));
		vb.setMargin(ShowCitezens, new Insets(0,0,10,0));
		vb.setMargin(ShowParties, new Insets(0,0,10,0));
		vb.setMargin(Elections, new Insets(0,0,10,0));
		Scene scene=new Scene(vb,500,500);
		stage.setScene(scene);
		stage.show();
	}
	
	/*public void addEventButtonChoose(EventHandler<ActionEvent> event) {
		System.out.println("A");
	}
*/
	public String getKind() {
		 //ShowBallot.getOnAction().toString();
		return AddCitizen.getOnMousePressed().toString();
		// if (vb.getOnMousePressed().toString()=="AddCitizen")
			// newCitizenWindow();
	}
	
	

	public void newCitizenWindow() {//add new citizen window
		Text title=new Text("new citizen");
		VBox vb=new VBox();
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().addAll(title);
		Scene scene=new Scene(vb,500,500);
		stage.setScene(scene);
		stage.show();
	}
}
