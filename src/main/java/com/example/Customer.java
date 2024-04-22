package com.example;

public class Customer {

    private Long id;

    private String firstName, lastName, gender;
    
    private String age;

    private String income;
    
    public Customer(Long id, String firstName, String lastName, String gender, String age, String income) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age= age;
        this.income = income;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the income
	 */
	public String getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(String income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", income=" + income + "]";
	}

}
