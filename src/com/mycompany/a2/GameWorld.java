package com.mycompany.a2;
//import com.codename1.ui.geom.Point2D; 

import java.util.ArrayList;
import java.util.Observable;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

public class GameWorld extends Observable implements IGameWorld {
    private static double width = 1024.0 ;
    private static double length = 768.0 ;
    
   // private  double width = 1024.0 ;
  //  private  double length = 768.0 ;
    private int score;
    private int time;
    private int lives; 
    private GameObjectCollection store1 =new GameObjectCollection() ;
    private int elapsedGameTime;
    private int numPlayerShipMissiles=10 ;
    private boolean isPS = false;
    public boolean soundB = true;
    
    private BGSound bgSound ;
	
    //Constructor
    public GameWorld(){
    	init();
        bgSound= new BGSound("background.mp3") ;
       // bgSound.play();
    } 
    
    public void init(){
    	this.lives = 3;
    	this.time = 0;
    	this.score = 0;
    	this.elapsedGameTime = 0;
    	this.numPlayerShipMissiles = 10;
    	System.out.println("Initialized Game");
    	this.setChanged();
    	this.notifyObservers(new GameWorldProxy(this));
    	
    }
    
    
    

    public void addAsteroid (){   // 'a'
    	
    	
    	getStore1().add(new Asteroid());
    	this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
    	
    }

    public void addNonPlayerShip(){  // 'y'

    	getStore1().add(new NonPlayerShip());
    	this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
    }
    

    
    
    ////// add PlayerShip with singelton pattern //////
    
    public void addPlayerShip() {
    	 PlayerShip ps = PlayerShip.getPlayerShip() ;
    	 if(ps!=null) {
    		getStore1().add(ps);
    	 	this.setChanged();
 			this.notifyObservers(new GameWorldProxy(this));
    	 }else
    		 System.out.println("Cant have mroe than 1 PlayerShip at a time") ;
    }
    

 //////////////////// 'b'
    
    public void addSpaceStation(){ 
    	
    	getStore1().add(new SpaceStation());
    	this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
    }

    /////// Implementation for 'i' with Iterator /////////
    public void increasePlayerShipSpeed(){
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj); 

    		if(playerShip)
    		{
    			PlayerShip ps = (PlayerShip) curObj;
    			ps.increaseSpeed();
    			System.out.println("PlayerShip speed increased by 2 units ");
    			this.setChanged();
    			this.notifyObservers(new GameWorldProxy(this));
    		}
    	}
    }

    
/////// Implementation for 'd' with Iterator /////////
    
    public void decreasePlayerShipSpeed(){
  	  Boolean playerShip = false;
  	  IIterator itr = getStore1().getIterator();
  	  Object curObj ;
  	  while(itr.hasNext()) {
  		  curObj = itr.getNext() ;
  		  playerShip = isPlayerShip(curObj);
		  if(playerShip)
    		{
    			PlayerShip ps = (PlayerShip) curObj;
    			ps.decreaseSpeed();
    			this.setChanged();
    			this.notifyObservers(new GameWorldProxy(this));
    			
    		}	
    	}
    }


/////// Implementation for 'l' with Iterator /////////
    public void turnPlayerShipLeft(){
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj);
    		if(playerShip)
    		{
    			PlayerShip ps = (PlayerShip) curObj;
    			ps.turnLeft();
    			System.out.println("PlayerShip Turned Left by 25 units ");
    			this.setChanged();
    			this.notifyObservers(new GameWorldProxy(this));
    			
    		}	
    	}
    }

/////// Implementation for 'r' with Iterator /////////
    public void turnPlayerShipRight(){
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj);
    		if(playerShip)
    		{
    			PlayerShip ps = (PlayerShip) curObj;
    			ps.turnRight();
    			System.out.println("PlayerShip Turned Right by 25 units ");
    			this.setChanged();
    			this.notifyObservers(new GameWorldProxy(this));
    		}	
    	}
    }

  
