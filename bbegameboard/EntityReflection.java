package bbegameboard; 

import java.awt.*;

@SuppressWarnings("UnnecessaryReturnStatement")
class EntityReflection
{
    private final Object e;
    private Hitbox h;
    private final String backupPath;


    EntityReflection(Object entity, String backupImgPath)
    {
        e = entity;
        backupPath = backupImgPath;
    }

    Object getEntity()
    {
        return e;
    }
    Hitbox getHitbox()
    {
        if(h == null)
        {
            Image img = getImage();
            h = new Hitbox(getX(),getY(),img.getWidth(null),img.getHeight(null));
        }
        h.setCoordinates(getX(),getY());
        return h;
    }
    Image getImage()
    {
        try
        {
            Object oImg = e.getClass().getMethod("getImagePath").invoke(e);
            if(oImg instanceof String path)
            {
                return ResourceTools.getImage(path);
            }
        }
        catch(Exception ex)
        {
            // method does not exist
        }
        return ResourceTools.getImage(backupPath);
    }

    int getX()
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

    int getY()
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

    String getText()
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

    void run()
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

    void setUp(boolean b)
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


    void setDown(boolean b)
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

    void setLeft(boolean b)
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

    void setRight(boolean b)
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

    void setSpace(boolean b)
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

    void setEnter(boolean b)
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

    void setW(boolean b)
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

    void setA(boolean b)
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

    void setS(boolean b)
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

    void setD(boolean b)
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

    void crash(String className, Object obj)
    {
        try
        {
            e.getClass().getMethod("crash", String.class, Object.class).invoke(e,className,obj);
            return;
        }
        catch(Exception ex) {  /*method does not exist*/ }

        try
        {
            e.getClass().getMethod("crash", String.class).invoke(e,className);
            return;
        }
        catch(Exception ex) {  /*method does not exist*/ }

        try
        {
            e.getClass().getMethod("crash", Object.class).invoke(e,obj);
            return;
        }
        catch(Exception ex) {  /*method does not exist*/ }

        try
        {
            e.getClass().getMethod("crash").invoke(e);
            return;
        }
        catch(Exception ex) {  /*method does not exist*/ }


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
                return Integer.parseInt((String)o);
            }
            catch(Throwable t) { /* do nothing */ }
        }
        return 0;
    }
}
