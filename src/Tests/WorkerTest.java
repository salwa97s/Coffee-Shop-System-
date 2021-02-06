package Tests;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Test;
import model.DataBase;
import model.Supplier;
import model.Worker;

public class WorkerTest {

	
	Worker w1=new Worker("999","rich","giraffa", "3143hgfh","000", "a@o.com");
	Worker w2 = new Worker("11", "ami", "mall", "675kk", "8887665", "ami@nana.co");
	Worker w3 = new Worker("2233", "noa", "nini", "1234", "8765", "noa@nini.il");

	@Test
	public void test() {
		
		w1.Add();
		w2.Add();
		w3.Add();
		try {
			ResultSet result=DataBase.GetResult("SELECT * FROM Worker WHERE id = '"+ w1.getM_ID() +"' ;");
			String id = result.getString(1);
			assertEquals(id,"999");
			String fname=result.getString(2);
			assertEquals(fname,"rich");
			String lname = result.getString(3);
			assertEquals(lname,"giraffa");
			String pass = result.getString(4);
			assertEquals(pass,"3143hgfh");
			String phone = result.getString(5);
			assertEquals(phone,"000");
			String mail = result.getString(6);
			assertEquals(mail,"a@o.com");
			
			result=DataBase.GetResult("SELECT * FROM Worker WHERE email = '"+ w3.getM_ID() +"' ;");
			assertEquals(result.next(), false);
			
			result=DataBase.GetResult("SELECT * FROM Worker WHERE id = '"+ w1.getM_ID() +"' and email = '" + w2.getM_Email() + "';)");
			assertEquals(result.next(), false);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();}
		
	
		w1.delete();
		try {
			ResultSet result=DataBase.GetResult("SELECT firstname FROM supplier WHERE id = '"+ w1.getM_ID() +"' ;");
			assertEquals(result.next(), false);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();}
		

	}

}
