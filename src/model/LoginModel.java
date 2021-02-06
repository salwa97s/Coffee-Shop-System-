package model;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import view.MainMenu;

public class LoginModel {
	
	public LoginModel() {
		
	}
	
	public boolean isDetailsGood(String ID, String Passward) {
		
		boolean flag = false;
		
		String query = "select * from worker where id = " + ID + " and password = " + Passward;
		try{
			if(DataBase.IsDataExists(query))
			{
				flag = true;
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return flag;
	}
	
	public String getWorkerName(String ID) {
		
		String query , workerName = "Worker Name Dugma";
		try{
			query = "select firstname,lastname from worker where id = " + ID;
			ResultSet resultWorkerName = DataBase.GetResult(query);
			workerName = resultWorkerName.getString("firstname") + " "+resultWorkerName.getString("lastname");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return workerName;
	}
}
