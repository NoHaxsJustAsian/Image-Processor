# assignment2 part3
## Model
  - ImageProcesssorModel
    - Decoupled
    
  
## View
  - GUIView 
    - Decoupled from model, No longer needs to be passed a model or an interface of a model. 
    - Decoupled from controller, does not need to be passed a controller. 
    - Originally, the controller was passed in, and never used.
    - Only relies on the features interface of a controller. 
    - Fixed buttons that were not working, such as the save button, and the load button. 
    - Added file type filtering for the load button.
    - Added file type filtering for the save button, allowing the user to choose what type of file 
    - to save. 
    - Debugged 
  
## Controller
  - GUIController
    - Decoupled from 
    - addLayerButton
    - Changed our original saveImage, to savePPM, as it saved a ppm, then constructed a new method,
    - called, saveImage, which can save any type of image, including ppms.
    - Changed our original addImage, to addPPM, as it loaded in a ppm, then constructed a 
    - new method, called, addImage, which can load any type of image, including ppms.
    - Debugged
  - ImageProcessorController
    - Added switch case operations for new filters, multiply, difference, and screen filters. 
    - handle add-image to render png and jpg files 
    - Changed our original saveImage, to savePPM, as it loaded a ppm, then constructed a new
    - method, called, saveImage, which can take in any type of image, including ppms.
    - Changed our original addImage, to addPPM, as it loaded in a ppm, then constructed a 
    - new method, called, addImage, which can load any type of image, including ppms.

# assignment2 part2
## Controller
  - Feature
    - Represents the interface which the user uses to interact with the model of the image processor The interface defines methods related to file functions such as
    saving projects and images, filter functions such as applying various filters to an image, and layer functions such as adding layers and images to a project.
    - The "void" return type for all methods in the interface indicates that they do not return any value. The methods take a string parameter called "curLayer" which     specifies the layer to which the filter or image should be applied.
    - The purpose of this interface is to provide a set of methods that can be used by different classes to interact with the image processing model in a consistent       manner, regardless of the underlying implementation details. This promotes modularity and allows different parts of the program to be developed and tested             independently.
  - GUIController
    -  Represents the controller for the GUI view. This controller will be used to control the GUI view. The class has three private fields: a JPanel named "panel", a        GUIView named "view", and an IImageProcessorModel named "model".
    - The constructor takes two arguments, a GUIView object and an IImageProcessorModel object, and initializes the view and model fields with them. It also calls the        "addFeatures" method of the view object and passes itself (the current object) as an argument, and then calls the "display" method of the view object.
    - The class has an "actionPerformed" method that is called when an action is performed on the GUI. It checks the action command of the event and performs an action       accordingly. Currently, it only handles "Red", "Green", "Blue", and "Exit Button" actions. When the "Red" action is performed, it sets the filter of a layer to a       "RedFilter" object, and when the "Exit Button" action is performed, it exits the program.
    - It will be able to load a project, save a project, and apply filters to the project.  
## View
  - GUIView
    - Represents the GUI view for the program. This displays the JFrame of the Program including the buttons, the image, and the layers. 
    - The GUI view displays a JFrame that includes buttons, an image, and layers. It also has a model and a controller that are used to implement the functionality of       the program.
    - The constructor initializes the GUI view by setting up the JFrame, the panels, and the buttons. It sets the layout of the GUI using BorderLayout and adds the           panels to the JFrame. It also initializes the buttons and adds them to the GUI view.


# assignment2 part1
Inheritance Summary:
This project contains an Image interface and its implementation AImage class which is an abstract class for PPMImage class, 
an IImageProcessorState interface which contains non-mutable methods extended by a IImageProcessorModel interface which 
contains mutable methods and its implementation is an ImageModelProcessor class, an ILayer interface and its implementation 
Layer class, an IPixel interface and its implementation Pixel class, an IImageProcessorController and its implementation 
ImageProcessorController class, an IImageProcessorView Class and its implementation ImageProcessor class, and an IFilter 
interface and its implementation of function object classes that include Normal class, RedFilter class, GreenFilter class, 
BlueFilter class, BrightenIntensity class, BrightenLuma class, BrightenValue class, DarkenIntensity class, DarkenLuma class, 
DarkenValue class and ColorFilter class. There a ImageUtil class and a main class to run the program.

