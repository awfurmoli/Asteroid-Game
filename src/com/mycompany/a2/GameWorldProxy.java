package com.mycompany.a2;

import java.util.Observable;

//import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld  {

	private GameWorld gw ;
	
	
	public GameWorldProxy(GameWorld gw) {
		this.gw=gw ;
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printMap() {
		// TODO Auto-generated method stub
		gw.printMap();
	}

	@Override
	public void about() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addAsteroid() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addNonPlayerShip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayerShip() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addSpaceStation() {
		// TODO Auto-generated method stub
	}

	@Override
	public void twoAsteroidCollision() {
		// TODO Auto-generated method stub
	}

	@Override
	public void asteroidImpactedNPS() {
		// TODO Auto-generated method stub
	}

	@Override
	public void decreasePlayerShipSpeed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void increasePlayerShipSpeed() {
		// TODO Auto-generated method stub
	}

	@Override
	public void jumpThroughHyperspace() {
		// TODO Auto-generated method stub
	}

	@Override
	public void loadPlayerMissiles() {
		// TODO Auto-generated method stub
	}

	@Override
	public void launchNPSMissile() {
		// TODO Auto-generated method stub
	}

	@Override
	public void NPSMissileExplodePS() {
		// TODO Auto-generated method stub
	}

	@Override
	public void playerShipHitNPS() {
		// TODO Auto-generated method stub
	}

	@Override
	public void playerKillsAstroid() {
		// TODO Auto-generated method stub
	}

	@Override
	public void playerElimNPS() {
		// TODO Auto-generated method stub
	}

	@Override
	public void firePlayerMissile() {
		// TODO Auto-generated method stub
	}

	@Override
	public void playerShipCrashAstroid() {
		// TODO Auto-generated method stub
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
	}

	@Override
	public void setSound() {
		// TODO Auto-generated method stub
	}

	@Override
	public void tick(int time) {
		// TODO Auto-generated method stub
	}

	@Override
	public void turnPlayerMissileCounterClockwise() {
		// TODO Auto-generated method stub
	}

	@Override
	public void turnPlayerMissileClockwise() {
		// TODO Auto-generated method stub
	}

	@Override
	public void turnPlayerShipLeft() {
		// TODO Auto-generated method stub
	}

	@Override
	public void turnPlayerShipRight() {
		// TODO Auto-generated method stub
	}
	@Override
	public int getNumPlayerShipMissiles() {
		// TODO Auto-generated method stub
		return gw.getNumPlayerShipMissiles();
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return gw.getScore();
	}
	@Override
	public int  getElapsedGameTime() {
		// TODO Auto-generated method stub
		return gw.getElapsedGameTime();
	}
	@Override
	public boolean getSound() {
		// TODO Auto-generated method stub
		return gw.getSound();
	}
	@Override
	public int getLives() {
		// TODO Auto-generated method stub
		return gw.getLives() ;
	}

}
