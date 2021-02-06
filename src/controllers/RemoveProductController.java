package controllers;

import enums.ControllerType;
import factories.ControllerFactory;
import interfaces.IController;
import model.Product;
import view.ProductReport;
import view.RemoveProduct;

public class RemoveProductController implements IController {

	private Product model;
	private RemoveProduct view;
	
	public RemoveProductController(Product model, RemoveProduct view)
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