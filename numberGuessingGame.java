import java. util. Scanner;

import java.lang.Math;

public class numberGuessingGame {
    
     public static void main(String[] args)
      {
        Scanner sc = new Scanner(System.in);

        int number = (int)(Math.random()*100)+1;
        int trail=10;
        boolean crt=false;

        System.out.print("A number is choosen between 1 and 100...");
        System.out.println("Guess the number within the "+trail+" trails.");

        while(trail > 0)
        {
            System.out.println("Enter your guess:");
            int guess=sc.nextInt();

            if (number == guess)
            {
                System.out.println("Congrats!! ,You won the game.");
                System.out.println("You guessed within "+(10-trail+1)+" chances.");
                System.out.println("Your score is "+(100-((10-trail)*10)) +" out of 100.");
                crt = true;
                break;
            }
            else if (guess > number)
            {
                System.out.println("Your guess too high.");
                System.out.println("You have only "+(trail-1)+" chances left.");
                trail--;
            }
            else
            {
                System.out.println("Your guess is too low.");
                System.out.println("You have only "+(trail-1)+" chances left.");
                trail--;
            }
            
        }

        if(crt == false)
        {
           System.out.println("Your chances are over.Your score is zero.");
           System.out.println("Better luck next time!") ;
        }
        
    }
}
