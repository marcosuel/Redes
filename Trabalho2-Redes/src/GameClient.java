import java.rmi.*;


public class GameClient {

	public static void main(String[] args) {
		int cardNumber = 0;
		if(args.length > 0)  cardNumber = Integer.parseInt(args[0]);
		
 		System.out.println("Card number = " + cardNumber);
 		
 		if(System.getSecurityManager() == null){
        	System.setSecurityManager(new RMISecurityManager());
        } else System.out.println("Already has a security manager, so cant set RMI SM");
 		
 		
        iGame aGame = null;
        try{
            aGame  = (iGame) Naming.lookup("//127.0.0.1:1099/Game");
 			System.out.println("Found server");
 			
 			aGame.drawCard(cardNumber);
 			System.out.println(aGame.getCurrentCards());
 			
		}catch(Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}
	}

}
