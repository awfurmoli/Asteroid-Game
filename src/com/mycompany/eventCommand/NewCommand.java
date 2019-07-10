package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class NewCommand extends Command {

	private IGameWorld gw ;
	public NewCommand(IGameWorld gw) {
		super("New");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		//gw.addNonPlayerShip();
		//System.out.println("Player has New  by NewCommand" );
	}

}
