package edu.curtin.imageviewer;
import java.util.*;

public class Album 
{
    // CLASS FIELDS:
    private List<ImageRecord> images;
    private int currentIndex;

    // DEFAULT CONSTRUCTOR
    public Album()
    {
        images = new ArrayList<>();
        currentIndex = 0;
    }

    // ACCESOR
    public ImageRecord getCurrentImage()
    {
        if (images.isEmpty())
        {
            return null;
        }
        return images.get(currentIndex);
    }

    public ImageRecord getNextImage()
    {
        if (!images.isEmpty())
        {
            currentIndex = (currentIndex + 1) % images.size();
        }
        return getCurrentImage();
    }

    public ImageRecord getPreviousImage()
    {
        if (!images.isEmpty())
        {
            currentIndex = (currentIndex - 1 + images.size()) % images.size();
        }
        return getCurrentImage();
    }

    // MUTATOR
    public void addImage(String filename, String caption)
    {
        images.add(new ImageRecord(filename, caption));
    }
}