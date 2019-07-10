package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.plaf.Border;


public class MapView extends Container implements Observer {
	
	private GameWorld gw ;
	
///// Constructor
	public MapView(GameWorld gw) {
		this.gw=gw ;
		this.getStyle().setBorder(Border.createLineBorder(10, ColorUtil.BLACK));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Point pCmpRelPrnt = new Point(getX(), getY());
		GameObject cur ;
		IIterator itr = gw.getStore1().getIterator() ;
		while(itr.hasNext()) {
			cur= (GameObject)itr.getNext() ;
			if(cur instanceof IDrawable ) {
				((IDrawable) cur ).draw(g, pCmpRelPrnt);
			}
		}
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		

		((IGameWorld)data).printMap();
		
		
		this.repaint();
	}
	
	
} 
