package jw08;

import com.anish.mycreatures.Bullet;
import com.anish.mycreatures.Tank;
import com.anish.mycreatures.Wall;
import com.anish.mycreatures.World;
import com.anish.utils.Direction;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author ljh
 * @create 2021-12-26 9:21
 */
public class BulletTest
{
    World wo;
    @Before
    public void setUp()
    {
        wo = new World();
        for (int i = 0; i < 10; i++)
        {
            wo.put(new Wall(wo), i, 1);
        }
    }
    @Test
    public void isCountWallTest()
    {
        Bullet bu = new Bullet(wo);
        wo.put(bu, 0, 0);
        Direction before = bu.direction;
        bu.isCountWall();
        Direction now = bu.direction;
        assertEquals(before, now);
        bu.direction = Direction.DOWN;
        bu.isCountWall();
        now = bu.direction;
        assertNotEquals(before, now);
    }
    @Test
    public void isCountCreatureTest()
    {
        Bullet bu = new Bullet(wo);
        wo.put(bu, 0, 0);
        assertFalse(bu.isCountCreature());
        wo.put(new Tank(Color.magenta, wo), bu.direction.getX(), bu.direction.getY());
        assertTrue(bu.isCountCreature());
    }
}
