package fr.afpa.javaee.library.dao;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Subscriber;

public interface IDaoSubscriber {
	public void addSubscriber(String firstName, String lastName);

	public Subscriber getOneSubscriber(int id);

	public ArrayList<Subscriber> getAllSubscribers();

	public void updateSubscriber(int id, String newFirstName, String newLastName);

	public void deleteSubscriber(int id);
}
