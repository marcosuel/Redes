import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class GameServer {
	public static void main(String args[]){
         System.setSecurityManager(new RMISecurityManager());
         System.setProperty( "java.rmi.server.hostname", "127.0.0.1" );
        try{
            LocateRegistry.createRegistry(1099);
            iGame aGame = new GameServant();
            iGame stub = (iGame) UnicastRemoteObject.exportObject(aGame,0);
			Naming.rebind("Game", (Remote) aGame); 
            System.out.println("Game server ready");
        }catch(Exception e) {
            System.out.println("Game server main " + e.getMessage());
        }
    }
}