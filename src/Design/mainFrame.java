package Design;

import java.io.File;

import assignmentCheckerAlgorithm.CalculationMaster;
import assignmentCheckerAlgorithm.studentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class mainFrame implements constant {

	private String path = "dataStore";
	 private double min_copy = 0.0;
	 private int totalProblems= 11;
	 private int marks = 20;

	public void init(Stage primaryStage) {

		primaryStage.setScene(scene);
		primaryStage.setResizable(false);

		ImageView imgView = new ImageView(img);
		root.getChildren().add(imgView);

		ButtonView();
	    TableView();

		primaryStage.show();

	}

	private void ButtonView() {
		buttonGallery = new Pane();
		buttonGallery.setStyle("-fx-background-color: GREEN;" + "-fx-background-insets: 10; "
				+ "-fx-background-radius: 10;" + "-fx-effect: dropshadow(three-pass-box, purple, 10, 0, 0, 0);");
		buttonGallery.setPrefSize(300, height);

		insertData = new Button("Select Folder");
		insertData.setLayoutX(layoutX);
		insertData.setLayoutY(layoutY);
		insertData.setPrefSize(prefWidth, prefHeight);
		insertData.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				System.out.println("Insert");
			}

		});

		buttonGallery.getChildren().add(insertData);

		totalproblems_Text = new TextField();
		totalproblems_Text.setLayoutX(layoutX);
		totalproblems_Text.setLayoutY(layoutY + 2 * 30);
		totalproblems_Text.setPrefSize(prefWidth, prefHeight);
		totalproblems_Text.setPromptText("Total Questions");
		buttonGallery.getChildren().add(totalproblems_Text);
		marks_Text = new TextField();
		marks_Text.setLayoutX(layoutX);
		marks_Text.setLayoutY(layoutY + 4 * 30);
		marks_Text.setPromptText("Marks");
		marks_Text.setPrefSize(prefWidth, prefHeight);
		buttonGallery.getChildren().add(marks_Text);

		min_copy_Text = new TextField();
		min_copy_Text.setLayoutX(layoutX);
		min_copy_Text.setLayoutY(layoutY + 6 * 30);
		min_copy_Text.setPrefSize(prefWidth, prefHeight);
		min_copy_Text.setPromptText("min copy is not considered");
		buttonGallery.getChildren().add(min_copy_Text);
		copyList = new Button("START");
		copyList.setLayoutX(layoutX);
		copyList.setLayoutY(layoutY + 8 * 30);
		copyList.setPrefSize(prefWidth, prefHeight);
		copyList.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String Problems = totalproblems_Text.getText();
				String mark = marks_Text.getText();
				String min = min_copy_Text.getText();
				if (!Problems.trim().isEmpty() && !mark.trim().isEmpty() && !min.trim().isEmpty()) {
					System.out.println("ok Done");
					 totalProblems = Integer.parseInt(Problems);
					 marks = Integer.parseInt(mark);
					 min_copy = Double.parseDouble(min);

				}

			}

		});

		buttonGallery.getChildren().add(copyList);

		root.getChildren().add(buttonGallery);
	}

	private void TableView() {

		tableGallery.setStyle("-fx-background-color: #7cb342;" + "-fx-background-insets: 10; "
				+ "-fx-background-radius: 10;" + "-fx-effect: dropshadow(three-pass-box, purple, 10, 0, 0, 0);");
		tableGallery.setLayoutX(320.0);
		tableGallery.setPrefSize(480, height);

		label = new Label("Information");
		label.setLayoutX(10.0);
		label.setLayoutY(10.0);
		label.setPrefSize(460.0, 100.0);
		label.setStyle("-fx-background-color:  #7cb342;" + "-fx-background-radius: 10;");
		label.setFont(new Font("Cambria", 24));
		label.setAlignment(Pos.CENTER);

		tableGallery.getChildren().add(label);

		scrollpane = new ScrollPane();
		scrollpane.setFitToHeight(true);
		scrollpane.setFitToWidth(true);
		list = CalculationMaster.getObservableList(path, min_copy, totalProblems, marks);
		 CalculationMaster.clear();
		 scrollpane.setContent(tableFactory.getMainTable(list));
		// scrollpane.setContent(tableFactory.getCopyTable(getFactory.getObservableListOfInformations("dataStore")));
		scrollpane.setLayoutX(10.0);
		scrollpane.setLayoutY(120.0);
		scrollpane.setPrefSize(460, 370);
		tableGallery.getChildren().add(scrollpane);

		root.getChildren().add(tableGallery);

	}

	private Image img = new Image(new File(imagePath + "background.jpg").toURI().toString());
	private static final double layoutX = 65.0;
	private static final double layoutY = 100.0;
	private static final double prefWidth = 170.0;
	private static final double prefHeight = 30.0;
	private Pane buttonGallery = new Pane();
	private Pane tableGallery = new Pane();
	private static ScrollPane scrollpane;
	private static Group root = new Group();
	private static Scene scene = new Scene(root, width, height);
	private static TableView<studentData> informations;
	private static Label label;
	private ObservableList<studentData> list= FXCollections.observableArrayList();
	private static Button insertData, pdf, word, Marks, copyList;
	private TextField min_copy_Text, totalproblems_Text, marks_Text;

}
