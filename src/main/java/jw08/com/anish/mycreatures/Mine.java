package com.anish.mycreatures;

import java.awt.*;
import java.util.Random;

/**
 * 这个类是地雷类，我们吃了之后可以放三个地雷。
 * 地雷放下之后会每500ms变一次颜色，三次后爆炸，爆炸后9*9的格子里的生物gg
 * 那对于一颗地雷来说，他知道什么，首先，他知道自己变颜色，知道爆炸，知道炸人，就够了
 * @author ljh
 * @create 2021-12-26 18:51
 */
public class Mine extends Thing implements Runnable
{
    Random rand;
    public Mine(Color color, World world)
    {
        super(color, (char)48, world);
        rand = new Random(47);
    }
    public void boom()
    {
        int x = this.getX() - 1;
        int y = this.getY() - 1;
        for (int i = x; i < x + 3; i++)
        {
            for (int j = y; j < y + 3; j++)
            {
                if(world.get(i, j) instanceof Dragon)
                {
                    ((Dragon)world.get(i, j)).boom();
                }
                else if(world.get(i, j) instanceof Tank)
                {
                    ((Tank)world.get(i, j)).boom();
                }
                Fragment f = new Fragment(world);
                world.put(f, i, j);
                new Thread(f).start();
            }
        }
    }

    @Override
    public void run()
    {
        int i = 0;
        while(i < 3)
        {
            i++;
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            this.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        }
        this.boom();
    }
}
