package model;
import java.util.*;
import java.util.Observable;

import controllers.LoginController;
import enums.ControllerType;
import factories.ControllerFactory;
import interfaces.IController;


public class CoffeeSystem{
	
	public CoffeeSystem() {
		
	}
	
	public void runLogin() {
		IController controller = ControllerFactory.initController(ControllerType.Login);
		controller.open();
	}
}
