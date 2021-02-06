package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	private int m_OrderNumber;
	private Product m_Product;
	private Supplier m_Supplier;
	private int m_Amount;
	private Date m_OrderDate;
	private eOrderState m_State;
	
	public Order(int i_OrderNumber, Product i_Product, int i_Amount, Date i_Date, eOrderState i_State)
	{
		this.m_OrderNumber = i_OrderNumber;
		this.m_Product = i_Product;
		m_Supplier = m_Product.getM_Supplier();
		this.m_Amount = i_Amount;
		this.m_OrderDate = i_Date;
		this.m_State = i_State;
	}

	public int getM_OrderNumber() {
		return m_OrderNumber;
	}

	public Product getM_Product() {
		return m_Product;
	}

	public Supplier getM_Supplier() {
		return m_Supplier;
	}
	
	public int getM_Amount() {
		return m_Amount;
	}
	
	public Date getM_OrderDate() {
		return m_OrderDate;
	}

	public eOrderState getM_State() {
		return m_State;
	}

	public void setM_State(eOrderState m_State) {
		this.m_State = m_State;
		
	}
	
	public void Add()
	{
		try {
			DataBase.UpdateData("INSERT INTO orders (order_id, product_id, supplier_id, amount, order_date, order_state) "
					+ "VALUES ( '"+ 
					this.m_OrderNumber +"' , '"+
					this.m_Product.getM_ProductID() + "' , '" + 
					this.m_Product.getM_Supplier().getM_ID()+ "' , '" + 
					this.m_Amount +"' , '" +
					this.m_OrderDate + "' , '" +
					this.m_State + "' );");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Delete()
	{
		try {
			DataBase.UpdateData("DELETE FROM orders WHERE order_id = '"+ this.m_OrderNumber +"' ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public enum eOrderState
	{
		inProgress, Delivered;
	}

}
