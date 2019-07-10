package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer {
	private Label pointsValueLable ;
	private Label missileCountValueLable ;
	private Label elapsedTimeValueLable ;
	private Label livesCountValueLable ;
	private Label soundValueLable ;
	private Component soundLablel;

	
	/////  Constructor //////
	public PointsView() {
		 
		
	
	    
		//// Container to hold Player View Status
		Container myConatainer = new Container();   // Create a new container 
		myConatainer.setLayout(new BoxLayout(BoxLayout.X_AXIS)); // set layout for inside the container
		this.add(myConatainer);   // add container to pointView
		
		///// Labels for Point View 
		Label pointsLable=new Label("Points:") ;
		pointsValueLable=new Label("0") ;
		pointsLable.getAllStyles().setFgColor(ColorUtil.GREEN) ;  // set style for label
		pointsValueLable.getAllStyles().setFgColor(ColorUtil.GREEN) ; // set style for label
		myConatainer.add(pointsLable);   // add to Container
		myConatainer.add(pointsValueLable); //add to container 
		
		
		
		///// Labels for Missile Count view 
		Label missileCountLable=new Label("Missile Count:") ;
		missileCountValueLable=new Label("0") ;
		missileCountLable.getAllStyles().setFgColor(ColorUtil.GREEN) ;  // set style for label
		missileCountValueLable.getAllStyles().setFgColor(ColorUtil.GREEN) ; // set style for label
		myConatainer.add(missileCountLable);   // add to Container
		myConatainer.add(missileCountValueLable); //add to container 
		
		
		
		///// Labels for Elapsed Time  view 
		Label elapsedTimeLable=new Label("Elapsed Time:") ;
		elapsedTimeValueLable=new Label("0") ;
		elapsedTimeLable.getAllStyles().setFgColor(ColorUtil.GREEN) ;  // set style for label
		elapsedTimeValueLable.getAllStyles().setFgColor(ColorUtil.GREEN) ; // set style for label
		myConatainer.add(elapsedTimeLable);   // add to Container
		myConatainer.add(elapsedTimeValueLable); //add to container 
		
		
		///// Labels for Sound   view 
		Label soundLabel=new Label("Sound:") ;
		soundValueLable=new Label("ON") ;
		soundLabel.getAllStyles().setFgColor(ColorUtil.GREEN) ;  // set style for label
		soundValueLable.getAllStyles().setFgColor(ColorUtil.GREEN) ; // set style for label
		myConatainer.add(soundLabel);   // add to Container
		myConatainer.add(soundValueLable); //add to container 
		
		
	///// Labels for lives count   view 
			Label livesCountLabel=new Label("Lives:") ;
			livesCountValueLable=new Label("3") ;
			livesCountLabel.getAllStyles().setFgColor(ColorUtil.GREEN) ;  // set style for label
			livesCountValueLable.getAllStyles().setFgColor(ColorUtil.GREEN) ; // set style for label
			myConatainer.add(livesCountLabel);   // add to Container
			myConatainer.add(livesCountValueLable); //add to container
	}
	
	@Override
	public void update(Observable o , Object arg) {
		IGameWorld gw = (IGameWorld) arg;
		this.missileCountValueLable.setText(""+gw.getNumPlayerShipMissiles());
		this.pointsValueLable.setText(""+gw.getScore());
		this.elapsedTimeValueLable.setText(""+gw.getElapsedGameTime()/18);
		if(gw.getSound()) 
			this.soundValueLable.setText("ON");
		else 
			this.soundValueLable.setText("OFF");
		
		this.livesCountValueLable.setText(""+gw.getLives());
		this.repaint();
	}

	
	
	
}
