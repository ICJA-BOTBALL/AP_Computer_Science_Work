/**
 *  A class that models the game of Lucky Sevens. 
 *  
 *  @author: Hershel Thomas 
 *  @AP Computer Science A, Virtual Virginia
 */
import java.util.*;
import java.lang.Math;
import java.util.Scanner;

public class LuckySevens
{
    int userBalance;
    int balance;
    int numOfTurns;
    int maxBalance;
    int maxBalTurn;
    int sumSeven;
    public LuckySevens(int userBalance)
    {
        if (userBalance < 0)
        {
            balance = 0;
        } else
        {
            balance = userBalance;
        }
        numOfTurns = 0;
        maxBalance = balance;
        maxBalTurn = 0;
        sumSeven = 0;
    }
    public int rollDie()
    {
        int standardRoll;
        standardRoll = (int)(Math.random() * 6 + 1);
        return standardRoll;
    }
    public void playTurn()
    {
        int sumOf7;
        sumOf7 = rollDie() + rollDie();
        if (sumOf7 == 7)
        {
            sumSeven = sumSeven + 1;
            balance = balance + 4;
        } else
        {
            balance = balance - 1;
        }
        numOfTurns = numOfTurns + 1;
        if (balance > (maxBalance))
        {
            maxBalance = balance; 
            maxBalTurn = numOfTurns;
        }
    }
    public void playGame()
    {
        while (balance > 0) 
        {
            playTurn();
        }
        System.out.println(getGameReport());
    }
    public String getGameReport()
    {
        System.out.println("At turn " + String.valueOf(maxBalTurn) + " you possesed the most money and could have walked away with " + String.valueOf(maxBalance) + " dollars");
        System.out.print("The percantage of your turns where the sum of the dice rolls equaled seven was ");
        try 
        {
            System.out.print((int) (((1.0 * sumSeven) / numOfTurns) * 100));
        } catch(Exception error)
        {
            System.out.print("zero");
        }
        System.out.print(" percent");
        System.out.println("");
        System.out.println("The amount of turns you had was ");
        return String.valueOf(numOfTurns);
    }
}
