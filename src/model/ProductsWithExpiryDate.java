package model;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductsWithExpiryDate extends Product
{
	protected String m_ExpireDate;
	
	public ProductsWithExpiryDate(eProductID i_ID, String i_Name, String i_Date, int i_Amount, Supplier i_Supplier, eCategory i_Category)
	{
		super(i_ID, i_Name, i_Amount, i_Supplier, i_Category);
		
		m_ExpireDate = i_Date;
	}
	
	public static boolean IsExpired(String date) throws ParseException 
	{
		return new SimpleDateFormat("dd/MM/yyyy").parse(date).before(new Date());
	}
	
	public String getM_ExpireDate() 
	{
		return m_ExpireDate;
	}
	
	@Override
	public void Add() {
		try {
			DataBase.UpdateData(
					"INSERT INTO Product(product_name, product_id, Expiry_Date, amount, supplier_id, category) VALUES('" +
				this.m_Name + "' , '" +
				this.m_ProductID.getNumVal() + "' , '" +
				this.m_ExpireDate + "' , '" +
				this.m_Amount + "' , '" +
				this.m_Supplier.m_ID + "' , '" +
				this.m_Category.toString() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(this.m_Amount<50) {
			try {
				DataBase.UpdateData(
						"INSERT INTO outofstock(product_name, product_id, Expiry_Date, amount, supplier_id, category,order_state) VALUES('" +
					this.m_Name + "' , '" +
					this.m_ProductID.getNumVal() + "' , '" +
					this.m_ExpireDate + "' , '" +
					this.m_Amount + "' , '" +
					this.m_Supplier.m_ID + "' , '" +
					this.m_Category.toString()  + "' , '" +
					null + "');");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
