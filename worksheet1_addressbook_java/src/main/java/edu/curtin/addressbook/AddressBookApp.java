package edu.curtin.addressbook;

import java.io.*;
import java.util.*;

/**
 * File: AddressBookApp.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Wsh 2
 *          Refactored to use non-static methods, contains a Map to store Option objects, 
 *          and has a method to add options.
 * 
 * Reference: OOSE lecture 3 slides
 *            
 * Comments: 
 * Last mod: 10/08/2024
 */
public class AddressBookApp
{
    // CLASS FIELDS:
    private AddressBook addressBook;
    private Map<Integer, Option> options;

    private static Scanner input = new Scanner(System.in);

    // DEFAULT CONSTRUCTOR
    public AddressBookApp()
    {
        addressBook = new AddressBook();
        options = new HashMap<>();
    }

    public void addOption(int label, Option option)
    {
        options.put(label, option);
    }

    public void showMenu()
    {
        boolean done = false;
        while(!done)
        {
            System.out.println("(1) Search by name, (2) Search by email, (3) Display all entries, (4) Quit");
            try
            {
                int choice = Integer.parseInt(input.nextLine());
                if (choice == 4)
                {
                    done = true;
                }
                else if(options.containsKey(choice))
                {
                    Option option = options.get(choice);
                    String searchText = "";
                    if (option.requiresText())
                    {
                        System.out.print("Enter search term: ");
                        searchText = input.nextLine();
                    }
                    String result = option.doOption(searchText, addressBook);
                    System.out.println(result);
                }
                else
                {
                    System.out.println("Enter a valid number");
                }
            }catch(NumberFormatException e)
            {
                System.out.println("Enter a number");
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.print("Enter address book filename: ");
        String fileName = input.nextLine();

        AddressBookApp app = new AddressBookApp();
        app.addOption(1, new SearchByName());
        app.addOption(2, new SearchByEmail());
        app.addOption(3, new DisplayAllEntries());

        try
        {
            app.addressBook = readAddressBook(fileName);
            app.showMenu();
        }
        catch(IOException e)
        {
            System.out.println("Could not read from " + fileName + ": " + e.getMessage());
        }
    }

    private static AddressBook readAddressBook(String fileName) throws IOException
    {
        AddressBook addressBook = new AddressBook();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(":");
                String name = parts[0];
                List<String> emails = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
                addressBook.addEntry(name, emails);
            }
        }
        return addressBook;
    }
    
}
