package edu.curtin.addressbook;

/**
 * File: SearchByName.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 2
 *          Implement the Option interface and perform the search by name.
 *
 * Reference: OOSE lecture 3 slides
 *            
 * Comments: 
 * 
 * Last mod: 10/08/2024
 */
public class SearchByName implements Option
{
    @Override
    public String doOption(String name, AddressBook addressBook)
    {
        Entry entry = addressBook.getEntryByName(name);
        return (entry != null) ? entry.toString() : "No entry found for name: " + name;
    }

    @Override
    public boolean requiresText()
    {
        return true;
    }
}
