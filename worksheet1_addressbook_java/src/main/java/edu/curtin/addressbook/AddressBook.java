package edu.curtin.addressbook;

import java.util.*;

/**
 * File: AddressBook.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 1
 *          Contains all the address book entries.
 *          This class manages a collection of Entry objects, 
 *          allowing for entries to be added, and searched by name or email.
 * 
 * Reference: OOSE lecture 1 slides
 *            
 * Comments: 
 * 
 * Last mod: 04/08/2024
 */
public class AddressBook
{
    // CLASS FIELDS:
    private Map<String, Entry> entriesByName;
    private Map<String, Entry> entriesByEmail;
    // Maps contain key-value pairs of objects, get & set 'value' by supplying the 'key'
    // Keys and values can be different in types

    // DEFAULT CONSTRUCTOR
    public AddressBook()
    {
        entriesByName = new HashMap<>();    // Hash maps, unordered but faster
        entriesByEmail = new HashMap<>();
    }

    // ACCESSOR    
    public Entry getEntryByName(String name) 
    {
        return entriesByName.get(name);
    }

    public Entry getEntryByEmail(String email) 
    {
        return entriesByEmail.get(email);
    }

    // MUTATOR
    public void addEntry(String name, List<String> emails) 
    {
        Entry entry = entriesByName.getOrDefault(name, new Entry(name));
        for (String email : emails) 
        {
            entry.addEmailAddress(email);
            entriesByEmail.put(email, entry);
        }
        entriesByName.put(name, entry);
    }

}