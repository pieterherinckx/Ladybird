import greenfoot.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Animal. This is the base class for all animals. In addition to the standard Actor
 * methods, it provides the ability to move and turn.
 * 
 * @author Michael Kolling
 * @version 1.0
 */
public class Animal extends Actor
{
    //private static final double WALKING_SPEED = 5.0;
    private boolean movingRight = true;   
    
    /**
     * Turn 'angle' degrees towards the right (clockwise).
     */
    public void turn(int angle)
    {
        setRotation(getRotation() + angle);
    }
    

    /**
     * Move forward in the current direction with the given speed.
     */
    public void move(int speed)
    {
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * speed);
        int y = (int) Math.round(getY() + Math.sin(angle) * speed);
        
        setLocation(x, y);
    }

    
    /**
     * Test if we are close to one of the edges of the world. Return true is we are.
     */
    public boolean atWorldEdge()
    {
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    
    
    /**
     * Return true if we can see an object of class 'clss' right where we are. 
     * False if there is no such object here.
     */
    public boolean canSee(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    
    /**
     * Try to eat an object of class 'clss'. This is only successful if there
     * is such an object where we currently are. Otherwise this method does
     * nothing.
     */
    public void eat(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
    
    
    /**
     * Check whether a given key is currently pressed down.
     */
    public boolean isKeyPressed(String keyName)
    {
        return Greenfoot.isKeyDown(keyName);
    }
    
    /**
     * Makes the actor move automatically with the given speed.
     */
    public void moveAutomatically(int speed)
    {
        move(speed);
        if(atWorldEdge()){
            turn(Greenfoot.getRandomNumber(30));
        }
    }
    
}