Specific Purposes:
The IPixel interface specifies methods to get the red, green, blue, and alpha values of a pixel in an image.
The Pixel class represents a pixel's values in an image. It implements the IPixel interface and provides methods to get the red, 
green, blue, and alpha values of a pixel. The class constructor takes four arguments and assigns them to instance variables after 
validating their range (0-255). 

The IImage interface provides methods to retrieve the pixels, the pixel at a given location, the height, and the width of an image.
The AImage class represents an abstract class for image types. It has a constructor that takes in an array of pixels, height, and 
width. It implements the IImage interface which has methods to retrieve the pixels, a specific pixel at a given location, and the 
height and width of the image. 
The PPMImage class represents a PPM image. It extends the abstract class AImage and has a constructor that takes in a 2D array of 
pixels, height, and width.

The ILayer interface represents a layer in an image editor. It includes methods for getting and setting the height and width of the 
layer, setting a filter for the layer, adding an image to the layer, setting the canvas to all white background, getting the canvas 
from the layer, getting the name of the layer, getting a pixel given an x and a y, and getting the filter of the layer.
The Layer class represents a layer on an image and can accept an image and location, in which, the image is placed onto the layer's 
canvas at said location. The canvas holds each pixel from the image on its own canvas and can be fed more images. If a pixel is 
overridden on the canvas, it will show the last placed image's pixel. The package includes methods to get the name, pixel, filter, 
height, and width of the layer. It also includes methods to add an image to the layer, set the filter for the layer, and get the canvas 
from the layer. There is also a method to set the canvas to a white transparent background.

The IFilter interface is for the image filter classes. It contains two methods: apply(ILayer layer) which applies the filter to an image 
layer and returns the modified pixels as a two-dimensional IPixel array, and getName() which returns the name of the filter as a string. 
When applying a filter, the output canvas will replace the original layer's canvas, and the layer's filter should be changed to "normal".

The ImageProcessorModel is the main model for this image processing program. It represents an image project and stores information about 
the image such as its height, width, maximum value, and layers. The layers are stored in a HashMap with keys as their names and in a List 
in the order they should be applied. The model provides methods for getting and manipulating layers, swapping layers, and applying filters 
to them. It also has methods for saving and loading projects.

The ImageProcessorController implements an interface for an Image Processor Controller. It includes methods for starting the program, 
reading commands from an input source, and executing those commands using a model and a view. The available commands include creating a 
new project, loading and saving projects, and applying various filters to images.

The ImageProcessorView class is responsible for displaying images using the provided model. It has two constructors, one that takes a 
model object and uses the console as the display destination, and another that takes a model object and an Appendable object as the 
display destination. It also has a method renderMessage() that can be used to transmit a message to the display destination. If 
transmission fails, an IOException is thrown.

ImageUtil is a tool used to read image files from the computer's files, and to write a given Image into a file.

NEED TO DO THIS!!!
A script of commands that your program will accept, that will create a new project, add at least one image as a layer, add some layers and filters on it and save the resulting image and project in other files. Include in your README file instructions on how we can run this script using your program (e.g. ''provide this file as a command line argument", ''type this script when the program runs", etc.

//FIXME: Not currently working but would be script of commands

# Creates the project with an 500 pixel by 500 pixel canvas
new-project 500 500

# Creates a new layer called boxes-blue
add-layer boxes-blue

# Sets the filter to only show the blue of the image
set-filter boxes-blue blue

# Sets the image on the layer to the provided image, but offset 5 pixels to the right and 5 pixels down from the top left
add-image-to-layer boxes-blue image/boxes.ppm 5 5

# Creates a new layer called boxy-dark
add-layer boxy-dark

# Adds the image to the boxy-dark layer with no offset
add-image-to-layer 0 0 boxy-dark image/boxy.ppm

# Sets the filter to darken according to the luma value
set-filter boxy-dark darken-luma

# Saves the final rendered image to the given path
save-image images/boxes-boxy.ppm

# Saves the project to the given path to pick up later
save-project projects/boxes-boxy.collage

# All commands
new-project <height> <width>
load-project <path>
save-project <path>
save-image <path>
add-layer <layer-name>
set-filter <layer-name> <filter-name>
add-image-to-layer <x-offset> <y-offset> <layer-name> <path> 

# All filters <filter-name>
normal
blue
red
green
brighten-intensity
brighten-luma
brighten-value
darken-intensity
darken-luma
darken-value


