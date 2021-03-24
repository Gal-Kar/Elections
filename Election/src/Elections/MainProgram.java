package Elections;


import Controller.Controller;
import Model.Model;
import View.MainWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainProgram  extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage)throws Exception{
		
		Model theModel=new Model();
		MainWindow theView=new MainWindow(stage);
		Controller theController=new Controller(theModel,theView);
		
		
	}
}

