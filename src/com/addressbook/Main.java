package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Contacts contact;
    static String name;
    Scanner sc= new Scanner(System.in);
    static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    public void uc1_createContact(){

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
    public void uc3_editContact(){
        int loop=1;
        System.out.println("Enter the name of contact you want to edit");
        name=sc.next();
        while(loop==1){
            if(contacts.get(0).getFirstName().equalsIgnoreCase(name)){
                System.out.println("Select which one you want to edit");
                System.out.println("1.First Name\n" +
                        "2.Last Name\n" +
                        "3.Address\n" +
                        "4.City\n" +
                        "5.State\n" +
                        "6.Zip\n" +
                        "7.Phone Number\n" +
                        "8.Email Id\n" +
                        "9.Exit\n");
                int option = sc.nextInt();
                switch(option){
                    case 1:
                        System.out.println("Change first name");
                        contacts.get(0).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Change Last name");
                        contacts.get(0).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Change Address name");
                        contacts.get(0).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Change City name");
                        contacts.get(0).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Change State name");
                        contacts.get(0).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Change Zip");
                        contacts.get(0).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Change Phone number");
                        contacts.get(0).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Change Email ID");
                        contacts.get(0).setEmail(sc.next());
                        break;
                    case 9:
                        loop=0;
                        break;
                    default:
                        System.out.println("Select correct option");
                }
            }
            else {
                System.out.println("Cannot find name...");
                break;
            }
        }

    }

    public void uc4_deleteContact(){
        System.out.println("Enter the name of contact you want to delete");
        name=sc.next();
        if(contacts.get(0).getFirstName().equalsIgnoreCase(name)){
            contacts.remove(0);
            System.out.println("Contact Deleted");
        }
        else{
            System.out.println("Cannot find name...");
        }
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
            System.out.println("1.Add Contact\n2.Edit Contact\n3.Delete\n4.Display\n5.Exit");
            int op=sc.nextInt();
            switch (op){
                case 1:
                    ab.uc1_createContact();
                    ab.uc2_addContact();
                    break;
                case 2:
                    ab.uc3_editContact();
                    break;
                case 3:
                    if(contacts.size()>0){
                        ab.uc4_deleteContact();
                    }
                    else{
                        System.out.println("Contacts list is empty");
                    }
                    break;
                case 4:
                case 5:
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