package controllers;

import java.sql.ResultSet;

import interfaces.IController;
import model.Report;
import view.ValidityReport;

public class ValidityReportController implements IController {

	private Report model;
	private ValidityReport view;
	
	public ValidityReportController(Report model, ValidityReport view)
	{
		this.model=model;
		this.view=view;
	}

	@Override
	public void open() {
		
		String query = "select * from eproductid";
		ResultSet result = model.getReport(query);
		view.setTable(result);
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
}
