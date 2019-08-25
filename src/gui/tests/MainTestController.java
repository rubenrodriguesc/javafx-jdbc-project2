package gui.tests;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

public class MainTestController implements Initializable {

	@FXML
	private DatePicker datePicker;
	
	private Date date;

	@FXML
	public void onDatePickerAction() {
		System.out.println(datePicker.getValue());
		date = new Date(datePicker.getValue().toEpochDay());
		System.out.println();
		System.out.println(date);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		/*
		 * datePicker.setOnAction((ActionEvent event) -> {
		 * System.out.println(datePicker.getValue()); System.out.println(); });
		 */
	}

}
