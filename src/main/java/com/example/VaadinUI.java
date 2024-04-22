package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@SpringUI
public class VaadinUI extends UI {

	@Autowired
	private CustomerService service;

	private Customer customer;

	private Binder<Customer> binder = new Binder<>(Customer.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Grid<Customer> grid = new Grid(Customer.class);
	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private TextField gender = new TextField("Gender");
	private TextField age = new TextField("Age");
	private TextField income = new TextField("income");
	private Button save = new Button("Update", e -> saveCustomer());
	private Button delete = new Button("Delete", e -> deleteCustomer());
	private Button add = new Button("Add", e -> addCustomer());
	private NativeSelect<String> select = new NativeSelect<>("Order By");

	@Override
	protected void init(VaadinRequest request) {
		updateGrid();
		grid.setColumns("firstName", "lastName", "gender", "age", "income");
		firstName.setVisible(true);
		lastName.setVisible(true);
		gender.setVisible(true);
		age.setVisible(true);
		income.setVisible(true);
		add.setVisible(true);
		grid.addSelectionListener(e -> updateForm());

		binder.forField(gender)
		.withValidator(
				gender -> gender.equals("M") || gender.equals("F"),
		        "Gender Should M or F")
	    .bind(Customer::getGender,
	    		Customer::setGender);

		
		binder.bindInstanceFields(this);
		select.setItems("first_name", "last_name", "gender", "age", "income");
		select.addValueChangeListener(e -> orderBy(e.getValue()));
		VerticalLayout layout = new VerticalLayout(grid);
		HorizontalLayout layou = new HorizontalLayout(firstName, lastName);
		layout.addComponent(layou);
		HorizontalLayout layo = new HorizontalLayout(gender, age, income);
		layout.addComponent(layo);
		HorizontalLayout lay = new HorizontalLayout(add, save, delete);
		layout.addComponent(lay);
		layout.addComponent(select);
		setContent(layout);
	}

	private void updateGrid() {
		List<Customer> customers = service.findAll();
		System.out.println(customers);
		grid.setItems(customers);
		setFormVisible(false);
	}

	private void updateForm() {
		if (grid.asSingleSelect().isEmpty()) {
			setFormVisible(false);
		} else {
			customer = grid.asSingleSelect().getValue();
			binder.setBean(customer);
			setFormVisible(true);
		}
	}

	private void setFormVisible(boolean visible) {
		firstName.setVisible(visible);
		lastName.setVisible(visible);
		gender.setVisible(visible);
		age.setVisible(visible);
		income.setVisible(visible);
		add.setVisible(visible);
		save.setVisible(visible);
		delete.setVisible(visible);
		select.setVisible(visible);
	}

	private void saveCustomer() {
		service.update(customer);
		updateGrid();
	}

	private void deleteCustomer() {
		service.delete(customer);
		updateGrid();
	}

	private void addCustomer() {
		service.add(new Customer(null, firstName.getValue(), lastName.getValue(), gender.getValue(), age.getValue(),
				income.getValue()));
		updateGrid();
	}

	private void orderBy(String columnName) {
		List<Customer> customers = service.orderBy(columnName, "ASC");
		System.out.println(customers);
		grid.setItems(customers);
		setFormVisible(false);
	}
}
