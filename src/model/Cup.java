package model;

import java.sql.SQLException;

public class Cup extends ProductsWithNoExpiryDate{

	private eCupSize m_Size;

	public Cup(eProductID i_ID, int i_Amount, Supplier i_Supplier) {
		super(i_ID, "Cup", i_Amount, i_Supplier, eCategory.Other);
		
		switch(m_ProductID)
		{
		case Small_Cup :
			this.m_Size = eCupSize.Small;
			break;
		case Medium_Cup :
			this.m_Size = eCupSize.Medium;
			break;
		case Large_Cup :
			this.m_Size = eCupSize.Large;
			break;
		}
	}
	
	public eCupSize getM_Size() {
		return m_Size;
	}

	@Override
	public void Add() {
		super.Add();
		try {
			DataBase.UpdateData(
					"INSERT INTO cup (product_name, product_id, cup_size, Amount, category, supplier_id) VALUES ('"+
			this.m_Name + "' , '" +
			this.m_ProductID.getNumVal() + "' , '" +
			this.m_Size.toString() + "' , '" +
			this.m_Amount + "' , '" +
			this.m_Category.toString() + "' , '" +
			this.m_Supplier.getM_ID() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
	
	enum eCupSize
	{
		Small, Medium, Large;
	}

}
