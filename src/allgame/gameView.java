package allgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import javax.swing.*;

public class gameView extends JFrame implements MouseListener, ActionListener{

	private static final long serialVersionUID = 1L;
	
	private static int WIDTH = 1000, HEIGTH = 600, HERO_SIZE = 20;
	private static Rectangle hero; //bird
	private static ArrayList<Rectangle> columns; //array of columns
	private Renderer renderer; //graphics
	private static boolean gameOver, started;
	private static int score;
	
	gameView()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hero = new Rectangle(WIDTH / 2, HEIGHT / 2 , HERO_SIZE , HERO_SIZE);
		columns = new ArrayList<Rectangle>(2);
		renderer = new Renderer();
		score = 0;
		this.add(renderer);
		this.setSize(WIDTH, HEIGTH);
		this.setResizable(false);
		this.setTitle("Simple MVC game");
		this.setVisible(true);
	}
	
	public class Renderer extends JPanel{
		
		private static final long serialVersionUID = 1L;
		
		//Automatically generated code for painting
		@Override									
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			gameView.repaint(g);
		}
	}
	
	public static void repaint(Graphics g) 
	{		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGTH);
		
		g.setColor(Color.orange);
		g.fillRect(0, HEIGTH - 100, WIDTH,  100);
		
		g.setColor(Color.green);
		g.fillRect(0, HEIGTH - 100 , WIDTH, 20);
		
		g.setColor(Color.red);
		g.fillRect(hero.x, hero.y, hero.height, hero.width);
		
		for(Rectangle column : columns)
		{
			g.setColor(Color.green.darker());
			g.fillRect(column.x, column.y, column.width, column.height);
		}
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial", 1 , 100));
		
		if(!started)
		{
			g.drawString("Click to start", WIDTH / 4 , HEIGTH/2 - 50);
		}
		
		if(gameOver)
		{
			g.drawString("Game Over!", WIDTH / 4 , HEIGTH/2 - 50);
			g.drawString("Score: " + String.valueOf(score), WIDTH / 4 , HEIGTH/2 + 50);
		}
		
		if (!gameOver && started)
		{
			g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
		}
	}
	
	public void rendererRepaint()
	{
		renderer.repaint();
	}
	
	public void addJumpListener(MouseListener listenForJump)
	{
		this.addMouseListener(listenForJump);
	}
	
//SETTERS BEGIN
	public void setStarted(boolean newStarted)
	{
		gameView.started = newStarted;
	}
	
	public void setColumns(ArrayList<Rectangle> newColumns) {
		gameView.columns = newColumns;
	}
	
	public void setHero(Rectangle newHero)
	{
		gameView.hero = newHero;
	}
	
	public void setScore(int newScore)
	{
		gameView.score = newScore;
	}
	public void setGameOver(boolean newGameOver)
	{
		gameView.gameOver = newGameOver;
	}
//SETTERS END

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
