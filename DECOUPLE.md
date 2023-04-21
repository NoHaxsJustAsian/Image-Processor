What files do you need to send along for only the controllers to compile? This list must include the interfaces and implementations for the controller itself.
For each file, briefly explain why that file is necessary for the controller to work.


For the controllers to compile, the following files are needed:
- GUIController
    - model.IImageProcessorModel
        - This is needed because the controller needs to be able to access the interface of a model, which must contain the methods listed in the interface. This interface of the model includes every method necessary for the controller to work, model wise. 
    - view.GUIView
        - This is needed because the controller needs to be able to access the GUIview, which is specific to the controller. The reason this is specific, is that not every method contained in its text counterpart can be utilized with the GUIController. Because of this, we chose to not utlize an interface, to ensure the correct view was being used. 
    - java.awt.image.BufferedImage
        - This is needed to store jpgs and pngs as images, which can be manipulated by the controller.
    - java.io.File
        - This is needed to store the file path of the image being manipulated.
    - java.io.FileInputStream
        - This is needed to read the image file that is fed in by the user.
    - java.io.FileNotFoundException
        - This is needed to catch the exception thrown when the file is not found.
    - java.io.IOException
        - This is needed to catch the exception thrown when the file cannot be read utilizing the imageIO class.
    - java.io.PrintWriter
        - This is needed to write data to a file, specifically for saving a project or saving a PPM image.
    - java.util.Scanner
        - This is needed to read data from a file, specifically for loading a project or loading a PPM image.
    - javax.imageio.ImageIO
        - This is needed to read and write images, specifically png and jpg images.
    
    

- ImageProcessorController
    - model.IImageProcessorModel
        - This is needed because the controller needs to be able to access the interface of a model, which must contain the methods listed in the interface. This interface of the model includes every method necessary for the controller to work, model wise.
    - view.IImageProcessorView
        - This is needed because the controller needs to be able to access the interface of a view, which must contain the methods listed in the interface. This interface of the view includes every method necessary for the controller to work, view wise.
     - java.awt.image.BufferedImage
        - This is needed to store jpgs and pngs as images, which can be manipulated by the controller.
    - java.io.File
        - This is needed to store the file path of the image being manipulated.
    - java.io.FileInputStream
        - This is needed to read the image file that is fed in by the user.
    - java.io.FileNotFoundException
        - This is needed to catch the exception thrown when the file is not found.
    - java.io.IOException
        - This is needed to catch the exception thrown when the file cannot be read utilizing the imageIO class.
    - java.io.PrintWriter
        - This is needed to write data to a file, specifically for saving a project or saving a PPM image.
    - java.util.Scanner
        - This is needed to read data from a file, specifically for loading a project or loading a PPM image.
    - javax.imageio.ImageIO
        - This is needed to read and write images, specifically png and jpg images.