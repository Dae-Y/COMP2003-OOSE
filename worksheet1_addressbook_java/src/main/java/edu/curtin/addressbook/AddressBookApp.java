package edu.curtin.addressbook;

import java.io.*;
import java.util.*;

/**
 * File: AddressBookApp.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 1
 *          A simple address book application.
 *          This class manages the app's main workflow,
 *          reading the address book from a file and handling user interaction.
 * 
 * Reference: OOSE lecture 1 slides
 *            
 * Comments: 
 * 
 * Last mod: 04/08/2024
 */
public class AddressBookApp 
{
    /* Used to obtain user input. */
    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        String fileName;
        String entryName;
        
        System.out.print("Enter address book filename: "); // "addressbook.txt"
        fileName = input.nextLine();
        
        try
        {
            AddressBook addressBook = readAddressBook(fileName);
            showMenu(addressBook);
        }
        catch(IOException e)
        {
            System.out.println("Could not read from " + fileName + ": " + e.getMessage());
        }
    }
    
    /**
     * Read the address book file, containing all the names and email addresses.
     *
     * @param fileName The name of the address book file.
     * @return A new AddressBook object containing all the information.
     * @throws IOException If the file cannot be read.
     */
    private static AddressBook readAddressBook(String fileName) throws IOException
    {
        AddressBook addressBook = new AddressBook();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line = reader.readLine();
            while(line != null)
            {
                String[] parts = line.split(":");
                                
                /* FIXME: Insert your code here to add a new address book entry. 
                   parts[0] contains the person's name.
                   parts[1], parts[2], etc. contain the person's email address(es). */
                String name = parts[0];
                List<String> emails = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
                addressBook.addEntry(name, emails);
                
                line = reader.readLine();
            }
        }
        return addressBook;
    }
    
    /**
     * Show the main menu, offering the user options to (1) search entries by 
     * name, (2) search entries by email, or (3) quit.
     *
     * @param addressBook The AddressBook object to search.
     */
    private static void showMenu(AddressBook addressBook)
    {
        boolean done = false;
        while(!done)
        {
            int option;
            System.out.println("(1) Search by name, (2) Search by email, (3) Quit");
            
            try
            {
                switch(Integer.parseInt(input.nextLine()))
                {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = input.nextLine();
                        
                        // FIXME: Insert your code here to find an entry by name and display it.
                        Entry entryByName = addressBook.getEntryByName(name);
                        if(entryByName != null)
                        {
                            System.out.println(entryByName);
                        }
                        else
                        {
                            System.out.println("No entry found for name: " + name);
                        }
                        break;
                        
                    case 2:
                        System.out.print("Enter email address: ");
                        String email = input.nextLine();
                        
                        // FIXME: Insert your code here to find an entry by email and display it.
                        Entry entryByEmail = addressBook.getEntryByEmail(email);
                        if(entryByEmail != null)
                        {
                            System.out.println(entryByEmail);
                        }
                        else
                        {
                            System.out.println("No entry found for email: " + email);
                        }
                        break;
                        
                    case 3:
                        done = true;
                        break;
                        
                    default:
                        System.out.println("Enter a valid number");
                        break;
                }
            }
            catch(NumberFormatException e)
            {
                // The user entered something non-numerical.
                System.out.println("Enter a number");
            }
        }
    }
}
