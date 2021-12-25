package com.medHub.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.medHub.model.AdminModel;
import com.medHub.model.CartModel;
import com.medHub.model.OrderItemsModel;
import com.medHub.model.OrderModel;
import com.medHub.model.ProductModel;
import com.medHub.model.UserModel;

public class TestMain {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AdminDao adminDao = new AdminDao();
		UserDao userDao1 = new UserDao();
		ProductDao productDao = new ProductDao();
		CartDao cartdao = new CartDao();

		String logregtem = null;
		boolean end = true;

		String continueChoice1;
		// Starting do while
//																Login And Register	
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Register   2.Login");
			logregtem = sc.nextLine();

			if (logregtem.matches("[1-3]")) {
				int logreg = Integer.parseInt(logregtem);
				end = false;

				switch (logreg) {
//																	User Register
				case 1:
					String userName = null;
					boolean b = true;

					do {
						System.out.println("enter fullname");
						userName = sc.nextLine();
						if (userName.matches("[A-Za-z]{3,}")) {
							b = false;
						} else {
							System.out.println(
									"Name does not consists empty space, not contains number and special character");
						}
					} while (b);

					String tempAge = null;
					boolean ageFlag = true;
					int age = 0;
					do {
						System.out.println("enter age");
						tempAge = sc.nextLine();
						if (tempAge.matches("[0-9]{2,3}")) {
							age = Integer.parseInt(tempAge);
						}
						if (age >= 18 && age <= 100) {
							ageFlag = false;
						} else {
							System.out.println(
									"age must be greater than or equal to 18 \n" + "Read terms and conditions");
						}
					} while (ageFlag);

					long mobile = 0;
					boolean mobileflag = true;

					do {
						System.out.println("enter usermobile");
						String tempMobile = sc.nextLine();
						if (tempMobile.matches("[6-9][0-9]{9}")) {
							mobile = Long.parseLong(tempMobile);
							mobileflag = false;
						} else
							System.out.println("Invalid Mobile Number");
					} while (mobileflag);

					String userMail;
					boolean mailFlag = true;
					do {
						System.out.println("enter email");
						userMail = sc.nextLine();
						if (userMail.matches("[a-z][a-z0-9]*[@][a-z]+[.][A-Za-z]{2,3}")
								&& !userMail.contains("medhub.com")) {
							mailFlag = false;
							userMail = userMail.toLowerCase();
						} else
							System.out.println("email should be like abc@xyz.com \n");
					} while (mailFlag);

					String pswd = null;
					boolean flagpswd = true;
					do {
						System.out.println("enter password");
						pswd = sc.nextLine();
						if (pswd.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
							flagpswd = false;
							// System.out.println(password);
						} else {
							System.out.println("password must have 8 to 15 characters only \n"
									+ " contains one upper case, one lower case, one number , one special character");
						}
					} while (flagpswd);
					UserModel user = new UserModel(userName, age, mobile, userMail, pswd);
					userDao1.insert(user);
//															 Login  
				case 2:
					System.out.println("login page");
					String loginEmail = null;
					boolean loginFlag = true;
					do {

						System.out.println("enter Email");
						loginEmail = sc.nextLine();
						if (loginEmail.matches("[a-z][a-z0-9]*[@][a-z]+[.][A-Za-z]{2,3}")) {
							loginFlag = false;
							loginEmail = loginEmail.toLowerCase();
						} else
							System.out.println("email should be like abc@xyz.com");
					} while (loginFlag);

					String loginPassword = null;
					boolean loginFlagPswd = true;
					do {
						System.out.println("Enter password");
						loginPassword = sc.nextLine();
						if (loginPassword
								.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%?&])[A-Za-z\\d@$!%*?&]{8,15}$")) {
							loginFlagPswd = false;
							
						} else {
							System.out.println("password must have 8 to 15 characters only \n"
									+ " contains one upper case, one lower case, one number , one special character");
						}

					} while (loginFlagPswd);
					boolean b1 = true;

