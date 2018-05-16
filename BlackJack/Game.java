import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 * @author (Larson)
 * @version (a version number or a date)
 */
public class Game
{
    private Player u;
    private Player d;
    private Deck deckOfCards;   
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        this.deckOfCards = new Deck();
        u = new Player("U", 100);
        d = new Dealer();
        Greeting();
        playGame();
    }
    
    public void playGame(){
        this.deckOfCards.initializeDeck();
        this.deckOfCards.shuffle();
        int b = u.bet();      
        this.u.hand = this.deckOfCards.deal();
        this.d.hand = this.deckOfCards.deal();    
        playerTurn();
        dealerTurn();       
        int win = Winner();     
        if(win == -1){
            DealerWins();
            System.out.println("You have " +u.getCash() + " dollars");
        }
        else if(win == 0){
            TiePay();
            u.addCash(b);
            System.out.println("You have " + u.getCash() + " dollars");
        }
        else{
            PlayerWins();
            u.addCash(2*b);
            System.out.println("You have " + u.getCash() + " dollars");
        }     
        System.out.println("Do you want to play another game? (y/n)");
        Scanner scan = new Scanner(System.in);
        String cont = scan.nextLine();       
        if(cont.equals("y")){
            playGame();
        }
        else{
            endGame();
        }        
    }    
    public int Winner(){
        int pTotal = u.handSize();
        int dTotal = d.handSize();        
        // if 1 player wins, if -1 dealer wins, if 0 tie
        int winner = 0;                
        if(pTotal > 21 && dTotal <= 21){
            winner = -1;
        }
        else if(dTotal > 21 && pTotal <= 21){
            winner = 1;
        }
        else if(dTotal == pTotal){
            winner = 0;
        }
        else if(pTotal <= 21 && dTotal <= 21){
            if(pTotal > dTotal){
                winner = 1;
            }
            else{
                winner = -1;
            }
        }        
        return winner;
    }    
    public void endGame(){
        GameOver();
    }   
    public void Greeting(){
        System.out.println("Welcome to BlackJack");
        System.out.println("\nYou have " + u.getCash() + " dollars");
        System.out.println();
    }    
    public void Line1(){
        printPlayerHand();        
        System.out.println("\nThe dealer is showing: ");
        System.out.println(d.hand.get(0));        
        System.out.println("\nChoose one of the following:");
        System.out.println("hit");
        System.out.println("stand");
    }    
    public void PlayerWins(){
        System.out.println("\nYou win");
    }   
    public void TiePay(){
        System.out.println("\nIt's a tie");
    }    
    public void DealerWins(){
        System.out.println("\nThe dealer wins");
    }    
    public void GameOver(){
        System.out.println("Your final amount of money " + + u.getCash() + " dollars");
        System.out.println();
        System.out.println("Good Game");
    }    
    public void printPlayerHand(){
        System.out.println("\nYour hand is: ");
        for(Card c : u.hand){
            System.out.println(c);
        }
    }    
    public void playerTurn(){
        while(true){
            if(u.handSize() >= 21){
                printPlayerHand();
                System.out.println("\nThe dealer is showing: ");
                System.out.println(d.hand.get(0));
                break;
            }           
            Line1();            
            Scanner scan = new Scanner(System.in);
            String choice = scan.nextLine();            
            if(choice.equals("hit")){
                this.u.hand.add(deckOfCards.getFirstCard());
            }else{
                break;
            }
        }
    }
    public void dealerTurn(){
        while(d.handSize() < 17){
            this.d.hand.add(deckOfCards.getFirstCard());
        }        
        System.out.println("\nThe dealer has: " + d.handSize());
        for(Card c : d.hand){
            System.out.println(c);
        }
    }    
    public void showHands(){
        System.out.println("Player");
        for(Card c: u.hand){
            System.out.println(c);
        }
        System.out.println("Dealer");
        for( Card c: d.hand){
            System.out.println(c);
        }
    }
}
