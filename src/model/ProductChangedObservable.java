package model;

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;

public class ProductChangedObservable extends Observable {
	
	public void notifyProductChanged(String productId) {
		try {
		String query = "select * from product where product_id = "+ productId;
		ArrayList<Product> productList = DataBase.Products(query);
		setChanged();
		notifyObservers(productList.get(0));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
	    }
	}
}