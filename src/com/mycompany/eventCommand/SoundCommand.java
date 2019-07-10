package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class SoundCommand extends Command {

	private IGameWorld gw ;
	public SoundCommand(IGameWorld gw) {
		super("Sound");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		gw.setSound();
		//System.out.println("Player has Sound  by SoundCommand" );
	}

}
