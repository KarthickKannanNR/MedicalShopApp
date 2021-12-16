package com.medHub.Dao;

import java.util.List;
import java.util.Scanner;

import com.medHub.module.AdminModule;
import com.medHub.module.ProductModule;
import com.medHub.module.UserModule;

public class TestMain {
	int i;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		AdminDao adminDao = new AdminDao();

		Scanner sc = new Scanner(System.in);
		int logreg=0;
		
		
		do {
			System.out.println("1.Register   2.Login   3.Update   4.Delete  5.Exit");
			logreg=Integer.parseInt(sc.nextLine());
		switch(logreg){
		
		case 1:
			String userName=null;
			boolean b=true;
			do {
			System.out.println("enter fullname");
			userName=sc.nextLine();
			if(userName.matches("[A-Za-z]{3,}"))
			{
				b=false;
			}
			
			}
			while(b);
			System.out.println("enter age");
			int age=Integer.parseInt(sc.nextLine());
			System.out.println("enter usermobile");
			long userMobile=Long.parseLong(sc.nextLine());
			System.out.println("enter email");
			String userMail=sc.nextLine();
			System.out.println("enter password");
			String password = sc.nextLine();
			
			UserModule user=new UserModule(userName,age,userMobile,userMail,password);
			
			UserDao userDao =new  UserDao();
			userDao.insert(user);
			
			
		case 2:
			System.out.println("enter mail");
			String loginEmail=sc.nextLine();
			System.out.println("enter password");
			String loginPassword = sc.nextLine();
			
			if(loginEmail.endsWith("medhub.com"))
			{
				AdminModule admin=adminDao.login(loginEmail, loginPassword);
				
			System.out.println(" welcome "+admin.getAdminName());
			
			
			}
			else
			{
				UserDao userDaoLogin=new UserDao();
				UserModule currentUser=userDaoLogin.login(loginEmail,loginPassword);
				if(currentUser==null)
				{
					System.out.println("not a registered user");
				}
			System.out.println(" welcome "+currentUser.getName());
			
			ProductDao pDao=new ProductDao();
			List<ProductModule> productList=pDao.viewProduts();
			System.out.println(productList);
			
			
			}
			break;
		case 3:
			System.out.println("case 3");
			break;
		case 4:
		System.out.println("case 4");
			break;
					}
		}
		
		while(logreg==5);
		
		
		
//		user insert
		
		
		

		

	}

}
