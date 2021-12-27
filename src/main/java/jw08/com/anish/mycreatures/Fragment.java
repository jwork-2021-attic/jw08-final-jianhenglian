package com.anish.mycreatures;

import java.awt.*;

/**
 * 现在想想，这个碎片应该会自己消失才对
 * @author ljh
 * @create 2021-12-26 19:03
 */
public class Fragment extends Thing implements Runnable
{
    public Fragment(World world)
    {
        super(Color.blue, (char)4, world);
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        world.put(new Floor(world), this.getX(), this.getY());
    }
}
