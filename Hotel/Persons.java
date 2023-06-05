package Hotel;

class Persons {
    String firstName[] = {"Adam","Alex", "Steve", "Sira"};
 // first name ends here
    public Persons()
    {

    }
    public String name() {
        //System.out.println("Persons name");
        java.util.Random r = new java.util.Random();
        String Name = firstName[r.nextInt(firstName.length)];
        return Name; 
    }
    public static void main(String[] args)
    {
        Persons n = new Persons();
        System.out.println(n.name());
    }
}//class
