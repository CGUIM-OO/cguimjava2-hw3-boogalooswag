import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * Try to write some comments for your codes (methods, 10 points)
 */
public class HW3 {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("input N(deck of cards):");
		//String testn= sc.nextLine(); 
		int nDeck=1;
		//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
		Deck deck=new Deck(nDeck);
		
		//TODO: please check your output, make sure that you print newCard and newCard2 on your screen  (10 points)
		//TODO: please add new fields and methods to Card class (25)
		//Use enumerated type in Card (10 points)
		//Constructor (5 points)
		//printCard (5 points)
		//getSuit (5 points)
		
		
		class Deck{
			private ArrayList<Card> cards;
			//TODO: Please implement the constructor (30 points)
			public Deck(int nDeck){
				cards=new ArrayList<Card>();
				//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
				//Hint: Use new Card(x,y) and 3 for loops to add card into deck
				//Sample code start
				//Card card=new Card(1,1); ->means new card as clubs ace
				//cards.add(card);
				//Sample code end

			}	
			//TODO: Please implement the method to print all cards on screen (10 points)
			public void printDeck(){
				//Hint: print all items in ArrayList<Card> cards, 
				//TODO: please implement and reuse printCard method in Card class (5 points)

			}
			public ArrayList<Card> getAllCards(){
				return cards;
			}
		}
		/**
		 * Description: TODO: please add description here
		 */
		class Card{
			private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
			private int rank; //1~13
			/**
			 * @param s suit
			 * @param r rank
			 */
			public Card(int s,int r){
				suit=s;
				rank=r;
			}	
			//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
			public void printCard(){
				//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace

			}
			public int getSuit(){
				return suit;
			}
			public int getRank(){
				return rank;
			
		}
		public Card getOneCard() {
			// TODO Auto-generated method stub
			return null;
		
		Card newCard=deck.getOneCard();
		newCard.printCard();
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		deck.shuffle();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	/**
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=1){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
