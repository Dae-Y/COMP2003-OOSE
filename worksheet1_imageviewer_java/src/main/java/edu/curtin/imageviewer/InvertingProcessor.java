package edu.curtin.imageviewer;

public class InvertingProcessor extends ImageProcessor
{
    @Override
    public ImageData processImage(ImageData oldImage)
    {
        int newWidth = oldImage.getWidth();
        int newHeight = oldImage.getHeight();
        ImageData newImage = new ImageData(newWidth, newHeight);
        
        for(int y = 0; y < newHeight; y++)
        {
            for(int x = 0; x < newWidth; x++)
            {
                newImage.setPixel(x, y, ~oldImage.getPixel(x, y));
            }
        }
        return newImage;
    }
}
