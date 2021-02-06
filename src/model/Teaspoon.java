package model;

import java.sql.SQLException;

import model.Product.eCategory;
import model.Product.eProductID;


public class Teaspoon extends ProductsWithNoExpiryDate{

	public Teaspoon(eProductID i_ID, int i_Amount, Supplier i_Supplier) {
		super(i_ID, "Teaspoon", i_Amount, i_Supplier, eCategory.Other);
	}
	
	@Override
	public void Add() {
		super.Add();
		try {
			DataBase.UpdateData(
					"INSERT INTO teaspoon(product_name, product_id, Amount, supplier_id, category) VALUES ('"+
			this.m_Name + "' , '" +
			this.m_ProductID.getNumVal() + "' , '" +
			this.m_Amount + "' , '" +
			this.m_Supplier.getM_ID() + "' , '" +
			this.m_Category.toString() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
