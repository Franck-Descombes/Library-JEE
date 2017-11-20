package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.model.Subscriber;

public interface IServiceSubscriber {

	public void addSubscriber(String lastName, String firstName);

	public Subscriber getOneSubscriber(int id);

	public ArrayList<Subscriber> getAllSubscribers();

	public void updateSubscriber(int id, String lastName, String firstName);

	public void deleteSubscriber(int id);

}
