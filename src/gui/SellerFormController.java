package gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.util.converter.LocalDateStringConverter;
import model.entities.Department;
import model.entities.Seller;
import model.services.DepartmentService;
import model.services.SellerService;

public class SellerFormController implements Initializable {

	private Seller entity;

	private SellerService service;

	private DepartmentService departmentService = new DepartmentService();

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

	private ObservableList<Department> obsList;

	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if (entity == null)
			throw new IllegalStateException("Entity null");
		if (service == null)
			throw new IllegalStateException("Service null");

		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.currentStage(event).close();
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}

	}

	private Seller getFormData() {
		Seller obj = new Seller();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		obj.setEmail(txtEmail.getText());
		obj.setBaseSalary(Utils.tryParseToDoble(txtBaseSalary.getText()));
		// falta implementar a forma como pegar o valor do pickBirthDate
		obj.setBirthDate(new java.sql.Date(new Date().getTime()));
				
		try {
			obj.setDepartment(comboDepartment.getValue());
		} catch (Exception e) {
			Alerts.showAlert("Department not Selected", null, "Department can't be empty.\nPlease select a department", AlertType.WARNING);
		}
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initializeNodes();
		initializeComboDepartment();
	}

	private void initializeComboDepartment() {
		if (departmentService == null)
			throw new IllegalStateException("Department Service null");

		List<Department> list = departmentService.findAll();
		obsList = FXCollections.observableArrayList(list);
		comboDepartment.setItems(obsList);

		Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<Department>() {
			@Override
			protected void updateItem(Department item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboDepartment.setCellFactory(factory);
		comboDepartment.setButtonCell(factory.call(null));
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldDouble(txtBaseSalary);
	}

	public void setSeller(Seller entity) {
		this.entity = entity;
	}

	public void setSellerService(SellerService service) {
		this.service = service;
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