					if (loginEmail.endsWith("medhub.com")) {
						do {
							AdminModel admin = adminDao.login(loginEmail, loginPassword);

							if (admin == null) {
								System.out.println("invalid username or password");
								b1 = true;
							} else {
								System.out.println(" welcome " + admin.getAdminName());
								b1 = false;
							}
						} while (b1);
						boolean adminChoice = true;

//				    														Admin choices
						do {
							System.out.println(
									"1. Show all products   2. Show all users   3. Add product   4.update Product Details   5.Delete Product   6.SHow user by Id");

							String adminchoice = sc.nextLine();
							ProductDao allProducts = new ProductDao();
							if (adminchoice.contains("1") || adminchoice.contains("2") || adminchoice.contains("3")
									|| adminchoice.contains("4") || adminchoice.contains("5")) {

								adminChoice = false;
								switch (adminchoice) {
//																		  List All products
								case "1":
									List<ProductModel> productList = allProducts.viewProduts();

									for (int i = 0; i < productList.size(); i++) {
										System.out.println(productList.get(i));
									}
									break;
//																			List All users
								case "2":
									UserDao allUsers = new UserDao();
									List<UserModel> userList = allUsers.ViewAllUser();

									for (int i = 0; i < userList.size(); i++) {
										System.out.println(userList.get(i));
									}
									break;

								case "3":
//																			Add New Products
									System.out.println("Add products");
									System.out.println("Enter product name");
									String productname = sc.nextLine();
									System.out.println("Enter product Category");
									String productcategory = sc.nextLine();
									System.out.println("Enter product Description");
									String description = sc.nextLine();
									System.out.println("Enter product Unit Price");
									int unitPrice = Integer.parseInt(sc.nextLine());
									System.out.println("Enter product Quantity");
									int quantity = Integer.parseInt(sc.nextLine());
									System.out.println("Enter product Id");
									int productId = Integer.parseInt(sc.nextLine());
									ProductModel productModule = new ProductModel(productname, productcategory,
											description, unitPrice, quantity, productId);
									productDao.insertProduct(productModule);
									break;
//																		Update products
								case "4":
									System.out.println("update Products");
									System.out.println("Enter Product Id");
									int updateProductId = Integer.parseInt(sc.nextLine());
									System.out.println("Enter product category to be update");
									String updateproductcategory = sc.nextLine();
									System.out.println("Enter product name to be update");
									String updateProductName = sc.nextLine();
									System.out.println("Enter Description to be update ");
									String updateProductDescription = sc.nextLine();
									System.out.println("enter unitprice to be udpate");
									int updateUnitPrice = Integer.parseInt(sc.nextLine());
									System.out.println("Enter quantity to be update");
									int updateQuantity = Integer.parseInt(sc.nextLine());
									productDao.updateProducts(updateProductId, updateproductcategory, updateProductName,
											updateProductDescription, updateUnitPrice, updateQuantity);
									break;

								case "5":
//																		Delete Products
									System.out.println("Enter product Id");
									int userId = Integer.parseInt(sc.nextLine());
									productDao.deleteProduct(userId);
									break;
								}
							}

							else {
								System.out.println("invalid input");

							}

						} while (adminChoice);

//																		User Page

					} else {

						boolean adminflag = true;
						UserModel currentUser = userDao1.login(loginEmail, loginPassword);
						if (currentUser == null) {
							System.out.println("not a registered user");
							adminflag = false;
						} else {
							System.out.println(" welcome " + currentUser.getName());
							
						}

						do {
							ProductDao allProducts = new ProductDao();
							System.out.println("1. Show All Products    2.Update Account    3.Delete Account");
							String choice = sc.nextLine();
							if (choice.matches("[0-9]{1}")) {
								adminflag = false;
								int val = Integer.parseInt(choice);
								switch (val) {

//																			Show all products
								case 1:

									List<ProductModel> productList = allProducts.viewProduts();

									for (int i = 0; i < productList.size(); i++) {
										System.out.println(productList.get(i));
									}

									boolean product = true;
									do {
										System.out.println(
												"   1.Add products to cart   2.Buy Products  3.View cart   4.My Orders");
										int productChoices = Integer.parseInt(sc.nextLine());

										if (productChoices == 1 || productChoices == 2 || productChoices == 3
												|| productChoices == 4) {
											switch (productChoices) {

//																			Add Product To Cart
											case 1:
												System.out.println("enter product name");
												String productName = sc.nextLine();
												productName.toLowerCase();
												ProductModel products = productDao.findProductByName(productName);
												System.out.println(products.getProductName());
												System.out.println(products.getQuantity());
												System.out.println("enter quantity");
												int quantity = Integer.parseInt(sc.nextLine());
												double totalPrice = products.getUnitPrice() * quantity;

												if (products.getQuantity() > quantity) {

													CartModel cart = new CartModel(products, currentUser, quantity,
															products.getUnitPrice(), totalPrice);
													CartDao cartDao = new CartDao();
													cartDao.insertProduct(cart);

												}

												break;

//																			Buy product
											case 2:									
												
												List<OrderItemsModel> orderLitemsList = new ArrayList<OrderItemsModel>();
												double sum = 0;
												OrderModel order = new OrderModel();
												ProductModel buyProducts = new ProductModel();
												int buyProductQuantity;
												do {
													System.out.println("Enter Product name");
													String buyProductName = sc.nextLine();
													buyProductName.toLowerCase();
													buyProducts=productDao.findProductByName(buyProductName);
													System.out.println("Enter Quantity");
													buyProductQuantity = Integer.parseInt(sc.nextLine());
													System.out.println(buyProducts.getQuantity() );
													if (buyProducts.getQuantity() >= buyProductQuantity) {
														System.out.println(buyProducts.getQuantity() >= buyProductQuantity);
														if (currentUser.getWallet() >= sum) {
															order = new OrderModel(currentUser, sum);
															OrderDao orderDao = new OrderDao();

//															System.out.println(currentUser.getUserId() + " " + sum);
															orderDao.orders(currentUser.getUserId(), sum);

															buyProducts.setQuantity((buyProducts.getQuantity()) - buyProductQuantity);
															productDao.updateProductQuantity(buyProducts);
															OrderItemsModel orderItem = new OrderItemsModel(currentUser,
																	order, buyProducts, buyProductQuantity,
																	buyProducts.getUnitPrice(),
																	(buyProducts.getUnitPrice() * buyProductQuantity));
															orderLitemsList.add(orderItem);
															sum += (buyProducts.getUnitPrice() * buyProductQuantity);

															int orderId = orderDao.getByOrderId();
															OrderItemsDao orderItemDao = new OrderItemsDao();
															for (OrderItemsModel oi : orderLitemsList) {
																oi.getOrderModel().setOrderId(orderId);
																orderItemDao.insertOrders(oi);
															}

														}
														 else {
																System.out.println("You Have Not Enough Money To Buy");
																System.out.println("Add money to Wallet Enter Amount");
																double walletAmount = Double.parseDouble(sc.nextLine());
																userDao1.addMoneyInWallet(walletAmount, currentUser);
															}

													} else {
														System.out.println("Sorry Currently The Product Is Out Of Stock");
													}
													System.out.println("do you want continue yes/no");
													choice = sc.nextLine();
												} while (choice.equals("yes"));

										
												break;
//																		View Cart
											case 3:
												List<CartModel> cartItems = cartdao.viewCart(currentUser);

												for (int i = 0; i < cartItems.size(); i++) {
													System.out.println(cartItems.get(i));
												}
												boolean confirmPurchaseFlag = true;
												do {
													System.out.println("Confirm Purchase enter 1");
													int confirmPurchase = Integer.parseInt(sc.nextLine());

													if (confirmPurchase == 1) {
														confirmPurchaseFlag = false;

													} else {
														System.out.println("Invalid Input");
													}

												} while (confirmPurchaseFlag);
												break;
//															My Orders
											case 4:
												System.out.println("view my orders");
												OrderItemsDao myOrder = new OrderItemsDao();
												myOrder.ViewMyOrders(currentUser);
												break;
											}
										} else {
											System.out.println("Invalid option");
										}

										System.out.println("do you want to continue " + "Y for yes" + " N for No");
										String continueChoice = sc.nextLine();
										if (continueChoice.equalsIgnoreCase("n")) {
											product = false;
										}

									} while (product);
									break;

//																		Update Account By User
								case 2:
									System.out.println("update all");
									UserModel userModule = new UserModel();
									System.out.println(userModule.getUserMail());
									System.out.println("update full name");
									String fullname = sc.nextLine();
									System.out.println("update password");
									String password = sc.nextLine();
									System.out.println("update mobile");
									long mobilenumber = Long.parseLong(sc.nextLine());
									int updateStatus = userDao1.update(currentUser);
									if (updateStatus > 0) {
										System.out.println("update sucessfully");
									} else {
										System.out.println("something went wrong account is not updated");
									}
									break;
//																	Delete Account by User								
								case 3:
									System.out.println("enter userId");
									int userId = Integer.parseInt(sc.nextLine());
									boolean deleteStatus = userDao1.deleteUser(userId);
									if (deleteStatus) {
										System.out.println("account deleted");
									} else
										System.out.println("something went wrong");
									break;

								case 4:
									break;
								}

							} else {

								System.out.println("Invalid input");
							}

						} while (adminflag);
					}
					break;
				case 3:
					System.out.println("");
					end = false;
					break;

				case 4:
					System.out.println("case 4");
					break;

				default:
					System.out.println("Invalid Input");

				}

			} else {
				System.out.println("Invalid Input");
			}

//		user insert
			System.out.println("Are you want to continue");
			System.out.println("Enter Yes or No");
			continueChoice1 = sc.nextLine();
			continueChoice1.toLowerCase();

		} while (continueChoice1.equalsIgnoreCase("yes"));
	}
}
