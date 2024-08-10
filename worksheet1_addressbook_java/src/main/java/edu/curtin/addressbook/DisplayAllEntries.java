package edu.curtin.addressbook;

/**
 * File: DisplayAllEntries.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 2
 *          Implement the Option interface,
 *          an additional option to display all entries in the address book.
 *
 * Reference: OOSE lecture 3 slides
 *            
 * Comments: 
 * 
 * Last mod: 10/08/2024
 */
public class DisplayAllEntries implements Option
{
    @Override
    public String doOption(String s, AddressBook addressBook)
    {
        StringBuilder allEntries = new StringBuilder();

        for (Entry entry : addressBook.getAllEntries())
        {
            allEntries.append(entry.toString()).append("\n");
        }

        return allEntries.toString();
    }

    @Override
    public boolean requiresText()
    {
        return false;
    }
}
