import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URL;

/**
 * Created by yogeshmadaan on 02/04/16.
 */
public class Main {

    public static final String IMAGE_URL ="https://upload.wikimedia.org/wikipedia/en/b/b4/Helpshift_logo.png";
    private static String encodedString64 = null,encodedString32 =null;

    public static void main(String[] args) {
        byte [] image = null;
        try{
            image = fetchImage();
            if(image!=null)
            {
                encodedString64 = Base64.encode(image);
                encodedString32 = Base32.encode(image);
            }

        }catch(Exception e)
        {
            System.out.println("Some error occured "+e);
        }
        if(encodedString64!=null)
            System.out.println("Base 64 values is "+encodedString64);
        else
            System.out.println("Some error occured");

        if(encodedString32!=null)
            System.out.println("Base 32 values is "+encodedString32);
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
