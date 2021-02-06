 package model;
import java.sql.SQLException;
import java.util.*;

abstract public class PersonInTheSystem 
{
	String m_ID; 
	String m_FirstName;
	String m_LastName;
	String m_Telephone;
	String m_Email;
	
	public PersonInTheSystem(String i_ID, String i_FirstName, String i_LastName, String i_Telephone, String i_Email)
	{
		this.m_ID = i_ID;
		this.m_FirstName = i_FirstName;
		this.m_LastName = i_LastName;
		this.m_Telephone = i_Telephone;
		this.m_Email = i_Email;
	}
	
	public PersonInTheSystem()
	{}
	
	 public String getM_ID() {
		return m_ID;
	}
	
	public String getM_FirstName() {
		return m_FirstName;
	}

	public void setM_FirstName(String m_FirstName) {
		this.m_FirstName = m_FirstName;
		String query = "";
		if(this instanceof Worker)
		{
			query = "UPDATE Worker SET" +
				"firstname =  " + this.m_FirstName +
				" WHERE id = " + this.m_ID;
		}
		else
		{
			query = "UPDATE Supplier SET" +
					"firstname =  " + this.m_FirstName +
					" WHERE id = " + this.m_ID;
		}
		
		try {
			DataBase.UpdateData(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String getM_LastName() {
		return m_LastName;
	}

	public void setM_LastName(String m_LastName) {
		this.m_LastName = m_LastName;
		String query = "";
		if(this instanceof Worker)
		{
			query = "UPDATE Worker SET" +
				"lastname =  " + this.m_LastName +
				" WHERE id = " + this.m_ID;
		}
		else
		{
			query = "UPDATE Supplier SET" +
					"lastname =  " + this.m_LastName +
					" WHERE id = " + this.m_ID;
		}
		
		try {
			DataBase.UpdateData(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String getM_Email() {
		return m_Email;
	}

	public void setM_Email(String m_Email) {
		this.m_Email = m_Email;
		String query = "";
		if(this instanceof Worker)
		{
			query = "UPDATE Worker SET" +
				"email =  " + this.m_Email +
				" WHERE id = " + this.m_ID;
		}
		else
		{
			query = "UPDATE Supplier SET" +
					"email =  " + this.m_Email +
					" WHERE id = " + this.m_ID;
		}
		
		try {
			DataBase.UpdateData(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public String getM_Telephone() 
	{
		return m_Telephone;
	}
	
	public void setM_Telephone(String i_Telephone) 
	{
		this.m_Telephone = i_Telephone;
		String query = "";
		if(this instanceof Worker)
		{
			query = "UPDATE Worker SET" +
				"phone =  " + this.m_Telephone +
				" WHERE id = " + this.m_ID;
		}
		else
		{
			query = "UPDATE Supplier SET" +
					"phone =  " + this.m_Telephone +
					" WHERE id = " + this.m_ID;
		}
		
		try {
			DataBase.UpdateData(query);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	abstract public void Add();
	
	abstract public void delete();

}
