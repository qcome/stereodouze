package librairies;
import net.coobird.thumbnailator.Thumbnails;
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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

        if (newHeight < 200)
            newHeight = 200;
        if (newWidth < 200)
            newWidth = 200;

        //BufferedImage tmp = Thumbnails.of(inputImage).scale(percent).asBufferedImage();
        BufferedImage tmp = Scalr.resize(inputImage, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, newWidth, newHeight);
        System.out.println("tmp.getWidth() : " + tmp.getWidth());
        System.out.println("tmp.getHeight() : " + tmp.getHeight());
        System.out.println("x*percent : " + (int) (x*percent));
        System.out.println("y*percent : " + (int) (y*percent));
        BufferedImage outputImage = tmp.getSubimage((int) (x*percent), (int) (y*percent), 200, 200);
        //BufferedImage outputImage = tmp.getSubimage((int) (x*percent), (int) (y*percent), 200, 200);

       /* AffineTransform at = new AffineTransform();
        at.scale(percent, percent);

        AffineTransformOp scaleOp =
                new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);*/
        //BufferedImage after = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        //after = scaleOp.filter(inputImage, after);
        //copy initial image
        //BufferedImage tmp = inputImage.getSubimage(0, 0, inputImage.getWidth(), inputImage.getHeight());


        String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
        ImageIO.write(outputImage, "png", new File(outputImagePath));
    }
}
