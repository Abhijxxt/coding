package Hotel;
//import Hotel.Persons;
//import java.util.*;

public class Revenue {
    String Name;
    
    Revenue()
    {
        Name="";
    }
    public void Guest() 
    {     
        //System.out.println("Revenue Guest. ");
        Persons x = new Persons();
        System.out.println("Guest name:" + x.name() );  
        
    }
    public static void main(String args[])
    { 
        //System.out.println("Revenue main.");
        Revenue rev = new Revenue();
        rev.Guest();
    }
}
