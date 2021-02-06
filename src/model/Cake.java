package model;

import java.sql.SQLException;
import java.util.Date;

public class Cake extends ProductsWithExpiryDate
{
	eDesertFlavor m_Flavor;
	
	public Cake(eProductID i_ID, String i_Date, int i_Amount, Supplier i_Supplier)
	{
		super(i_ID, "Cake", i_Date, i_Amount, i_Supplier, eCategory.Desert);
		
		switch(this.m_ProductID)
		{
			case Chocolate_Cake :
				this.m_Flavor = eDesertFlavor.Chocolate;
				break;
			case ChocolateChip_Cake :
				this.m_Flavor = eDesertFlavor.ChocolateChip;
				break;
			case Vanilla_Cake:
				this.m_Flavor = eDesertFlavor.Vanilla;
				break;
			case Cheese_Cake:
				this.m_Flavor = eDesertFlavor.Cheese;
				break;
		
		}
	}
	
	public eDesertFlavor getM_Falvor() {
		return m_Flavor;
	}

	@Override
	public void Add()
	{
		super.Add();
		try {
			DataBase.UpdateData(
					"INSERT INTO cake(product_name, product_id, flavor, Expiry_Date, Amount, supplier_id, category) VALUES ('"+
			this.m_Name + "' , '" +
			this.m_ProductID.getNumVal() + "' , '" +
			this.m_Flavor + "' , '" +
			this.m_ExpireDate + "' , '" +
			this.m_Amount + "' , '" +
			this.m_Supplier.getM_ID() + "' , '" +
			this.m_Category.toString() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
