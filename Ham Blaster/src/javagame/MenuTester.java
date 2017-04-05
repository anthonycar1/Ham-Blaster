package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MenuTester extends BasicGameState{
	
	public String mouse = "no mouse yet";
	
	//constructor for the menu
	public MenuTester(int state){
		
	}
	
	//initialize stuff the class needs
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	//rendering the game "drawing"
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString(mouse, 190, 100);
		g.drawRect(100, 100, 60, 120); //x, y, width, height
		
		Image pika = new Image("res/Pikachu_Sprite.png"); //creating an image
		g.drawImage(pika, 200, 130); //drawing the image at these coordinates 
	}
	
	//update method to updated the images on the screen 
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		mouse = "Mouse position X: " + xpos + " Y: " + ypos;
	}
	
	//grabs the ID for our menu state, which is 0
	public int getID(){
		return 0;
	}
}
