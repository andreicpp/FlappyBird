package allgame;


public class MVCGame {

	public static void main(String [] args)
	{
		gameView theView = new gameView();
		gameModel theModel = new gameModel();
		gameController theController = new gameController(theView, theModel);
		
		theView.setVisible(true);
		
	}
	
}
