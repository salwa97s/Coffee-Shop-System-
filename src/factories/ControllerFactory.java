package factories;
import interfaces.IController;
import jdk.nashorn.tools.Shell;
import model.LoginModel;
import model.Order;
import model.Product;
import model.Report;
import view.AddOrder;
import view.AddProduct;
import view.AddContact;
import view.InventoryReport;
import view.Login;
import view.MainMenu;
import view.OutOfStock_Product;
import view.ProductReport;
import view.RemoveContact;
import view.RemoveOrder;
import view.RemoveProduct;
import view.SearchContact;
import view.Search_Product;
import view.ShowOrders;
import view.SupplierReport;
import view.UpdateContact;
import view.UpdateProduct;
import view.ValidityReport;
import controllers.AddContactController;
import controllers.AddOrderController;
import controllers.AddProductController;
import controllers.InventoryReportController;
import controllers.LoginController;
import controllers.MainMenuController;
import controllers.OutOfStockProductController;
import controllers.ProductReportController;
import controllers.RemoveContactController;
import controllers.RemoveOrderController;
import controllers.RemoveProductController;
import controllers.SearchContactController;
import controllers.SearchProductController;
import controllers.ShowOrdersController;
import controllers.SupplierReportController;
import controllers.UpdateContactController;
import controllers.UpdateProductController;
import controllers.ValidityReportController;
import enums.ControllerType;

public class ControllerFactory {
	
public static IController initController(ControllerType type) {
		
		IController controller=null;
		
		switch(type) {
		case Login:
			controller = new LoginController(new LoginModel(),new Login());
			break;
		case MainMenu:
			controller=new MainMenuController(null,new MainMenu());
			break;
		case AddProduct:
			controller = new AddProductController(null,new AddProduct());
			break;
		case RemoveProduct:
			controller = new RemoveProductController(null, new RemoveProduct());
			break;
		case UpdateProduct:
			controller = new UpdateProductController(null, new UpdateProduct());
			break;
		case OutOfStockProduct:
			controller = new OutOfStockProductController(new Report(), new OutOfStock_Product());
			break;
		case Search_Product:
			controller = new SearchProductController(null, new Search_Product());
			break;
		case AddOrder:
			controller = new AddOrderController(null, new AddOrder());
			break;
		case RemoveOrder:
			controller = new RemoveOrderController(null, new RemoveOrder());
			break;
		case ShowOrders:
			controller = new ShowOrdersController(new Report(), new ShowOrders());
			break;
		case ProductReport:
			controller = new ProductReportController(new Report() ,new ProductReport());
			break;
		case SupplierReport:
			controller = new SupplierReportController(new Report() ,new SupplierReport());
			break;
		case InventoryReport:
			controller = new InventoryReportController(new Report() ,new InventoryReport());
			break;
		case ValidityReport:
			controller = new ValidityReportController(new Report() ,new ValidityReport());
			break;
		case SearchContact:
			controller = new SearchContactController(null , new SearchContact());
			break;
		case AddContact:
			controller = new AddContactController(null , new AddContact());
			break;
		case RemoveContact:
			controller = new RemoveContactController(null , new RemoveContact());
			break;
		case UpdateContact:
			controller = new UpdateContactController(null , new UpdateContact());
			break;
		default:
			break;
		}
		
		return controller;
	}
}
