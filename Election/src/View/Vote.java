package View;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import Model.Ballot;
import Model.Citizen;
import Model.PoliticalParty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Vote {

	private Stage stage;
	private Button submit;
	private ArrayList<HBox>allCitizens;
	private ArrayList<ComboBox>allPartiesList;
	private Ballot ballot;
	private ArrayList <RadioButton>coronaY;
	private ArrayList <RadioButton>coronaN;
	private ArrayList <RadioButton>weponY;
	private ArrayList <RadioButton>weponN;


	public Vote(Stage s,Ballot b) {
		stage=s;
		ballot=b;
		VBox vb=new VBox();
		coronaY=new ArrayList<RadioButton>();
		coronaN=new ArrayList<RadioButton>();		
		weponY=new ArrayList<RadioButton>();
		weponN=new ArrayList<RadioButton>();
		allPartiesList=new ArrayList<ComboBox>();
		allCitizens=new ArrayList<HBox>();
		Text title=new Text("Elections"); 
		Text BallotInfo=new Text(ballot.ballotShow());
		title.setFont(Font.font ("Verdana", 22));
		BallotInfo.setFont(Font.font ("Verdana", 14));
		BallotInfo.setFill(Color.GREEN);
		vb.getChildren().addAll(title,BallotInfo);
		VBox.setMargin(title, new Insets(20, 50, 20, 0) );
		Text info=new Text();

		if(ballot.getBallotType().toLowerCase().equals("regular")) {

			for(int i=0;i<ballot.getBallotAssociatedCitizen().size();i++) {
				allPartiesList.add(partiesCBox(ballot.getAllParties()));
				allCitizens.add(buildNormalHBox(ballot.getBallotAssociatedCitizen().get(i),i));
				allCitizens.get(i).setAlignment(Pos.CENTER);
				vb.getChildren().addAll(allCitizens.get(i),new Text("___________________________________________________________________"
						+ "____________________________________________________________"));
				VBox.setMargin(allCitizens.get(i), new Insets(20, 0, 0, 0) );
			}
		}

		if(ballot.getBallotType().toLowerCase().equals("corona")) {
			info=(new Text("name                    id           have been in isolation over 14 days?                  parties                "));
			vb.getChildren().add(info);
			for(int i=0;i<ballot.getBallotAssociatedCitizen().size();i++) {
				allPartiesList.add(partiesCBox(ballot.getAllParties()));
				allCitizens.add(buildCoronaHBox(ballot.getBallotAssociatedCitizen().get(i),i));
				allCitizens.get(i).setAlignment(Pos.CENTER);
				allCitizens.get(i).setAlignment(Pos.CENTER);
				vb.getChildren().addAll(allCitizens.get(i),new Text("___________________________________________________________________"
						+ "____________________________________________________________"));
				VBox.setMargin(allCitizens.get(i), new Insets(20, 0, 0, 0) );
			}
		}

		if(ballot.getBallotType().toLowerCase().equals("army")) {
			info=(new Text("name                    id                                 carring wepon?                      parties               "
					+ "                   "));
			vb.getChildren().add(info);
			for(int i=0;i<ballot.getBallotAssociatedCitizen().size();i++) {
				allPartiesList.add(partiesCBox(ballot.getAllParties()));
				allCitizens.add(buildArmyHBox(ballot.getBallotAssociatedCitizen().get(i),i));
				allCitizens.get(i).setAlignment(Pos.CENTER);
				vb.getChildren().addAll(allCitizens.get(i),new Text("___________________________________________________________________"
						+ "____________________________________________________________"));
				VBox.setMargin(allCitizens.get(i), new Insets(20, 0, 0, 0) );
			}
		}

		if(ballot.getBallotType().toLowerCase().equals("armycorona")) {
			info=(new Text("name              id                        have been in isolation over 14 days?                carring wepon?                     parties  "
					+ "                                              "));
			info.setFont(Font.font(12));
			vb.getChildren().add(info);
			for(int i=0;i<ballot.getBallotAssociatedCitizen().size();i++) {
				allPartiesList.add(partiesCBox(ballot.getAllParties()));
				allCitizens.add(buildArmyCoronaHBox(ballot.getBallotAssociatedCitizen().get(i),i));
				allCitizens.get(i).setAlignment(Pos.CENTER);
				vb.getChildren().addAll(allCitizens.get(i),new Text("___________________________________________________________________"
						+ "____________________________________________________________"));
				VBox.setMargin(allCitizens.get(i), new Insets(20, 0, 0, 0) );
			}
		}
		submit=new Button("submit");
		submit.setStyle("-fx-font-size: 1em; ");
		vb.getChildren().add(submit);
		VBox.setMargin(info,new Insets(20, 0, 0, 0));
		VBox.setMargin(submit,new Insets(80, 0, 0, 0));
		vb.setAlignment(Pos.TOP_CENTER);

		stage.initModality(Modality.APPLICATION_MODAL);
		Scene scene=new Scene(vb,800,800);
		stage.setScene(scene);
		stage.show();			
	}

	private HBox buildNormalHBox(Citizen c,int i) {
		HBox hb=new HBox();
		Text name=new Text(c.getName());
		Text ID=new Text(c.getID());
		hb.getChildren().addAll(name,ID,allPartiesList.get(i));
		HBox.setMargin(name, new Insets(0, 20, 0, 0) );
		HBox.setMargin(ID, new Insets(0, 40, 0, 0) );
		return hb;
	}

	private HBox buildCoronaHBox(Citizen c,int i) {
		HBox hb=new HBox();
		Text name=new Text(c.getName());
		Text ID=new Text(c.getID());
		coronaY.add(new RadioButton("yes"));
		coronaN.add(new RadioButton("no"));		
		ToggleGroup coronaTG = new ToggleGroup();
		coronaY.get(i).setToggleGroup(coronaTG);
		coronaN.get(i).setToggleGroup(coronaTG);
		coronaY.get(i).setSelected(true);
		hb.getChildren().addAll(name,ID,coronaY.get(i),coronaN.get(i),allPartiesList.get(i));
		HBox.setMargin(name, new Insets(0, 80, 0, 0) );
		HBox.setMargin(ID, new Insets(0, 80, 0, 0) );
		HBox.setMargin(coronaY.get(i), new Insets(0, 30, 0, 0) );
		HBox.setMargin(coronaN.get(i), new Insets(0, 80, 0, 0) );
		return hb;
	}

	private HBox buildArmyHBox(Citizen c,int i) {
		HBox hb=new HBox();
		Text name=new Text(c.getName());
		Text ID=new Text(c.getID());
		weponY.add(new RadioButton("yes"));
		weponN.add(new RadioButton("no"));	
		ToggleGroup carryingWeponTG = new ToggleGroup();
		weponY.get(i).setToggleGroup(carryingWeponTG);
		weponN.get(i).setToggleGroup(carryingWeponTG);
		weponN.get(i).setSelected(true);
		hb.getChildren().addAll(name,ID,weponY.get(i),weponN.get(i),allPartiesList.get(i));
		HBox.setMargin(name, new Insets(0, 80, 0, 0) );
		HBox.setMargin(ID, new Insets(0, 80, 0, 0) );
		HBox.setMargin(weponY.get(i), new Insets(0, 30, 0, 0) );
		HBox.setMargin(weponN.get(i), new Insets(0, 80, 0, 0) );
		return hb;

	}

	private HBox buildArmyCoronaHBox(Citizen c,int i) {
		HBox hb=new HBox();
		Text name=new Text(c.getName());
		Text ID=new Text(c.getID());

		coronaY.add(new RadioButton("yes"));
		coronaN.add(new RadioButton("no"));
		ToggleGroup coronaTG = new ToggleGroup();
		coronaY.get(i).setToggleGroup(coronaTG);
		coronaN.get(i).setToggleGroup(coronaTG);

		weponY.add(new RadioButton("yes"));
		weponN.add(new RadioButton("no"));
		ToggleGroup carryingWeponTG = new ToggleGroup();
		weponY.get(i).setToggleGroup(carryingWeponTG);
		weponN.get(i).setToggleGroup(carryingWeponTG);
		coronaY.get(i).setSelected(true);
		weponN.get(i).setSelected(true);

		hb.getChildren().addAll(name,ID,coronaY.get(i),coronaN.get(i),weponY.get(i),weponN.get(i),allPartiesList.get(i));
		HBox.setMargin(name, new Insets(0, 50, 0, 0) );
		HBox.setMargin(ID, new Insets(0, 60, 0, 0) );
		HBox.setMargin(coronaY.get(i), new Insets(0, 20, 0, 0) );
		HBox.setMargin(coronaN.get(i), new Insets(0, 80, 0, 0) );
		HBox.setMargin(weponY.get(i), new Insets(0, 20, 0, 0) );
		HBox.setMargin(weponN.get(i), new Insets(0, 40, 0, 0) );
		return hb;

	}

	public ComboBox partiesCBox(List<PoliticalParty> p) {
		ComboBox allParties=new ComboBox<>(); 
		allParties.getItems().add("I dont want to vote");
		for(int i=0;i<p.size();i++) {
			allParties.getItems().add(p.get(i).getPoliticalPartyName());
		}
		allParties.getSelectionModel().selectFirst();
		return allParties;
	}

	public void addEventToSubmit(EventHandler<ActionEvent> event) {
		submit.setOnAction(event);
	}

	public String check(int row) {
		if (ballot.getBallotType().toLowerCase().equals("corona"))
			for(int i=0;i<allCitizens.size();i++) {
				if(coronaN.get(i).isSelected())
					if(!allPartiesList.get(i).getValue().equals("I dont want to vote"))
						return "citizen "+ballot.getBallotAssociatedCitizen().get(i).getName()+" can't vote -havent been in isolation long enaf";
			}
		if (ballot.getBallotType().toLowerCase().equals("army"))
			for(int i=0;i<allCitizens.size();i++) {
				if(weponY.get(i).isSelected())
					if(!allPartiesList.get(i).getValue().equals("I dont want to vote"))
						return "soldier "+ballot.getBallotAssociatedCitizen().get(i).getName()+" can't vote -carrying wepon";
			}
		if (ballot.getBallotType().toLowerCase().equals("armycorona"))
			for(int i=0;i<allCitizens.size();i++) {
				if(coronaN.get(i).isSelected())
					if(!allPartiesList.get(i).getValue().equals("I dont want to vote"))
						return "citizen "+ballot.getBallotAssociatedCitizen().get(i).getName()+" can't vote -havent been in isolation long enaf";
				if(weponY.get(i).isSelected())
					if(!allPartiesList.get(i).getValue().equals("I dont want to vote"))
						return "soldier "+ballot.getBallotAssociatedCitizen().get(i).getName()+" can't vote -carrying wepon";
			}
		return "OK";
	}

	public void closeStage() {
		stage.close();
	}
	
	public int returnPartyVotes(String name) {
		int counter=0;
		for(int i=0;i<allPartiesList.size();i++) {
			if(allPartiesList.get(i).getValue().toString().toLowerCase().equals(name.toLowerCase()))
					counter++;
		}
		return counter;
	}
	public int addVotesToBaLLOT() {
		int counter=0;
		for(int i=0;i<allPartiesList.size();i++) {
			if(!allPartiesList.get(i).getValue().equals("I dont want to vote"))
				counter++;
		}
		return counter;
	}



}













