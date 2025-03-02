import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Simon {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Random rdm = new Random();
        List<Character> list = new ArrayList<>();
        for(int i = 0;i < 32;i++){
            String s = "RGBY";
            list.add(s.charAt(rdm.nextInt(4)));
            System.out.println("Welcome to the simon game!!!");
            System.out.println("Rules: a sequence of colours will be shown and you have to repeat the sequence.\n");
            System.out.println("Level:" + i+1);
            for(int j = 0;j <= i;j++){
                System.out.print("\r" + list.get(j));
                Thread.sleep(2000 - i*50);
                System.out.print("\r   ");
                Thread.sleep(32 - i);
            }
            for(int j = 0;j <= i;j++){
                char c = sc.next().charAt(0);
                if(c != list.get(j)){
                    System.out.print("Oops! Seems like you have FAILED!!!!");
                    System.exit(0);
                }
            }
            System.out.println("You have WON this stage!\n");
        }
        System.out.print("We no longer have the capacity to test your memmory!!!!");
    }
}
