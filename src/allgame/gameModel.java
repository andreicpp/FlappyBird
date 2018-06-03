package allgame;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

public class gameModel {
	
	private int WIDTH = 1000, HEIGHT = 600, BIRD_SIZE = 20;
	
	private ArrayList<Rectangle> columns;
	private Rectangle bird;
	private boolean gameOver, started;
	private Random rand;
	public int ticks, yMotion, score;
	private int speed = 10;
	
	
	public gameModel()
	{
		bird = new Rectangle(WIDTH / 2,  HEIGHT / 2 , BIRD_SIZE , BIRD_SIZE);
		columns = new ArrayList<Rectangle>(2);
		rand = new Random();
		yMotion = 0;
		
		addColumn(true);
		addColumn(true);
		addColumn(true);
	}
	
	private void addColumn(boolean start)
	{
		int space = 250;
		int width = 100;
		int height = 50 + rand.nextInt(300);
		
		if(start)
		{
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 100, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		else
		{
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 100, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 1).x, 0, width, HEIGHT - height - space));
		}
	}
	
	public void moveColumns()
	{
		for(int i=0; i< columns.size(); i++)
		{
			Rectangle column = columns.get(i);
			column.x -= speed;
		}
	}
	
	public void deleteColumns() {
		for(int i = 0; i < columns.size(); i++)
		{
			Rectangle column = columns.get(i);
			
			if (column.x + column.width <0)
			{
				columns.remove(column);
				
				if(column.y == 0)
				addColumn(false);
			}
		}
	}
	
	private void scoreAdd(Rectangle column)
	{
		if (column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 10 && bird.x + bird.width / 2 < column.x + column.width / 2 + 10)
		{
			score++;
		}
	}
	
	private void isGameOver(Rectangle column)
	{
		if(column.intersects(bird) || (bird.y > HEIGHT - 120) || (bird.y < 0))  //uderzył sie o kolumne lub wyleciał 
		{
			gameOver = true;
		}
	}
	
	public void checkForGameOver()
	{
		for (Rectangle column : columns)
		{
			this.scoreAdd(column);
			this.isGameOver(column);
		}
	}
	
	public void jump()
	{
		if(!started)
		{
			started = true;
		}
		
		if(!gameOver && started)
		{
			if(yMotion > 0)
			{
				yMotion = 0;
			}
			yMotion -= 15;
		}
		
		if(gameOver)
		{
			bird = new Rectangle(WIDTH / 2 , HEIGHT / 2 , BIRD_SIZE , BIRD_SIZE);//!!
			columns.clear();
			yMotion = 0;
			score = 0;

			
			addColumn(true);
			addColumn(true);
			addColumn(true);
			
			gameOver = false;	
		}
	}
	
	public void moveBird()
	{
		bird.y += yMotion; 
	}
	
	public void  addBirdPos()
	{
		yMotion += 2;
	}

//SETTERS BEGIN

	public void setGameOver(boolean gameOverNew)
	{
		this.gameOver = gameOverNew;
	}
	
	public void setGameStarted(boolean gameStartedNew)
	{
		this.started = gameStartedNew;
	}
	
	public void setBird(Rectangle newBird)
	{
		this.bird = newBird;
	}
	
//SETTERS END
	
//GETTERS BEGIN	
	public Rectangle getBird()
	{
		return this.bird;
	}
	
	public ArrayList<Rectangle> getColumns()
	{
		return this.columns;
	}
	
	public boolean getStarted() {
		return this.started;
	}
	
	public boolean getGameOver() {
		return this.gameOver;
	}
	
	public int getScore()
	{
		return this.score;
	}
	public int getYMotion()
	{
		return yMotion;
	}
}
//GETTERS END
