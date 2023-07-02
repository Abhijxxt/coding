package bank;
import java.util.*;
public class Interface {
    public static void main(String[] args) throws Exception {
        
        System.out.print("\033[H\033[2J");  
        Scanner sc = new Scanner(System.in);

        String phrase = "1. Card info or transaction,\n2. Net banking \n3. Person to Person money transfer\n"; 
                
        System.out.println("<Welcome to R Bank>");
        System.out.println(phrase);

        int opt = sc.nextInt();
    
        switch(opt)
        {
            case 1: 
            System.out.print("\033[H\033[2J");  
            phrase = "\u001B[31m1. Card info or transaction\u001B[31m\u001B[37m\n2. Net banking \n3. Person to Person money transfer\n"; 
            System.out.println("<Welcome to R Bank>\n"+phrase);
            Thread.sleep(1300);

            cardInterface ci = new cardInterface();
            ci.start();
            break;
            
            case 2:
            System.out.print("\033[H\033[2J");  
            phrase = "1. Card info or transaction\n\u001B[31m2. Net banking \u001B[31m\u001B[37m\n3. Person to Person money transfer\n"; 
            System.out.println("<Welcome to R Bank>\n"+phrase);
            Thread.sleep(1300);
            System.out.println("net banking");
            break;

            case 3:
            System.out.print("\033[H\033[2J");  
            phrase = "1. Card info or transaction\n2. Net banking \n\u001B[31m3. Person to Person money transfer\u001B[31m\u001B[37m\n"; 
            System.out.println("<Welcome to R Bank>\n"+phrase);
            Thread.sleep(1300);
            System.out.println("P2P");
            break;

            default:
            System.out.println("Wrong input");
        }

        sc.close();
    }
}
