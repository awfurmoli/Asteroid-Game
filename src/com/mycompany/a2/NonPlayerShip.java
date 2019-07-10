package com.mycompany.a2;
//import com.codename1.ui.geom.Point2D; 
import java.util.Random;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public class NonPlayerShip extends Ship implements IDrawable {

    private MissileLauncher launcher ;
    private int  size ;
    Random rand = new Random();
    
    //// Constructor /////
    public NonPlayerShip() {
       
        this.setColor(ColorUtil.MAGENTA);
        System.out.println("NPS Created");
        this.launcher = new MissileLauncher();
        this.setMissileCount(4); 
         
        int i = rand.nextInt(2);
        if(i == 1) {
        	this.size = 15;
        }
        else {
        	this.size = 25;
        }
    }

    //// Methods///
    public int getDirectionML(){ 
        return 0;
    }

    public int getSize() {
        return size;
    }

    public void setDirction(){

    }

    public void setSpeed(){

    }

    /// ToString///
    public String toString(){
    	
		String parentDesc = super.toString();
		String myDesc = parentDesc + ", size=" + size;
		return "Non-Player Ship: "+myDesc;
	}
    /// need to take size into account ///////
    public void draw(Graphics g, Point pComRelPrnt) {
		// TODO Auto-generated method stub
		 g.setColor(this.getColor());
		 int xLoc = (int) (pComRelPrnt.getX()+this.getLocation().getX());
		 int yLoc =  (int) (pComRelPrnt.getY()+this.getLocation().getY());
		 int [] xPoints = {xLoc-50 ,xLoc+50 , xLoc} ;
		 int [] yPoints = {yLoc+50 ,yLoc+50 , yLoc} ;
		 
		 
		 g.fillPolygon(xPoints, yPoints, 3);
		
	}
}

