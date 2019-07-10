package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class DecreasePlayerSpeedCommand extends Command {

	private IGameWorld gw ;
	public DecreasePlayerSpeedCommand(IGameWorld gw) {
		super("");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.decreasePlayerShipSpeed();
		//System.out.println("PS speed decreased by DecreasePlayerSpeedCommand" );
	}

}
