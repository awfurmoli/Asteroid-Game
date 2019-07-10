package com.mycompany.eventCommand;

import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;


import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AddAsteroidCommand extends Command {

	private IGameWorld gw ;
	public AddAsteroidCommand(IGameWorld gw) {
		super("+Asteroid");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.addAsteroid();			
	}
}
