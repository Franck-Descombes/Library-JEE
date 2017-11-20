package fr.afpa.javaee.library.model;

public class Author {
	private int id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;

	// CONSTRUCTOR USING ALL FIELDS
	public Author(int id, String firstName, String lastName, String dateOfBirth) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	// GETTERS & SETTERS
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + " " + firstName + " " + lastName + " (" + dateOfBirth + ")";
	}

}
