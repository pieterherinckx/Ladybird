import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.Random;

public class BugWorld extends World
{
    /**
     * Create the crab world (the beach). Our world has a size 
     * of 560x460 cells, where every cell is just 1 pixel.
     */
    public BugWorld() 
    {
        super(560, 460, 1);
        setBackground("sand.jpg");
    }
}