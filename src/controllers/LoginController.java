package controllers;

import javax.swing.JOptionPane;

import enums.ControllerType;
import factories.ControllerFactory;
import interfaces.IController;
import model.LoginModel;
import view.Login;
import view.MainMenu;

public class LoginController implements IController{
	
	private LoginModel model;
	private Login view;
	
	public LoginController (LoginModel model, Login view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.getLoginButton().addActionListener(e -> checkDetails());
	}
	
	private void checkDetails() {
		String ID = view.getIDText().getText(), passward = view.getPasswardText().getText();
		boolean goodDetails = model.isDetailsGood(ID, passward);
		if(goodDetails) {
			view.dispose();
			String nameWorker = model.getWorkerName(ID);
			//open the menu 
			IController menuController = ControllerFactory.initController(ControllerType.MainMenu);
			((MainMenuController)menuController).setWorkerName(nameWorker);
			menuController.open();
		}
		else {
			JOptionPane.showMessageDialog(null, "ID or Password is incorrect");
		}
	}
}
