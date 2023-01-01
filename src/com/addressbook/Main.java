package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Contacts contact;
    static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
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
    public void uc2_addContact() {
        contacts.add(contact);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Address Book");
        System.out.println("***********************");
        Main ab=new Main();
        ab.uc1_createContact();
        ab.uc2_addContact();
        System.out.println(contact);
        int loop=1;
        while(loop==1){
            System.out.println("1.Add Contact\n2.Stop");
            int op=sc.nextInt();
            switch (op){
                case 1:
                    ab.uc1_createContact();
                    ab.uc2_addContact();
                    break;
                case 2:
                    loop=0;
                    break;
                default:
                    System.out.println("Enter a number between 1 0r 2");
                    break;
            }
        }
        System.out.println(contacts);
    }
}
