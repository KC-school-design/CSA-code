/**
 * STUDENT FILE: Duck behavior.
 *
 * Sprite provides the graphics code. Your job is to make the Duck move,
 * bounce, fall, and reset.
 */
public class Pacman extends Sprite {
    // ===============================
    // STUDENT SETTINGS
    // ===============================
    private int dx = 4;
    private int dy = 2;

    // ===============================
    // GAME STATE - mostly provided
    // ===============================
    private int homeX;
    private int homeY;
    private int fallSpeed = 1;
    private boolean active = false;
    private boolean falling = false;
    private boolean landed = false;
    private int justlanded = 0;
    Music soundpacman = new Music("pacman3.wav", false);
    Music Ooffall = new Music("Oof.wav", false);
    public Pacman() {
        this(150, 120);
    }

    public Pacman(int startX, int startY) {
        // Change duck.gif to your own Halloween or fall image later.
        super("pacmanmovingright.gif", startX, startY, 64, 64);

        homeX = startX;
        homeY = startY;
    }

    /**
     * STEP 1: make the Duck move.
     * STEP 2: add the bouncing rules.
     * STEP 3: add the falling rules.
     */
    public void update() {
        
    	if (!active) {
            return;
        }
    	

    	    	
        if (falling) {
            // STEP 3: Uncomment and complete the falling code.

        	
        	y = y + fallSpeed;
            fallSpeed = fallSpeed + 1;
             
             
             changePicture("deadpacman.png");
             if (y + height >= GameWorld.GROUND_TOP) {
            	 y = GameWorld.GROUND_TOP;
            	 // original line:   y = GameWorld.GROUND_TOP - height;
                 landed = true;
                 justlanded += 1;
             }
             
             
           return;
        }
        else {
        

        // STEP 1: Uncomment these lines to move the Duck.
         x = x + dx;
         y = y + dy;
         

        // STEP 2: Add if statements that bounce the Duck off the edges.
        // Hint: reverse a direction by changing dx to -dx or dy to -dy.
        // Hint: GameWorld.WORLD_WIDTH is the width of the game.
        // Hint: GameWorld.GROUND_TOP is the top of the ground.
   
        if (x >= (GameWorld.WORLD_WIDTH-50) || x <= 0) {
        	 	dx *= -1;
        	 if (x >= GameWorld.WORLD_WIDTH -50) {
        		 changePicture("pacmanmovingleft (2).gif");
        	 }
        	 if (x <= 0) {
        		 changePicture("pacmanmovingright.gif");
        	 }
        	 	
         }
        if ( y >= GameWorld.GROUND_TOP || y <= 0) {
        	 dy *= -1;
         }
    

        } 
    
    
    }
    
    /**
     * STEP 3: Uncomment the two lines below so a successful click starts the
     * falling behavior.
     */
    public void startFalling() {
        if (active && !falling) {
        	falling = true;
            fallSpeed = 2;
             
        }
    }

    public boolean hasLanded() {
        return active && landed;    
    }

    public boolean isFalling() {
        return falling;
    }

    public boolean isActive() {
        return active;
    }
    
    public int justlandedcount() {
    	
        return justlanded;
    }

    @Override
    public boolean wasClicked(int mouseX, int mouseY) {
        return active && !falling && super.wasClicked(mouseX, mouseY);
    }

    // These methods are provided so the GameWorld can manage progression.
    public void activate() {
        active = true;
        reset();
        
        
    }

    public void deactivate() {
        active = false;
    }

    /** STEP 4: verify that reset returns the Duck to its starting position. */
    public void reset() {
        x = homeX;
        y = homeY;
        fallSpeed = 2;
        falling = false;
        landed = false;
    }
}
