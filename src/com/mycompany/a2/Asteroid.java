package com.mycompany.a2;
import com.codename1.ui.geom.Point2D; 

import java.util.Random ;

import com.codename1.charts.util.ColorUtil ;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class Asteroid extends MovableObject implements IDrawable{
	
	 
	Random ran = new Random();
    // Random number between 6 and 30 
    private int size= ran.nextInt(25)+6;
    
    //Point2D point= new Point2D.Double(ran.nextInt(1024)+1, ran.nextInt(768)+1);

    /// Constructor///

    public Asteroid() {
       this.setColor(ColorUtil.GRAY);
       this.setSize(size);

       //IF WE NEED TO MAKE SPECIFIC FOR ASTEROIDS CHANGE THESE TO OVERWRITE
       //this.setDirection(ran.nextInt(50));
       //this.setSpeed(ran.nextInt(11)) ;
       //this.setRandLocation();
         
       System.out.println("Astroid created") ;
     
    }

    // Getters and Setters//
   public void setSize(int size) {
	   
	   this.size = size;
   }

    public int getSize() {
    	
        return size;
    }

    /// ToString
    	public String toString(){
    		String parentDesc = super.toString();
    		String myDesc = parentDesc + ", size=" + this.size;
    		return "Asteroid: "+myDesc;
    	
    	}

	@Override
	public void draw(Graphics g, Point pComRelPrnt) {
		// TODO Auto-generated method stub
		 g.setColor(this.getColor());
		 int xLoc = (int) (pComRelPrnt.getX()+this.getLocation().getX());
		 int yLoc =  (int) (pComRelPrnt.getY()+this.getLocation().getY());
		 
		 g.drawRect( xLoc,yLoc, this.size, this.size);
		
	}
}
