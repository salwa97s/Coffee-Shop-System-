package model;

import java.sql.SQLException;
import java.util.Date;

import model.Product.eProductID;

public class Sweeteners extends ProductsWithExpiryDate 
{
	private eSweetenersType m_Type;
	
	public Sweeteners(eProductID i_ID, String i_Date, int i_Amount, Supplier i_Supplier) 
	{
		super(i_ID, "sweeteners", i_Date, i_Amount, i_Supplier, eCategory.Sweetener);
		
		switch(m_ProductID)
		{
			case white_Sugar :
				this.m_Type = eSweetenersType.whiteSugar;
				break;
			case Brown_Sugar :
				this.m_Type = eSweetenersType.BrownSugar;
				break;
			case Stevia:
				this.m_Type = eSweetenersType.Stevia;
				break;
		
		}
	}

	public eSweetenersType getM_Type() {
		return m_Type;
	}



	@Override
	public void Add() {
		try {
			super.Add();
			DataBase.UpdateData(
					"INSERT INTO sweeteners (product_name, product_id, type_name, Expiry_Date, Amount, supplier_id, category) VALUES ('"+
			this.m_Name + "' , '" +
			this.m_ProductID.getNumVal() + "' , '" +
			this.m_Type.toString()+ "' , '" +
			this.m_ExpireDate.toString() + "' , '" +		
			this.m_Amount + "' , '" +
			this.m_Supplier.getM_ID() + "' , '" +
			this.m_Category.toString() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	enum eSweetenersType
	{
		whiteSugar,
		BrownSugar,
		Stevia;
	}

}
