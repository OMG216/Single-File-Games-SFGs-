import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
public class Wordle_Clone{
    public static String getWord(int a) throws IOException{
        String path = "C:\\Users\\deepa\\.vscode\\java\\Random_Programs\\SFG\\valid-wordle-words.txt";
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        for(int i = 0;i < a - 1;i++){
            br.readLine();
        }
        String word = br.readLine();
        br.close();
        return word;
    }

    public static boolean isTheWord(String a,String b){
        if(a.equals(b)){
            return false;
        }
        char [] ew = {'_','_','_','_','_'};
        char [] s = {' ',' ',' ',' ',' '};
        for(int i = 0;i < 5;i++){
            for(int j = 0;j < 5;j++){
                if(b.charAt(i) == a.charAt(j)){
                    ew[i] = b.charAt(i);
                    if(i == j){
                        s[i] = '.';
                    }
                    else{
                        s[i] = ' ';
                    }
                }
            }
        }
        for(int i = 0;i < 5;i++){
            System.out.print(ew[i]);
            System.out.print(s[i]);
        }
        return true;
    }
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random(); 
        int a = rdm.nextInt(14855);
        String g,w = getWord(a);
        boolean f = true;
        System.out.print(w);
        while(f){
            System.out.println("");
            System.out.print("Enter your guess:");
            g = sc.next();
            f = isTheWord(w,g);
        }
        System.out.print("Congratulations");
        sc.close();
    }
}