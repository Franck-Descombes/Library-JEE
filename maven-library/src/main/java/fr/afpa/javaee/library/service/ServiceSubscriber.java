package fr.afpa.javaee.library.service;

import java.util.ArrayList;

import fr.afpa.javaee.library.dao.IDaoSubscriber;
import fr.afpa.javaee.library.model.Subscriber;

public class ServiceSubscriber implements IServiceSubscriber {

	private IDaoSubscriber iDaoSubscriber;

	// Constructor
	public ServiceSubscriber(IDaoSubscriber myDaoSubscriber) {
		this.iDaoSubscriber = myDaoSubscriber;
	}

	// GETTERS & SETTERS
	@Override
	public void addSubscriber(String lastName, String firstName) {
		iDaoSubscriber.addSubscriber(lastName, firstName);
	}

	@Override
	public Subscriber getOneSubscriber(int id) {
		return iDaoSubscriber.getOneSubscriber(id);
	}

	@Override
	public ArrayList<Subscriber> getAllSubscribers() {
		return iDaoSubscriber.getAllSubscribers();
	}

	@Override
	public void updateSubscriber(int id, String lastName, String firstName) {
		iDaoSubscriber.updateSubscriber(id, lastName, firstName);
	}

	@Override
	public void deleteSubscriber(int id) {
		iDaoSubscriber.deleteSubscriber(id);
	}

	public void saveSubscriber(Subscriber subscriber) {
		iDaoSubscriber.saveSubscriber(subscriber);
	}
}
