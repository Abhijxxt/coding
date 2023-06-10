import java.util.*;
public class randomColor {
    public static void main(String[] args) {
        int col[] = {30,31,32,33,34,35,36};
        Random r = new Random();
        System.out.printf("Color should be: \u001b[%dm", col[r.nextInt(col.length)]);
        System.out.println("Hello world. This is in some color!\u001b[0m");
    }
}
