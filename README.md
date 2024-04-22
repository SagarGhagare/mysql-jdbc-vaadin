# MySQL and Vaadin integration example using Spring JDBC template

This example shows how to build a web UI for an existing MySQL database using plain Java.

See the complete guide at: [https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java-](https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java-).


![plot](https://github.com/SagarGhagare/mysql-jdbc-vaadin/blob/6c96b788d85a9407452f3e7634a4e377523b5b46/output.PNG)

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