////Letter '>'  with Iterator  ////////
    public void turnPlayerMissileClockwise(){
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj); 

    		if(playerShip)
    			{
    				PlayerShip ps = (PlayerShip) curObj;
    				ps.revolveMR();
    				System.out.println("PS Missile Turned clockwise by 5 units ");
    				this.setChanged();
    				this.notifyObservers(new GameWorldProxy(this));
    			}
    		}
    	}

////Letter '<'  with Iterator  ////////
    public void turnPlayerMissileCounterClockwise(){
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj); 

    		if(playerShip)
    			{
    				PlayerShip ps = (PlayerShip) curObj;
    				ps.revolveML();
    				System.out.println("PS Missile Turned clockwise by 5 units ");
    				this.setChanged();
    				this.notifyObservers(new GameWorldProxy(this));
    			}
    		}	
    	}

    /////// implementation 'f'  With Iterator /////////////
    public void firePlayerMissile(){  // 
        	
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj);
    			if(playerShip)
    			{
    				PlayerShip ps = (PlayerShip) curObj; 
    			if(ps.getMissileCount() > 0) {
        				
        				ps.setMissileCount(ps.getMissileCount() - 1);
        				Missile msl = new Missile(ps.getLocation(),ps.getLauncherDirection(),ps.getSpeed(), true);
        				getStore1().add(msl);
        				System.out.println("PS Fired a missile \n Number of Missiles: " + ps.getMissileCount());
        				this.setChanged();
        				this.notifyObservers(new GameWorldProxy(this));
        			}
        			else {
        					
        				System.out.println("Player has no missiles");
        			}
        		  }
        	   	}
           	}

    
    	public boolean hasPlayerShip() {
    		Boolean playerShip = false;
    		IIterator itr = getStore1().getIterator();
    		Object curObj ;
    		while(itr.hasNext()) {
    			curObj = itr.getNext() ;
    			playerShip = isPlayerShip(curObj);
    			if(playerShip)
    			{
    				return true;
    			}
    			else 
    			{
    				System.out.print("no player shipt found");
    			}
    		}
    		return false;
    	}
    
  
    
    ////// for A2 with Iterator ///////
    public  boolean isPlayerShip(Object object){

   		return object instanceof PlayerShip ;
   	}
    
    /////// for A1 ////////////
    public  boolean isPlayerShip(GameObject object){

   		return object instanceof PlayerShip ;
   	}
    

    ////////////////// Implementation for 'L' with Iterator ////////////////
    
    public void launchNPSMissile() {   
    	
 	   Boolean nonPlayerShip = false;
 	   IIterator itr = getStore1().getIterator();
 	   Object curObj ;
 	   while(itr.hasNext()) {
 		   curObj = itr.getNext() ;
 		   nonPlayerShip = isNonPlayerShip(curObj); 
 		   
 		   if(nonPlayerShip)
 		   {
 			   NonPlayerShip nps = (NonPlayerShip) curObj;
 			   if(nps.getMissileCount() > 0) {
 				   
 				   nps.setMissileCount(nps.getMissileCount() - 1);
 				   Missile msl = new Missile(nps.getLocation(),nps.getDirection(),nps.getSpeed(), false);
 				   getStore1().add(msl);
 				   System.out.println("NPS Fired a missile \n Number of Missiles: " + nps.getMissileCount());
 				   this.setChanged();
 				   this.notifyObservers(new GameWorldProxy(this));
 			   }
 			   else {
 				   
 				   System.out.println("NPlayer has no missiles");
 			   }	
 		   }	
 	   }
    }
    
    
    
    
   
    
    
    ///// for A2 ///////////
    public  boolean isNonPlayerShip(Object curObj){
    	
    	return curObj instanceof NonPlayerShip ;
   	}
    ////////for A1 ///////
    public  boolean isNonPlayerShip(GameObject curObj){
    	
    	return curObj instanceof NonPlayerShip ;
   	}

    
    ///implementation for 'j' With Iteratory ////////////////////
    public void jumpThroughHyperspace(){
 	   Boolean playerShip = false;
 		IIterator itr = getStore1().getIterator();
 		Object curObj ;
 		while(itr.hasNext()) {
 			curObj = itr.getNext() ;
 			playerShip = isPlayerShip(curObj); 
    		if(playerShip)
    		{
    			PlayerShip ps = (PlayerShip) curObj;
    			ps.setLocationDefault() ;
    			System.out.println("PlyerShip jumped through Hyperspace !  ");
    			this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
    			
    		}
    	}
    }

  
