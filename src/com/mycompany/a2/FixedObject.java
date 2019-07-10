package com.mycompany.a2;
import com.codename1.ui.geom.Point2D; 

public abstract class  FixedObject extends GameObject {
   private int id;
   private int helper;
 
    // Constructor
    public FixedObject() {

    }

    @Override
    public void setLocation(Point2D location) {
    	
        super.setLocation(location);
    }

    public abstract int getNextID();

    // setters ////

    public void setId(int id) {
    	
        this.id = id;
    }

    public void setHelper(int helper) {
    	
        this.helper = helper;
    }

    ////Getters/////


    public int getId() {
    	
        return id;
    }

    public int getHelper() {
    	
        return helper;
    }
}
