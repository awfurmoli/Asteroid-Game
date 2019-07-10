package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class PlayerHitsNonPlayerCommand extends Command {

	private IGameWorld gw ;
	public PlayerHitsNonPlayerCommand(IGameWorld gw) {
		super("");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{   
		gw.playerShipHitNPS();
		//System.out.println("Player Hit NonPlayer by PlayerHitsNonPlayerCommand" );
	}

}