///// Implementing letter 'n' with Iterator //////
   public void loadPlayerMissiles(){
	    Boolean playerShip = false;
		IIterator itr = getStore1().getIterator();
		Object curObj ;
		while(itr.hasNext()) {
			curObj = itr.getNext() ;
			playerShip = isPlayerShip(curObj); 
	   		if(playerShip)
	   			{
	   				PlayerShip ps = (PlayerShip) curObj;
	   				ps.reloadMissiles();
	   				System.out.println("PS Missile Reloaded to Max ");
	   				System.out.println("PS Missile Reloaded to Max ");
	   				this.setChanged();
	   				this.notifyObservers(new GameWorldProxy(this));
	   			
	   			}
		}
   	
   }

    
  

    /////////Old Implementation k////////
   public void playerKillsAstroid(){
   
    	Boolean astVisited= false ;
    	Boolean misVisited= false ;
    	Missile mis = null ;
    	Asteroid ast = null ;
    	
    	IIterator itr = getStore1().getIterator(); 
    	Object curObj;
    	while(itr.hasNext()) {
    		curObj = itr.getNext();
    		if(!astVisited) {
    			if(curObj instanceof Asteroid) {
    				astVisited=true;
    				ast=(Asteroid) curObj ;
    			}
    		}
    	}
    	
    	
    	
    
    	 itr = getStore1().getIterator();
    	while(itr.hasNext()) {
    		curObj = itr.getNext();
    		if(!misVisited) {
    			if(curObj instanceof Missile) {
    				 mis = (Missile) curObj ;
    				if(mis.missileType() == "PS's ") {
    					misVisited=true;
    				}
    			}
    		}
    	}
    	
    		
    	if(astVisited && misVisited) { 	
    		itr.remove(ast);
    		itr.remove(mis);
    		
    		System.out.println("One Player Missile and one Astreoid is removed");
    		this.setScore(this.getScore());
    		System.out.println("Score increased by 1 ") ;
    		 	  
    	}
    		
    	if (!(astVisited && misVisited)) {
    		System.out.println("Both instances not available.");
    	}
    	
    	this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
   }
 
   //// Implementation for 'e'  /////////
   public void playerElimNPS(){
	   
   	Boolean npsVisited= false ;
   	Boolean misVisited= false ;
   	Missile mis = null ;
   	NonPlayerShip nps = null ;
   	
   	IIterator itr = getStore1().getIterator(); 
   	Object curObj;
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!npsVisited) {
   			if(curObj instanceof NonPlayerShip) {
   				npsVisited=true;
   				nps=(NonPlayerShip) curObj ;
   			}
   		}
   	}
   	
   	
   	
   
   	itr = getStore1().getIterator();
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!misVisited) {
   			if(curObj instanceof Missile) {
   				 mis = (Missile) curObj ;
   				if(mis.missileType() == "PS's ") {
   					misVisited=true;
   				}
   			}
   		}
   	}
   	
   		
   	if(npsVisited && misVisited) { 	
   		itr.remove(nps);
   		itr.remove(mis);
   		
   		System.out.println("One Player Missile and one NPS is removed");
   		this.setScore(this.getScore());
   		System.out.println("Score increased by 1 ") ;
   		 	  
   	}
   		
   	if (!(npsVisited && misVisited)) {
   		System.out.println("Both instances not available.");
   	}
   	
   		this.setChanged();
   		this.notifyObservers(new GameWorldProxy(this));
   		
  }
  
   //// Implementation for 'E'  /////////
   public void NPSMissileExplodePS(){
	   
   	Boolean psVisited= false ;
   	Boolean misVisited= false ;
   	Missile mis = null ;
   	PlayerShip ps = null ;
   	
   	IIterator itr = getStore1().getIterator(); 
   	Object curObj;
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!psVisited) {
   			if(curObj instanceof PlayerShip) {
   				psVisited=true;
   				ps=(PlayerShip) curObj ;
   			}
   		}
   	}
   	
   	
   	
   
   	itr = getStore1().getIterator();
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!misVisited) {
   			if(curObj instanceof Missile) {
   				 mis = (Missile) curObj ;
   				if(mis.missileType() == "NPS's ") {
   					misVisited=true;
   				}
   			}
   		}
   	}
   	
   		
   	if(psVisited && misVisited) { 
   		ps.setToNull();
   		itr.remove(ps);
   		itr.remove(mis);
   		
   		
		System.out.println("The Player Ship and NPS missile removed\nlife decreased by one ") ;
		this.decrementLives();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		this.isPS=false;
		if(this.getLives()==0) {
			System.out.println("GAME OVER !");
			//this.quit();
			System.exit(1);
	
		}
   		 	  
   	}
   		
   	if (!(psVisited && misVisited)) {
   		System.out.println("Both instances not available.");
   	}
   	
   		this.setChanged();
   		this.notifyObservers(new GameWorldProxy(this)) ;	
  }
     
    private void decrementLives() {
		this.lives--;
		
	}
 	
   //// Implementation for 'c'  /////////
   public void playerShipCrashAstroid(){
	   
   	Boolean psVisited= false ;
   	Boolean astVisited= false ;
   	Asteroid ast = null ;
   	PlayerShip ps = null ;
   	
   	IIterator itr = getStore1().getIterator(); 
   	Object curObj;
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!psVisited) {
   			if(curObj instanceof PlayerShip) {
   				psVisited=true;
   				ps=(PlayerShip) curObj ;
   			}
   		}
   	}
   	
   	
   	
   
   	itr = getStore1().getIterator();
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!astVisited) {
   			if(curObj instanceof Asteroid) {
   				ast = (Asteroid) curObj ;
   				astVisited=true;	
   			}
   		}
   	}
   	
   		
   	if(psVisited && astVisited) { 
   		ps.setToNull();
   		itr.remove(ps);
   		itr.remove(ast);
   		
   		
		System.out.println("The Player Ship crashed with asteroid, both removed\nlife decreased by one ") ;
		this.decrementLives();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		this.isPS=false;
		if(this.getLives()==0) {
			System.out.println("GAME OVER !");
			//this.quit();
			System.exit(1);
	
		}
   		 	  
   	}
   		
   	if (!(psVisited && astVisited)) {
   		System.out.println("Both instances not available.");
   	}
   	
   		this.setChanged();
   		this.notifyObservers(new GameWorldProxy(this)) ;	
  }  

   //// Implementation for 'h'  /////////
   public void playerShipHitNPS(){
	   
   	Boolean psVisited= false ;
   	Boolean npsVisited= false ;
   	NonPlayerShip nps = null ;
   	PlayerShip ps = null ;
   	
   	IIterator itr = getStore1().getIterator(); 
   	Object curObj;
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!psVisited) {
   			if(curObj instanceof PlayerShip) {
   				psVisited=true;
   				ps=(PlayerShip) curObj ;
   			}
   		}
   	}
   	
   	
   	
   
   	itr = getStore1().getIterator();
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!npsVisited) {
   			if(curObj instanceof NonPlayerShip) {
   				nps = (NonPlayerShip) curObj ;
   				npsVisited=true;	
   			}
   		}
   	}
   	
   		
   	if(psVisited && npsVisited) { 
   		ps.setToNull();
   		itr.remove(ps);
   		itr.remove(nps);
   		
   		
		System.out.println("The Player Ship crashed with NPS, both removed\nlife decreased by one ") ;
		this.decrementLives();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
		this.isPS=false;
		if(this.getLives()==0) {
			System.out.println("GAME OVER !");
			//this.quit();
			System.exit(1);
	
		}
   		 	  
   	}
   		
   	if (!(psVisited && npsVisited)) {
   		System.out.println("Both instances not available.");
   	}
   	
   		this.setChanged();
   		this.notifyObservers(new GameWorldProxy(this)) ;	
  } 

   //// Implementation for 'x'  /////////
   public void twoAsteroidCollision(){
	   
   	Boolean ast1Visited= false ;
   	Boolean astVisited= false ;
   	Asteroid ast = null ;
   	Asteroid ast1 = null ;
   	
   	IIterator itr = getStore1().getIterator(); 
   	Object curObj;
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!ast1Visited) {
   			if(curObj instanceof Asteroid) {
   				ast1Visited=true;
   				ast1=(Asteroid) curObj ;
   				break ;
   			}
   		}
   	}
   	
   	
   	
   
   	//itr = store1.getIterator();
   	while(itr.hasNext()) {
   		curObj = itr.getNext();
   		if(!astVisited) {
   			if(curObj instanceof Asteroid) {
   				ast = (Asteroid) curObj ;
   				astVisited=true;	
   			}
   		}
   	}
   	
   		
   	if(ast1Visited && astVisited) { 
   		
   		itr.remove(ast1);
   		itr.remove(ast);
		System.out.println("Tow Asteroids colided and were removed ") ;	 	  
   	}
   		
   	if (!(ast1Visited && astVisited)) {
   		System.out.println("Both instances not available.");
   	}
   	
   	this.setChanged();
   	this.notifyObservers(new GameWorldProxy(this)) ;	
  } 
  
