package pojo;

public class Order {

	private String _id;
	private ProductDetails product;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public void setProduct(ProductDetails product) {
		this.product = product;
	}

	public ProductDetails getProduct() {
		return product;
	}
}
