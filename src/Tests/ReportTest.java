package Tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.junit.Test;

import model.DataBase;
import model.Report;

public class ReportTest {
	
	
	Report report=new Report();
	ResultSet result1 = null;
	
	@Test
	public void testGetReport() {
		
		result1=report.getReport("select order_id from order"); 
		
		try {
		ResultSet result2 = DataBase.GetResult("select order_id from order");
		assertEquals(result1,result2);
			} 
		catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
		    }

	}

}
