# AppiumECommerceHybridApp


This is an Appium Android Project designed to work with connected phone. 

Chrome Driver and .APK file used is included under src folder.



There are 8 java file included in this project.

#base.java
- Include the initialization of appium and setup to use the application.

#ecommerce_tc_1
- Initialize the application and enter: Name, Gender, Country
- Confirm the information

#ecommerce_tc_2
- Initialize the application and enter: Country
- Validate the error on the application ("Please enter your name")

#ecommerce_tc_3
- Initialize the application and enter information on front page
- Scroll to specific item ("Jordan 6 Rings") and click ("Add to cart")
- Click into check out cart, validate the name is equal

#ecommerce_tc_4
- Initialize the application and enter information on front page
- Add the first two item into cart
- Click into check out cart, validate the "Subtotal" is correct

#ecommerce_tc_5
- Initialize the application and enter information on front page
- Add the first two item into cart
- Click into check out cart, validate the "Subtotal" is correct (Using udf)

#ecommerce_tc_5_2
- Initialize the application and enter information on front page
- Add three item into the cart
- Click into check out cart, validate the "Subtotal" is correct (Using udf)
- Check the agreement checkbox
- Long press to read the agreement and close
- Proceed on the purchase

#ecommerce_tc_6
- Initialize the application and enter information on front page
- Add the first two item into cart
- Click into check out cart, check the agreement checkbox
- Proceed on the purchase
- Switch to the webview and do a search on the prompted web
- Use the "Android Back" button to backout the webpage.
