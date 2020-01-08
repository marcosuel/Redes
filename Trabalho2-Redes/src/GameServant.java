import java.rmi.RemoteException;
import java.util.Arrays;

public class GameServant implements iGame{
	Game game;
	int first;
	int last;
	int cont;
	boolean reset = false;
	
	public GameServant() throws RemoteException {
		this.game = new Game();
		this.first = 0;
		this.last = 0;
		this.cont = 0;
	}
	
	
	@Override
	public String getCurrentCards() throws RemoteException {
		return Arrays.toString(game.getCurrentCards());
	}

	@Override
	public void drawCard(int num) throws RemoteException {
		if(reset) {
			if(!game.checkPair(first, last))	game.resetCard(first, last);
			reset = false;
		}
		if(cont == 0) {
			first = num;
			game.drawCard(first);
			cont++;
		} else if(cont == 1) {
			last = num;
			game.drawCard(last);
			cont = 0;
			reset = true;
		}
	}

}
