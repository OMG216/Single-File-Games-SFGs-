import java.util.Scanner;
public class Sudoku_Solver {

    static int [][] ogrid = {{5 ,3 ,0,0, 7, 0,  0, 0, 0},  
    {6, 0, 0,  1, 9, 5,  0, 0, 0 }, 
    {0, 9, 8,  0, 0, 0,  0, 6, 0  },
    {8, 0, 0,  0, 6, 0,  0, 0, 3  },
    {4, 0, 0,  8, 0, 3,  0, 0, 1  },
    {7, 0, 0,  0, 2, 0,  0, 0, 6  },
    {0, 6, 0,  0, 0, 0,  2, 8, 0  },
    {0, 0, 0,  4, 1, 9,  0, 0, 5  },
    {0, 0, 0,  0, 8, 0,  0, 7, 9  }};

    /* 5 3 4  6 7 8  9 1 2  
6 7 2  1 9 5  3 4 8  
1 9 8  3 4 2  5 6 7  
8 5 9  7 6 1  4 2 3  
4 2 6  8 5 3  7 9 1  
7 1 3  9 2 4  8 5 6  
9 6 1  5 3 7  2 8 4  
2 8 7  4 1 9  6 3 5  
3 4 5  2 8 6  1 7 9  
*/

/* 5 3 0  0 7 0  0 0 0  
6 0 0  1 9 5  0 0 0  
0 9 8  0 0 0  0 6 0  
8 0 0  0 6 0  0 0 3  
4 0 0  8 0 3  0 0 1  
7 0 0  0 2 0  0 0 6  
0 6 0  0 0 0  2 8 0  
0 0 0  4 1 9  0 0 5  
0 0 0  0 8 0  0 7 9  
*/
    
    static int [][] sgrid = ogrid;

    public static boolean isPossible(Pointer c,int a){
        int i,j,x = (c.getX()/3)*3,y = (c.getY()/3)*3;
        for(i = 0;i < 9;i++){
            if(sgrid[c.getY()][i] == a || sgrid[i][c.getX()] == a){
                return false;
            }
        }
        for(i = y;i <= y+2;i++){
            for(j = x;j <= x+2;j++){
                if(sgrid[i][j] == a){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSolved(){
        Pointer p1 = new Pointer(0,0,8,8);
        for(int i = 0;i < 81;i++){
            if(sgrid[p1.getY()][p1.getX()] == 0){
                return false;
            }
            if(!isPossible(p1,sgrid[p1.getY()][p1.getX()])){
                return false;
            }
            p1.next();
        }
        return true;
    }

    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        Pointer p = new Pointer(0,0,8,8);
        int i,j;

        /*System.out.println("Enter your Sudoku:");
        for(i = 0;i < 9;i++){
            for(j = 0;j < 9;j++){
                ogrid[i][j] = sc.nextInt();
                sgrid[i][j] = sc.nextInt();
            }
        }*/


        while(ogrid[p.getY()][p.getX()] != 0){
            p.next();
        }
        while(!isSolved()){
            boolean z = false;
            int v = sgrid[p.getY()][p.getX()];
            int s = (v == 0)?0:v;
            for(i = s+1;i <= 9;i++){
                z = true;
                if(isPossible(p,i)){
                    v = i;
                    p.next();
                    while(ogrid[p.getY()][p.getX()] != 0){
                        p.next();
                    }
                    break;
                }
                else if(i == 9){
                     z = false;
                }
            }
            if(!z){
                v = 0;
                p.previos();
                while(ogrid[p.getY()][p.getX()] != 0){
                    p.previos();
                }
            }
        }

        System.out.println("\n.\n.\n.\nThe Soulution is :");
        for(i = 0;i < 9;i++){
            for(j = 0;j < 9;j++){
                System.out.print(sgrid[i][j] + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}
