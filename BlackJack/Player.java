import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Player here.
 *
 * @author (Larson)
 * @version (a version number or a date)
 */
public class Player
{
    private String name;
    private int cash;
    private int handTotal;
    public ArrayList<Card> hand;
    /**
     * Constructor for objects of class Player
     */
    public Player(String nm, int c)
    {
        this.name = nm;
        this.cash = c;
    }    
    public int bet(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your bet");
        int b = scan.nextInt();
        this.cash -= b;
        return b;
    }    
    public int handTotal(){
        int total = 0;
        int aceCount = 0;
        for(Card c : hand){
            if(c.getValue() == 1){
                aceCount += 1;
            }
            total += c.getValue();
        }        
        if(aceCount > 0 && total + 10 < 22){
            total += 10;
        }       
        return total;
    }    
    public String toString(){
        return "";
    }    
    public int getCash(){
        return this.cash;
    }
    public void addCash(int a){
        this.cash += a;
    }       
}

