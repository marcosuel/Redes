import java.rmi.*;

public interface iGame extends Remote{
	public String getCurrentCards() throws RemoteException;
	public void drawCard(int num) throws RemoteException;
}
