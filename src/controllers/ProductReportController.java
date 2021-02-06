package controllers;

import java.sql.ResultSet;

import interfaces.IController;
import model.Report;
import view.ProductReport;

public class ProductReportController implements IController{
	
	private Report model;
	private ProductReport view;

	public ProductReportController(Report model, ProductReport view) {
		
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void open() {
		String query = "select * from product order by category,product_name,product_id asc";
		ResultSet result = model.getReport(query);
		view.setTable(result);
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
}
