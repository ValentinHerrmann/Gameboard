package bbe;

@SuppressWarnings("unused")
public class Gameboard
{
    private final InternalGameboard gb;

    public Gameboard()
    {
        gb = new InternalGameboard();
    }

    public void start(String title)
    {
        gb.start(title);
    }

    public void add(Object object)
    {
        gb.add(object);
    }

    public void remove(Object object)
    {
        gb.remove(object);
    }

    public void clear()
    {
        gb.clear();
    }

    public void setBackgroundImagePath(String backgroundImagePath)
    {
        gb.setBackgroundImagePath(backgroundImagePath);
    }

    public Object[] getObjects()
    {
        return gb.getObjects();
    }
}
