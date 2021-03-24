package View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import Model.Ballot;
import Model.PoliticalParty;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowResults {
	private Stage stage;
	private Button exit;
	private PieChart pieChart;

	public ShowResults(Stage s, List<PoliticalParty> party) {	
		stage=s;
		Text title=new Text("Election Results");
		title.setFont(Font.font ("Verdana", 30));
		VBox page=new VBox();
		VBox vb1=new VBox();
		VBox vb2=new VBox();
		HBox hb=new HBox();
		pieChart = new PieChart();
		for(int i=0;i<party.size();i++) {
			pieChart.getData().add(new PieChart.Data(party.get(i).getPoliticalPartyName(), party.get(i).getVotes()));
			vb1.getChildren().addAll(new Text(party.get(i).getPoliticalPartyName()+":"+party.get(i).getVotes()));                                    
			}
		exit=new Button("exit");
		exit.setFont(Font.font ("Verdana", 20));
		vb2.getChildren().addAll(pieChart);
		vb1.setAlignment(Pos.CENTER_LEFT);
		vb2.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(vb1,vb2);
		page.getChildren().addAll(title,hb,exit);
		page.setAlignment(Pos.CENTER);
		VBox.setMargin(exit, new Insets(15, 0, 0, 0) );
		Scene scene=new Scene(page,700,700);
		HBox.setMargin(vb1, new Insets(0, 0, 0, 20) );
		stage.setScene(scene);
		stage.show();

	}

	public void addEventToExit(EventHandler<ActionEvent> event) {
		exit.setOnAction(event);
	}

	public void closeStage() {
		stage.close();
	}

}