////Implementation for 'I'  /////////
 public void asteroidImpactedNPS(){
	   
 	Boolean npsVisited= false ;
 	Boolean astVisited= false ;
 	Asteroid ast = null ;
 	NonPlayerShip nps = null ;
 	
 	IIterator itr = getStore1().getIterator(); 
 	Object curObj;
 	while(itr.hasNext()) {
 		curObj = itr.getNext();
 		if(!npsVisited) {
 			if(curObj instanceof NonPlayerShip) {
 				npsVisited=true;
 				nps=(NonPlayerShip) curObj ;
 			}
 		}
 	}
 	
 	
 	
 
 	itr = getStore1().getIterator();
 	while(itr.hasNext()) {
 		curObj = itr.getNext();
 		if(!astVisited) {
 			if(curObj instanceof Asteroid) {
 				ast = (Asteroid) curObj ;
 				astVisited=true;	
 			}
 		}
 	}
 	
 		
 	if(npsVisited && astVisited) { 
 		
 		itr.remove(nps);
 		itr.remove(ast);
		System.out.println(" Asteroids colided with NPS both removed ") ;	 	  
 	}
 		
 	if (!(npsVisited && astVisited)) {
 		System.out.println("Both instances not available.");
 	}
 	
 	this.setChanged();
 	this.notifyObservers(new GameWorldProxy(this)) ;	
}

