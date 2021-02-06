package controllers;

import java.sql.ResultSet;

import interfaces.IController;
import model.Report;
import view.InventoryReport;

public class InventoryReportController implements IController {

	private Report model;
	private InventoryReport view;
	
	public InventoryReportController(Report model, InventoryReport view)
	{
		this.model=model;
		this.view=view;
	}

	@Override
	public void open() {
		
		String query = "select amount,product_id,product_name from product order by amount asc";
		ResultSet result = model.getReport(query);
		view.setTable(result);
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
}