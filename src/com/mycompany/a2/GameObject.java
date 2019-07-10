package com.mycompany.a2;
import com.codename1.ui.geom.Point2D;  //add 1.8 jre library build path
import java.util.Random ;
//import java.text.DecimalFormat;


import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {

    private Point2D location ;
    private int color ;
    
    Random rand = new Random();
    
   // Constructor ///
    public GameObject(){

    	setColor(ColorUtil.BLACK);
    	this.setRandLocation();
    }
     
    
   /// Getters
    public Point2D getLocation() {
    	
        return location;
    }
 
    
    public int getColor() {
    	
        return color;
    }

    //Setters
    public void setLocation(Point2D location) {
    	
        this.location = location;
    }
    
    public void setRandLocation() {
    	Point2D point;
    //	point = new Point2D(rand.nextFloat()*1024, rand.nextFloat()*768);
    	point = new Point2D(rand.nextFloat()*GameWorld.getWidth() ,rand.nextFloat()*GameWorld.getHeight());
		this.location = point;
    }

    public void setColor(int color) {
    	
        this.color = color;
    }
    
    // ToString
    public String toString() {
    	
    	double numX = Math.round((location.getX()*10.0)/10.0);
    	double numY = Math.round((location.getY()*10.0)/10.0);
    	
    	String myDesc = "loc=" + numX + "," + numY + 
				" color=[" + ColorUtil.red(color) + "," + ColorUtil.green(color) + "," + ColorUtil.blue(color) + "]";
    		return myDesc ;
    }
    
}