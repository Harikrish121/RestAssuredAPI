package pojo;

import java.util.List;

public class CreateOrder_Response {

	private List<String> orders;
	private List<String> productOrderId;
	private String message;

	public void setOrders(List<String> orders) {
		this.orders = orders;
	}

	public List<String> getOrders() {
		return orders;
	}

	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}

	public List<String> getProductOrderedId() {
		return productOrderId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
