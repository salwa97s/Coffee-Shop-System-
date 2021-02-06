package controllers;

import java.sql.ResultSet;

import interfaces.IController;
import model.Report;
import view.ShowOrders;

public class ShowOrdersController implements IController {

	private Report model;
	private ShowOrders view;
	
	public ShowOrdersController(Report model, ShowOrders view)
	{
		this.model=model;
		this.view=view;
	}

	@Override
	public void open() {
	
		String query = "select * from orders order by category asc";
		ResultSet result = model.getReport(query);
		view.setTable(result);
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
}
