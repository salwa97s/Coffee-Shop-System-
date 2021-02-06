package controllers;

import interfaces.IController;
import model.Product;
import view.UpdateProduct;

public class UpdateProductController implements IController {

	private Product model;
	private UpdateProduct view;
	
	public UpdateProductController(Product model, UpdateProduct view)
	{
		this.model=model;
		this.view=view;
		view.getEnterButton().addActionListener(e -> enterButton());
		view.getDoneButton().addActionListener(e -> doneButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void enterButton() {
		
	}
	private void doneButton() {
		
	}
}