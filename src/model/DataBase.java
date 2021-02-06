package model;
import java.sql.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Coffee.eCoffeeTypes;
import model.Cup.eCupSize;
import model.Milk.eFatPercentage;
import model.Milk.eLiterAmount;
import model.Milk.eMilkType;
import model.Order.eOrderState;
import model.Product.eProductID;
import model.Sweeteners.eSweetenersType;

public class DataBase 
{
	
    public static Connection s_Connection = null;
    public static PreparedStatement s_PreparedStatement = null;
    public static ResultSet s_Result = null;
    public static Statement s_Statement = null;
    private static eProductID productid;
	
    public static Connection connect() throws SQLException, ClassNotFoundException 
	{
        String url = "jdbc:sqlite:coffeeShop.db";
        Class.forName("org.sqlite.JDBC");

        return DriverManager.getConnection(url);
    }
    
    public static void CreateTable(String i_Query) throws ClassNotFoundException, SQLException
    {
       	s_Connection = connect();
       	s_Statement = s_Connection.createStatement();
        s_Statement.execute(i_Query);
         
        s_Statement.close();
    }
    
	public static void UpdateData(String i_Query) throws ClassNotFoundException, SQLException 
	{
		s_Connection = DataBase.connect();
		s_PreparedStatement = s_Connection.prepareStatement(i_Query);
		s_PreparedStatement.executeUpdate();
		s_PreparedStatement.close();
	}
	 
	public static boolean IsDataExists(String i_Query) throws ClassNotFoundException, SQLException {
		 boolean exists = false;
		 
		 s_Connection = DataBase.connect();
		 s_PreparedStatement = s_Connection.prepareStatement(i_Query);
		 s_Result = s_PreparedStatement.executeQuery();
		 exists = s_Result.next();
		 s_PreparedStatement.close();
		 s_Result.close();
		 
		 return exists;
	}
	
	public static ArrayList<Worker> Workers(String i_Query) throws ClassNotFoundException, SQLException{
		ArrayList<Worker> o_WorkersList = new ArrayList<Worker>();
		s_Connection = connect();
		s_Statement = s_Connection.createStatement();
		s_Result = s_Statement.executeQuery(i_Query);
		while(s_Result.next())
		{
			o_WorkersList.add(new Worker(s_Result.getString("id"),  s_Result.getString("firstname"), s_Result.getString("lastname"), 
				s_Result.getString("password"), s_Result.getString("phone"),s_Result.getString("email")));
		}
		
		return o_WorkersList;
	}
	
	public static ArrayList<Supplier> Suppliers(String i_Query) throws ClassNotFoundException, SQLException{
		ArrayList<Supplier> o_SuppliersList = new ArrayList<Supplier>();
		s_Connection = connect();
		s_Statement = s_Connection.createStatement();
		s_Result = s_Statement.executeQuery(i_Query);
		while(s_Result.next())
		{
			o_SuppliersList.add(new Supplier(s_Result.getString("supplier_id"),  s_Result.getString("firstname"), 
					s_Result.getString("lastname"), s_Result.getString("phone"),s_Result.getString("email")));
		}
		
		return o_SuppliersList;
	}
	
	public static ArrayList<Product> Products(String i_Query) throws ClassNotFoundException, SQLException{

		ArrayList<Supplier> supplierList = Suppliers("Select * from supplier");
		Supplier supplier = new Supplier();
		ArrayList<Product> o_ProductsList = new ArrayList<Product>();
		eProductID eProduct;
		s_Connection = connect();
		s_Statement = s_Connection.createStatement();
		s_Result = s_Statement.executeQuery(i_Query);
		while(s_Result.next())
		{
			Product product = null;
			for (Supplier sup : supplierList) {
				if(s_Result.getString("supplier_id").contentEquals(sup.getM_ID())) {
					supplier = sup;
					break;
				}
			}
			
			eProduct = Product.get_eProductID(s_Result.getInt("product_id"));
			switch(s_Result.getString("product_name").toLowerCase())
			{
			case "cake" :
				product = new Cake(eProduct, s_Result.getString("Expiry_Date"), s_Result.getInt("Amount"), supplier);
				break;
			case "coffee":
				product = new Coffee(eProduct, s_Result.getString("Expiry_Date"), s_Result.getInt("Amount"), supplier);
				break;
			case "cup":
				product = new Cup(eProduct, s_Result.getInt("Amount"), supplier);
				break;
			case "cupcake": 
				product = new Cupcake(eProduct, s_Result.getString("Expiry_Date"), s_Result.getInt("Amount"), supplier);
				break;
			case "milk":
				product = new Milk(eProduct, s_Result.getString("Expiry_Date"), s_Result.getInt("Amount"), supplier);
				break;
			case "sweeteners":
				product = new Sweeteners(eProduct, s_Result.getString("Expiry_date"), s_Result.getInt("Amount"), supplier);
				break;
			case "teaspoon":
				product = new Teaspoon(eProduct, s_Result.getInt("Amount"), supplier);
				break;
			}
			
			if(product != null) {
			o_ProductsList.add(product);
			}
		}
			
		return  o_ProductsList;
	}
	
	
	
	
	public static ArrayList<Order> Orders(String i_Query) throws ClassNotFoundException, SQLException{
		ArrayList<Order> o_OrdersList = new ArrayList<Order>();
		ArrayList<Product> productsList= Products("select * from product");
		s_Connection = connect();
		s_Statement = s_Connection.createStatement();
		s_Result = s_Statement.executeQuery(i_Query);
		while(s_Result.next())
		{
			Product product = null;
			for (Product pro : productsList) {
				if(s_Result.getString("product_id").contentEquals(pro.getM_ProductID().toString())) {
					product = pro;
					break;
				}
			}
			o_OrdersList.add(new Order(s_Result.getInt("order_id"), product, s_Result.getInt("amount"), s_Result.getDate("order_date"), eOrderState.valueOf(s_Result.getString("order_state"))));
		}
		
		return o_OrdersList;
	}
	
	public static ArrayList<test> OrderArr(String i_Query) throws ClassNotFoundException, SQLException{
		ArrayList<test> o_TestList = new ArrayList<test>();
		s_Connection = connect();
		s_Statement = s_Connection.createStatement();
		s_Result = s_Statement.executeQuery(i_Query);
		while(s_Result.next())
		{
			o_TestList.add(new test(s_Result.getString("order_id"),  s_Result.getString("product_id"), 
					s_Result.getString("supplier_id"), s_Result.getString("amount"),s_Result.getString("order_date"),s_Result.getString("order_state"),s_Result.getString("category")));
		}
		
		return o_TestList;
	}
	
	public static ArrayList<ProductInfo> ProductInfo(String i_Query) throws ClassNotFoundException, SQLException{
		ArrayList<ProductInfo> o_ProductList = new ArrayList<ProductInfo>();
		s_Connection = connect();
		s_Statement = s_Connection.createStatement();
		s_Result = s_Statement.executeQuery(i_Query);
		while(s_Result.next())
		{
			o_ProductList.add(new ProductInfo(s_Result.getString("product_name"),  s_Result.getString("product_id"), 
					s_Result.getString("Expiry_Date"), s_Result.getString("amount"),s_Result.getString("supplier_id"),s_Result.getString("category")));
		}
		
		return o_ProductList;
	}
	
	
	public static ResultSet GetResult(String i_Query) throws ClassNotFoundException, SQLException 
	{
		 Connection connection = DataBase.connect();
		 PreparedStatement preparedStatement = connection.prepareStatement(i_Query);
		 ResultSet result = preparedStatement.executeQuery();
		 
		 return result;
	}
}
	
