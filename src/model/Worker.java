package model;

import java.sql.SQLException;

public class Worker extends PersonInTheSystem
{
	String m_Password;
	String m_first , m_last , m_email , m_phone , m_id ; 
	
	public Worker(String i_ID, String i_FirstName, String i_LastName, String i_Password, String i_Telephone, String i_Email)
	{
		super(i_ID, i_FirstName, i_LastName, i_Telephone, i_Email);
		this.m_id = i_ID;
	}

	@Override
	public void Add()
	{
		try {
			DataBase.UpdateData("INSERT INTO Worker (id, firstname, lastname, password , phone, email) "
					+ "VALUES ( '"+ this.m_ID +"' , '"+
					this.m_FirstName + "' , '" + 
					this.m_LastName + "' , '" + 
					this.m_Password +"' , '" +
					this.m_Telephone + "' , '" +
					this.m_Email + "' );");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete()
	{
		try {
			DataBase.UpdateData("DELETE FROM Worker WHERE id = '"+ this.m_ID +"' ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void setWorkerFirst(String first) {
		this.m_FirstName = first;
		try {
			DataBase.UpdateData("UPDATE worker SET firstname ='"+ this.m_FirstName +"' WHERE id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setWorkerLast(String first) {
		this.m_LastName = first;
		try {
			DataBase.UpdateData("UPDATE worker SET lastname ='"+ this.m_LastName +"' WHERE id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setWorkerEmail(String first) {
		this.m_Email = first;
		try {
			DataBase.UpdateData("UPDATE worker SET email ='"+ this.m_Email +"' WHERE id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setWorkerPhone(String first) {
		this.m_Telephone = first;
		try {
			DataBase.UpdateData("UPDATE worker SET phone ='"+ this.m_Telephone +"' WHERE id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
