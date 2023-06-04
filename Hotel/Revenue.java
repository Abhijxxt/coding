package Hotel;

import Hotel.Persons;
//import java.util.*;

public class Revenue {
    String Name;
    
    Revenue()
    {
        Name="";
    }
    public void Guest()
    {
        Persons x = new Persons();
        System.out.println("Guest name:" + x.name() );  
        
    }
    public static void main(String args[])
    { 
        Revenue rev = new Revenue();
        rev.Guest();
    }
}
