package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.converter.LocalDateStringConverter;
import model.entities.Department;
import model.entities.Seller;

public class SellerFormController implements Initializable {

	private Seller entity;

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
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldDouble(txtBaseSalary);
	}

	public void setSeller(Seller entity) {
		this.entity = entity;
	}

	public void updateFormData() {
		if (entity == null)
			throw new IllegalStateException("Entity null");
		
		// localDate is only for test of setValue from pickBirthDate...
		LocalDate localDate = new LocalDateStringConverter().fromString("01/01/2019");
		
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
		txtEmail.setText(entity.getEmail());
		txtBaseSalary.setText(String.valueOf(entity.getBaseSalary()));
		pickBirthDate.setValue(localDate);
		comboDepartment.setValue(entity.getDepartment());
	}

}
