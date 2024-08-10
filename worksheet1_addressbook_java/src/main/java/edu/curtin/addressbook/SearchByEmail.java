package edu.curtin.addressbook;

/**
 * File: SearchByEmail.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 2
 *          Implement the Option interface and perform the search by email.
 *
 * Reference: OOSE lecture 3 slides
 *            
 * Comments: 
 * 
 * Last mod: 10/08/2024
 */
public class SearchByEmail implements Option
{
    @Override
    public String doOption(String email, AddressBook addressBook)
    {
        Entry entry = addressBook.getEntryByEmail(email);
        return (entry != null) ? entry.toString() : "No entry found for email: " + email;
    }

    @Override
    public boolean requiresText()
    {
        return true;
    }
}
