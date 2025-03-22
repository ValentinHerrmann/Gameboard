package bbegameboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

class KeyboardListener implements KeyListener
{
    private final Map<Integer,Boolean> pressedKeys = new HashMap<>();

    public KeyboardListener(int[] keys)
    {
        for(int key : keys)
        {
            pressedKeys.put(key, false);
        }
    }

    public void keyTyped(KeyEvent e)
    {
        // Nichts tun
    }

    public void keyPressed(KeyEvent e)
    {
        if(pressedKeys.containsKey(e.getKeyCode()))
        {
            pressedKeys.put(e.getKeyCode(), true);
        }
    }

    public void keyReleased(KeyEvent e)
    {
        if(pressedKeys.containsKey(e.getKeyCode()))
        {
            pressedKeys.put(e.getKeyCode(), false);
        }
    }

    public Map<Integer,Boolean> getPressedKeys()
    {
        return pressedKeys;
    }
}
