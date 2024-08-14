package edu.curtin.imageviewer;

public abstract class ImageProcessor
{
    public final ImageData applyOperation(ImageData oldImage)
    {
        // Template method containing the algorithm
        return processImage(oldImage);
    }
    
    // Abstract method to be implemented by subclasses
    protected abstract ImageData processImage(ImageData oldImage);
}

