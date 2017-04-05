package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState{
	
	Animation isaac, movingUp, movingDown, movingLeft, movingRight;
	Image world;
	boolean quit = false;
	int[] duration = {200,200}; //duration tells the program how long each frame will last... this one is 2 tenths of a sentance for two images
	float isaacPositionX = 0; //starting position of isaac X
	float isaacPositionY = 0;//starting position of isaac Y
	float shiftX = isaacPositionX + 320; // keeps isaac in the middle of the screen
	float shiftY = isaacPositionY + 160; // keeps isaac in the middle of the screen
	
	//constructor for the play state
	public Play(int state){
		
	}
	
	//initialize stuff the class needs
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		world = new Image("res/world.png");
		Image[] walkUp = {new Image("res/isaacsBack.png"), new Image("res/isaacsBack.png")}; //whenever isaac is walking up, show his back starting with his back and ending with his back
		Image[] walkDown = {new Image("res/isaacsFront.png"), new Image("res/isaacsFront.png")}; 
		Image[] walkLeft = {new Image("res/isaacsLeft.png"), new Image("res/isaacsLeft.png")}; 
		Image[] walkRight = {new Image("res/isaacsRight.png"), new Image("res/isaacsRight.png")}; 
		
		movingUp = new Animation(walkUp, duration, false); //creates the animation... parameters are (what image to use, how long, just make it false)
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		isaac = movingDown;
	}
	
	//rendering the game
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		world.draw(isaacPositionX, isaacPositionY);
		isaac.draw(shiftX, shiftY);
		g.drawString("Isaac's X: "+ isaacPositionX+ "\nIsaac's PositionY: "+isaacPositionY, 20, 40);
		
		//esc menu
		if (quit == true){
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit (Q)", 250, 200);
			if(quit == false){
				g.clear();
			}
		}
	}
	
	//update method to updated the images on the screen 
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_UP)){
			isaac = movingUp; //make Isaac look up
			isaacPositionY += delta * .1f; //increase the Y position of Isaac
			if (isaacPositionY > 103 ){ 
				isaacPositionY -= delta * .1f; //dont allow any more values to be added to the Y position
			}
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			isaac = movingDown; //make Isaac look down
			isaacPositionY -= delta * .1f; //decrease the Y position of Isaac
			if (isaacPositionY < -481 ){ 
				isaacPositionY += delta * .1f; //dont allow any more values to be subtracted from the Y position
			}
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			isaac = movingLeft; //make Isaac look left
			isaacPositionX += delta * .1f; //increase the X position of Isaac
			if (isaacPositionX > 265 ){ 
				isaacPositionX -= delta * .1f; //dont allow any more values to be added to the X position
			}
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			isaac = movingRight; //make Isaac look right
			isaacPositionX -= delta * .1f; //decrease the X position of Isaac
			if (isaacPositionX < -935 ){ 
				isaacPositionX += delta * .1f; //dont allow any more values to be subtracted from the X position
			}
		}
		
		//escape menu
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
		}
		//when menu is up
		if(quit == true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)){
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
			
		}
	}
	
	//grabs the ID for our play state, which is 1
	public int getID(){
		return 1;
	}
}
