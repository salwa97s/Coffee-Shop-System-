package controllers;

import interfaces.IController;
import model.PersonInTheSystem;
import view.SearchContact;

public class SearchContactController implements IController {

	private PersonInTheSystem model;
	private SearchContact view;
	
	public SearchContactController(PersonInTheSystem model, SearchContact view)
	{
		this.model=model;
		this.view=view;
		//view.getSaveButton().addActionListener(e -> saveButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void saveButton() {
		
	}
}
