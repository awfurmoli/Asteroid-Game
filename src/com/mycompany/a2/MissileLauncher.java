package com.mycompany.a2;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D; 

public class MissileLauncher extends MovableObject implements IDrawable, ISteerable {
	
	Point2D center = new Point2D(GameWorld.getWidth()/2,GameWorld.getHeight()/2);
    public MissileLauncher() {
       
    	this.setColor(ColorUtil.BLUE);
    	this.setDirection(0);
    	this.setSpeed(0);
    	this.setLocation(center);
    	
    
    }

    
    
    
	
	@Override
	public void draw(Graphics g, Point pComRelPrnt) {
		
		 g.setColor(this.getColor());
		 int xLoc = (int) (pComRelPrnt.getX()+this.getLocation().getX());
		 int yLoc =  (int) (pComRelPrnt.getY()+this.getLocation().getY());
		
		 
		double angle = Math.toRadians(90-this.getDirection()) ;
		double deltaX = Math.cos(angle) ;
		double deltaY = Math.sin(angle) ;
		
		 int width = 1;
		 int height = 30;
		 
		 g.drawLine(xLoc, yLoc, (int) (xLoc + (50 *deltaX)), (int) (yLoc +(50 *deltaY)));
		
		
	}
	
	
	
	

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		if(this.getDirection()>355) {
			this.setDirection(0);
		}
		this.setDirection(this.getDirection()+5);
		
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		if(this.getDirection()<5) {
			this.setDirection(360);
		}
		this.setDirection(this.getDirection()-5);
		
	}
}
 