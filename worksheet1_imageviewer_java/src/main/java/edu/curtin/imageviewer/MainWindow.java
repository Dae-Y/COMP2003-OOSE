package edu.curtin.imageviewer;

import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import java.io.File;


public class MainWindow
{
    // CLASS FIELDS:
    private Album album;
    private Stage stage;
    private BorderPane mainBox = new BorderPane();
    private ImageView imageWidget = new ImageView();
    private Label captionWidget = new Label();
    
    // ALTERNATE CONSTRUCTOR
    public MainWindow(Album album, Stage stage)
    {
        this.album = album;
        this.stage = stage;
    }
    
    public File chooseAlbumFile()
    {
        FileChooser dialog = new FileChooser();
        dialog.setTitle("Select Album File");
        dialog.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        
        File currentDir = new File(System.getProperty("user.dir"));
        File resourcesDir = new File(currentDir, "resources");        
        if(resourcesDir.isDirectory())
        {
            dialog.setInitialDirectory(resourcesDir);
        }
        else
        {
            dialog.setInitialDirectory(currentDir);
        }
        return dialog.showOpenDialog(stage);
    }
    
    /**
     * Builds the main UI, based on an Album and a JavaFX 'Stage' (which is basically a 
     * pre-existing window).
     */
    public void show()
    {
        Platform.setImplicitExit(true);
        stage.setTitle("JavaFX Image Viewer");
        
        // *** Fix this code so that it loads the initial (first) image. ***
        ImageRecord initialImage = album.getCurrentImage();
        if(initialImage != null)
        {
            String url = new File(initialImage.getFilename()).toURI().toString();
            imageWidget.setImage(new Image(url));
            captionWidget.setText(initialImage.getCaption());
        }
        
        // Add 'mainBox' to the window. This is a container for holding the other bits: the toolbar, 
        // scroller (containing the image), and caption.
        Scene scene = new Scene(mainBox);
        stage.setScene(scene);
        
        Button prevBtn = new Button("Previous");
        Button nextBtn = new Button("Next");
        Button scaleBtn = new Button("Scale");
        Button rotateBtn = new Button("Rotate");
        Button invertBtn = new Button("Invert");
        ToolBar toolBar = new ToolBar(prevBtn, nextBtn, scaleBtn, rotateBtn, invertBtn);
        mainBox.setTop(toolBar);
        
        // Set up nextBtnHandler() to be called when nextBtn is clicked, and similarly for prevBtn.
        // ('abc::xyz' is a method reference, essentially a tiny object that calls the specified 
        // method.)
        prevBtn.setOnAction(this::prevBtnHandler);
        nextBtn.setOnAction(this::nextBtnHandler);
        scaleBtn.setOnAction(this::scaleBtnHandler);
        rotateBtn.setOnAction(this::rotateBtnHandler);
        invertBtn.setOnAction(this::invertBtnHandler);

        ScrollPane scroller = new ScrollPane();
        scroller.setContent(imageWidget);
        mainBox.setCenter(scroller);
        
        // FIXME: fix this code so that it displays the caption for the first image.
        captionWidget.setText(initialImage.getCaption());
        mainBox.setBottom(captionWidget);
        
        stage.sizeToScene();
        stage.show();
    }
    
    /**
    * Retrieves the album.
    */
    public Album getAlbum()
    {
        return album;
    }

    /**
     * Called to handle "previous" button clicks.
     */
    private void prevBtnHandler(ActionEvent event)
    {
        // FIXME: fix this code so that it actually displays the previous image & caption.
        ImageRecord prevImage = album.getPreviousImage();
        if (prevImage != null)
        {
            String url = new File(prevImage.getFilename()).toURI().toString();
            imageWidget.setImage(new Image(url));
            captionWidget.setText(prevImage.getCaption());
        }
    }

    /**
     * Called to handle "next" button clicks.
     */
    private void nextBtnHandler(ActionEvent event)
    {
        // FIXME: fix this code so that it actually displays the next image & caption.
        ImageRecord nextImage = album.getNextImage();
        if (nextImage != null)
        {
            String url = new File(nextImage.getFilename()).toURI().toString();
            imageWidget.setImage(new Image(url));
            captionWidget.setText(nextImage.getCaption());
        }
    }
    
    private void scaleBtnHandler(ActionEvent event)
    {
        /*
        ImageRecord currentImage = album.getCurrentImage();
        if(currentImage != null)
        {
            // Load the image data from the file
            ImageData oldImageData = loadImageData(currentImage.getFilename());

            // Create a ScalingProcessor and apply the scaling operation
            ScalingProcessor scalingProcessor = new ScalingProcessor();
            ImageData scaledImageData = scalingProcessor.applyOperation(oldImageData);

            // Convert the scaled ImageData to a temporary image file URL and update the ImageView
            String scaledImageUrl = convertToImageUrl(scaledImageData);
            imageWidget.setImage(new Image(scaledImageUrl));

            // Update the caption
            captionWidget.setText(currentImage.getCaption());
        }*/
    }



    private void rotateBtnHandler(ActionEvent event)
    {
        
    }

    private void invertBtnHandler(ActionEvent event)
    {
        
    }
}
