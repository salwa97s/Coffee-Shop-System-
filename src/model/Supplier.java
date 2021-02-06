package model;
import java.sql.SQLException;
import java.util.ArrayList;

public class Supplier extends PersonInTheSystem
{
	String m_id;
	public Supplier(String i_ID, String i_FirstName, String i_LastName, String i_Telephone, String i_Email) 
	{
		super(i_ID, i_FirstName, i_LastName, i_Telephone, i_Email);
		this.m_id=i_ID;
	}
	
	public Supplier()
	{
	}
	
	@Override
	public void Add() {
		try {
			DataBase.UpdateData(
					"INSERT INTO Supplier (supplier_id, firstname, lastname, phone, email) VALUES ( '"+ 
					this.m_ID + "' , '" +
					this.m_FirstName + "' , '" +
					this.m_LastName +"' , '" + 
					this.m_Telephone + "' , '" +
					this.m_Email+"' );");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}	

	@Override
	public void delete() {
		try {
			DataBase.UpdateData("DELETE FROM Supplier WHERE supplier_id = '"+ this.m_ID +"' ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setsupplierFirst(String first) {
		this.m_FirstName = first;
		try {
			DataBase.UpdateData("UPDATE supplier SET firstname ='"+ this.m_FirstName +"' WHERE supplier_id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setsupplierLast(String first) {
		this.m_LastName = first;
		try {
			DataBase.UpdateData("UPDATE supplier SET lastname ='"+ this.m_LastName +"' WHERE supplier_id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setsupplierEmail(String first) {
		this.m_Email = first;
		try {
			DataBase.UpdateData("UPDATE supplier SET email ='"+ this.m_Email +"' WHERE supplier_id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void setsupplierPhone(String first) {
		this.m_Telephone = first;
		try {
			DataBase.UpdateData("UPDATE supplier SET phone ='"+ this.m_Telephone +"' WHERE supplier_id = '"+ this.m_id+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

}
