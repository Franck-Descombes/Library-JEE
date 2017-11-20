package fr.afpa.javaee.library.model;

public class Copy {

	private int idCopy;
	private boolean available;
	private String borrowingDate;
	private String returnDate;
	private boolean fix;
	private Subscriber subscriber;
	private Book book;

	// CONSTRUCTOR USING ALL FIELDS
	public Copy(int idCopy, boolean available, String borrowingDate, String returnDate, boolean fix, Subscriber subscriber,
			Book book) {
		this.idCopy = idCopy;
		this.available = available;
		this.borrowingDate = borrowingDate;
		this.returnDate = returnDate;
		this.fix = fix;
		this.subscriber = subscriber;
		this.book = book;
	}

	// GETTERS & SETTERS
	public int getIdCopy() {
		return idCopy;
	}

	public void setIdCopy(int idCopy) {
		this.idCopy = idCopy;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getBorrowingDate() {
		return borrowingDate;
	}

	public void setBorrowingDate(String borrowingDate) {
		this.borrowingDate = borrowingDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public Subscriber getSubscriber() {
		return subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isFix() {
		return fix;
	}

	public void setFix(boolean fix) {
		this.fix = fix;
	}

	@Override
	public String toString() {
		return "ISBN : " + getBook().getIsbn() + "Title : " + getBook().getTitle() + "Author : "
				+ getBook().getAuthor().getLastName() + getBook().getAuthor().getFirstName() + "Id :" + idCopy
				+ " | Availability : " + available;
	}
}