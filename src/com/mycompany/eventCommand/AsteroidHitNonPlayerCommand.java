package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class AsteroidHitNonPlayerCommand extends Command {

	private IGameWorld gw ;
	public AsteroidHitNonPlayerCommand(IGameWorld gw) {
		super("");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{   
		gw.asteroidImpactedNPS();
		//System.out.println("Asteroid Hit NonPlayer by PlayerHitsNonPlayerCommand" );
	}

}
