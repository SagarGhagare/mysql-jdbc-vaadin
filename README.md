# MySQL and Vaadin integration example using Spring JDBC template

This example shows how to build a web UI for an existing MySQL database using plain Java.

See the complete guide at: [https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java-](https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java-).

![plot](./output.png)

# Database Queries

CREATE SCHEMA demo;

CREATE TABLE customers (
id SERIAL primary key,
first_name VARCHAR(255),
last_name VARCHAR(255),
gender char(1) default null,
age int default null,
income decimal(18,2) default null
);

INSERT INTO customers(first_name, last_name, gender, age, income) values("Marc","Lutuin","M", 56, 11000);

SELECT id, first_name, last_name, gender, age, income FROM customers ORDER BY age ASC