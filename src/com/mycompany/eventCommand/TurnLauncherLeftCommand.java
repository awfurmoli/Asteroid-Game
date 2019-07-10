package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class TurnLauncherLeftCommand extends Command {

	private IGameWorld gw ;
	public TurnLauncherLeftCommand(IGameWorld gw) {
		super("");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.turnPlayerMissileCounterClockwise();
		//System.out.println("PS turned left by TurnLauncherLeftCommand" );
	}

}
