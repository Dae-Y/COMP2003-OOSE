package edu.curtin.imageviewer;

/**
 * File: ImageRecord.java
 * Author: Daehwan Yeo 19448288
 * Purpose: OOSE Prac 1
 * Reference: OOSE lecture 1 slides
 *            
 * Comments: Represents an image in an album.
 * 
 * Last mod: 04/08/2024
 */
public class ImageRecord
{
    private String filename;
    private String caption;
    
    public ImageRecord(String newFilename, String newCaption)
    {
        filename = newFilename;
        caption = newCaption;
    }
    
    public String getFilename()
    {
        return filename;
    }
    
    public String getCaption()
    {
        return caption;
    }
}
