package bbegameboard; 

import javax.swing.*;
import java.awt.*;

public class EntityReflection
{
    private Object e;
    private Hitbox h;
    private String backupPath;


    public EntityReflection(Object entity, String backupImgPath)
    {
        e = entity;
        backupPath = backupImgPath;
    }

    public Object getEntity()
    {
        return e;
    }
    public Hitbox getHitbox()
    {
        if(h == null)
        {
            Image img = getImage();
            h = new Hitbox(getX(),getY(),img.getWidth(null),img.getHeight(null));
        }
        h.setCoordinates(getX(),getY());
        return h;
    }
    public Image getImage()
    {
        try
        {
            Object oImg = e.getClass().getMethod("getImagePath").invoke(e);
            if(oImg instanceof String path)
            {
                return new ImageIcon(path).getImage();
            }
        }
        catch(Exception ex)
        {
            // method does not exist
        }
        return new ImageIcon(backupPath).getImage();
    }

    public int getX()
    {
        try
        {
            return toInt(e.getClass().getMethod("getX").invoke(e));
        }
        catch(Exception ex)
        {
            //System.out.println(ex.getMessage());
            // method does not exist
        }
        return 0;
    }

    public int getY()
    {
        try
        {
            return toInt(e.getClass().getMethod("getY").invoke(e));
        }
        catch(Exception ex)
        {
            // method does not exist
        }
        return 0;
    }

    public String getText()
    {
        try
        {
            Object o = e.getClass().getMethod("getText").invoke(e);
            if(o instanceof String s)
            {
                return s;
            }
        }
        catch(Exception ex)
        {
            // method does not exist
        }
        return null;
    }

    public void run()
    {
        try
        {
            e.getClass().getMethod("run").invoke(e);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setUp(boolean b)
    {
        try
        {
            e.getClass().getMethod("setUp",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }


    public void setDown(boolean b)
    {
        try
        {
            e.getClass().getMethod("setDown",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setLeft(boolean b)
    {
        try
        {
            e.getClass().getMethod("setLeft",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setRight(boolean b)
    {
        try
        {
            e.getClass().getMethod("setRight",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setSpace(boolean b)
    {
        try
        {
            e.getClass().getMethod("setSpace",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setEnter(boolean b)
    {
        try
        {
            e.getClass().getMethod("setEnter",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setW(boolean b)
    {
        try
        {
            e.getClass().getMethod("setW",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setA(boolean b)
    {
        try
        {
            e.getClass().getMethod("setA",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setS(boolean b)
    {
        try
        {
            e.getClass().getMethod("setS",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void setD(boolean b)
    {
        try
        {
            e.getClass().getMethod("setD",boolean.class).invoke(e,b);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }

    public void crashMuenze()
    {
        try
        {
            e.getClass().getMethod("crashMuenze").invoke(e);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }
    public void crashSpieler()
    {
        try
        {
            e.getClass().getMethod("crashSpieler").invoke(e);
        }
        catch(Exception ex)
        {
            // method does not exist
        }
    }
    
    private static int toInt(Object o)
    {
        if(o instanceof Double) {
            return (int)(double)o;
        }
        if(o instanceof Float) {
            return (int)(float)o;
        }
        if(o instanceof Integer || o instanceof Long || o instanceof Short || o instanceof Byte) {
            return (int)o;
        }
        if(o instanceof String)
        {
            try {
                return (int)Integer.parseInt((String)o);
            }
            catch(Throwable t) { }
        }
        return 0;
    }
}
