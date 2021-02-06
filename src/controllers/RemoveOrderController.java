package controllers;
import interfaces.IController;
import model.Order;
import view.AddOrder;
import view.RemoveOrder;


public class RemoveOrderController implements IController {

	private Order model;
	private RemoveOrder view;
	
	
	public RemoveOrderController(Order model, RemoveOrder view)
	{
		this.model=model;
		this.view=view;
		view.getRemoveButton().addActionListener(e -> removeButton());
	}

	@Override
	public void open() {
		view.setVisible(true);
		view.setLocationRelativeTo(null);
	}
	
	private void removeButton() {
		
	}
}