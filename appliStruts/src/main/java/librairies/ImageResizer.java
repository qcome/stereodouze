package librairies;

import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Quentin on 05/02/2017.
 */
public class ImageResizer {
    /**
     * Resizes an image by a percentage of original size (proportional).
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath, String outputImagePath, double percent, int x, int y) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        int newWidth = new Double(inputImage.getWidth() * percent).intValue();
        int newHeight = new Double(inputImage.getHeight() * percent).intValue();

        BufferedImage tmp = Scalr.resize(inputImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, newWidth, newHeight, Scalr.OP_ANTIALIAS);
        BufferedImage outputImage = tmp.getSubimage((int) (x*percent), (int) (y*percent), 200, 200);

        String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }
}
