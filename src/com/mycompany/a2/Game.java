package com.mycompany.a2;

import java.lang.String;

import com.codename1.charts.util.ColorUtil;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Point2D;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.mycompany.eventCommand.*;


public class Game extends Form implements Runnable{
    private GameWorld gw ;
    private  MapView mv ;
    private PointsView pv ;
    UITimer timer ;
    
    
    
    //private BGSound bgSound ;
    
    
    ///Button
    private Button addAsteroidButton;
    private Button addNpsButton;
    private Button addSpaceStationButton;
    private Button addPlayerShipButton;
    private Button playerShipFireButton;
    private Button jumpButton;
   
    
    
    //Commands
    private AddAsteroidCommand comAddAsteroid;
    private AddNonPlayerShipCommand comAddNPS;
    private AddSpaceStationCommand comAddSpaceStation;
    private AddPlayerShipCommand comAddPlayerShip;
    private PlayerShipFireCommand comPlayerFire;
    private JumpCommand jumpCommand;
    
    //Non Button Commands
    private AboutCommand comAbout;
    private AsteroidHitAsteroidCommand comAsteroidHitAsteroid;
    private AsteroidHitNonPlayerCommand comAsteroidHitNP;
    private DecreasePlayerSpeedCommand comDecreaseSpeed;
    private IncreasePlayerSpeedCommand comIncreaseSpeed;
    private LoadPlayerMissileCommand comLoadMissile;
    private NewCommand comNew;
    private NonPlayerFireCommand comNPSFire;
    private NonPlayerMissileHitPlayerCommand comNPMHitPlayer;
    private PlayerHitsNonPlayerCommand comPlayerHitNP;
    private PlayerMissileHitAsteroidCommand comPlayerMHitA;
    private PlayerMissileHitNonPlayerCommand comPlayerMHitNP;
    private PlayerShipHitsAsteroidCommand comPlayerHitA;
    private QuitCommand comQuit;
    private SaveCommand comSave;
    private SoundCommand comSound;
    private TurnLauncherLeftCommand comTurnLauncherL;
    private TurnLauncherRightCommand comTurnLauncherR;
    private TurnPlayerLeftCommand comTurnPlayerL;
    private TurnPlayerRightCommand comTurnPlayerR;
    private UndoCommand comUndo;
    
    //MENU CONTAINER
    Container leftContainer;

