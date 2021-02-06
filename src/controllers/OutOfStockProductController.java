package controllers;

import java.sql.ResultSet;

import interfaces.IController;
import model.Report;
import view.MainMenu;
import view.OutOfStock_Product;

public class OutOfStockProductController implements IController {

	private Report model;
	private OutOfStock_Product view;
	
	public OutOfStockProductController(Report model, OutOfStock_Product view)
	{
		this.model=model;
		this.view=view;
	}

	@Override
	public void open() {
		
		String query = "select * from outofstock where amount < '" + MainMenu.productObserver.getM_minimumAmount()+"';";
		ResultSet result = model.getReport(query);
		view.setTable(result);
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
}
