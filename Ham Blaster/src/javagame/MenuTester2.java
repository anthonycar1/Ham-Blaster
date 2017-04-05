package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MenuTester2 extends BasicGameState{
	
	Image pika;
	int pikaX = 200;
	int pikaY = 200;
	
	//constructor for the menu
	public MenuTester2(int state){
		
	}
	
	//initialize stuff the class needs
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		pika = new Image("res/Pikachu_Sprite.png");
	}
	
	//rendering the game "drawing"
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(pika, pikaX, pikaY);
	}
	
	//update method to updated the images on the screen 
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput(); //Create an object from the Input class in order to store input
		if(input.isKeyDown(Input.KEY_UP)){pikaY -= 1;}
		if(input.isKeyDown(Input.KEY_DOWN)){pikaY += 1;}
		if(input.isKeyDown(Input.KEY_LEFT)){pikaX -= 1;}
		if(input.isKeyDown(Input.KEY_RIGHT)){pikaX += 1;}
	}
	
	//grabs the ID for our menu state, which is 0
	public int getID(){
		return 0;
	}
}