    public Game(){
    	
    	
    	timer= new UITimer(this);
    	timer.schedule(50, true , this);
    	
    	
        this.gw = new GameWorld();
        this.mv = new MapView(gw);
        this.pv= new PointsView();
        this.gw.addObserver(mv);
        this.gw.addObserver(pv);
        
        // set the background Music
        //bgSound= new BGSound("background.mp3") ;
        
        
        
        
        
        
        
       // bgSound.play();
       
        //add title and set layout
        this.setTitle("Asteroid Game");
    	this.setLayout(new BorderLayout());
    	
    	//add views and container for buttons
    	this.add(BorderLayout.CENTER, mv);  //map view
    	this.add(BorderLayout.NORTH, pv); //points view
    	
    	this.leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    	this.leftContainer.getAllStyles().setBorder(Border.createLineBorder(10,ColorUtil.BLACK));
    	
    	//BUTTONS AND COMMANDS IMPLEMENTATION
    	
    	// Add a new asteroid command and keyBinding
    	this.addAsteroidButton = new Button("Add Asteroid");
    	addAsteroidButton.getAllStyles().setPadding(TOP,5) ;
    	addAsteroidButton.getAllStyles().setPadding(BOTTOM,5) ;
    	this.comAddAsteroid = new AddAsteroidCommand(this.gw);
    	this.addAsteroidButton.setCommand(comAddAsteroid);
    	this.leftContainer.add(this.addAsteroidButton);
    	addKeyListener('a', comAddAsteroid);
    	this.addAsteroidButton.setFocusable(false);
    	
    	
    	
    	
    
    	// Add a new NOnPlayerShip command and keyBinding
    	this.addNpsButton = new Button("addNPS");
    	addNpsButton.getAllStyles().setPadding(TOP,5) ;
    	addNpsButton.getAllStyles().setPadding(BOTTOM,5) ;
    	this.comAddNPS = new AddNonPlayerShipCommand(this.gw);
    	this.addNpsButton.setCommand(comAddNPS);
    	this.leftContainer.add(this.addNpsButton);
    	addKeyListener('y', comAddNPS);
    	this.addNpsButton.setFocusable(false);
    	
    	
    	// Add a new SpaceStation command and keyBinding
    	this.addSpaceStationButton = new Button("addSpace Station");
    	addSpaceStationButton.getAllStyles().setPadding(TOP,5) ;
    	addSpaceStationButton.getAllStyles().setPadding(BOTTOM,5) ;
    	this.comAddSpaceStation = new AddSpaceStationCommand(this.gw);
    	this.addSpaceStationButton.setCommand(comAddSpaceStation);
    	this.leftContainer.add(this.addSpaceStationButton);
    	addKeyListener('b', comAddSpaceStation);
    	this.addSpaceStationButton.setFocusable(false);
    	
    	
    	// Add a new PlayerShip command and keyBinding
    	this.addPlayerShipButton = new Button("Add PlayerShip");
    	addPlayerShipButton.getAllStyles().setPadding(TOP,5) ;
    	addPlayerShipButton.getAllStyles().setPadding(BOTTOM,5) ;
    	this.comAddPlayerShip = new AddPlayerShipCommand(this.gw);
    	this.addPlayerShipButton.setCommand(comAddPlayerShip);
    	this.leftContainer.add(this.addPlayerShipButton);
    	addKeyListener('s', comAddPlayerShip);
    	this.addPlayerShipButton.setFocusable(false);
    	
    	
    	// Playership fire command and keyBinding
    	this.playerShipFireButton = new Button("PlayerShip fire");
    	playerShipFireButton.getAllStyles().setPadding(TOP,5) ;
    	playerShipFireButton.getAllStyles().setPadding(BOTTOM,5) ;
    	this.comPlayerFire = new PlayerShipFireCommand(this.gw);
    	this.playerShipFireButton.setCommand(comPlayerFire);
    	this.leftContainer.add(this.playerShipFireButton);
    	addKeyListener(-90, comPlayerFire);
    	addKeyListener('f', comPlayerFire);
    	this.playerShipFireButton.setFocusable(false);
    	
    	
   
    	
    
    	// Jump  command and keyBinding
    	this.jumpButton = new Button("Jump Botton");
    	jumpButton.getAllStyles().setPadding(TOP,5) ;
    	jumpButton.getAllStyles().setPadding(BOTTOM,5) ;
    	this.jumpCommand = new JumpCommand(this.gw);
    	this.jumpButton.setCommand(jumpCommand);
    	this.leftContainer.add(this.jumpButton);
    	addKeyListener('j', jumpCommand);
    	this.jumpButton.setFocusable(false);
    	
    	
    	//OTHER MENU COMMANDS
    	this.comAbout = new AboutCommand(this.gw);
    	this.comNew = new NewCommand(this.gw);
    	this.comSave = new SaveCommand(this.gw);
    	this.comUndo = new UndoCommand(this.gw);
    	
    	//NON BUTTON COMMANDS IMPLEMENTED
    	this.comAsteroidHitAsteroid = new AsteroidHitAsteroidCommand(this.gw);
    	this.addKeyListener('x', comAsteroidHitAsteroid);
    	
    	this.comAsteroidHitNP = new AsteroidHitNonPlayerCommand(this.gw);
    	this.addKeyListener('I', comAsteroidHitNP);
    	
    	this.comDecreaseSpeed = new DecreasePlayerSpeedCommand(this.gw);
    	this.addKeyListener(-92 , comDecreaseSpeed);
    	this.addKeyListener('d' , comDecreaseSpeed);
    	
    	this.comIncreaseSpeed = new IncreasePlayerSpeedCommand(this.gw);
    	this.addKeyListener(-91 , comIncreaseSpeed);
    	this.addKeyListener('i' , comIncreaseSpeed);
    	
    	this.comLoadMissile = new LoadPlayerMissileCommand(this.gw);
    	this.addKeyListener('n' , comLoadMissile);
    	
    	this.comNPSFire = new NonPlayerFireCommand(this.gw);
    	this.addKeyListener('L' , comNPSFire);
    	
    	this.comNPMHitPlayer = new NonPlayerMissileHitPlayerCommand(this.gw);
    	this.addKeyListener('E' , comNPMHitPlayer);
    	
    	this.comPlayerHitNP = new PlayerHitsNonPlayerCommand(this.gw);
    	this.addKeyListener('h' , comPlayerHitNP);
    	
    	this.comPlayerMHitA = new PlayerMissileHitAsteroidCommand(this.gw);
    	this.addKeyListener('k' , comPlayerMHitA);
    	
    	this.comPlayerMHitNP = new PlayerMissileHitNonPlayerCommand(this.gw);
    	this.addKeyListener('e' , comPlayerMHitNP);
    	
    	this.comPlayerHitA = new PlayerShipHitsAsteroidCommand(this.gw);
    	this.addKeyListener('c' , comPlayerHitA);
    	
    	this.comQuit = new QuitCommand(this.gw);
    	this.addKeyListener('q', comQuit);
    	
    
    	
    	this.comTurnLauncherL = new TurnLauncherLeftCommand(this.gw);
    	this.addKeyListener('1', comTurnLauncherL);
    	
    	this.comTurnLauncherR = new TurnLauncherRightCommand(this.gw);
    	this.addKeyListener('3', comTurnLauncherR);
    	
    	this.comTurnPlayerL = new TurnPlayerLeftCommand(this.gw);
    	this.addKeyListener(-93, comTurnPlayerL);
    	this.addKeyListener('l', comTurnPlayerL);
    	
    	
    	this.comTurnPlayerR = new TurnPlayerRightCommand(this.gw);
    	this.addKeyListener(-94, comTurnPlayerR);
    	this.addKeyListener('r', comTurnPlayerR);
    	
    	
    	
    	///TOOLBAR
    	Toolbar bar = new Toolbar(); 
    	this.setToolbar(bar);
    	bar.setTitle("Asteroid Game");
    	
    	//SOUNDBOX MENU
    	this.comSound = new SoundCommand(this.gw);
    	CheckBox soundBox = new CheckBox();
    	soundBox.setSelected(true);
    	soundBox.setCommand(this.comSound);
    	
    	//ADD ALL COMPONENTS TO MENU
    	bar.addCommandToSideMenu(this.comAbout);
    	bar.addCommandToSideMenu(this.comNew);
    	bar.addCommandToSideMenu(this.comSave);
    	bar.addCommandToSideMenu(this.comUndo);
    	bar.addComponentToSideMenu(soundBox);
    	bar.addCommandToSideMenu(this.comQuit);
    	
    	this.add(BorderLayout.WEST, this.leftContainer);
    	this.show();
    	
    	//bgSound.play();
    
    

    	
    	/// set width and height for gameworld
    //	gw.setDimesion(this.getWidth() ,this.getHeight()) ;
    	gw.setDimesion(mv.getWidth() ,mv.getHeight()) ;
    	
    	
    	
    	
  	   
    }

	@Override
	public void run() {
		gw.tick(50);
		
	}
}


