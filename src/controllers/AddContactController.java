package controllers;

import interfaces.IController;
import model.PersonInTheSystem;
import view.AddContact;

public class AddContactController implements IController {

	private PersonInTheSystem model;
	private AddContact view;
	
	public AddContactController(PersonInTheSystem model, AddContact view)
	{
		this.model=model;
		this.view=view;
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.getAddButton().addActionListener(e -> addButton());
	}
	
	private void addButton() {
		
	}
}