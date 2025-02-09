package bbegameboard;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;

public class Coin
{
    private int x;
    private int y;


    public Coin()
    {
        x = 0;
        y = 0;
    }
    public Coin(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public String getImagePath()
    {
        return "Coin.png";
    }
}
