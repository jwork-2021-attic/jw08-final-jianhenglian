package com.anish.screen;

import asciiPanel.AsciiPanel;
import com.anish.mycreatures.Floor;
import com.anish.mycreatures.Fragment;
import com.anish.mycreatures.MyChar;
import com.anish.mycreatures.World;

import java.awt.event.KeyEvent;

/**
 * 这个屏幕询问你要干什么，按c继续上一句，按n新开一局
 * @author ljh
 * @create 2021-12-26 19:37
 */
public class BeginScreen implements Screen
{
    private World world;
    public BeginScreen()
    {
        world = new World();
        for (int i = 0; i < World.WIDTH; i++)
        {
            for (int j = 0; j < World.HEIGHT; j++)
            {
                world.put(new Floor(world), i, j);
            }
        }
        outputWord("Press C to continue", 30, 30);
        outputWord("Press N to begin a new game", 30, 31);
    }
    @Override
    public void displayOutput(AsciiPanel terminal)
    {
        for (int x = 0; x < World.WIDTH; x++)
        {
            for (int y = 0; y < World.HEIGHT; y++)
            {
                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key)
    {
        switch (key.getKeyChar())
        {
            case 'c':
                break;
            case 'n':
                return new FightScreen();
            default:
                System.out.println("guami");
        }
        return this;
    }
    public void outputWord(String targetWord, int startX, int startY)
    {
        startX -= 5;
        int i = 0;
        for (char c : targetWord.toCharArray())
        {
            world.put(new MyChar(c, world), startX + i++, startY);
        }
    }
}
