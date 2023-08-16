package conqueror;

import java.util.Random;

public class map {
    int pos_x, pos_y;
    boolean flag;
    String color = "";

    char MAP[][] = 
    {
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'}, 
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
            {'x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x','x'},
    }; //20 C 20 R

    int MAP_HEX[][] = 
    {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    };//20 C 20 R

    map(String color)
    {
        flag = true;
        Random r = new Random();
        this.pos_x = r.nextInt(MAP[0].length); //column
        this. pos_y = r.nextInt(MAP.length); //row  
        this.color = color;
    }

    void print()
    {
        System.out.println("\033[H\033[2J");
        for(int i=0; i<MAP_HEX.length; i++)
        {
            for(int j=0; j< MAP_HEX[0].length; j++)
            {
                if(MAP_HEX[i][j] == 1)
                {
                    
                    System.out.print(this.color + "\u001B[43m" + MAP[i][j] + " \u001B[40m\u001B[30m");
                }
                else
                    System.out.print("\u001B[30m" + MAP[i][j]+ " \u001B[40m\u001B[30m");
            }
            System.out.println();
        }
        System.out.println("\u001B[37m");
    }

    int freeSpace(int pos_x, int pos_y)
    {
        int top=1,bottom=1,left=1,right = 1; //0- not available 1 - available

        //RIGHT LEFT CHECK
        if(pos_y + 1 >= MAP_HEX[0].length) //TO EXPAND MAP CHANGE IT 
            right = 0;
        else if(pos_y - 1 <0)
            left = 0;
        else
        {
            if(MAP_HEX[pos_x][pos_y+1] == 1)
                right = 0;
            else if(MAP_HEX[pos_x][pos_y-1] == 1)
                left = 0;
            else 
            {
                left = 1;
                right = 1;
            }
        }

        //TOP DOWN CHECK
        if(pos_x + 1 >= MAP_HEX.length)
            bottom=0;
        else if(pos_x-1 <0)
            top=0;
        else
        {
            if(MAP_HEX[pos_x+1][pos_y] == 1)
                bottom = 0;
            else if(MAP_HEX[pos_x-1][pos_y] == 1)
                top = 0;
            else
            {
                top = 1;
                bottom = 1;
            }
        }

        int freeSpaceMapping[] = {top, bottom, left, right};
        Random r = new Random();
        int seed = r.nextInt(freeSpaceMapping.length);
        while(freeSpaceMapping[seed] == 0)
        {
            seed = r.nextInt(freeSpaceMapping.length);
        }
        //seed will always be a available space so the returning value is the pos of new entry
        if(top==0 && bottom==0 && left == 0 && right == 0)
            seed = 4;
        //System.out.println(seed);
        return seed;//0-top 1-bottom 2-left 3-right 4-no space avail
    }

    void create()
    {
           

        if(MAP_HEX[this.pos_x][this.pos_y] == 0)
        {
            //System.out.println(pos_x + " " + pos_y); 
            MAP[this.pos_x][this.pos_y] = 'x';
            MAP_HEX[this.pos_x][this.pos_y] = 1;
        }
        else
        {
            //Adding O to neighbouring territory of initial position
           
            int cases = freeSpace(this.pos_x,this.pos_y); // 0-top 1-bottom 2-left 3-right
            
            switch(cases)
            {
                case 0:
                    this.pos_x = this.pos_x-1;
                    break;
                case 1:
                    this.pos_x = this.pos_x+1;
                    break;
                case 2:
                    this.pos_y = this.pos_y-1;
                    break;
                case 3:
                    this.pos_y = this.pos_y+1;
                    break;
                case 4:
                    flag = false;
            }
            //System.out.println(this.pos_x + " " + this.pos_y); 
            MAP[this.pos_x][this.pos_y] = 'x';
            MAP_HEX[this.pos_x][this.pos_y] = 1;
            
        }
    }

    public static void main(String[] args) throws Exception {
        map c1 = new map("\u001B[33m");
        //map c2 = new map("\u001B[33m");
        for(int i =1 ; i<=50; i++)
        {
            c1.create();
            c1.print();
            Thread.sleep(800);
        }
        
        
      
    }
}
