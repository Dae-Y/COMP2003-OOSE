package edu.curtin.imageviewer;

public class ImageData
{
    private int[][] image;
    
    public ImageData(int width, int height)
    {
        image = new int[height][width];
    }

    public void setPixel(int x, int y, int value)
    {
        image[y][x] = value;
    }

    public int getPixel(int x, int y)
    {
        return image[y][x];
    }

    public int getWidth()
    {
        return image[0].length;
    }

    public int getHeight()
    {
        return image.length;
    }
    
}