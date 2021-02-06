package model;

import java.sql.SQLException;

import model.Product.eProductID;

public class ProductInfo {
	protected eProductID m_ProductID;
	
	String productName , productID , ExpireDate , Amount , suplierID , Category ;

	public ProductInfo(String productName, String productID, String expireDate, String amount, String suplierID,
			String category) {
		super();
		this.productName = productName;
		this.productID = productID;
		ExpireDate = expireDate;
		Amount = amount;
		this.suplierID = suplierID;
		Category = category;
	}

	public ProductInfo() {
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
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getExpireDate() {
		return ExpireDate;
	}

	public void setExpireDate(String expireDate) {
		ExpireDate = expireDate;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		//Amount = amount;
		this.Amount = amount;
		try {
			DataBase.UpdateData("UPDATE '" + this.productName.toLowerCase() + "' SET"+" amount =  '"+ this.Amount +"' WHERE product_id = '"+ this.productID+"';");
			DataBase.UpdateData("UPDATE product SET"+" amount =  '"+ this.Amount +"' WHERE product_id = '"+ this.productID+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public String getSuplierID() {
		return suplierID;
	}

	public void setSuplierID(String suplierID) {
		this.suplierID = suplierID;
		try {
			DataBase.UpdateData("UPDATE '" + this.productName.toLowerCase() + "' SET"+" supplier_id =  '"+ this.suplierID +"' WHERE product_id = '"+ this.productID+"';");
			DataBase.UpdateData("UPDATE product SET"+" supplier_id =  '"+ this.suplierID +"' WHERE product_id = '"+ this.productID+"';");
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	} 
	
	

}
