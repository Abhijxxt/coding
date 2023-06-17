package boardGame;
import java.util.*;
public class Board {
                        //0,  1,  2,  3,  4 , 5 , 6   7   8 
    char board[][] = {  {'O','x','x','x','x','x','x','x','x'},
              /*31 */   {'x','x','x','x','x','x','x','x','x'},//9
              /*30 */   {'x','x','x','x','x','x','x','x','x'},//10
                /*29 */ {'x','x','x','x','x','x','x','x','x'},//11
                /*28 */ {'x','x','x','x','x','x','x','x','x'},//12
                /*27 */ {'x','x','x','x','x','x','x','x','x'},//13
                /*26 */ {'x','x','x','x','x','x','x','x','x'},//14
                /*25 */ {'x','x','x','x','x','x','x','x','x'},//15
                /*24 */ {'x','x','x','x','x','x','x','x','x'} //16                       
                    };// 24  23   22  21  20  19  18  17
                          
    int dice[] = {1,2,3,4,5,6};
    int pos= 0;
    void clearBoard()
    {
        for(int i =0; i<board.length;i++)
        {
            for(int j = 0; j<board[0].length; j++)
            {
                if(board[i][j] != 'x')
                    board[i][j] = 'x';
            }
        }
    }
    void boardPrint(int roll)
    {
        if(roll == 0 || roll >6)
        {
            pos+=0;
        }
        else
        {
            clearBoard();
            pos += roll;
            if(pos >=32) //LAST NUMBER + 1
            {
                pos = pos - 32;
            }
            
            //System.out.println(pos);
            if(pos>=0&& pos<=8) //top row board[0][pos]
            {
                board[0][pos] = 'O';
            }
            else if(pos>=9 && pos <=16) //right column board[pos-4][MAX_ROW_INDEX] ; pos-4= 1,2,3,... column
            {
                board[pos-8][8] = 'O';
            }
            else if(pos>=17 && pos<=24)  //bottom row board[MAX_COLUMN_INDEX][Final val - pos] ; final val - pos = 0,1,2,3(reverse) row
            {
                board[8][24-pos] = 'O';
            }
            else if(pos>=25 && pos<=31) //left column board[final val + 1 - pos][0] ; ensures index > 1 (reverse order) column
            {
                board[32-pos][0] = 'O';
            }
            
        }
    
         //MAIN PRINTING
            for(int i = 0; i<board.length; i++)
            {
                for(int j = 0 ; j<board[0].length; j++)
                {
                    if(i>0 && i <(board.length-1) && j>0 && j< (board[0].length-1) )
                        System.out.print("  ");
                    else 
                    {
                        if(board[i][j]=='O')
                            System.out.print("\u001b[31mO \u001b[37m");
                        else
                            System.out.print("\u001b[33m" + board[i][j] + " \u001b[37m");
                    }
                }
                System.out.println();
            }//MAIN PRINTING ENDS

    }
    public static void main(String[] args) {
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean flag = false;
        //int sum = 0;

        Board g = new Board();
        g.boardPrint(0);
        while(!flag)
        {
            System.out.print("\nRoll again Y/N: ");
            String x = sc.next();
            if(x.toLowerCase().equals("n"))
                break;
            
            int roll = g.dice[r.nextInt(g.dice.length)];
            System.out.println("\033[H\033[2J");
            System.out.println("You rolled: " + roll + "\n");
            g.boardPrint(roll);

            
        }
        sc.close();
        System.out.println("GAME EXITTED");
    }
}
