package com.udemy;

public class Main {

    public static void main(String[] args) {
//	    Car porsche = new Car();
//	    Car holden = new Car();
//	    porsche.setModel("Carrera");
//		System.out.println("Model is " + porsche.getModel());

//    	BankAccount myAccount = new BankAccount();//(12345, 0.00, "Bob Brown", "myemail@bob.com",
//				//12345678)
//		System.out.println(myAccount.getBalance());
//		myAccount.setBalance(100.0);
//    	myAccount.withdrawFunds(200.0);
//    	myAccount.depositFunds(150.0);
//    	myAccount.withdrawFunds(200.0);

		VipCustomer chris = new VipCustomer("Chris", 100000);
		System.out.println(chris.getName());
		System.out.println(chris.getCreditLimit());
		System.out.println(chris.getEmail());
	}
}
