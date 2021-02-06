package model;

import java.sql.SQLException;

public class ProductsWithNoExpiryDate extends Product {

	public ProductsWithNoExpiryDate(eProductID i_ID, String i_Name, int i_Amount, Supplier i_Provider, eCategory i_Category) {
		super(i_ID, i_Name, i_Amount, i_Provider, i_Category);
	}

	@Override
	public void Add() {
		try {
			DataBase.UpdateData(
					"INSERT INTO Product(product_name, product_id, Expiry_Date, amount, supplier_id, category) VALUES('" +
				this.m_Name + "' , '" +
				this.m_ProductID.getNumVal() + "' , '" +
			     "' , '" +
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
					"' , '" +
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
