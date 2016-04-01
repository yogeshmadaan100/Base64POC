import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by yogeshmadaan on 02/04/16.
 */
public class Base64Test
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

            String encoded = Base64.encode(original);
            byte[] decoded = Base64.decode(encoded);

            if (!Arrays.equals(original, decoded)) {
                print(original);
                print(decoded);
                System.out.println();
            }
        }

        System.out.println("Encode, decode with other");
        for (int count = 0; count < steps; count++) {
            int len = rand.nextInt(100)+1;
            byte[] original = new byte[len];
            for (int i = 0; i < len; i++) {
                original[i] = (byte)rand.nextInt(0xFF);
            }

            String encoded = Base64.encode(original);
            byte[] decoded = DatatypeConverter.parseBase64Binary(encoded);

            if (!Arrays.equals(original, decoded)) {
                print(original);
                print(decoded);
                System.out.println();
            }
        }

        System.out.println("Encode with other, decode");
        for (int count = 0; count < steps; count++) {
            int len = rand.nextInt(100)+1;
            byte[] original = new byte[len];
            for (int i = 0; i < len; i++) {
                original[i] = (byte)rand.nextInt(0xFF);
            }

            String encoded = DatatypeConverter.printBase64Binary(original);
            byte[] decoded = Base64.decode(encoded);

            if (!Arrays.equals(original, decoded)) {
                print(original);
                print(decoded);
                System.out.println();
            }
        }

        System.out.println("Comparison test");
        for (int count = 0; count < 100000; count++) {
            int len = rand.nextInt(100)+1;
            byte[] original = new byte[len];
            for (int i = 0; i < len; i++) {
                original[i] = (byte)rand.nextInt(0xFF);
            }

            String encoded = DatatypeConverter.printBase64Binary(original);
            String encoded2 = Base64.encode(original);

            if (!encoded.equals(encoded2)) {
                System.out.println("mismatch");
                System.out.println(encoded);
                System.out.println(encoded2);
                System.out.println();
            }
            else{
                System.out.println("Everything matched");
                System.out.println("Test Successful");
            }
        }
    }
}