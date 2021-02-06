package Tests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import model.DataBase;
import model.Supplier;

public class SupplierTest {
	
	
	String id="999",firstname="rich",lastname="giraffa", tel="000",email="a@o.com";
	Supplier s=new Supplier(id,firstname,lastname,tel,email);
	

	@Test
	public void test() {
		
		s.Add();
		try {
			ResultSet result=DataBase.GetResult("SELECT firstname FROM supplier WHERE id = '"+ id +"' ;");
			String name=result.getString(1);
			assertEquals(name,"rich");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();}
		
	
		s.delete();
		try {
			ResultSet result=DataBase.GetResult("SELECT firstname FROM supplier WHERE id = '"+ id +"' ;");
			String name=result.getString(1);
			assertNull(name);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();}
		

}
}