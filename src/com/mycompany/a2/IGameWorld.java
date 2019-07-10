package com.mycompany.a2;

public interface IGameWorld {
	
	public void init();
	public void printMap();
	public void about();
	public void addAsteroid();
	public void addNonPlayerShip();
	public void addPlayerShip();
	public void addSpaceStation();
	public void twoAsteroidCollision();
	public void asteroidImpactedNPS();
	public void decreasePlayerShipSpeed();
	public void increasePlayerShipSpeed();
	public void jumpThroughHyperspace();
	public void loadPlayerMissiles();
	public void launchNPSMissile();
	public void NPSMissileExplodePS();
	public void playerShipHitNPS();
	public void playerKillsAstroid();
	public void playerElimNPS();
	public void firePlayerMissile();
	public void playerShipCrashAstroid();
	public void quit();
	public void setSound();
	public void tick(int time);
	public void turnPlayerMissileCounterClockwise();
	public void turnPlayerMissileClockwise();
	public void turnPlayerShipLeft();
	public void turnPlayerShipRight();
	
	public int getNumPlayerShipMissiles();
	public int getScore();
	public int getElapsedGameTime();
	public boolean getSound();
	public int getLives();
	
}
 