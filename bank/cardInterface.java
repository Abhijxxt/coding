package bank;
import java.util.Scanner;
public class cardInterface {

    void start() throws Exception
    {
        System.out.print("\033[H\033[2J");  

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Card interface");
        System.out.println("1. Check Balance/Loans.\n2. Withdraw");
        int opt = sc.nextInt();

        switch(opt)
        {
            case 1: 
                cardReader cr = new cardReader();
                cr.main();
                break;
            default:
                System.out.println("Wrong input.");
                break;
        }

        sc.close();
    }
    public static void main(String[] args) {
        
    }
}
