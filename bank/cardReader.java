package bank;
import java.util.*;
import java.io.*;
public class cardReader {

    void databaseRetrieve(long account_number) throws FileNotFoundException
    {
        String[] database = new String[10];

        
        File f = new File("D:\\programs\\coding\\coding\\bank\\data.txt");
        Scanner read = new Scanner(f);
        String data="";
        
        while(read.hasNextLine())
        {
            data = read.nextLine();
            StringTokenizer st = new StringTokenizer(data, ",");
            long acc_check = Long.parseLong(st.nextToken());
            if(acc_check == account_number)
                break;
        }

        if(data.equals(""))
        {
            System.out.println("No data found!");
        }
        else
        {
            
            StringTokenizer st = new StringTokenizer(data,",");
            database[0] = st.nextToken(); //acc no
            database[1] = st.nextToken(); //name
            database[2] = st.nextToken(); //pin
            database[3] = st.nextToken(); //amount 
            database[4] = st.nextToken(); //loans

            System.out.println("Welcome " + database[1]);
            int pin = Integer.parseInt(database[2]);

            System.out.println("Enter the pin: ");
            Scanner sc = new Scanner(System.in);
            int PIN = sc.nextInt();
            if(pin == PIN)
            {
                System.out.println("Welcome " + database[1]);
                System.out.println("Amount: " + database[3]);
                System.out.println("Loan: " + database[4]);
            }
            else
            {
                System.out.println("Wrong pin.");
            }
            sc.close();
        }
        
        
        read.close();

       
    }
    void dataRetrieve(String data) throws FileNotFoundException
    {
        StringTokenizer card_data_array = new StringTokenizer(data, ",");
        String name = card_data_array.nextToken();
        long account_number = Long.parseLong(card_data_array.nextToken());

        databaseRetrieve(account_number);

        
    }
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your card then press enter: ");
        String enter = sc.nextLine();

        if(enter.isEmpty())
        {
            System.out.println("Please wait reading card.");
            Thread.sleep(3000);
            try
            {
                System.out.println("Card found. Please wait");
                File file = new File("E:\\id.txt");
                Scanner read = new Scanner(file);
                String data = read.nextLine().trim();
                
                cardReader cr = new cardReader();
                cr.dataRetrieve(data);
                
                read.close();
            }
            catch(Exception e)
            {
                //System.out.println(e);
                System.out.println("No card found.");
            }
        }
        else
        {
            System.out.println("You cancelled the queue.");
        }
        sc.close();
    }
}
