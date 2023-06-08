package F1;
import Hotel.Persons;
import java.util.*;


// import Hotel.Persons;
//driver, rating, teamCOM, tyreWear, WetCond, randomness, analysis
public class accident {
    Random r = new Random();

    double rating()
    {
        double ratings[] = {
            3,3.1,3.1,3.2,3.2,3.3,3.3,3.4,3.5,3.5,3.6,3.6,3.7,3.7,3.7,3.7,3.8,3.8,3.8,3.8,3.8,
            3.9,3.9,3.9,3.9,4,4,4,
            4,4.1,4.1,4.1,4.1,4.1,4.1,4.2,4.2,4.2,4.2,4.3,4.3,4.3,4.3,
            4.4,4.4,4.4,4.4,4.5,4.5,4.5,4.6,4.6,4.7,4.7,4.8,4.8,4.9,4.9,
            5
        };
        return ratings[r.nextInt(ratings.length)];
    }

    int tyreWear()
    {
        int wearings[] = {
            0,0,10,10,10,20,20,20,20,20,20,30,30,30,30,30,40,40,40,50,50,50,60,70,70,80,80,90,100
        };
        return wearings[r.nextInt(wearings.length)];
    }

    int wetCond()
    {
        int wet[] = {0,0,0,0,0,1,1};
        return wet[r.nextInt(wet.length)];
    }

    double randomness(double rating, int tyreWear, int wetCond)
    {
        double randomness = 0;
        
        if (rating>=4.5)
            randomness += 0.5;
        else if (rating>=4)
            randomness += 0.75;
        else if (rating>=3.5)
            randomness += 1.2;
        else
            randomness += 1.6;

        if (tyreWear>=80 && rating <4)
            randomness += 3;
        else if (tyreWear>=80 && rating >= 4)
            randomness += 2;
        else if (tyreWear>= 70 && rating < 4)
            randomness += 2.5;
        else if (tyreWear >= 70 && rating >= 4)
            randomness += 1.75;
        else if (tyreWear >= 60 && rating < 4)
            randomness += 2.2;
        else if (tyreWear >=60 && rating >= 4)
            randomness += 1.7;
        else if (tyreWear>=30 && tyreWear<60 && rating < 4)
            randomness += 2;
        else if (tyreWear>=30 && tyreWear<60 && rating >= 4)
            randomness += 1.5;
        else if (tyreWear>10 && tyreWear<30 && rating < 4)
            randomness += 1.5; 
        else if (tyreWear>10 && tyreWear<30 && rating >= 4) 
            randomness += 0.75;
        else if (tyreWear<=10 && rating < 4)
            randomness += 1;
        else if (tyreWear<=10 && rating >= 4)
            randomness += 0.25;

        if (wetCond == 1 && rating >=4.5)
            randomness+= 0.75;
        else if(wetCond == 1 && rating >=4)
            randomness += 1;
        else if(wetCond == 1 && rating >=3.5)
            randomness += 1.5;
        else if (wetCond == 1 && rating >=3)
            randomness += 2;
        else
            randomness += 0;
        
        return randomness;
    }

    int teamCOM(double rating, int tyreWear, int wetCond, double randomness) {
        
        int pC = 0; // percent chance of team COM being aggressive or defensive greater the % greater the chance

        if (rating>=4.5)
            pC += 80;
        else if (rating>=4)
            pC += 70;
        else if (rating>=3.5)
            pC += 60;
        else
            pC += 45;

        if (tyreWear>=80 && rating <4)
            pC += 20;
        else if (tyreWear>=80 && rating >= 4)
            pC += 35;
        else if (tyreWear>= 70 && rating < 4)
            pC += 30;
        else if (tyreWear >= 70 && rating >= 4)
            pC += 40;
        else if (tyreWear >= 60 && rating < 4)
            pC += 40;
        else if (tyreWear >=60 && rating >= 4)
            pC += 50;
        else if (tyreWear>=30 && tyreWear<60 && rating < 4)
            pC += 65;
        else if (tyreWear>=30 && tyreWear<60 && rating >= 4)
            pC += 75;
        else if (tyreWear>10 && tyreWear<30 && rating < 4)
            pC += 80; 
        else if (tyreWear>10 && tyreWear<30 && rating >= 4) 
            pC += 90;
        else if (tyreWear<=10 && rating < 4)
            pC += 85;
        else if (tyreWear<=10 && rating >= 4)
            pC += 95;

        if (wetCond == 1 && rating >=4.5)
            pC+= 65;
        else if(wetCond == 1 && rating >=4)
            pC += 55;
        else if(wetCond == 1 && rating >=3.5)
            pC += 35;
        else if (wetCond == 1 && rating >=3)
            pC += 20;
        else
            pC += 100;

        if (wetCond == 1 && randomness >2.5 && randomness <= 5)
            pC += 50;
        else if (wetCond == 1 && randomness > 5)
            pC += 10;
        else if (wetCond == 1 && randomness <=2.5)
            pC += 65;
        else if (wetCond == 0 && randomness > 2.25 && randomness <= 4.5)
            pC += 65;
        else if (wetCond == 0 && randomness > 4.5)
            pC += 45;
        else if (wetCond == 0 && randomness <= 2.25)
            pC += 75;

        // pC > 90% aggresive only
        // pC > 80% 80% agg 
        // pC > 60% 70% agg
        // pC > 50% 50% agg
        // pC < 50% 30% agg
        pC = pC/4;
        System.out.println("Chances of COM: " + pC);
        int COM = 0;
        if (pC >= 90)
        {
            int agg[] = {1,1,1,1,1,1,1,1,1,0};
            COM = agg[r.nextInt(agg.length)];
        }
        else if (pC >= 80)
        {
            int agg[] = {1,1,1,1,1,1,1,1,0,0};
            COM = agg[r.nextInt(agg.length)];
        }
        else if (pC >= 70)
        {
            int agg[] = {1,1,1,1,1,1,1,0,0,0};
            COM = agg[r.nextInt(agg.length)];
        }
        else if (pC >= 50)
        {
            int agg[] = {1,1,1,1,1,0,0,0,0,0};
            COM = agg[r.nextInt(agg.length)];
        }
        else 
        {
            int agg[] = {1,1,1,0,0,0,0,0,0,0};
            COM = agg[r.nextInt(agg.length)];
        }
        return COM;
    }

