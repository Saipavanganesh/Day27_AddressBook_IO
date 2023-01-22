package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactOperations {
    static Contacts contact;
    String name;
    int count;
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
        boolean isMatch = contacts.stream().anyMatch(name -> (name.getFirstName()+name.getLastName()).equalsIgnoreCase((contact.getFirstName()+contact.getLastName())));
        if(isMatch){
            System.out.println("This contact already exists");
        }
        else{
            contacts.add(contact);
        }
    }
    public void uc3_editContact(){
        System.out.println("Enter the name of contact you want to edit");
        name=sc.next();
        for(int i=0; i< contacts.size(); i++){
            if(contacts.get(i).getFirstName().equalsIgnoreCase(name)){
                System.out.println("Select which one you want to edit");
                System.out.println("1.First Name\n" +
                        "2.Last Name\n" +
                        "3.Address\n" +
                        "4.City\n" +
                        "5.State\n" +
                        "6.Zip\n" +
                        "7.Phone Number\n" +
                        "8.Email Id\n");
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
                    default:
                        System.out.println("Select correct option");
                }
            }
        }
    }
    public void uc4_deleteContact(){
        System.out.println("Enter the name of contact you want to delete");
        name=sc.next();
        for(int i=0; i< contacts.size(); i++){
            if(contacts.get(i).getFirstName().equalsIgnoreCase(name)){
                contacts.remove(i);
                System.out.println("Contact Deleted");
            }
        }
    }

    public void displayContact(){
        System.out.println("Enter the name of contact you want to delete");
        name=sc.next();
        for(int i=0; i< contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equalsIgnoreCase(name)) {
                System.out.println(contacts.get(i));
            } else {
                System.out.println("Can't find name");
            }
        }
    }
}
