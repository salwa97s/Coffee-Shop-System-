package controllers;

import javax.swing.JButton;

import enums.ControllerType;
import factories.ControllerFactory;
import interfaces.IController;
import model.CoffeeSystem;
import view.MainMenu;

public class MainMenuController implements IController {

	private CoffeeSystem model;
	private MainMenu view;
	
	public MainMenuController(CoffeeSystem model,MainMenu view)
	{
		this.model = model;
		this.view=view;
	}

	@Override
	public void open() {
		
		view.setVisible(true);
		view.setLocationRelativeTo(null);
		view.getbtnAddProducts().addActionListener(e->tbtnAddProducts());
		view.getbtnRemoveProduct().addActionListener(e->btnRemoveProduct());
		view.getbtnUpdateProduct().addActionListener(e->btnUpdateProduct());
		view.getbtnOutOfStock().addActionListener(e->btnOutOfStock());
		view.getbtnSearchProduct().addActionListener(e->btnSearchProduct());
		view.getbtnAddOrder().addActionListener(e->btnAddOrder());
		view.getbtnRemoveOrder().addActionListener(e->btnRemoveOrder());
		view.getbtnShowOrders().addActionListener(e->btnShowOrders());
		view.getbtnProductReport().addActionListener(e->btnProductReport());
		view.getbtnSupplierReport().addActionListener(e->btnSupplierReport());
		view.getbtnInventoryReport().addActionListener(e->btnInventoryReport());
		view.getbtnValidityReport().addActionListener(e->btnValidityReport());
		view.getbtnSearch().addActionListener(e->btnSearch());
		view.getbtnAddContact().addActionListener(e->btnAddContact());
		view.getbtnRemoveContact().addActionListener(e->btnRemoveContact());
		view.getbtnUpdate().addActionListener(e->btnUpdate());
		view.getLogOutbtn().addActionListener(e -> btnLogOut());
	}
	
	public void setWorkerName(String workerName) {
		view.setWorkerName(workerName);
	}
	
	public void tbtnAddProducts() {
		IController addProductsController = ControllerFactory.initController(ControllerType.AddProduct);
		addProductsController.open();
	}
	public void btnRemoveProduct() {
		IController removeProductController = ControllerFactory.initController(ControllerType.RemoveProduct);
		removeProductController.open();
	}
	public void btnUpdateProduct() {
		IController updateProductController = ControllerFactory.initController(ControllerType.UpdateProduct);
		updateProductController.open();
	}
	public void btnOutOfStock() {
		IController outOfStockController = ControllerFactory.initController(ControllerType.OutOfStockProduct);
		outOfStockController.open();
	}
	public void btnSearchProduct() {
		IController searchProductController = ControllerFactory.initController(ControllerType.Search_Product);
		searchProductController.open();
	}
	public void btnAddOrder() {
		IController addOrderController = ControllerFactory.initController(ControllerType.AddOrder);
		addOrderController.open();
	}
	public void btnRemoveOrder() {
		IController removeOrderController = ControllerFactory.initController(ControllerType.RemoveOrder);
		removeOrderController.open();
	}
	public void btnShowOrders() {
		IController showOrdersController = ControllerFactory.initController(ControllerType.ShowOrders);
		showOrdersController.open();
	}
	public void btnProductReport() {
		IController productController = ControllerFactory.initController(ControllerType.ProductReport);
		productController.open();
	}
	public void btnSupplierReport() {
		IController supplierController = ControllerFactory.initController(ControllerType.SupplierReport);
		supplierController.open();
	}
	public void btnInventoryReport() {
		IController inventoryController = ControllerFactory.initController(ControllerType.InventoryReport);
		inventoryController.open();
	}
	public void btnValidityReport() {
		IController validityController = ControllerFactory.initController(ControllerType.ValidityReport);
		validityController.open();
	}
	public void btnSearch() {
		IController searchController = ControllerFactory.initController(ControllerType.SearchContact);
		searchController.open();
	}
	public void btnAddContact() {
		IController addContactController = ControllerFactory.initController(ControllerType.AddContact);
		addContactController.open();
	}
	public void btnRemoveContact() {
		IController removeContactController = ControllerFactory.initController(ControllerType.RemoveContact);
		removeContactController.open();
	}
	public void btnUpdate() {
		IController updateController = ControllerFactory.initController(ControllerType.UpdateContact);
		updateController.open();
	}
	public void btnLogOut() {
		view.dispose();
		model = new CoffeeSystem();
		model.runLogin();
	}
}
