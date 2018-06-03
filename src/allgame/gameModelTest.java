package allgame;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Test;
//given when then !!
public class gameModelTest {

	private int WIDTH = 1000, HEIGHT = 600, BIRD_SIZE = 20;  
	
	@Test
	public void gameModelBirdConstructorTest() 
	{
		gameModel gameModelTest = new gameModel();
		Rectangle birdNew = new Rectangle(WIDTH /2, HEIGHT/ 2, BIRD_SIZE , BIRD_SIZE);
		
		assertEquals(birdNew, gameModelTest.getBird());
	}
	
	@Test
	public void gameModelYMotionConstructorTest()
	{
		gameModel gameModelTest = new gameModel();
		
		assertEquals(0, gameModelTest.getYMotion());
	}
	
	@Test
	public void gameModelOneJumpTest() 
	{
		gameModel gameModelTest = new gameModel();
		int oneJumpPosition = -15;
		
		gameModelTest.setGameOver(false);
		gameModelTest.setGameStarted(true);
		gameModelTest.jump();
		
		assertEquals(oneJumpPosition, gameModelTest.getYMotion());
	}
	
	@Test
	public void gameModelTwoJumpTest() 
	{
		gameModel gameModelTest = new gameModel();
		int twoJumpPosition = -15 + -15;
		
		gameModelTest.setGameOver(false);
		gameModelTest.setGameStarted(true);
		gameModelTest.jump();
		gameModelTest.jump();
		
		assertEquals(twoJumpPosition, gameModelTest.getYMotion());
	}
	
	@Test
	public void gameModelNewGameTest()
	{
		gameModel gameModelTest = new gameModel();
		Rectangle birdNew = new Rectangle(WIDTH /2, HEIGHT/ 2, BIRD_SIZE , BIRD_SIZE);
		
		gameModelTest.setGameOver(true);
		
		assertEquals(birdNew, gameModelTest.getBird());
		
	}
	
	@Test
	public void checkForGameOverTest()
	{
		gameModel gameModelTest = new gameModel();
		Rectangle column = gameModelTest.getColumns().get(0);
		
		gameModelTest.setGameOver(false);
		gameModelTest.setBird(new Rectangle(column.x - BIRD_SIZE, column.y - BIRD_SIZE, BIRD_SIZE , BIRD_SIZE)); 
		gameModelTest.checkForGameOver();
		
		assertEquals(false, gameModelTest.getGameOver());
		
		gameModelTest.setBird(new Rectangle(column.x, column.y, 20 , 20)); //w kolumnie
		gameModelTest.checkForGameOver();
		assertEquals(true, gameModelTest.getGameOver());
		
		gameModelTest.setBird(new Rectangle(0, 99999, 20 , 20));  //wyleciał po za granicę
		gameModelTest.checkForGameOver();
		assertEquals(true, gameModelTest.getGameOver());
	}
	
	@Test
	public void checkForGameOverColumnIntersectsBirdTest()
	{
		gameModel gameModelTest = new gameModel();
		Rectangle column = gameModelTest.getColumns().get(0);
		
		gameModelTest.setBird(new Rectangle(column.x, column.y, BIRD_SIZE , BIRD_SIZE)); //w kolumnie
		gameModelTest.checkForGameOver();
		
		assertEquals(true, gameModelTest.getGameOver());
	}
	
	@Test
	public void checkForGameOverBirdFlewOwerSkyTest()
	{
		gameModel gameModelTest = new gameModel();
		int birdY = 99999;
		
		gameModelTest.setBird(new Rectangle(0, birdY, 20 , 20));  //wyleciał po za granicę
		gameModelTest.checkForGameOver();
		
		assertEquals(true, gameModelTest.getGameOver());
	}
	
	@Test
	public void checkForGameOverBirdFlewUnderTheGroundTest()
	{
		gameModel gameModelTest = new gameModel();
		int birdY = -99999;
		
		gameModelTest.setBird(new Rectangle(0, birdY, 20 , 20));  //wyleciał po za granicę
		gameModelTest.checkForGameOver();
		
		assertEquals(true, gameModelTest.getGameOver());
	}

}
