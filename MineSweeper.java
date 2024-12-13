import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    public static char [][] getGrid(){
        Random rdm = new Random();
        char [][] grid = new char [5][5];
        int i,j,k,l;
        for(i = 0;i < 5;i++){
            for(j = 0;j < 5;j++){
                grid[i][j] = '0';
            }
        }
        for(i = 0;i < 5;i++){
            for(j = 0;j < 5;j++){
                if(rdm.nextInt(5) == 0){
                    grid[i][j] = '@';
                    for(k = i-1;k <= i+1;k++){
                        for(l = j-1;l <= j+1;l++){
                            if((k == i && l ==j) || k == -1 || k == 5 || l == -1 || l == 5 || grid[k][l] == '@'){
                                continue;
                            }
                            grid[k][l]++;
                        }
                    }
                }
            }
        }
        for(i = 0;i < 5;i++){
            for(j = 0;j < 5;j++){
                if(grid[i][j] == '0'){
                    grid[i][j] = '.';
                }
            }
        }
        return grid;
    }

    public static void printg(char[][] arr){
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static boolean isWin(char [][] arr,char [][] arr2){
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                if(arr[i][j] != '@' && arr2[i][j] == 'O'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        char [][] grid = getGrid();
        char [][] sgrid = new char [5][5];
        int i,j,k,l,x,y;
        boolean cont = false;

        for(i = 0;i < 5;i++){
            for(j = 0;j < 5;j++){
                sgrid[i][j] = 'O';
            }
        }

        printg(grid);

        while(!cont){
            printg(sgrid);
            System.out.println("Enter your square in x and y coordinates:");
            x = sc.nextInt();
            y = sc.nextInt();

            if(grid[y][x] == '@'){
                System.out.print("You lose!!!!!!!!!!");
                System.exit(0);
            }

            sgrid[y][x] = grid[y][x];

            if(grid[y][x] != '@'){
                for(k = y-1;k <= y+1;k++){
                    for(l = x-1;l <= x+1;l++){
                        if((k == y && l ==x) || k == -1 || k == 5 || l == -1 || l == 5 || grid[k][l] == '@'){
                            continue;
                        }
                        sgrid[k][l] = grid[k][l];
                    }
                }
            }

            cont = isWin(grid,sgrid);
        }
        
        System.out.println("You won!!!!!!!!!!!");
        sc.close();
    }
}
