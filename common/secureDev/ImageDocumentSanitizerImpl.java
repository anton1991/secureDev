package secureDev;

import ij.ImagePlus;
import ij.io.Opener;
import ij.process.ImageProcessor;

import java.io.File;


/**
 * Implementation of the sanitizer for Image file.
 * 
 * @see "http://stackoverflow.com/a/24747085"
 *
 */

public class ImageDocumentSanitizerImpl {


	public static  boolean madeSafe(File f) {
		boolean safeState = false;
		try {
			System.out.println("checking file");
			if ((f != null) && f.exists() && f.canRead() && f.canWrite()) {
				// Load image
				ImagePlus image = new Opener().openImage(f.getAbsolutePath());

				// Check that image has been successfully loaded
				if (image == null) {
					throw new Exception("Cannot load the original image !");
				}

				// Get current Width and Height of the image
				int originalWidth = image.getWidth();
				int originalHeight = image.getHeight();

				// Obtain an Image processor on this image
				ImageProcessor originalImageProcessor = image.getProcessor();
				if (originalImageProcessor == null) {
					throw new Exception("Cannot obtains an image processor for the original image !");
				}

				// Resize the image by removing 1px on Width and Height
				ImageProcessor resizedImageProcessor = originalImageProcessor.resize(originalWidth - 1, originalHeight - 1);
				if (resizedImageProcessor == null) {
					throw new Exception("Cannot resize the original image !");
				}

				// Resize the resized image by adding 1px on Width and Height
				// In fact set image to is initial size
				ImageProcessor initialSizedImageProcessor = resizedImageProcessor.resize(originalWidth, originalHeight);
				if (initialSizedImageProcessor == null) {
					
					throw new Exception("Cannot restore the initial size of the original image !");
				}

				// Set state flag
				safeState = true;
			}
			else
			{
				System.out.println("cant read image file");
			}

		}
		catch (Exception e) {
			System.out.println(e.toString());
			safeState = false;
		}

		return safeState;
	}

}