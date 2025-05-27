package bbe;

import java.awt.*;
import java.lang.reflect.Method;

@SuppressWarnings("UnnecessaryReturnStatement")
class EntityReflection
{
    private final Object e;
    private Hitbox h;
    private final String backupPath;
    //private final List<String> notImplementedMethods = new ArrayList<>();

    enum MethodIDs
    {
        getX,
        getY,
        getText,
        getImagePath,

        run,

        setUp,
        setDown,
        setLeft,
        setRight,
        setW,
        setA,
        setS,
        setD,
        setSpace,
        setEnter,

        crash,
        isStatic,
        getScaleFactor,
        getGameoverMessage,
    }
    private final boolean[] implementedMethodsMap = new boolean[MethodIDs.values().length];


    EntityReflection(Object entity, String backupImgPath)
    {
        e = entity;
        backupPath = backupImgPath;
        parseImplementedMethods();
    }


    private void parseImplementedMethods()
    {
        Method[] methods = e.getClass().getMethods();
        for(Method m : methods)
        {
            try
            {
                implementedMethodsMap[MethodIDs.valueOf(m.getName()).ordinal()] = true;

                if(m.getName().equals("isStatic"))
                {
                    try
                    {
                        implementedMethodsMap[MethodIDs.valueOf(m.getName()).ordinal()] = (Boolean)m.invoke(e);
                    }
                    catch (Exception ex) {  /*method does not exist*/ }
                }
            }
            catch (IllegalArgumentException ignored)
            {

            }
        }
    }




    Object getEntity()
    {
        return e;
    }
    Hitbox getHitbox()
    {
        Image img = getImage();
        if(h==null)
        {
            h = new Hitbox(getX(),getY(),(int)(img.getWidth(null)*getScaleFactor()),(int)(img.getHeight(null)*getScaleFactor()));
        }
        else
        {
            h.setCoordinates(getX(), getY());
            h.setWidth((int)(img.getWidth(null)*getScaleFactor()));
            h.setHeight((int)(img.getHeight(null)*getScaleFactor()));
        }

        return h;
    }
    Image getImage()
    {
        if(implementedMethodsMap[MethodIDs.getImagePath.ordinal()])
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
        }
        return ResourceTools.getImage(backupPath);
    }

    double getScaleFactor()
    {

        if(implementedMethodsMap[MethodIDs.getScaleFactor.ordinal()])
        {
            try
            {
                return (Double)e.getClass().getMethod("getScaleFactor").invoke(e);
            }
            catch (Exception ex)
            {
                //System.out.println(ex.getMessage());
                // method does not exist
            }
        }
        return 1;
    }


    String getGameoverMessage()
    {

        if(implementedMethodsMap[MethodIDs.getGameoverMessage.ordinal()])
        {
            try
            {
                String msg = (String)(e.getClass().getMethod("getGameoverMessage").invoke(e));
                if(msg != null && msg.isEmpty())
                {
                    msg = null;
                }
                return msg;
            }
            catch (Exception ex)
            {
                //System.out.println(ex.getMessage());
                // method does not exist
            }
        }
        return null;
    }

    int getX()
    {

        if(implementedMethodsMap[MethodIDs.getX.ordinal()])
        {
            try
            {
                return toInt(e.getClass().getMethod("getX").invoke(e));
            }
            catch (Exception ex)
            {
                //System.out.println(ex.getMessage());
                // method does not exist
            }
        }
        return 0;
    }

    int getY()
    {
        if(implementedMethodsMap[MethodIDs.getY.ordinal()])
        {
            try
            {
                return toInt(e.getClass().getMethod("getY").invoke(e));
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
        return 0;
    }

    String getText()
    {
        if(implementedMethodsMap[MethodIDs.getText.ordinal()])
        {
            try
            {
                Object o = e.getClass().getMethod("getText").invoke(e);
                if (o instanceof String s)
                {
                    return s;
                }
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
        return null;
    }

    void run()
    {
        if(implementedMethodsMap[MethodIDs.run.ordinal()])
        {

            try
            {
                e.getClass().getMethod("run").invoke(e);
                //h.setCoordinates(getX(), getY());
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setUp(boolean b)
    {
        if(implementedMethodsMap[MethodIDs.setUp.ordinal()])
        {
            try
            {
                e.getClass().getMethod("setUp", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }


    void setDown(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setDown.ordinal()])
        {
            try
            {
                e.getClass().getMethod("setDown", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setLeft(boolean b)
    {
        if(implementedMethodsMap[MethodIDs.setLeft.ordinal()])
        {

            try
            {
                e.getClass().getMethod("setLeft", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setRight(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setRight.ordinal()])
        {
            try
            {
                e.getClass().getMethod("setRight", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setSpace(boolean b)
    {
        if(implementedMethodsMap[MethodIDs.setSpace.ordinal()])
        {

            try
            {
                e.getClass().getMethod("setSpace", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setEnter(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setEnter.ordinal()])
        {

            try
            {
                e.getClass().getMethod("setEnter", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setW(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setW.ordinal()])
        {

            try
            {
                e.getClass().getMethod("setW", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setA(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setA.ordinal()])
        {
            try
            {
                e.getClass().getMethod("setA", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setS(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setS.ordinal()])
        {
            try
            {
                e.getClass().getMethod("setS", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void setD(boolean b)
    {

        if(implementedMethodsMap[MethodIDs.setD.ordinal()])
        {

            try
            {
                e.getClass().getMethod("setD", boolean.class).invoke(e, b);
            }
            catch (Exception ex)
            {
                // method does not exist
            }
        }
    }

    void crash(String className, Object obj)
    {
        if(implementedMethodsMap[MethodIDs.crash.ordinal()])
        {

            try
            {
                e.getClass().getMethod("crash", String.class, Object.class).invoke(e, className, obj);
                return;
            }
            catch (Exception ex) {  /*method does not exist*/ }

            try
            {
                e.getClass().getMethod("crash", String.class).invoke(e, className);
                return;
            }
            catch (Exception ex) {  /*method does not exist*/ }

            try
            {
                e.getClass().getMethod("crash", Object.class).invoke(e, obj);
                return;
            }
            catch (Exception ex) {  /*method does not exist*/ }

            try
            {
                e.getClass().getMethod("crash").invoke(e);
                return;
            }
            catch (Exception ex) {  /*method does not exist*/ }
        }
    }

    boolean isStatic()
    {
        return implementedMethodsMap[MethodIDs.isStatic.ordinal()];
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
