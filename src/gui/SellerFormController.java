package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class SellerFormController implements Initializable {
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private TextField txtBaseSalary;
	
	@FXML
	private DatePicker pickBirthDate;
	
	@FXML
	private ComboBox<Department> comboDepartment;
	
	@FXML
	private Label labelNameError;
	
	@FXML
	private Label labelEmailError;
	
	@FXML
	private Label labelBaseSalaryError;
	
	@FXML
	private Label labelBirthDateError;
	
	@FXML
	private Label labelDepartmentError;
	
	@FXML
	private Button btSave;	
	
	@FXML
	private Button btCancel;	
	
	@FXML
	public void onBtSaveAction() {
		System.out.println("onBtSaveAction");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
