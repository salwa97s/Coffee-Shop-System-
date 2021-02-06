package model;

import java.sql.SQLException;
import java.util.Date;

public class Milk extends ProductsWithExpiryDate 
{
	eMilkType m_MilkType;
	eFatPercentage m_FatPercentage; 
	eLiterAmount m_Liters;

	public Milk(eProductID i_ID, String i_Date, int i_Amount, Supplier i_Supplier)
	{
		super(i_ID, "Milk", i_Date, i_Amount, i_Supplier, eCategory.Milk);
		
		switch(m_ProductID)
		{
			case Milk_One_liter_1_Fat:
				this.m_MilkType = eMilkType.Regular_Milk;
				this.m_FatPercentage = eFatPercentage.one;
				this.m_Liters = eLiterAmount.one;
				break;
			case Milk_Two_liter_1_Fat:
				this.m_MilkType = eMilkType.Regular_Milk;
				this.m_FatPercentage = eFatPercentage.one;
				this.m_Liters = eLiterAmount.Two;
				break;
			case Milk_One_liter_3_Fat:
				this.m_MilkType = eMilkType.Regular_Milk;
				this.m_FatPercentage = eFatPercentage.three;
				this.m_Liters = eLiterAmount.one;
				break;
			case Milk_Two_liter_3_Fat:
				this.m_MilkType = eMilkType.Regular_Milk;
				this.m_FatPercentage = eFatPercentage.three;
				this.m_Liters = eLiterAmount.Two;
				break;
			case Soya_Milk_One_liter_1_Fat:
				this.m_MilkType = eMilkType.Soya;
				this.m_FatPercentage = eFatPercentage.one;
				this.m_Liters = eLiterAmount.one;
				break;
			case Soya_Milk_One_liter_3_Fat:
				this.m_MilkType = eMilkType.Soya;
				this.m_FatPercentage = eFatPercentage.three;
				this.m_Liters = eLiterAmount.one;
				break;
			case Soya_Milk_Two_liter_1_Fat:
				this.m_MilkType = eMilkType.Soya;
				this.m_FatPercentage = eFatPercentage.one;
				this.m_Liters = eLiterAmount.Two;
				break;
			case Soya_Milk_Two_liter_3_Fat:
				this.m_MilkType = eMilkType.Soya;
				this.m_FatPercentage = eFatPercentage.three;
				this.m_Liters = eLiterAmount.Two;
				break;
		}
		
	}	
	
	public eMilkType getM_MilkType() {
		return m_MilkType;
	}

	public eFatPercentage getM_FatPercentage() {
		return m_FatPercentage;
	}

	public eLiterAmount getM_Liters() {
		return m_Liters;
	}

	@Override
	public void Add() {
		try {
			super.Add();
			DataBase.UpdateData(
					"INSERT INTO milk(product_name, product_id, milk_type, fat_precentage, liter_amount, Expiry_Date, Amount, supplier_id, category) VALUES ('"+
			this.m_Name + "' , '" +
			this.m_ProductID.getNumVal() + "' , '" +
			this.m_MilkType.toString() + "' , '" +
			this.m_FatPercentage.numVal + "' , '" +
			this.m_Liters.numVal + "' , '" +
			this.m_ExpireDate + "' , '" +
			this.m_Amount + "' , '" +
			this.m_Supplier.getM_ID() + "' , '" +	
			this.m_Category.toString() + "');");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	public enum eMilkType
	{
		Soya, 
		Regular_Milk;
	}
	
	public enum eFatPercentage
	{
		one(1), three(3);
		
		 private int numVal;

		 eFatPercentage(int numVal) {
			 this.numVal = numVal;
		 }

		 public int getNumVal() {
		        return numVal;
		 }
	}
	
	public enum eLiterAmount
	{
		one(1), Two(2);
		
		 public void setNumVal(int numVal) {
			this.numVal = numVal;
		}

		private int numVal;

		 eLiterAmount(int numVal) 
		 {
			 this.numVal = numVal;
		 }

		 public int getNumVal() 
		 {
		        return numVal;
		 }
	}

}
