package edu.curtin.addressbook;

/**
 * File: Option.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 2
 *          Option interface class
 *
 * Reference: OOSE lecture 3 slides
 *            
 * Comments: 
 * 
 * Last mod: 10/08/2024
 */
public interface Option
{
    String doOption(String s, AddressBook addressBook);

    boolean requiresText();

}
