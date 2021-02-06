package model;

import java.sql.SQLException;
import java.util.Date;

import model.Product.eCategory;
import model.Product.eProductID;

public class Cupcake extends ProductsWithExpiryDate{
	private eDesertFlavor m_Flavor;
	

	public Cupcake(eProductID i_ID, String i_Date, int i_Amount, Supplier i_Supplier) 
	{
		super(i_ID, "Cupcake", i_Date, i_Amount, i_Supplier, eCategory.Desert);
		
		switch(m_ProductID)
		{
			case Chocolate_CupCake :
				this.m_Flavor = eDesertFlavor.Chocolate;
				break;
			case Vanilla_CupCake :
				this.m_Flavor = eDesertFlavor.Vanilla;
				break;
			case ChocolateChip_CupCake:
				this.m_Flavor = eDesertFlavor.ChocolateChip;
				break;
			case Cheese_CupCake:
				this.m_Flavor = eDesertFlavor.Cheese;
				break;
		
		}
	}
	
	public eDesertFlavor getM_Flavor() {
		return m_Flavor;
	}

	@Override
	public void Add() {
		super.Add();
		try {
			DataBase.UpdateData(
					"INSERT INTO CupCake (product_name, product_id, flavor, Expiry_Date, Amount, supplier_id, category) VALUES ('"+
			this.m_Name + "' , '" +
			this.m_ProductID.getNumVal() + "' , '" +
			this.m_Flavor.toString() + "' , '" +
			this.m_ExpireDate + "' , '" +
			this.m_Amount + "' , '" +
			this.m_Supplier.getM_ID() + "' , '" +
			this.m_Category.toString() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}

}
