package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

import java.util.Random;

public class SpaceStation extends FixedObject implements IDrawable {

    private int blinkRate ;
    private boolean lightOn ;
    Random rand = new Random();
    
    //// Constructor/////
    public SpaceStation() {

    	this.setColor(ColorUtil.GREEN);
    	System.out.println("SpaceStation Created");
    	this.blinkRate = rand.nextInt(6)+1;
    } 

    public void toggleLight(){
    	if(!lightOn) {
    		lightOn=true;
    	}else {
    		lightOn=false ;
    	}
    }

    public int getBlinkRate() { 
        return this.blinkRate;
    }
    // Implement abstract methode from FixedObject
    @Override
	public int getNextID(){
        return 0;
    }

    @Override
    public String toString(){
    	String parentDesc = super.toString();
    	String myDesc = parentDesc + ", rate=" + blinkRate;
    	return "Space Station: "+myDesc;

    }

	@Override
	public void draw(Graphics g, Point pComRelPrnt) {
		// TODO Auto-generated method stub
		 g.setColor(this.getColor());
		 int xLoc = (int) (pComRelPrnt.getX()+this.getLocation().getX());
		 int yLoc =  (int) (pComRelPrnt.getY()+this.getLocation().getY());
		 
		 int width = 80;
		 int height = 80;
		 
		 
		 if(!lightOn) {
			 g.drawArc(xLoc, yLoc, width, height, 0, 360);
		 }
		 else {
			 g.fillArc(xLoc, yLoc, width, height, 0, 360);
		 }

	}
}
