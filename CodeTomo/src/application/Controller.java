package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;

/**
 * Controller to connect UI elements and logical elements
 * <p>
 * Note: UI elements are prefixed by '@FXML'
 * @author Ethan Coco
 */
public class Controller implements Initializable {
	
    @FXML
    private Button addAlarmsBtn;
    @FXML
    private Button addTasksBtn;
    @FXML
    private Button alarmsBtnFXID;
    @FXML
    private ListView<String> alarmsListView;
    @FXML
    private Pane alarmsPaneFXID;
    @FXML
    private TextField alarmsTextField;
    @FXML
    private Button editAlarmsBtn;
    @FXML
    private Button editTasksBtn;
    @FXML
    private Button habitsBtnFXID;
    @FXML
    private Pane habitsPaneFXID;
    @FXML
    private Button homeBtnFXID;
    @FXML
    private Pane homePaneFXID;
    @FXML
    private Button removeAlarmsBtn;
    @FXML
    private Button removeTasksBtn;
    @FXML
    private Button tasksBtnFXID;
    @FXML
    private ListView<String> tasksListView;
    @FXML
    private Pane tasksPaneFXID;
    @FXML
    private TextField tasksTextField;
    
    private int selectedTask;
    
	/**
	 *Initializes UI
	 *@author Ethan Coco
	 *@param location
	 *@param resources 
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	
	/**
	 * Handles mouse clicks to elements within the UI element Frame
	 * @author Ethan Coco
	 * @param e
	 */
	@FXML
	private void handleClicksFrame(ActionEvent e) {
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
	@FXML
	private void handleClicksTasks(ActionEvent e) {
		
	}
	
		
		/**
		 * Adds task specified in tasksTextField to tasksListView when addTextsBtn is pressed
		 * @author Ethan Coco
		 * @param e
		 */
		@FXML
		private void addTasks(ActionEvent e) {
			tasksListView.getItems().add(tasksTextField.getText());
		}

		
		/**
		 * Edits task specified in tasksTextField to tasksListView when editTextsBtn is pressed
		 * @author Ethan Coco
		 * @param e
		 */
		@FXML
		private void editTasks(ActionEvent e) {
			
		}
		
		
		/**
		 * Removes task in tasksListView when item in tasksListView is selected and removeTextsBtn is pressed
		 * @author Ethan Coco
		 * @param e
		 */
		@FXML
		private void removeTasks(ActionEvent e) {
			selectedTask = tasksListView.getSelectionModel().getSelectedIndex();
			tasksListView.getItems().remove(selectedTask);
		}
		
		
	
}