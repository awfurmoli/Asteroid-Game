package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class AboutCommand extends Command {

	private IGameWorld gw ;
	public AboutCommand(IGameWorld gw) {
		super("About");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.about();
		//System.out.println("Player has About by AboutCommand" );
	}

}