/////// Implementation for 't' //////////
 public void tick(int time){
	   
	 
	 
		////// Decrement Missiles Fuel and remove ones with no fuel/////
 		//// Got some negative number for locations ////////
	 	
	 	elapsedGameTime++ ;
	 	
	 	IIterator itr = getStore1().getIterator(); 
	 	Object curObj;
	 	while(itr.hasNext()) {
	 		curObj = itr.getNext();
	 		
	 			if(curObj instanceof Missile) {
	 				Missile ms= (Missile) curObj ;
	 				if(ms.getFuelLevel()==1) {	
	    				itr.remove(ms); 
	    			}else {
	    				ms.decrementFuelLevel();
	    			}
	 			}
	 		
	 	}
	 	
	 	
	 	
	////// Move al the moveable objects /////////
	 	
	 	itr = getStore1().getIterator();
	 	while(itr.hasNext()) {
	 		curObj = itr.getNext();
	 		if(curObj instanceof MovableObject) {
	 			MovableObject obj = (MovableObject) curObj ;
	 			obj.move(time);
	 		}
	 	}
	 	
	 	
	 	
	 	
		///// Space Station Toggle ////
	 	itr = getStore1().getIterator();
	 	while(itr.hasNext()) {
	 		curObj = itr.getNext();
	 		if(curObj instanceof SpaceStation) {
	 			SpaceStation obj = (SpaceStation) curObj ;
	 			if((elapsedGameTime % obj.getBlinkRate())==0)
	 				obj.toggleLight();
	 		}
	 	}
	 	
	 	
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	
 }
	 	
 
 

    public void printDisplay(){

    	System.out.println("Player Lives: " + this.getLives() + " Player Score: " + this.getScore() +
    	                   " Player Missile Count: " + this.getNumPlayerShipMissiles() + " Elapsed Time:" +
    			elapsedGameTime);
    }
  
