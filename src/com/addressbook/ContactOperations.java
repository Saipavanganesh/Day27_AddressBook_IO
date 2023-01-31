package com.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContactOperations {
    static Contacts contact;
    String name;
    int count;
    static HashMap<String, List<Contacts>> stateDictionary = new HashMap<>();
    static HashMap<String, List<Contacts>> cityDictionary = new HashMap<>();
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
                        contacts.get(i).setFirstName(sc.next());
                        break;
                    case 2:
                        System.out.println("Change Last name");
                        contacts.get(i).setLastName(sc.next());
                        break;
                    case 3:
                        System.out.println("Change Address name");
                        contacts.get(i).setAddress(sc.next());
                        break;
                    case 4:
                        System.out.println("Change City name");
                        contacts.get(i).setCity(sc.next());
                        break;
                    case 5:
                        System.out.println("Change State name");
                        contacts.get(i).setState(sc.next());
                        break;
                    case 6:
                        System.out.println("Change Zip");
                        contacts.get(i).setZip(sc.next());
                        break;
                    case 7:
                        System.out.println("Change Phone number");
                        contacts.get(i).setPhoneNumber(sc.next());
                        break;
                    case 8:
                        System.out.println("Change Email ID");
                        contacts.get(i).setEmail(sc.next());
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
        System.out.println("Enter the name of contact you want to see");
        name=sc.next();
        for(int i=0; i< contacts.size(); i++) {
            if (contacts.get(i).getFirstName().equalsIgnoreCase(name)) {
                System.out.println(contacts.get(i));
            } else {
                System.out.println("Can't find name");
            }
        }
    }
    public List<Contacts> uc8_checkByCity(String city){
        List<Contacts> checkByCity = contacts.stream().filter(checkCity -> checkCity.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        return checkByCity;
    }
    public List<Contacts> uc8_checkByState(String state){
        List<Contacts> checkByState = contacts.stream().filter(checkState -> checkState.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        return checkByState;
    }
    public void uc9_cityDictionary(){
        System.out.println("Enter city");
        String city = sc.next();
        List<Contacts> cityList = uc8_checkByState(city);
        stateDictionary.put(city, cityList);
        stateDictionary.get(city).forEach(cities -> System.out.println(cities));
    }
    public void uc9_stateDictionary(){
        System.out.println("Enter state");
        String state = sc.next();
        List<Contacts> statesList = uc8_checkByState(state);
        stateDictionary.put(state, statesList);
        stateDictionary.get(state).forEach(states -> System.out.println(states));
    }
    public void uc10_cityCount(){
        System.out.println("Enter city");
        String city = sc.next();
        long cityCount = contacts.stream().filter(checkCity -> checkCity.getCity().equalsIgnoreCase(city)).count();
        System.out.println("Count of " + city +" is " + cityCount);
    }
    public void uc10_stateCount(){
        System.out.println("Enter city");
        String state = sc.next();
        long stateCount = contacts.stream().filter(checkState -> checkState.getState().equalsIgnoreCase(state)).count();
        System.out.println("Count of " + state +" is " + sc);
    }
}
