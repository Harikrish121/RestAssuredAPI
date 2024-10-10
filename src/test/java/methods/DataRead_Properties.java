package methods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataRead_Properties {

	private Properties prop;
	private String _id;
	private String productName;
	private String productCategory;
	private String productSubCategory;
	private String productPrice;
	private String productImage;
	private String productAddedBy;
	private String productDescription;

	public DataRead_Properties() throws IOException {
		prop = new Properties();
		String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "java" + File.separator + "properties" + File.separator
				+ "product_Details.properties";
		FileInputStream file = new FileInputStream(filePath);
		prop.load(file);
		this._id = prop.getProperty("productId");
		this.productName = prop.getProperty("productName");
		this.productCategory = prop.getProperty("productCategory");
		this.productSubCategory = prop.getProperty("productSubCategory");
		this.productPrice = prop.getProperty("productPrice");
		this.productImage = prop.getProperty("productImage");
		this.productAddedBy = prop.getProperty("productAddedBy");
		this.productDescription = prop.getProperty("productDescription");

	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
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

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

}
