package pojo;

public class ProductDetails {

	private String productOrderedId;
	private String productName;
	private String productCategory;
	private String productSubCategory;
	private int productPrice;
	private String productImage;
	private String productAddedBy;

	public String get_id() {
		return productOrderedId;
	}

	public void set_id(String _id) {
		this.productOrderedId = _id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductSubCategory() {
		return productSubCategory;
	}

	public void setProductSubCategory(String productSubCategory) {
		this.productSubCategory = productSubCategory;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductAddedBy() {
		return productAddedBy;
	}

	public void setProductAddedBy(String productAddedBy) {
		this.productAddedBy = productAddedBy;
	}

}
