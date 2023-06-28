package bank;
import java.util.*;
public class Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("<Welcome to R Bank>");
        System.out.println("1. Card info or transaction,\n2. Net banking \n 3. Person to Person money transfer \n");

        int opt = sc.nextInt();
    
        switch(opt)
        {
            case 1: 
            cardInterface ci = new cardInterface();
            ci.start();
            break;
            
            case 2:
            System.out.println("net banking");
            break;

            case 3:
            System.out.println("P2P");
            break;

            default:
            System.out.println("Wrong input");
        }

        sc.close();
    }
}
