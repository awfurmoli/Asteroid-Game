package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class QuitCommand extends Command {

	private IGameWorld gw ;
	public QuitCommand(IGameWorld gw) {
		super("Quit");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.quit();
		//System.out.println("PlayerShip has quit by QuitCommand" );
	}

}
