package com.mycompany.a2;
//import com.codename1.ui.geom.Point2D; 

public abstract class Ship extends MovableObject {
    private int  missileCount;
    private final int Max_Missile= 10 ;
    
     // Constructor///
    public Ship() {
       this.missileCount = Max_Missile ;
    }
        /// Methods ///
    public void decreaseMissileCount(){
    	
    	this.missileCount--;
    }  
    
 //// Setter and Getter //////
    public int getMissileCount() {
        return this.missileCount;
    }
    
    public int getMaxMissile() {
    	return Max_Missile ;
    }

    public void setMissileCount(int missileCount) {
        this.missileCount = missileCount;
    }
    
    public String toString(){
		String parentDesc = super.toString();
		String myDesc = parentDesc; //+ ", Missiles=" + missileCount;
		return myDesc;
	
	}
}
