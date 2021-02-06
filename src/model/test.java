package model;

public class test {
	
	String order_id , product_id , supplier_id , amount , order_date , order_state , category ;

	public test(String order_id, String product_id, String supplier_id, String amount, String order_date,
			String order_state, String category) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.supplier_id = supplier_id;
		this.amount = amount;
		this.order_date = order_date;
		this.order_state = order_state;
		this.category = category;
	} 
	
	public test() {}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	};
	
	
	

}
