import java.text.NumberFormat;
import java.text.ParseException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Math_Quiz extends Application {

	// Radio Buttons to choose type of math
	private RadioButton rbAdd = new RadioButton("Add");
	private RadioButton rbSubtract = new RadioButton("Subtract");
	private RadioButton rbMultiply = new RadioButton("Multiply");
	private RadioButton rbDivide = new RadioButton("Divide");

	// Radio Buttons to choose level of quiz
	private RadioButton rbLevel1 = new RadioButton("Numbers from 0 to 5");
	private RadioButton rbLevel2 = new RadioButton("Numbers from 3 to 9");
	private RadioButton rbLevel3 = new RadioButton("Numbers from 0 to 20");
	private RadioButton rbLevel4 = new RadioButton("Any two digits");

	// Label for Question
	private Label lblQuestion = new Label("Question:");
	private Label lblAnswer = new Label("Answer:");
	private Label lblQuestion1 = new Label("Question will be shown");

	// TextField for Answer entry
	private TextField tfAnswer = new TextField();

	// Start and Stop buttons
	private Button btnStart = new Button("Start");
	private Button btnStop = new Button("Stop");

	// Label to display amount of correct answers
	private Label lblCorrectCountlbl = new Label("Correct Count");
	private Label lblCorrectCount = new Label("# Correct");

	// Label to display time spent taking quiz
	private Label lblTimeSpentlbl = new Label("Time Spent");
	private Label lblTimeSpent = new Label("Time will be shown");

	// variables for timer
	long startTime, endTime, elapsedTime;

	// variable for correct count
	int count = 0;

	@Override
	public void start(Stage primaryStage) {

		// add Type of Math radio buttons
		GridPane paneForType = new GridPane();
		paneForType.add(new Label("Select a type"), 0, 0);
		paneForType.add(rbAdd, 0, 1);
		paneForType.add(rbSubtract, 0, 2);
		paneForType.add(rbMultiply, 0, 3);
		paneForType.add(rbDivide, 0, 4);
		paneForType.setPadding(new Insets(10, 80, 40, 10));

		// group Type of Math radio buttons
		ToggleGroup tgType = new ToggleGroup();
		rbAdd.setToggleGroup(tgType);
		rbSubtract.setToggleGroup(tgType);
		rbMultiply.setToggleGroup(tgType);
		rbMultiply.setToggleGroup(tgType);

		// add radio buttons for levels
		GridPane paneForLevel = new GridPane();
		paneForLevel.add(new Label("Choose a level"), 1, 0);
		paneForLevel.add(rbLevel1, 1, 1);
		paneForLevel.add(rbLevel2, 1, 2);
		paneForLevel.add(rbLevel3, 1, 3);
		paneForLevel.add(rbLevel4, 1, 4);
		paneForLevel.setPadding(new Insets(10, 10, 20, 15));

		// group level radio buttons
		ToggleGroup tgLevel = new ToggleGroup();
		rbLevel1.setToggleGroup(tgLevel);
		rbLevel2.setToggleGroup(tgLevel);
		rbLevel3.setToggleGroup(tgLevel);
		rbLevel4.setToggleGroup(tgLevel);

		//
		GridPane typeLevel = new GridPane();
		typeLevel.add(paneForType, 0, 0);
		typeLevel.add(paneForLevel, 1, 0);

		FlowPane buttons = new FlowPane();
		buttons.getChildren().addAll(btnStart, btnStop);

		// create and add "Question" & "Answer" fields
		GridPane paneForQandA = new GridPane();
		paneForQandA.add(lblQuestion, 0, 0);
		paneForQandA.add(lblQuestion1, 0, 1);
		paneForQandA.add(lblAnswer, 2, 0);
		paneForQandA.add(tfAnswer, 2, 1);
		paneForQandA.add(btnStart, 1, 2);
		paneForQandA.add(btnStop, 2, 2);

		// tfAnswer.setMaxWidth(300);
		// paneForQandA.add(btnStop, 3, 2);
		// paneForQandA.setPadding(new Insets(10,10,10,15));

		// adding counter and timer
		GridPane results = new GridPane();
		results.add(lblCorrectCountlbl, 0, 0);
		results.add(lblCorrectCount, 0, 1);
		results.add(lblTimeSpentlbl, 3, 0);
		// GridPane.setHalignment(lblTimeSpentlbl, HPos.RIGHT);
		results.add(lblTimeSpent, 3, 1);

		// main pane
		BorderPane pane = new BorderPane();
		pane.setTop(typeLevel);
		pane.setCenter(paneForQandA);
		pane.setBottom(results);

		// create scene and place it in the stage
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Math Quiz");
		primaryStage.setScene(scene);
		primaryStage.show();

		tfAnswer.setOnAction(e -> {
			//
		});

		tfAnswer.setOnKeyPressed((event) -> {
			if (event.getCode() == KeyCode.ENTER) {
				try {
					double d = NumberFormat.getInstance().parse(tfAnswer.getText()).doubleValue();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnStart.setOnAction(e -> {
			startTime = System.currentTimeMillis();
		});

		btnStop.setOnAction(e -> {
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			lblTimeSpent.setText(String.valueOf(elapsedTime));
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
