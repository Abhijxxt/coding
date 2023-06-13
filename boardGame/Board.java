package boardGame;
import java.util.*;
public class Board {
                        //0,  1,  2,  3,  4
    char board[][] = {  {'O','x','x','x','x'},
              /*13 */   {'x','x','x','x','x'},//5
              /*12 */   {'x','x','x','x','x'},//6
                        {'x','x','x','x','x'}};//7
                       //11, 10,  9,  8,   
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
            if(pos >=14)
            {
                pos = pos - 14;
            }
            
            //System.out.println(pos);
            if(pos>=0&& pos<=4) //top row board[0][pos]
            {
                board[0][pos] = 'O';
            }
            else if(pos>=5 && pos <=7) //right column board[pos-4][MAX_ROW_INDEX] ; pos-4= 1,2,3,... column
            {
                board[pos-4][4] = 'O';
            }
            else if(pos>=8 && pos<=11)  //bottom row board[MAX_COLUMN_INDEX][Final val - pos] ; final val - pos = 0,1,2,3(reverse) row
            {
                board[3][11-pos] = 'O';
            }
            else if(pos>=12 && pos<=13) //left column board[final val + 1 - pos][0] ; ensures index > 1 (reverse order) column
            {
                board[14-pos][0] = 'O';
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
                        System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }//MAIN PRINTING ENDS

    }
    public static void main(String[] args) {
        
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
            System.out.println("You rolled: " + roll + "\n");
            g.boardPrint(roll);

            
        }
        sc.close();
        System.out.println("GAME EXITTED");
    }
}
