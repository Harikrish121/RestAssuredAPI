@regression
Feature: This function is used to check the cart functionality
         for adding a product and checkingout a product and
         deleting a product from the cart
 @Cartfunctionality     
Scenario: user cart functionality
Given user logwith "benzmarksaviouro@gmail.com" and "Stuartcent@123"
And user request "LoginUserApi" along with "post" httprequest
And user adds a product by providing authorization with "AddToCartApi" with "post" httprequest
Then user should get a message as "Product Added To Cart" with the status code 200
And user checkout the product from cart by providing country as "India" with "CreateOrderApi" with "post" httprequest
Then after creating user should get a message as "Order Placed Successfully"
When user calls this "DeleteOrderApi" resource with "delete" request 
Then user should get a message as "Orders Deleted Successfully"


