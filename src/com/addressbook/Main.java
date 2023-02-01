package com.addressbook;

import java.io.*;
import java.util.Scanner;

public class Main extends ContactOperations {
    public static void main(String[] args) throws Exception {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Address Book");
        System.out.println("***********************");
        Main ab=new Main();
        int loop = 1;
        while(loop == 1){
            System.out.println("1.Add Contact\n" +
                    "2.Edit Contact\n" +
                    "3.Delete\n" +
                    "4.Display\n" +
                    "5.Check by City or State\n" +
                    "6.Dictionary for city or state\n" +
                    "7.Count for city or state\n" +
                    "8.Sort the list\n" +
                    "9.Write into File\n" +
                    "10.Read from file\n" +
                    "11.Exit");
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
                    ab.displayContact();
                    break;
                case 5:
                    System.out.println("Enter 1 for City and 2 for State");
                    int cityOrState = sc.nextInt();
                    if(cityOrState == 1){
                        System.out.println("Enter the name of city ");
                        String city=sc.next();
                        ab.uc8_checkByCity(city).forEach(checkCity -> System.out.println(checkCity));
                    } else if (cityOrState == 2) {
                        System.out.println("Enter the name of state ");
                        String state=sc.next();
                        ab.uc8_checkByState(state).forEach(checkState -> System.out.println(checkState));
                    }
                    break;
                case 6:
                    System.out.println("Enter 1 for City and 2 for State");
                    int dictionaryCityOrState = sc.nextInt();
                    if(dictionaryCityOrState == 1){
                        ab.uc9_cityDictionary();
                    } else if (dictionaryCityOrState == 2) {
                        ab.uc9_stateDictionary();
                    }
                    break;
                case 7:
                    System.out.println("Enter 1 for CityCount and 2 for StateCount");
                    int countCityOrState = sc.nextInt();
                    if(countCityOrState == 1){
                        ab.uc10_cityCount();
                    } else if (countCityOrState == 2) {
                        ab.uc10_stateCount();
                    }
                    break;
                case 8:
                    System.out.println("Select option\n" +
                            "1.By Name\n" +
                            "2.By City\n" +
                            "3.By State\n" +
                            "4.By ZipCode");
                    int sortOption = sc.nextInt();
                    switch (sortOption){
                        case 1:
                            ab.uc11_sortByName();
                            break;
                        case 2:
                            ab.uc12_sortByCity();
                            break;
                        case 3:
                            ab.uc12_sortByState();
                            break;
                        case 4:
                            ab.uc12_sortByZip();
                            break;
                        default:
                            System.out.println("Enter correct option");
                            break;
                    }
                case 9:
                    FileWriter fileWriter = new FileWriter("D:\\JavaProgramsBridgelabz\\Day9_AddressBookSystem\\src\\com\\addressbook\\ContactsFromAddressbook.txt");
                    for(Contacts cont : contacts){
                        fileWriter.write(cont.toString());
                        System.out.println(cont.toString());
                        fileWriter.close();
                    }
                    break;
                case 10:
                    File file = new File("D:\\JavaProgramsBridgelabz\\Day9_AddressBookSystem\\src\\com\\addressbook\\ContactsFromAddressbook.txt");
                    Scanner scanner = new Scanner(file);
                    while(scanner.hasNextLine()){
                        System.out.println(scanner.nextLine());
                    }
                case 11:
                    loop=0;
                    break;
                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }
}