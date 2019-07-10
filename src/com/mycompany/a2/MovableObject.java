package com.mycompany.a2;
import com.codename1.ui.geom.Point2D; 
import java.util.Random;

public abstract class  MovableObject extends GameObject implements IMoveable {
    private int speed ;
    private int direction ;
    int maxWidth ;
    int maxHeight ;
    
    Random ran = new Random();

   

    public MovableObject() {
    	
    	this.setDirection(ran.nextInt(360));
        this.setSpeed(ran.nextInt(21)) ;
        maxWidth=GameWorld.getWidth();
        maxHeight = GameWorld.getHeight();
    }
    
 
    /// Getters And Setters///


    public int getSpeed() {
    	
        return speed;
    }

    public void setSpeed(int speed) {
    	
        this.speed = speed;
    }

    public int getDirection() {
    	
        return direction;
    }

    public void setDirection(int direction) {
    	
        this.direction = direction;
    }
    
    //private int incX =10 , incY = 10   ;
   
    int size = 20 ;
    double dirX = 1 , dirY = 1  ;
    // Move
    @Override
    
    
    
public void move(int time){
    	
    	//// Calculate the movement ////
    	 int currentX = (int) this.getLocation().getX();
    	 int currentY = (int) this.getLocation().getY();
    	 
    	 double angel = Math.toRadians( 90-(this.direction));
    	 double dist = speed * (time/50);
     	
     	 double incX= (Math.cos(angel)*dist);
    	 double incY= (Math.sin(angel)*dist);
     	
    	// int dist = speed * (time/1000);
    	//double incX=(int) (Math.cos(angel)*dist);
    	//double incY=(int) (Math.sin(angel)*dist);
    	 
    	
    	
    	if ( (currentX+size >= maxWidth) || (currentX < 0) ) 
			dirX = -dirX ;
		if ( (currentY+size >= maxHeight) || (currentY < 0) )
			dirY = -dirY ;
    	
    
		currentX += incX * dirX ; 
		currentY += incY * dirY ;
		
		this.setLocation(new Point2D(currentX,currentY));
    	
    
    }
      
    
    /*
	public void move(int time){
    	
    	//// Calculate the movement ////
    	 int currentX = (int) this.getLocation().getX();
    	 int currentY = (int) this.getLocation().getY();
    	 
    	 int angel =(int) Math.toRadians( 90-(this.direction));
     	
     	 double incX=(int) (Math.cos(angel)*speed);
    	 double incY=(int) (Math.sin(angel)*speed);
     	
    	// int dist = speed * (time/1000);
    	//double incX=(int) (Math.cos(angel)*dist);
    	//double incY=(int) (Math.sin(angel)*dist);
    	 
    	
    	
    	if ( (currentX+size >= maxWidth) || (currentX < 0) ) 
			dirX = -dirX ;
		if ( (currentY+size >= maxHeight) || (currentY < 0) )
			dirY = -dirY ;
    	
    
		currentX += incX * dirX ; 
		currentY += incY * dirY ;
		
		this.setLocation(new Point2D(currentX,currentY));
    	
    
    }
       
    /*
    
    /*
    public void move(int t) 
    { 
    	
    	
    	 int currentX = (int) this.getLocation().getX();
    	 int currentY = (int) this.getLocation().getY();
    	 int theta = 90 - direction; 

    	double distance = speed  * (t / 50.0); 
    	double newX = (currentX + ((Math.cos(Math.toRadians(theta))) * distance)); 
    	double newY=  (currentY + ((Math.sin(Math.toRadians(theta))) * distance)); 
    	
    	if ( (currentX+size >= maxWidth) || (currentX < 0) ) 
			dirX = -dirX ;
		if ( (currentY+size >= maxHeight) || (currentY < 0) )
			dirY = -dirY ;
    	
    
		
    	
    	this.setLocation(new Point2D(newX*dirX,newY*dirY));
    	
    } 
    */
    
    /*
    public void move(int t) 
    { 
        Point2D location = new Point2D(0,0) ;
    	int theta = 90 - direction;
    	
    	double distance = speed* (t / 50.0); 
    	double curX = this.getLocation().getX() + ((Math.cos(Math.toRadians(theta))) * distance) ;
    	double curY = this.getLocation().getY() + ((Math.sin(Math.toRadians(theta))) * distance) ;
    	
    
    	

    	
    	 
		location.setX(curX*dirX);
    	location.setY(curY*dirY);
    	this.setLocation(location);
    	
    	 
    
    	
    	if ( (curX+size >= maxWidth) || (curX < 0) ) 
    		dirX = -dirX ;
		if ( (curY+size >= maxHeight) || (curY < 0) )
			dirY = -dirY ;
    	
    
		location.setX(curX*dirX);
    	location.setY(curY*dirY);
    	this.setLocation(location);
    	
    	
    	
    } 
    
    */

    	
 


    @Override
    public String toString() {
       String parentDesc = super.toString();
       String myDesc = " Speed=" + speed + " Dir=" + direction;
       return parentDesc+myDesc;
    }
}
