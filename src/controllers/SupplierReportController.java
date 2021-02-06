package controllers;

import java.sql.ResultSet;

import interfaces.IController;
import model.Report;
import view.SupplierReport;

public class SupplierReportController implements IController {

	private Report model;
	private SupplierReport view;

	public SupplierReportController(Report model, SupplierReport view) {
		
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void open() {
		
		String query = "select * from supplier order by firstname,lastname";
		ResultSet result = model.getReport(query);
		view.setTable(result);
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
}