package com.addressbook;

import java.util.Scanner;

public class Main extends ContactOperations {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Address Book");
        System.out.println("***********************");
        Main ab=new Main();
        int loop = 1;
        while(loop == 1){
            System.out.println("1.Add Contact\n2.Edit Contact\n3.Delete\n4.Display\n5.Check by City or State\n6.Exit");
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
                        ab.uc8_checkByCity();
                    } else if (cityOrState == 2) {
                        ab.uc8_checkByState();
                    }
                    break;
                case 6:
                    loop=0;
                    break;
                default:
                    System.out.println("Enter correct option");
                    break;
            }
        }
    }
}