package com.mycompany.eventCommand;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.IGameWorld;

public class UndoCommand extends Command {

	private IGameWorld gw ;
	public UndoCommand(IGameWorld gw) {
		super("Undo");
		this.gw=gw;
	}
	 
	@Override//overriding parent method//invoked to perform the 'addNewAsteroid' operation
	public void actionPerformed(ActionEvent ev)
	{
		//gw.addNonPlayerShip();
		//System.out.println("Player has Undo  by JumpCommand" );
	}

}
