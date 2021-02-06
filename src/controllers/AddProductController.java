package controllers;

import interfaces.IController;
import model.Product;
import view.AddProduct;

public class AddProductController implements IController {

	private Product model;
	private AddProduct view;
	
	public AddProductController(Product model,AddProduct view)
	{
		this.model=model;
		this.view=view;
		view.getAddButton().addActionListener(e -> addButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void addButton() {
		
	}
}
