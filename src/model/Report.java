package model;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.proteanit.sql.DbUtils;
import view.MainMenu;


public class Report {
	
	public ResultSet getReport(String query) {
		
		ResultSet result = null;
		try {
			result = DataBase.GetResult(query);
			} 
		catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		    }
		
		return result;
	}
}
