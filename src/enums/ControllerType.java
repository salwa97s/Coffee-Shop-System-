package enums;

public enum ControllerType {

	//MainMenu(0, "MainMenu"),Login(1,"Login"), AddOrder(2, "AddOrder"), RemoveOrder(3, "RemoveOrder");
	
	Login(0,"Login"), MainMenu(1, "MainMenu"), AddProduct(2,"AddProduct"),RemoveProduct(3,"RemoveProduct"),
	UpdateProduct(4,"UpdateProduct"),OutOfStockProduct(5,"OutOfStockProduct"),Search_Product(6,"Search_Product"),
	AddOrder(7,"AddOrder"),RemoveOrder(8,"RemoveOrder"),ShowOrders(9,"ShowOrders"),
	ProductReport(10,"ProductReport"),SupplierReport(11,"SupplierReport"),InventoryReport(12,"InventoryReport"),
	ValidityReport(13,"ValidityReport"),SearchContact(14,"SearchContact"),AddContact(15,"AddContact"),
	RemoveContact(16,"RemoveContact"),UpdateContact(17,"UpdateContact");

	private final int val;
	private final String txt;

	private ControllerType(int val, String txt) {
		this.val = val;
		this.txt = txt;
	}

	public int getVal() {
		return val;
	}

	public String getTxt() {
		return txt;
	}
}
