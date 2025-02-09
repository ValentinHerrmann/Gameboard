package bbegameboard;  

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Gameboard extends JPanel implements Runnable
{
    private List<EntityReflection> entities = new ArrayList<>();
    private List<Object> rmEntities = new ArrayList<>();
    private List<Object> addEntities = new ArrayList<>();
    private Image backgroundImage;
    protected boolean isGameRunning = true;
    protected String gameOverMessage;

    private KeyboardListener keyboardListener = new KeyboardListener(
            new int[] {KeyEvent.VK_LEFT, KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_SPACE,
                    KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_ENTER}
    );


    public Gameboard()
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
            String absolutePath = Paths.get(backgroundImagePath).toAbsolutePath().toString();
            backgroundImage = new ImageIcon(absolutePath).getImage();
            int w = backgroundImage.getWidth(this);
            int h = backgroundImage.getHeight(this);
            setPreferredSize(new Dimension(w, h));
        }
        catch(Exception e) { }
    }


    /**
     * Ein Entity zum Gameboard hinzufügen.
     */
    public void addSpieler(Object spieler)
    {
        addEntities.add(spieler);
        applyEntityModifications();
    }


    /**
     * Ein Entity vom Gameboard entfernen (nachdem die run()-Methode aller Entites aufgerufen wurde).
     */
    public void removeSpieler(Object spieler)
    {
        rmEntities.add(spieler);
    }

    public Object[] getSpieler()
    {
        return entities.stream().map(x-> (Object)x.getEntity()).toArray(Object[]::new);
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

        for(EntityReflection e : entities)
        {
            try
            {
                Image img = e.getImage();
                int x = e.getX();
                int y = e.getY();
                g.drawImage(img,x,y, this);
                try
                {
                    if(e.getText() != null)
                    {
                        g.setColor(Color.BLACK);
                        g.drawString(e.getText(), x, y - 10);
                    }
                } catch (Exception ex) { }
                try
                {
                    e.setDown(keyboardListener.getPressedKeys().get(KeyEvent.VK_DOWN));
                    e.setLeft(keyboardListener.getPressedKeys().get(KeyEvent.VK_LEFT));
                    e.setRight(keyboardListener.getPressedKeys().get(KeyEvent.VK_RIGHT));
                    e.setUp(keyboardListener.getPressedKeys().get(KeyEvent.VK_UP));
                    e.setSpace(keyboardListener.getPressedKeys().get(KeyEvent.VK_SPACE));
                    e.setW(keyboardListener.getPressedKeys().get(KeyEvent.VK_W));
                    e.setA(keyboardListener.getPressedKeys().get(KeyEvent.VK_A));
                    e.setS(keyboardListener.getPressedKeys().get(KeyEvent.VK_S));
                    e.setD(keyboardListener.getPressedKeys().get(KeyEvent.VK_D));
                    e.setEnter(keyboardListener.getPressedKeys().get(KeyEvent.VK_ENTER));
                } catch (Exception ex) { }

                Toolkit.getDefaultToolkit().sync();
            }
            catch(Exception ex) { }
        }
    }

    private void cycle()
    {
        applyEntityModifications();

        for(EntityReflection e : entities)
        {
            try
            {
                keyboardListener.getPressedKeys();
                e.run();
                if(!(e.getEntity() instanceof Coin))
                {
                    for(EntityReflection other : entities)
                    {
                        if(e != other)
                        {
                            if(e.getHitbox().collidesWithOther(other.getHitbox()))
                            {
                                if(e.getEntity() instanceof Coin)
                                {
                                    e.crashMuenze();
                                    removeSpieler(other.getEntity());
                                }
                                else
                                {
                                    e.crashSpieler();
                                }
                            }
                        }
                    }
                }
            }
            catch(Exception ex) { }
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
                    entities.add(new EntityReflection(e, "car.gif"));
                }
            }


            for (Object e : rmEntities)
            {
                entities.removeIf(x -> x.getEntity() == e);
            }
            addEntities = new ArrayList<Object>();
            rmEntities = new ArrayList<Object>();
        }
        catch(Exception e) { }
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

            try { Thread.sleep(sleep); }
            catch (InterruptedException e) { }

            beforeTime = System.currentTimeMillis();
        }

        System.exit(0);
    }
    
    public void spielStarten(String fensterTitel)
    {
        Fenster fenster = new Fenster(fensterTitel, this);
        fenster.start();
    }
}

