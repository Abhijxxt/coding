package Hotel;

import Hotel.Persons;
import java.util.*;

public class Revenue {
    String Name;
    Revenue()
    {
        Name="";
    }
    public void Guest()
    {
        Persons name = new Persons();
        System.out.println(name.name());  
        
    }
    public static void main(String args[])
    { 
        Revenue rev = new Revenue();
        rev.Guest();
    }
}
