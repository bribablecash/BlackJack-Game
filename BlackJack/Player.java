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
    private String name;//name
    private int cash;//total cash
    private int handSize;//Hand total
    public ArrayList<Card> hand;//to hold Cards
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
        System.out.println("Please State Your Bet");
        int b = scan.nextInt();
        this.cash -= b;
        return b;
    }    
    public int handSize(){
        int total = 0;
        int aceTotal = 0;
        for(Card c : hand){
            if(c.getValue() == 1){
                aceTotal += 1;
            }
            total += c.getValue();
        }         
        if(aceTotal > 0 && total + 10 < 22){
            total += 10;
        }       
        return total;
    }    
    public String toString(){
        return null;
    }    
    public int getCash(){
        return this.cash;
    }
    public void addCash(int a){
        this.cash += a;
    }       
}

