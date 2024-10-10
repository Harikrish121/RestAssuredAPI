package methods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.CreateOrderDetails;
import pojo.CreateOrders;
import pojo.Order;
import pojo.ProductDetails;

public class AddProduct_Details {

	public Order prod_Details(String id) throws IOException {

		Order order = new Order();
		order.set_id(id);

		DataRead_Properties data_Prop = new DataRead_Properties();
		ProductDetails order_Details = new ProductDetails();
		order_Details.set_id(data_Prop.get_id());
		order_Details.setProductAddedBy(data_Prop.getProductAddedBy());
		order_Details.setProductImage(data_Prop.getProductImage());
		order_Details.setProductName(data_Prop.getProductName());
		order_Details.setProductPrice(Integer.parseInt(data_Prop.getProductPrice()));
		order.setProduct(order_Details);

		return order;

	}

	public CreateOrders orders(String country, String productId) {
		CreateOrders order = new CreateOrders();
		CreateOrderDetails det = new CreateOrderDetails();
		det.setCountry(country);
		det.setProductOrderedId(productId);
		List<CreateOrderDetails> od = new ArrayList<CreateOrderDetails>();
		od.add(det);
		order.setOrders(od);
		return order;
	}

}