////////'m' with Iterator  ////////
    public void printMap(){ 
    	System.out.println("*****************************************************");
    	System.out.println("World Map:");
    	IIterator itr = getStore1().getIterator();
    	while(itr.hasNext()) {
    		GameObject obj = (GameObject) itr.getNext();
    		System.out.println(obj);
    	}
    	System.out.println("*****************************************************");	
    }


    
    

    public void quit(){    // 'q' implemented with dialog box

    	if (Dialog.show("","Exit Game?", "Yes", "No")) {
			Display.getInstance().exitApplication();
		}
    }
    
 ///////  GETTERS FOR VARIABLES //////
  
    
    public void setGameScore(int s) { 
		this.score = s; 
	}

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public int getLives() {
        return lives;
    }

  

    public int getElapsedGameTime() {
        return elapsedGameTime;
    }

    //// Get number of PlayerShip Missiles 
    public int getNumPlayerShipMissiles() {
    	int temp = 0;
    	Boolean playerShip = false;
    	IIterator itr = getStore1().getIterator();
    	Object curObj ;
    	while(itr.hasNext()) {
    		curObj = itr.getNext() ;
    		playerShip = isPlayerShip(curObj); 
    		if(playerShip)
    			{
    				PlayerShip ps = (PlayerShip) curObj;
    				temp = ps.getMissileCount();
    			}
    	}
    	return temp;	
    }
    
  

    ///// SETTERS FOR VARIABLES
    public void setScore(int score) {
        this.score = score+1;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

   

    public void setElapsedGameTime(int elapsedGameTime) {
        this.elapsedGameTime = elapsedGameTime;
    }

    public void setNumPlayerShipMissiles(int numPlayerShipMissiles) {
        this.numPlayerShipMissiles = numPlayerShipMissiles;
    }

    ///// To String//////
    
   

    //RETURN CURRENT SOUND SETTING
	public boolean getSound() {
		return this.soundB;
	}
	
	//SET THE SOUND TO OPPOSITE WHEN CLICKED
	public void setSound() {
		this.soundB = !this.soundB;
		if(this.soundB == false) {
			//bgSound.pause();
		}
    	else {
    		//bgSound.play();
    	}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	//SHOW DOALOG BOX FOR ABOUT COMMAND
	public void about() {
		Dialog.show("About", "Authors: \nGurjot Hansra\nAhmad Furmoli"
				+ "\n\nCSC 133 Section 01\nSummer 2019", "OK", null);
	}

	public GameObjectCollection getStore1() {
		return store1;
	}

	public void setStore1(GameObjectCollection store1) {
		this.store1 = store1;
	}

	public void setDimesion(int width2, int height) {
		// TODO Auto-generated method stub
		width= width2 ;
		this.length = height ;
	}

	public static int getWidth() {
		// TODO Auto-generated method stub
		return (int) width ;
	}

	public static int getHeight() {
		// TODO Auto-generated method stub
		return (int) length;
	}

	

	
	
}