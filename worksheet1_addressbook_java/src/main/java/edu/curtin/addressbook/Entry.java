package edu.curtin.addressbook;

import java.util.*;
        
/**
 * File: Entry.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 1
 *          Represents a single address book entry.
 *          An addreess book entry with a name and a collection of unique email addresses.
 *
 * Reference: OOSE lecture 1 slides
 *            
 * Comments: 
 * 
 * Last mod: 31/07/2024
 */
public class Entry 
{
    // CLASS FIELDS:
    private String name;
    private Set<String> emailAddresses;

    // ALTERNATE CONSTRUCTOR
    public Entry(String name)
    {
        this.name = name;
        this.emailAddresses = new HashSet<>();
    }

    // ACCESSOR
    public String getName() 
    {
        return name;
    }

    public Set<String> getEmailAddresses() 
    {
        return Collections.unmodifiableSet(emailAddresses);
    }

    // MUTATOR
    public void addEmailAddress(String email) 
    {
        emailAddresses.add(email);
    }

    @Override
    public String toString() 
    {
        return name + ": " + String.join(", ", emailAddresses);
    }
}