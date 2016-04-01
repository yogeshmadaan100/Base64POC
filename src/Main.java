import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;

/**
 * Created by yogeshmadaan on 02/04/16.
 */
public class Main {

    public static final String IMAGE_URL ="https://upload.wikimedia.org/wikipedia/en/b/b4/Helpshift_logo.png";
    private static String encodedString = null;

    public static void main(String[] args) {
        byte [] image = null;
        try{
            image = fetchImage();
            if(image!=null)
                encodedString = Base64.encode(image);

        }catch(Exception e)
        {
            System.out.println("Some error occured "+e);
        }
        if(encodedString!=null)
            System.out.println("Base 64 values is "+encodedString);
        else
            System.out.println("Some error occured");

    }

    public static byte[] fetchImage() throws Exception
    {
        URL url = new URL(IMAGE_URL);

        // read image direct from url
        BufferedImage image = ImageIO.read(url);

        // write image to outputstream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();

        // get bytes
        byte[] imageBytes = baos.toByteArray();
        return imageBytes;
    }
}
