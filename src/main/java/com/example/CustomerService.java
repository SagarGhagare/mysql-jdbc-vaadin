package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Customer> findAll() {
		return jdbcTemplate.query("SELECT id, first_name, last_name, gender, age, income FROM customers",
				(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("gender"), String.valueOf(rs.getLong("age")), String.valueOf(rs.getDouble("income"))));
	}

	public void update(Customer customer) {
		jdbcTemplate.update("UPDATE customers SET first_name=?, last_name=?, gender=?, age=?, income=? WHERE id=?", customer.getFirstName(),
				customer.getLastName(), customer.getGender(), customer.getAge(), customer.getIncome(), customer.getId());
	}

	public void delete(Customer customer) {
		jdbcTemplate.update("DELETE FROM customers WHERE id=?", customer.getId());
	}

	public void add(Customer customer) {
		jdbcTemplate.update("INSERT INTO customers(first_name, last_name, gender, age, income) VALUES(?, ?, ?, ?, ?)", customer.getFirstName(),
				customer.getLastName(), customer.getGender(), customer.getAge(), customer.getIncome());
	}

	public List<Customer> orderBy(String columnName, String order) {
		return jdbcTemplate.query(
				"SELECT id, first_name, last_name, gender, age, income FROM customers ORDER BY " + columnName + " "
						+ order,
				(rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("gender"), String.valueOf(rs.getLong("age")), String.valueOf(rs.getDouble("income"))));
	}

}
