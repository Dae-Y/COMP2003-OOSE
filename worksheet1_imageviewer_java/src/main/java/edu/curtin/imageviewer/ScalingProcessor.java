package edu.curtin.imageviewer;

public class ScalingProcessor extends ImageProcessor
{
    @Override
    public ImageData processImage(ImageData oldImage)
    {
        int newWidth = oldImage.getWidth() / 2;
        int newHeight = oldImage.getHeight() / 2;
        ImageData newImage = new ImageData(newWidth, newHeight);
        
        for(int y = 0; y < newHeight; y++)
        {
            for(int x = 0; x < newWidth; x++)
            {
                newImage.setPixel(x, y, oldImage.getPixel(x * 2, y * 2));
            }
        }
        return newImage;
    }
}
