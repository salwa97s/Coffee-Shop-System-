package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.LoginModel;

public class LoginModelTest {

	
	 LoginModel form=new LoginModel();
	 String login="koko";
	 String password="123";	
	 String worker_expected="sveta  shtrakh";
					 
/*	@Test
	public void testIsDetailsGood() {
		
		 boolean res= form.isDetailsGood(login,password);
		 assertEquals(res,false);	
		
	}*/
	@Test
	public void testGetWorkerName()
	{
		String worker_name=form.getWorkerName("123");
		assertEquals(worker_expected,worker_name);
	}

	

}
