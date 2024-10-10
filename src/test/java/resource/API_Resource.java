package resource;

public enum API_Resource {

	LoginUserApi("/api/ecom/auth/login"), CreateNewUserApi("/api/ecom/auth/register"),
	AddToCartApi("/api/ecom/user/add-to-cart"), CreateOrderApi("/api/ecom/order/create-order"),
	DeleteOrderApi("api/ecom/order/delete-order/{productId}");

	private String resource;

	API_Resource(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
