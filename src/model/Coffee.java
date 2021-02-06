package model;

import java.sql.SQLException;
import java.util.Date;

public class Coffee extends ProductsWithExpiryDate
{
	eCoffeeTypes m_Type;
	
	public Coffee(eProductID i_ID, String i_Date, int i_Amount, Supplier i_Supplier)
	{
		super(i_ID, "Coffee", i_Date, i_Amount, i_Supplier, eCategory.Coffee);
		
		switch(this.m_ProductID)
		{
			case Red_Mug_Coffee :
				this.m_Type = eCoffeeTypes.RedMug;
				break;
			case Testers_Choice_Coffee :
				this.m_Type = eCoffeeTypes.TestersChoice;
				break;
			case Turkish_Coffee :
				this.m_Type = eCoffeeTypes.Turkish;
		}
	}
	
	public eCoffeeTypes getM_Type() {
		return m_Type;
	}

	@Override
	public void Add() {
		super.Add();
			try {
				DataBase.UpdateData(
						"INSERT INTO coffee(Product_name, product_id, type, Expiry_Date, Amount, supplier_id, category) VALUES ('"+
				this.m_Name + "' , '" +
				this.m_ProductID.getNumVal() + "' , '" +
				this.m_Type + "' , '" +
				this.m_ExpireDate + "' , '" +
				this.m_Amount + "' , '" +
				this.m_Supplier.getM_ID() + "' , '" +
				this.m_Category.toString() + "');");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	enum eCoffeeTypes
	{
		RedMug, TestersChoice, Turkish;
	}

	
}
