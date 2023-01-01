package com.addressbook;

import java.util.Scanner;

public class Main {
    static Contacts contact;
    public void uc1_createContact(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter contact details:");
        System.out.println("Enter First Name");
        String firstName=sc.nextLine();
        System.out.println("Enter Last Name");
        String lastName=sc.nextLine();
        System.out.println("Enter Address");
        String address=sc.nextLine();
        System.out.println("Enter City");
        String city=sc.nextLine();
        System.out.println("Enter State");
        String state=sc.nextLine();
        System.out.println("Enter Zip code");
        String zip=sc.nextLine();
        System.out.println("Enter Phone Number");
        String phoneNumber=sc.nextLine();
        System.out.println("Enter Email");
        String email=sc.nextLine();
        contact=new Contacts(firstName,lastName,address,city,state,zip,phoneNumber,email);
        System.out.println("Contact Created Successfully");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        System.out.println("***********************");
        Main ab=new Main();
        ab.uc1_createContact();
        System.out.println(contact);
    }
}
