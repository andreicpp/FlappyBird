package allgame;


import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import allgame.gameModel;
import allgame.gameView;



public class gameController {
	
	private gameView theView;
	private gameModel theModel;
	
	public gameController (gameView theView, gameModel theModel)
	{
		this.theView = theView;
		this.theModel = theModel;
		
		this.theView.addJumpListener(new jumpListener());
		
		this.mainLoop();
	}
	
	public void mainLoop() 
	{
		while (!Thread.currentThread().isInterrupted())
		{	
			if(this.theModel.getStarted() && !this.theModel.getGameOver())
			{
				this.theModel.addBirdPos();
				this.theModel.deleteColumns();
				this.theModel.moveBird();
				this.theModel.checkForGameOver();
				this.theModel.moveColumns();
			}
			
			this.theView.setHero(this.theModel.getBird());
			this.theView.setScore(this.theModel.getScore());
			this.theView.setStarted(this.theModel.getStarted());
			this.theView.setGameOver(this.theModel.getGameOver());
			this.theView.setHero(this.theModel.getBird());
			this.theView.setColumns(this.theModel.getColumns());
			this.theView.rendererRepaint();
			
			try
			{
				Thread.sleep(30);
			}
			
			catch (InterruptedException e)
			{
				
			}

		}
	}
	
	
	public gameView getGameView() {
		return this.theView;
	}
	
	public gameModel getGameModel() {
		return this.theModel;
	}
	
	class jumpListener implements MouseListener{
		
		public void actionPerformed(ActionEvent e){
		
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			getGameModel().jump();
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
}
