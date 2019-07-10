package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class SaveCommand extends Command {

	private IGameWorld gw ;
	public SaveCommand(IGameWorld gw) {
		super("Save");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		//gw.addNonPlayerShip();
		//System.out.println("Player has Save  by SaveCommand" );
	}

}
