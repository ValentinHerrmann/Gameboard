package bbe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class InternalGameboard extends JPanel implements Runnable
{
    private final List<EntityReflection> entities = new ArrayList<>();
    private List<Object> rmEntities = new ArrayList<>();
    private List<Object> addEntities = new ArrayList<>();
    protected boolean isGameRunning = true;
    protected String gameOverMessage = "";
    protected boolean showHitboxes = false;
    private Image backgroundImage = null;

    private final KeyboardListener keyboardListener = new KeyboardListener(
            new int[] {KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_SPACE,
                    KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_ENTER}
    );


    InternalGameboard()
    {
        int w = 1000;
        int h = 700;

        setPreferredSize(new Dimension(w, h));

        setFocusable(true);
        requestFocus();
        setVisible(true);
        addKeyListener(keyboardListener);
    }


    public void setBackgroundImagePath(String backgroundImagePath)
    {
        try
        {
            backgroundImage = ResourceTools.getImage(backgroundImagePath);
            int w = backgroundImage.getWidth(this);
            int h = backgroundImage.getHeight(this);
            setPreferredSize(new Dimension(w, h));

        }
        catch(Exception ignored) { }
    }


    /**
     * Ein Entity zum Gameboard hinzufügen.
     */
    public void add(Object obj)
    {
        addEntities.add(obj);
        applyEntityModifications();
    }


    /**
     * Ein Entity vom Gameboard entfernen (nachdem die run()-Methode aller Entites aufgerufen wurde).
     */
    public void remove(Object obj)
    {
        rmEntities.add(obj);
    }

    public void clear()
    {
        rmEntities = List.copyOf(entities);
    }

    public Object[] getObjects()
    {
        return entities.stream().map(EntityReflection::getEntity).toArray(Object[]::new);
    }

    @Override
    public void addNotify()
    {
        super.addNotify();

        Thread animator = new Thread(this);
        animator.start();
    }


    // Entities und Hintergrundbild anzeigen
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (this.backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }


        for(EntityReflection e : entities)
        {
            try
            {
                Image img = e.getImage();
                int x = e.getX();
                int y = e.getY();
                double scale = e.getScaleFactor();
                g.drawImage(img, x, y, (int)(img.getWidth(this) * scale), (int)(img.getHeight(this) * scale), this);

                if (showHitboxes)
                {
                    g.setColor(Color.RED);
                    g.drawPolygon(e.getHitbox().getPolygon());
                    g.setColor(Color.blue);
                    g.drawPolygon(e.getHitbox().lastStepPolygon());
                }

                if(!e.isStatic())
                {
                    if(e.getGameoverMessage() != null)
                    {
                        gameOverMessage = e.getGameoverMessage();
                        isGameRunning = false;
                    }
                    try
                    {
                        if (e.getText() != null)
                        {
                            g.setColor(Color.BLACK);
                            g.drawString(e.getText(), x, y - 10);
                        }
                    }
                    catch (Exception ignored) {}
                    try
                    {
                        Map<Integer, Boolean> pressedKeys = keyboardListener.getPressedKeys();
                        e.setDown(pressedKeys.get(KeyEvent.VK_DOWN));
                        e.setLeft(pressedKeys.get(KeyEvent.VK_LEFT));
                        e.setRight(pressedKeys.get(KeyEvent.VK_RIGHT));
                        e.setUp(pressedKeys.get(KeyEvent.VK_UP));
                        e.setSpace(pressedKeys.get(KeyEvent.VK_SPACE));
                        e.setW(pressedKeys.get(KeyEvent.VK_W));
                        e.setA(pressedKeys.get(KeyEvent.VK_A));
                        e.setS(pressedKeys.get(KeyEvent.VK_S));
                        e.setD(pressedKeys.get(KeyEvent.VK_D));
                        e.setEnter(pressedKeys.get(KeyEvent.VK_ENTER));
                    }
                    catch (Exception ignored) {}
                }
                Toolkit.getDefaultToolkit().sync();
            }
            catch(Exception ignored) { }
        }
    }

    private void cycle()
    {
        applyEntityModifications();

        for(EntityReflection e : entities)
        {
            try
            {
                e.run();
                for(EntityReflection other : entities)
                {
                    if(e != other)
                    {
                        if(e.getHitbox().collidesWithOther(other.getHitbox()))
                        {
                            e.crash(other.getEntity().getClass().getSimpleName(), other.getEntity());
                        }
                    }
                }
            }
            catch(Exception ignored) { }
        }
    }

    private void applyEntityModifications()
    {
        try
        {
            if (!addEntities.isEmpty())
            {
                for (Object e : addEntities)
                {
                    entities.add(new EntityReflection(e, "player/car.gif"));
                }
            }
            for (Object e : rmEntities)
            {
                entities.removeIf(x -> x.getEntity() == e);
            }
            addEntities = new ArrayList<>();
            rmEntities = new ArrayList<>();
        }
        catch(Exception ignored) { }
    }

    @Override
    public void run()
    {
        long beforeTime, timeDiff, sleep;
        beforeTime = System.currentTimeMillis();

        while (isGameRunning)
        {
            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            int DELAY = 25;
            sleep = DELAY - timeDiff;

            if (sleep < 0)
            {
                sleep = 2;
            }

            try { //noinspection BusyWait
                Thread.sleep(sleep); }
            catch (InterruptedException ignored) { }

            beforeTime = System.currentTimeMillis();
        }

        JOptionPane.showMessageDialog(this, gameOverMessage);
        System.exit(0);
    }

    void start(String title)
    {
        Window window = new Window(title, this);
        window.start();
    }

    void setShowHitboxes(boolean showHitboxes)
    {
        this.showHitboxes = showHitboxes;
    }
}

