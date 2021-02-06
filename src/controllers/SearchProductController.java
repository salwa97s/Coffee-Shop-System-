package controllers;

import interfaces.IController;
import model.Order;
import model.Product;
import view.AddOrder;
import view.Search_Product;

public class SearchProductController implements IController {

	private Product model;
	private Search_Product view;
	
	public SearchProductController(Product model, Search_Product view)
	{
		this.model=model;
		this.view=view;
		view.getSearchButton().addActionListener(e -> searchButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void searchButton() {
		
	}
}