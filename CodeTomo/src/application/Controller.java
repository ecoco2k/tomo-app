package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.event.ActionEvent;

/**
 * Controller to connect UI elements and logical elements
 * <p>
 * Note: UI elements are prefixed by '@FXML'
 * @author Ethan Coco
 */
public class Controller implements Initializable {
	
	//UI Variables
    @FXML private Button addAlarmsBtn;
    @FXML private Button addTasksBtn;
    @FXML private Button alarmsBtnFXID;
    @FXML private ListView<String> alarmsListView;
    @FXML private Pane alarmsPaneFXID;
    @FXML private TextField alarmsTextField;
    @FXML private Button editAlarmsBtn;
    @FXML Button editTasksBtn;
    @FXML private Button habitsBtnFXID;
    @FXML private Pane habitsPaneFXID;
    @FXML private Button homeBtnFXID;
    @FXML private Pane homePaneFXID;
    @FXML private Button removeAlarmsBtn;
    @FXML private Button removeTasksBtn;
    @FXML private Button tasksBtnFXID;
    @FXML private ListView<String> tasksListView;
    @FXML private Pane tasksPaneFXID;
    @FXML private TextField tasksTextField;
    
    //Add Tasks Dialog Box Variables
    @FXML private DialogPane tAddTaskPane;
    @FXML private DatePicker tDateDatePicker;
    @FXML private TextField tNotesTextField;
    @FXML private ChoiceBox<String> tPriorChoiceBox;
    @FXML private TextField tTimeTextField;
    @FXML private TextField tTitleTextField;
    
    //Local Variables
    private int selectedTask;
    private int tlvStartCheck = 0;
    
    static class Cell extends ListCell<String>{
    	HBox tlvHbox = new HBox();
    	Pane tlvPane = new Pane();
    	Label tlvTitleLabel = new Label("");
    	Button tlvEditBtn = new Button("Edit");
    	
    	public Cell() {
    		super();
    		
    		tlvHbox.getChildren().addAll(tlvTitleLabel, tlvPane, tlvEditBtn);
    		tlvHbox.setHgrow(tlvPane, Priority.ALWAYS);
    	}
    	
    	public void updateItem(String name, boolean empty) {
    		super.updateItem(name, empty);
    		setText(null);
    		setGraphic(null);
    		
    		if(name != null && !empty) {
    			tlvTitleLabel.setText(name);
    			setGraphic(tlvHbox);
    		}
    		
    	}
    }
    
    
	/**
	 *Initializes UI
	 *@author Ethan Coco
	 *@param location
	 *@param resources 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//tasksListView.setCellFactory(param -> new Cell());
	
	}
	
	/**
	 * Handles mouse clicks to elements within the UI element Frame
	 * @author Ethan Coco
	 * @param e
	 */
	@FXML private void handleClicksFrame(ActionEvent e) {
		if(e.getSource() == homeBtnFXID) {
			homePaneFXID.toFront();
		}else if(e.getSource() == tasksBtnFXID) {
			tasksPaneFXID.toFront();
		}else if(e.getSource() == alarmsBtnFXID) {
			alarmsPaneFXID.toFront();
		}else if(e.getSource() == habitsBtnFXID) {
			habitsPaneFXID.toFront();
		}else {
			homePaneFXID.toFront();
		}
	}
	
	
	/**
	 * Handles mouse clicks to elements within the UI element Tasks
	 * @author Ethan Coco
	 * @param e
	 */
	//@FXML
	//private void handleClicksTasks(ActionEvent e) {
	
	//}
	
		
		/**
		 * Adds task specified in tasksTextField to tasksListView when addTextsBtn is pressed
		 * @author Ethan Coco
		 * @param e
		 */
		@FXML private void addTasks(ActionEvent e) {
			//tasksListView.getItems().add(tasksTextField.getText());
			try {
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/resources/addTaskDialog.fxml"));
			DialogPane tAddTaskPane = fxmlLoader.load();
			Controller tController = fxmlLoader.getController();
			
			Dialog<ButtonType> dialog = new Dialog<>();
			dialog.setDialogPane(tAddTaskPane);
			dialog.setTitle("Add New Task");
			Optional<ButtonType> clickedButton = dialog.showAndWait();
			//tasksListView.setCellFactory(param -> new Cell());
			
			if(clickedButton.get() == ButtonType.OK) {
				if(tlvStartCheck == 0) {
					tasksListView.setCellFactory(param -> new Cell());
				}
				tlvStartCheck = 1;
				tasksListView.getItems().add(tController.tTitleTextField.getText());
			}
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}

		
		/**
		 * Edits task specified in tasksTextField to tasksListView when editTextsBtn is pressed
		 * @author Ethan Coco
		 * @param e
		 */
		@FXML private void editTasks(ActionEvent e) {
			
		}
		
		
		/**
		 * Removes task in tasksListView when item in tasksListView is selected and removeTextsBtn is pressed
		 * @author Ethan Coco
		 * @param e
		 */
		@FXML private void removeTasks(ActionEvent e) {
			selectedTask = tasksListView.getSelectionModel().getSelectedIndex();
			tasksListView.getItems().remove(selectedTask);
		}
		
		
	
}