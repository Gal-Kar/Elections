package Controller;

import java.util.List;

import Model.Citizen;
import Model.Model;
import Model.PartyMember;
import Model.PoliticalParty;
import View.AddBallot;
import View.AddCitizen;
import View.AddParty;
import View.MainWindow;
import View.MessageToUser;
import View.Show;
import View.ShowResults;
import View.Vote;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.stage.Stage;

public class Controller {
	private Model theModel;
	private MainWindow theView ;
	private MessageToUser msg;
	
	public Controller(Model m,MainWindow v) {
		theModel=m;
		theView=v;

		////add ballot window//////////////////////////////////////////////
		EventHandler<ActionEvent>EventToAddBallotButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AddBallot addballot=new AddBallot(new Stage());
				EventHandler<ActionEvent>EventToAddBallotSubmitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(theModel.addBallot(addballot.createBallot())){
							msg=new MessageToUser(new Stage(), "added");
							addballot.closeStage();
						}
					}
				};
				addballot.addEventToSubmit(EventToAddBallotSubmitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToAddBallotButton(EventToAddBallotButton);//Event to add ballot button
		//////////////////////////////////////////////////////////////////////

		////add citizen window////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToAddCitizenButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AddCitizen addCitizen=new AddCitizen(new Stage(),theModel.getBallot(),null,false);
				EventHandler<ActionEvent>EventToAddCitizenSubmitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Citizen c=addCitizen.createCitizen();
						boolean isolation=addCitizen.isInIsolation();
						String result=theModel.addCitizen(c.getName(), c.getID(), c.getDateOfBirth(), c.getBallotNum(), isolation);
						msg=new MessageToUser(new Stage(), result);
						if(!result.startsWith("Error:"))
							addCitizen.closeStage();
					}
				};
				addCitizen.addEventToSubmit(EventToAddCitizenSubmitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToAddCitizenButton(EventToAddCitizenButton);//Event to add citizen Button
		//////////////////////////////////////////////////////////////////////

		////add partyMember window////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToAddpartyMemberButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				AddCitizen addPartyMem=new AddCitizen(new Stage(),theModel.getBallot(),theModel.getParty(),true);
				EventHandler<ActionEvent>EventToAddPartyMemberSubmitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Citizen p=addPartyMem.createCitizen();
						boolean isolation=addPartyMem.isInIsolation();
						String result=theModel.addPartyMember(p.getName(), p.getID(), p.getDateOfBirth(), p.getBallotNum(),
								isolation,theModel.getPartyByName(addPartyMem.getPartyName()),addPartyMem.getPosition());
						msg=new MessageToUser(new Stage(), result);
						if(!result.startsWith("Error:"))
							addPartyMem.closeStage();
					}
				};
				addPartyMem.addEventToSubmit(EventToAddPartyMemberSubmitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToAddPartyMemberButton(EventToAddpartyMemberButton);//Event to add party member Button

		////add party window////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToAddPartyButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				AddParty addParty=new AddParty(new Stage());
				EventHandler<ActionEvent>EventToAddPartySubmitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						if(theModel.addParty(addParty.createParty())){
							msg=new MessageToUser(new Stage(), "added");
							addParty.closeStage();
						}
					}
				};
				addParty.addEventToSubmit(EventToAddPartySubmitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToAddPartyButton(EventToAddPartyButton);//Event to add citizen Button
		//////////////////////////////////////////////////////////////////////

		////show citizens window////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToShowCitizensButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Show showBallots=new Show(new Stage(),"All Citizens:",theModel.CitizenString());
				EventHandler<ActionEvent>EventToShowBallotsExitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						showBallots.closeStage();
					}
				};
				showBallots.addEventToExit(EventToShowBallotsExitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToShowCitizensButton(EventToShowCitizensButton);//Event to add citizen Button

		////show parties window////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToShowPartiessButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Show showBallots=new Show(new Stage(),"All Parties:",theModel.PartiesString());
				EventHandler<ActionEvent>EventToShowBallotsExitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						showBallots.closeStage();
					}
				};
				showBallots.addEventToExit(EventToShowBallotsExitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToShowPartiesButton(EventToShowPartiessButton);//Event to add citizen Button

		////show ballots window////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToShowBallotsButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Show showBallots=new Show(new Stage(),"All Ballots:",theModel.ballotsString());
				EventHandler<ActionEvent>EventToShowBallotsExitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						showBallots.closeStage();
					}
				};
				showBallots.addEventToExit(EventToShowBallotsExitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToShowBallotssButton(EventToShowBallotsButton);//Event to add citizen Button

		/////election/////////////////////////////////////////////////////////
		EventHandler<ActionEvent>EventToElectionsButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event){
				theView.votePress();
				for(int i=theModel.getBallot().size()-1;i>=0;i--) {
					electionsLoop(i);
				}	
			}
		};
		v.addEventToElectionsButton(EventToElectionsButton);//Event to add citizen Button
	
		////show results window/////////////////////////////////////////////
		EventHandler<ActionEvent>EventToShowResultsButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ShowResults showResults=new ShowResults(new Stage(),theModel.getParty());
				EventHandler<ActionEvent>EventToShowResultsExitButton=new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						showResults.closeStage();
					}
				};
				showResults.addEventToExit(EventToShowResultsExitButton);//Event to submit in add ballot window
			}
		};
		v.addEventToResultsButton(EventToShowResultsButton);//Event to add citizen Button
		
		
		
	}


	public void electionsLoop(int i) {
		Vote vote=new Vote(new Stage(),theModel.getBallot().get(i));
		EventHandler<ActionEvent>EventToSubmitButton=new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if(vote.check(i).equals("OK")) {
					for(int j=0;j<theModel.getParty().size();j++)
						theModel.addVotesToParty(theModel.getParty().get(j).getPoliticalPartyName(), vote.returnPartyVotes(theModel.getParty().get(j).getPoliticalPartyName()));
					theModel.addVotesToBallot(i, vote.addVotesToBaLLOT());
					vote.closeStage();
				}
				else
					msg=new MessageToUser(new Stage(),vote.check(i));
			}
		};
		vote.addEventToSubmit(EventToSubmitButton);//Event to submit in add votes window

	}
}



