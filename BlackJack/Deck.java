
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Deck here.
 *
 * @author (Larson)
 * @version (a version number or a date)
 */
public class Deck
{
    private ArrayList<Card> deck;
    /**
     * Constructor for objects of class Deck
     */
    public Deck()
    {
        this.deck = new ArrayList();
    }    
    public void initializeDeck(){
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        String[] ranks = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
                            "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        int[] value = {1,2,3,4,5,6,7,8,9,10,10,10,10};
        for (int h = 0; h < 4; h++){
            for (int f = 0; f < 13; f++ ){
                deck.add(new Card(value[f], suits[h], ranks[f]));
            }
        }
    }     
    public void shuffle(){
        ArrayList<Card> temp = new ArrayList();
        Random rng = new Random();
        int index;        
        for(int i = 0; i < 52; i++){
            index = rng.nextInt(this.deck.size());
            temp.add(this.deck.get(index));
            this.deck.remove(index);
        }        
        this.deck = temp;
    }    
    public ArrayList<Card> deal(){
        ArrayList<Card> hand = new ArrayList();
        for(int i = 0; i < 2; i++){
            hand.add(this.deck.get(0));
            this.deck.remove(0);
        }       
        return hand;
    }    
    public Card getFirstCard(){
        Card temp = this.deck.get(0);
        this.deck.remove(0);
        return temp;
    }
}