    void analysis(double rating, int tyreWear, int wetCond, double randomness, int teamCOM)
    {
        int pA = 0; // percent chances of accident
        // wet condition 15-22% is avg dry cond <7% is avg 
        if (rating>=4.5)
            pA += 5;
        else if (rating>=4)
            pA += 10;
        else if (rating>=3.5)
            pA += 20;
        else
            pA += 25;  
            
        if (tyreWear>=80)
            pA += 50;
        else if (tyreWear >= 70)
            pA += 45;
        else if (tyreWear >= 60)
            pA += 40;
        else if (tyreWear >= 40)
            pA += 25;
        else if (tyreWear >= 30)
            pA += 20;
        else if (tyreWear >= 20)
            pA += 10;
        else if (tyreWear > 10)
            pA += 7.5;
        else 
            pA += 2.5;

        if (wetCond == 1)
            pA = 40;
        else
            pA = 10;

        if (wetCond == 1 && randomness >2.5 && randomness <= 5)
            pA += 45;
        else if (wetCond == 1 && randomness > 5)
            pA += 75;
        else if (wetCond == 1 && randomness <=2.5)
            pA += 20;
        else if (wetCond == 0 && randomness > 2.25 && randomness <= 4.5)
            pA += 15;
        else if (wetCond == 0 && randomness > 4.5)
            pA += 25;
        else if (wetCond == 0 && randomness <= 2.25)
            pA += 5;

        if (teamCOM == 1)
            pA += 25;
        else    
            pA += 10;

        System.out.println("Chances of accident: " + pA/5);
    }

    void driver()
    {
        System.out.println("DRIVER DETAILS");
        
        Persons p = new Persons();
        
        String name = p.name();        
        double rating = rating();
        int tyreWear = tyreWear(); //0-30% good, 30-60% average, 60-100% bad
        int wetCond = wetCond(); //0-no, 1-yes
        double randomness = randomness(rating,tyreWear,wetCond); // 2.5-4.5 avg on dry 2.5-5 avg on wet 
        

        System.out.println("Name: " + name);

        if (rating>=4.5)
            System.out.println("Rating: \u001B[35m" + rating + "\u001B[37m");
        else if (rating>=4)
            System.out.println("Rating: \u001B[32m" + rating + "\u001B[37m");
        else if (rating >=3.5)
            System.out.println("Rating: \u001B[33m" + rating + "\u001B[37m");    
        else
            System.out.println("Rating: \u001B[31m" + rating + "\u001B[37m");    
        
        
        if (tyreWear>=70)
            System.out.println("Tyre Wear: \u001B[31m" + tyreWear + "\u001B[37m");
        else if (tyreWear >= 40)
            System.out.println("Tyre Wear: \u001B[33m" + tyreWear + "\u001B[37m");
        else if (tyreWear >= 15)
            System.out.println("Tyre Wear: \u001B[32m" + tyreWear + "\u001B[37m");
        else
            System.out.println("Tyre Wear: \u001B[35m" + tyreWear + "\u001B[37m");
        
        if (wetCond == 1)
            System.out.println("Wet Conditions: \u001B[33m" + wetCond + "\u001B[37m");
        else
            System.out.println("Wet Conditions: \u001B[32m" + wetCond + "\u001B[37m");
        
        //System.out.println("Randomness: \u001B[35m" + randomness + "\u001B[37m");
        if (wetCond == 1 && randomness >2.5 && randomness <= 5)
            System.out.println("Randomness: \u001B[33m" + randomness + "\u001B[37m");
        else if (wetCond == 1 && randomness > 5)
            System.out.println("Randomness: \u001B[31m" + randomness + "\u001B[37m");
        else if (wetCond == 1 && randomness <=2.5)
            System.out.println("Randomness: \u001B[32m" + randomness + "\u001B[37m");
        else if (wetCond == 0 && randomness > 2.25 && randomness <= 4.5)
            System.out.println("Randomness: \u001B[32m" + randomness + "\u001B[37m");
        else if (wetCond == 0 && randomness > 4.5)
            System.out.println("Randomness: \u001B[33m" + randomness + "\u001B[37m");
        else if (wetCond == 0 && randomness <= 2.25)
            System.out.println("Randomness: \u001B[35m" + randomness + "\u001B[37m");
        
        int teamCOM = teamCOM(rating, tyreWear, wetCond, randomness);//0 - defensive, 1 - aggressive
        if(teamCOM == 1)
            System.out.println("Team COM:\u001B[33m " + teamCOM+ "\u001B[37m");
        else
            System.out.println("Team COM:\u001B[32m " + teamCOM+ "\u001B[37m");
        
        analysis(rating, tyreWear, wetCond, randomness, teamCOM);

    }
    public static void main(String[] args) {
        System.out.println("\u001B[36mWe are going to check what driver get's more accident's happen with this program!\u001B[37m");
        
        accident a = new accident();
        for(int i = 1; i <= 100; i++)
        {
            System.out.println("\n\n"+i);
            a.driver();
        }

    }
}
