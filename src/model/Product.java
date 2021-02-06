package model;
import java.sql.SQLException;
import java.util.*;

abstract public class Product 
{
	protected eProductID m_ProductID;
	protected String m_Name;
	protected int m_Amount; 
	protected Supplier m_Supplier;
	protected eCategory m_Category;
	
	public Product(eProductID i_ID, String i_Name, int i_Amount, Supplier i_Supplier, eCategory i_Category) 
	{
		if(i_ID == null)
		{
			m_ProductID = eProductID.other;
		}
		else
		{
			m_ProductID = i_ID;
		}
		this.m_Name = i_Name;
		this.m_Amount = i_Amount;
		this.m_Supplier = i_Supplier;
		if(i_Category == null)
		{
			m_Category = eCategory.Other;
		}
		else
		{
			m_Category = i_Category;
		}
	}
	
	public int getM_Amount() {
		return m_Amount;
	}

	public void setM_Amount(int m_Amount) {
		this.m_Amount = m_Amount;
		try {
			DataBase.UpdateData("UPDATE " + this.m_Name + " SET" +
					"amount =  " + this.m_Amount +
					" WHERE product_id = " + this.m_ProductID.getNumVal());
			DataBase.UpdateData("UPDATE product SET" +
					"amount =  " + this.m_Amount +
					" WHERE product_id = " + this.m_ProductID.getNumVal());
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public Supplier getM_Supplier() {
		return m_Supplier;
	}

	public void setM_Supplier(Supplier m_Supplier) {
		this.m_Supplier = m_Supplier;
		try {
			DataBase.UpdateData("UPDATE " + this.m_Name + " SET" +
					"supplier_id =  " + this.m_Supplier.getM_ID() +
					" WHERE product_id = " + this.m_ProductID.getNumVal());
			DataBase.UpdateData("UPDATE product SET" +
					"supplier_id =  " + this.m_Supplier.getM_ID() +
					" WHERE product_id = " + this.m_ProductID.getNumVal());
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public eProductID getM_ProductID() {
		return m_ProductID;
	}

	public String getM_Name() {
		return m_Name;
	}

	public eCategory getM_Category() {
		return m_Category;
	}

	public enum eProductID
	{
		Chocolate_Cake(1000),
		Vanilla_Cake(1001),
		ChocolateChip_Cake(1002),
		Cheese_Cake(1003),
		Red_Mug_Coffee(2000),
		Testers_Choice_Coffee(2001),
		Turkish_Coffee(2002),
		Small_Cup(3000),
		Medium_Cup(3001),
		Large_Cup(3002),
		Chocolate_CupCake(1100),
		Vanilla_CupCake(1101),
		ChocolateChip_CupCake(1102),
		Cheese_CupCake(1103),
		Milk_One_liter_1_Fat(4000),
		Milk_Two_liter_1_Fat(4001),
		Milk_One_liter_3_Fat(4010),
		Milk_Two_liter_3_Fat(4011),
		Soya_Milk_One_liter_1_Fat(4100),
		Soya_Milk_Two_liter_1_Fat(4101),
		Soya_Milk_One_liter_3_Fat(4110),
		Soya_Milk_Two_liter_3_Fat(4111),
		white_Sugar(5000),
		Brown_Sugar(5001),
		Stevia(5002),
		teaspoon(6000),
		other(0000);

		 private int numVal;

		 eProductID(int numVal) {
			 this.numVal = numVal;
		 }

		 public int getNumVal() {
			 return numVal;
		 }
	}
	

	public static eProductID get_eProductID(int id) {
		
		eProductID eProductFinaly = null;
		
		for (eProductID eProduct : eProductID.values()) {
			if (eProduct.getNumVal() == id) {
				eProductFinaly = eProduct;
				break;
			}
		}
		
		return eProductFinaly;
	}
	
	public enum eCategory
	{
		Coffee(0), Desert(1), Milk(2), Sweetener(3), Other(4); 
		
		private int numVal2;

		 eCategory(int numVal2) {
			 this.numVal2 = numVal2;
		 }

		 public int getNumVal2() {
			 return numVal2;
		 }
	}

	abstract public void Add();
	
	public void delete()
	{
		try {
			DataBase.UpdateData("DELETE FROM product WHERE product_id = '"+ this.m_ProductID.getNumVal() +"' ;");
			DataBase.UpdateData("DELETE FROM " + this.m_Name + " WHERE product_id = '"+ this.m_ProductID.getNumVal() +"' ;");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	

}

