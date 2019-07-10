package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class IncreasePlayerSpeedCommand extends Command {

	private IGameWorld gw ;
	public IncreasePlayerSpeedCommand(IGameWorld gw) {
		super("");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.increasePlayerShipSpeed();
		//System.out.println("PS speed increased by IncreasePlayerSpeedCommand" );
	}

}
