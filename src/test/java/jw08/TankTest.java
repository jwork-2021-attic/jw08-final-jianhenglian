package jw08;

import com.anish.mycreatures.*;
import com.anish.utils.Direction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author ljh
 * @create 2021-12-26 14:19
 */
public class TankTest
{
    static World wo;
    static Tank tank;
    @Before
    public void setUp()
    {
        tank = new Tank(Color.magenta, wo);
        wo.put(tank, 0, 0);
    }
    @BeforeClass
    public static void makeTank()
    {
        wo = new World();
        for (int i = 0; i < 10; i++)
        {
            wo.put(new Wall(wo), i, 1);
        }
    }
    @Test
    public void testSetAndGetDirection()
    {
        assertEquals(tank.getDirection(), Direction.RIGHT);
        tank.setDirection(Direction.UP);
        assertEquals(tank.getDirection(), Direction.UP);
    }
    @Test
    public void testGetDirectionXY()
    {
        assertEquals(tank.getDirection().getX(), tank.getDirectionX());
        assertEquals(tank.getDirectionY(), tank.getDirection().getY());
    }
    @Test
    public void testComMoveTo()
    {
        assertEquals(tank.getX(), 0);
        assertEquals(tank.getY(), 0);
        tank.comMoveTo();
        assertEquals(tank.getX(), 1);
        assertEquals(tank.getY(), 0);
        assertTrue(wo.get(0, 0) instanceof Floor);
    }
    @Test
    public void testIsCountWall()
    {
        assertFalse(tank.isCountWall());
        wo.put(new Wall(wo), 1, 0);
        assertTrue(tank.isCountWall());
    }
    @Test
    public void testDead()
    {
        assertFalse(tank.isDead());
        tank.boom();
        assertTrue(tank.isDead());
    }
    @Test
    public void testFireBullet()
    {
        tank.fireBullet();
        for (int i = 0; i < World.WIDTH; i++)
        {
            if(wo.get(i, 0) instanceof Bullet)
            {
                assertTrue(true);
            }
        }
    }
}
