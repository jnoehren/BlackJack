
package randomdeck;

import javax.swing.JOptionPane;

public class RandomDeck{
 
    
    public static void main(String[] args) {
       
       int limit = 21;
       int dealerStop= 17;
       int x=52;
       int[] deck = new int[x];
       int deckIndex=0; 
       
            for(int i=0;i<deck.length; i++){
                deck[i]=(i%12)+1;
                    if (deck[i]==11)
                        deck[i]=10;
                     if (deck[i]==12)
                        deck[i]=10;
                      if (deck[i]==13)
                        deck[i]=10;
            }
            for (int i = 0; i<deck.length;i++){
                int index = (int)(Math.random()*deck.length);
                int temp = deck[i];
                deck[i] = deck[index];
                deck[index]=temp;
            }       
        
        System.out.println("Dealers Cards");
        System.out.print("[ "+ deck[deckIndex] + " ]");
            int dealerTotal = deck[deckIndex];
                deckIndex = deckIndex +1;
        System.out.println("[ X ]");
            dealerTotal = dealerTotal + deck[deckIndex];
                deckIndex = deckIndex +1;
        
        System.out.println("Your Cards");
        System.out.print("[ "+ deck[deckIndex] + " ]");
            int yourTotal = deck[deckIndex];
                deckIndex = deckIndex +1;
        System.out.print("[ "+ deck[deckIndex] + " ]");
            yourTotal = yourTotal + deck[deckIndex];
                deckIndex = deckIndex +1;
        System.out.println("="+yourTotal);
       
        boolean s = false;
        while (s==false){          
            
            if (dealerTotal == limit){
                    System.out.println("Dealer hit 21 You Have FAILED");
                    s=true;
            }
            if (yourTotal == limit){
                    System.out.println("JACK POT 21 YOU WIN!!!!");
                    s=true;
            }
            else if( yourTotal!= limit && dealerTotal!=limit){ 
            
            String nString = JOptionPane.showInputDialog(null,"Do you want another card? \n 1 for yes \n 2 for no");
                int n = Integer.parseInt(nString);

            if (n==1){
                System.out.print("[ "+ deck[deckIndex] + " ]");
                    yourTotal = yourTotal + deck[deckIndex];
                        deckIndex = deckIndex +1;
                System.out.println("="+yourTotal);
                
                if (yourTotal <limit)
                    s=false;
                if (yourTotal > limit){
                    System.out.println("You went bust!!!");
                    s=true;
                }
            }
            if (n==2){
                s=true;
           }
           }
        }
        if (yourTotal > limit){
                    System.out.println("Game Over Try Again");
        }
        if (yourTotal < limit){
         System.out.println("Dealer's Total");
         System.out.println(dealerTotal);
         if (dealerTotal<dealerStop && dealerTotal<yourTotal){   
          boolean r = false;
                while(r == false){
                        System.out.print("[ "+ deck[deckIndex] + " ]");
                             dealerTotal = dealerTotal + deck[deckIndex];
                                 deckIndex = deckIndex +1;
                        System.out.println("="+dealerTotal);
                        if (dealerTotal>dealerStop)
                            r=true;
                        if (dealerTotal<dealerStop)
                            r=false;
                    
                }
        }       
        }
        if (dealerTotal<limit && yourTotal<limit){
            if (dealerTotal>yourTotal){
                System.out.println("You lost to a computer, how sad");
            }
            if (dealerTotal<yourTotal){
                System.out.println("Begginers luck! Lets Try Again");
            }
        }
        
        if (dealerTotal>limit && yourTotal<limit){
            System.out.println("Dealer Went Bust");
        }
    }
    
  }


