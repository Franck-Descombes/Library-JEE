package fr.afpa.javaee.library.service;

import fr.afpa.javaee.library.dao.IDaoHome;

public class ServiceHome implements IServiceHome {

	private IDaoHome iDaoHome;

	// CONSTRUCTOR
	public ServiceHome(IDaoHome myDaoHome) {
		this.iDaoHome = myDaoHome;
	}

	// METHODS

}
