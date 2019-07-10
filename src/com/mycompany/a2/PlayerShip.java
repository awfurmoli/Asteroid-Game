package com.mycompany.a2;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D; 

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ship implements ISteerable , IDrawable {
    private MissileLauncher launcher ;
    private static PlayerShip playerShip ;
   
    // set the playership at center of Map View
    Point2D center = new Point2D(GameWorld.getWidth()/2,GameWorld.getHeight()/2);
    
    ///// Constructor /////
    private  PlayerShip() {
         
    	this.setColor(ColorUtil.BLUE);
    	this.setSpeed(0);
    	this.setLocation(center);
    	this.setDirection(0); // 0 = north ?
    	
    	System.out.println("Player Ship Created");
    	this.launcher = new MissileLauncher();
    	this.launcher.setDirection(0);
    }

 
    // Methodes ////
    
    
    public static  PlayerShip getPlayerShip() {
    	if(playerShip==null) {
    		playerShip= new PlayerShip( ) ;
    		return playerShip;
    	}else
    		return null;
		
    }

    public void increaseSpeed(){
    	if(this.getSpeed()<=18)
    		this.setSpeed(this.getSpeed()+2);
    }

    public void decreaseSpeed(){
    	if(this.getSpeed()>=2) {
    		this.setSpeed(this.getSpeed()-2);
			System.out.println("PlayerShip Speed was decreased by 2 units ");
    	}else {
    		System.out.println("PlayerShip is already at lowest speed ");
    	}
    } 

    @Override
	public void turnLeft(){
    	if(this.getDirection()<2) {
			this.setDirection(360);
		}
    	this.setDirection((this.getDirection()-25));
    }

    @Override
	public void turnRight(){
    	if(this.getDirection()>358) {
			this.setDirection(0);
		}
        	this.setDirection((this.getDirection()+25));
      }
    
////  /////////// 'n' //// Implementation
    public void reloadMissiles(){
    	this.setMissileCount(this.getMaxMissile());
    	
    }

    public int getLauncherDirection(){
    	
    	return this.launcher.getDirection();
    }

    public void rotateLauncher(){

    }

    @Override
    public String toString(){
    	String parentDesc = super.toString();
    	String myDesc = parentDesc + " Missiles = " + this.getMissileCount() +
    			" Missile Launcher dir=" + launcher.getDirection();
    	return "Player Ship: "+myDesc;

    	}
//////// Implementing '<' //////////

	public void revolveML() {
		/*
		if(this.launcher.getDirection()>355) {
			this.launcher.setDirection(0);
		}
		this.launcher.setDirection(this.launcher.getDirection()+5);
		*/
		launcher.turnLeft();
		 
	}
////////Implementing '>' //////////
	public void revolveMR() { 
		/*
		if(this.launcher.getDirection()<5) {
			this.launcher.setDirection(360);
		}
		this.launcher.setDirection(this.launcher.getDirection()-5);
		*/
		launcher.turnRight();
	}


	public void setLocationDefault() {
		this.setLocation(center);
	}


	public void setToNull() {
		// TODO Auto-generated method stub
		this.playerShip=null ;
	}

	public void move(int time) {
		super.move(time);
		launcher.setLocation(this.getLocation());
	}

	public void draw(Graphics g, Point pComRelPrnt) {
		// TODO Auto-generated method stub
		 g.setColor(this.getColor());
		 int xLoc = (int) (pComRelPrnt.getX()+this.getLocation().getX());
		 int yLoc =  (int) (pComRelPrnt.getY()+this.getLocation().getY());
		 int [] xPoints = {xLoc-50 ,xLoc+50 , xLoc} ;
		 int [] yPoints = {yLoc+50 ,yLoc+50 , yLoc} ;
		 
		 
		 g.drawPolygon(xPoints, yPoints, 3);
		 
		 launcher.draw(g, pComRelPrnt);
		
	}
}
