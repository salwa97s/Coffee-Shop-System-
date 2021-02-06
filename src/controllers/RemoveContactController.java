package controllers;

import interfaces.IController;
import model.PersonInTheSystem;
import view.RemoveContact;

public class RemoveContactController implements IController {

	private PersonInTheSystem model;
	private RemoveContact view;
	
	public RemoveContactController(PersonInTheSystem model, RemoveContact view)
	{
		this.model=model;
		this.view=view;
		view.getRemoveButton().addActionListener(e -> removeButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void removeButton() {
		
	}
}
