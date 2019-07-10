   package com.mycompany.a2;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D; 

import com.codename1.charts.util.ColorUtil;
public class Missile extends MovableObject implements IDrawable{

    private double fuelLevel ;
    private boolean owner ;
    
    // Constructor
    public Missile(Point2D shipLocation , int direction , int speed, boolean isPlayerMissile) {
        this.setLocation(shipLocation);
       	this.setDirection(direction);
       	this.setSpeed(speed+10); 
        this.setColor(ColorUtil.BLACK);
        this.fuelLevel = 15;
        if (isPlayerMissile) {
        	owner = true; 
        }
    } 
    
    // Methods to change if specific to missile
    // Some left empty for now
    public void setDirection(){

    	//this.setDirection(getDirection());
    }

    //public void setSpeed(){

    	//this.setSpeed(this.getSpeed()+30);
    //}
     
    public void decrementFuelLevel(){
    		fuelLevel-=0.2;
    }

    // Setters And Getters ///
    public int getFuelLevel() {
        return (int) fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    /// To String ///
    @Override
    public String toString(){
    	String parentDesc = super.toString();
    	String myDesc = parentDesc + ", fuel=" +(int) fuelLevel;
    	return missileType()+ " Missile: " +myDesc;

    }
    
    public String missileType() {
    	
    	if(owner) {
    		return "PS's ";
    	}
    	else {
    		return "NPS's ";
    	}
    }
    
    
    
	@Override
	public void draw(Graphics g, Point pComRelPrnt) {
		// TODO Auto-generated method stub
		
		 g.setColor(this.getColor());
		 int xLoc = (int) (pComRelPrnt.getX()+this.getLocation().getX());
		 int yLoc =  (int) (pComRelPrnt.getY()+this.getLocation().getY());
		 //int [] xPoints = {xLoc-50 ,xLoc+50 , xLoc} ;
		 //int [] yPoints = {yLoc+50 ,yLoc+50 , yLoc} ;
		 
		 int width = 30;
		 int height = 30;
		 
		// g.drawRect(xLoc, yLoc -31, width, height);
		 g.fillArc(xLoc, yLoc, width, height, 0, 360);
		
	}
}
