package controllers;

import interfaces.IController;
import model.PersonInTheSystem;
import view.UpdateContact;

public class UpdateContactController implements IController {

	private PersonInTheSystem model;
	private UpdateContact view;
	
	public UpdateContactController(PersonInTheSystem model, UpdateContact view)
	{
		this.model=model;
		this.view=view;
		view.getSaveButton().addActionListener(e -> saveButton());
		view.getEditButton().addActionListener(e -> editButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void saveButton() {
		
	}
	
	private void editButton() {
		
	}
}