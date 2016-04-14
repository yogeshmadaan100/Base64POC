import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by yogeshmadaan on 02/04/16.
 */
public class Base32Test
{
    public static void print(byte[] bytes)
    {
        for (byte b : bytes) {
            System.out.printf("%02X ", b);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int steps = 1000000;
        Random rand = new Random(System.currentTimeMillis());

        System.out.println("Encode, decode");
        for (int count = 0; count < steps; count++) {
            int len = rand.nextInt(100)+1;
            byte[] original = new byte[len];
            for (int i = 0; i < len; i++) {
                original[i] = (byte)rand.nextInt(0xFF);
            }

            String encoded = Base32.encode(original);
            byte[] decoded = Base32.decode(encoded);

            if (!Arrays.equals(original, decoded)) {
                print(original);
                print(decoded);
                System.out.println();
            }
            else
                System.out.println("Test Passed");
        }


    }
}