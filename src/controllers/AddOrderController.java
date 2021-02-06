package controllers;
import model.Order;
import view.AddOrder;
import interfaces.IController;

public class AddOrderController implements IController {

	private Order model;
	private AddOrder view;
	
	public AddOrderController(Order model, AddOrder view)
	{
		this.model=model;
		this.view=view;
		view.getOKButton().addActionListener(e -> okButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void okButton() {
		
	}
}
