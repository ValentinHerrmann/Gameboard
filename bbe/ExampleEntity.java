package bbe;

public class ExampleEntity
{

    /**
     * Rückgabewert ist x-Koordinate des Entities. Implementierung ist optional, falls nicht implementiert, wird 0 verwendet.
     */
    public double getX()
    {
        return 0;
    }

    /**
     * Rückgabewert ist y-Koordinate des Entities. Implementierung ist optional, falls nicht implementiert, wird 0 verwendet.
     */
    public double getY()
    {
        return 0;
    }

    /**
     * Rückgabewert ist Text, der neben dem Entity angezeigt werden soll. Implementierung ist optional, falls nicht implementiert, wird kein Text angezeigt.
     */
    public String getText()
    {
        return "";
    }

    /**
     *
     */
    public String getImagePath()
    {
        return "player/car.gif";
    }
    public double getScaleFactor()
    {
        return 1;
    }
    public boolean isStatic()
    {
        return false;
    }
    public String getGameoverMessage()
    {
        return "";
    }
    public void crash()
    {
    }
    public void crash(String otherClassname)
    {
    }
    public void crash(Object other)
    {
    }
    public void crash(String otherClassname, Object other)
    {
    }
    public void setLeft(boolean pressed)
    {
    }
    public void setRight(boolean pressed)
    {
    }
    public void setUp(boolean pressed)
    {
    }
    public void setDown(boolean pressed)
    {
    }
    public void setW(boolean pressed)
    {
    }
    public void setA(boolean pressed)
    {
    }
    public void setS(boolean pressed)
    {
    }
    public void setD(boolean pressed)
    {
    }
    public void setEnter(boolean pressed)
    {
    }
    public void setSpace(boolean pressed)
    {
    }
}
