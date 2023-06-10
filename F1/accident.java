package F1;
import Hotel.Persons;
import java.util.*;


// import Hotel.Persons;
//driver, rating, teamCOM, tyreWear, WetCond, randomness, analysis
public class accident {
    Random r = new Random();
    static ArrayList<Double> analysisWet= new ArrayList<Double>();
    static ArrayList<Double> analysisDry= new ArrayList<Double>();
    static int wet = 0; //0 - dry 1 - wet

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
        System.out.println("Chances of COM: " + pC + "%");
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

    double analysis(double rating, int tyreWear, int wetCond, double randomness, int teamCOM)
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
            pA += 5;
        else 
            pA += 2.5;

        if (wetCond == 1)
            pA = 25;
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
            pA += 20;
        else    
            pA += 5;

        
        System.out.println("Chances of accident: " + pA/5 + "%"); /*HAVE TO COLORISE THIS */

        return pA/5;
    }

    double driver()
    {
        System.out.println("DRIVER DETAILS");
        
        Persons p = new Persons();
        
        String name = p.name();        
        double rating = rating();
        int tyreWear = tyreWear(); //0-30% good, 30-60% average, 60-100% bad
        int wetCond = wetCond(); //0-no, 1-yes
        double randomness = randomness(rating,tyreWear,wetCond); // 2.5-4.5 avg on dry 2.5-5 avg on wet 
        
        if (wetCond == 1)
            wet = 1;
        else
            wet = 0;


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
            System.out.println("Tyre Wear: \u001B[31m" + tyreWear + "%\u001B[37m");
        else if (tyreWear >= 40)
            System.out.println("Tyre Wear: \u001B[33m" + tyreWear + "%\u001B[37m");
        else if (tyreWear >= 15)
            System.out.println("Tyre Wear: \u001B[32m" + tyreWear + "%\u001B[37m");
        else
            System.out.println("Tyre Wear: \u001B[35m" + tyreWear + "%\u001B[37m");
        
        if (wetCond == 1)
            System.out.println("Wet Conditions: \u001B[33m" + "YES" + "\u001B[37m");
        else
            System.out.println("Wet Conditions: \u001B[32m" + "NO" + "\u001B[37m");
        
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
            System.out.println("Team COM:\u001B[33m " + "YES"+ "\u001B[37m");
        else
            System.out.println("Team COM:\u001B[32m " + "NO"+ "\u001B[37m");
        
        return analysis(rating, tyreWear, wetCond, randomness, teamCOM);

    }


    double mode(double arr[])
    {
        int counter = 0;
        int maxCount = 0;
        double number = 0;
        for(int i = 0; i<arr.length; i++)
        {
            if(i==0)
            {
                counter++;
                maxCount = counter;
                number = arr[i];
            }
            else if(i!=0 && arr[i] == arr[i-1])
            {
                counter++;   
            }
            else    
            {
                if (counter >= maxCount)
                {
                    maxCount = counter;
                    number = arr[i-1];
                }
                counter = 1;
            }
        }
        if (counter >= maxCount)
        {
            number = arr[arr.length-1];
        }    
        return number;
    }
    void probability() 
    {
        double sumOfWet = 0, sumOfDry = 0;
        Collections.sort(analysisDry);
        Collections.sort(analysisWet);

        double arrOfWet[] = new double[analysisWet.size()];
        double arrOfDry[] = new double[analysisDry.size()];// arrays for median finding 


        System.out.println("\nTotal wet races: " + analysisWet.size());
        for(int i = 0; i < analysisWet.size(); i++)
        {
            //System.out.println(analysisWet.get(i));
            sumOfWet += analysisWet.get(i);
            arrOfWet[i] = analysisWet.get(i);
        }

        System.out.println("Total dry races: " + analysisDry.size());
        for(int i = 0; i < analysisDry.size(); i++)
        {
            //System.out.println(analysisDry.get(i));
            sumOfDry += analysisDry.get(i);
            arrOfDry[i] = analysisDry.get(i);
        }
        
        double meanOfWet = sumOfWet / analysisWet.size();
        double meanOfDry= sumOfDry / analysisDry.size();

        System.out.println("\nMean of chances of accident in wet conditions: " + meanOfWet 
        + "%\nMean of chances of accident in dry conditions: " + meanOfDry + "%");

        if(analysisWet.size()!=0)
        {
            if (analysisWet.size() % 2 != 0) // odd
            {
                int medianPOS = (analysisWet.size() + 1) / 2;
                double medianOfWet = arrOfWet[medianPOS-1];
                System.out.println("\nMedian of chances of accident in wet conditions: " + medianOfWet + "%");
            }
            else
            {
                int medianPOS1 = (analysisWet.size() / 2);
                double medianOfWet = (arrOfWet[medianPOS1-1] + arrOfWet[medianPOS1])/2;
                System.out.println("\nMedian of chances of accident in wet conditions: " + medianOfWet + "%");
            }
        }
        if(analysisDry.size()!=0)
        {
            if(analysisDry.size() % 2 != 0)
            {
                int medianPOS = (analysisDry.size() + 1) /2;
                double medianOfDry = arrOfDry[medianPOS-1];
                System.out.println("Median of chances of accident in dry conditions: " + medianOfDry + "%");
            }
            else
            {
                int medianPOS1 = (analysisDry.size() / 2);
                double medianOfDry = (arrOfDry[medianPOS1-1] + arrOfDry[medianPOS1])/2;
                System.out.println("Median of chances of accident in dry conditions: " + medianOfDry + "%");
            }
        }
        //MODE FINDER 
        double modeOfWet = mode(arrOfWet);
        double modeOfDry = mode(arrOfDry);

        System.out.println("\nMode of chances of accident in wet conditions: " + modeOfWet + 
        "%\nMode of chances of accident in dry conditions: " + modeOfDry + "%");

    }

    public static void main(String[] args) {
        System.out.println("\u001B[36mWe are going to check what driver get's more accident's happen with this program!\u001B[37m");
        
        accident a = new accident();
        for(int i = 1; i <= 100; i++)
        {
            System.out.print("\n\n"+i + ") ");
            double chanceOfAccident = a.driver();
            //System.out.println("Chance of accident: " + chanceOfAccident);
            //System.out.println("Wet Cond: " + wet);

            if (wet == 1)
                analysisWet.add(chanceOfAccident);
            else
                analysisDry.add(chanceOfAccident);

        }
        System.out.println("\n\n\u001b[34mANALYSIS OF THE CHANCE OF ACCIDENT\u001b[m");
        a.probability();
        
    }
}
