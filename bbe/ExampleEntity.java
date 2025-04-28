package bbe;

/**
 * Diese Klasse ist ein Beispiel für ein Entity, das alle möglichen Methoden implementiert. Wird eine Methode mit
 * Rückgabetyp void in einer Entity-Klasse nicht implementiert, wird sie ignoriert. Wird eine Methode mit Rückgabetyp
 * nicht implementiert wird der unten angegebene Standardwert verwendet.
 *
 * @author Valentin Herrman
 */
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
     * Der Rückgabewert wird als Bild für das Entity angezeigt - eine Übersicht über alle im Paket verfügbaren Bilder gibt es hier: <a href="https://gameboard.valentin-herrmann.com/resources/images.html">gameboard.valentin-herrmann.com/resources/images.html</a>
     */
    public String getImagePath()
    {
        return "player/car.gif";
    }
    /**
     * Der Rückgabewert ist der Skalierungsfaktor des Bildes und kann fortlaufend geändert werden. Faktor 1.0 bedeutet kein Zoom.
     */
    public double getScaleFactor()
    {
        return 1;
    }
    /**
     * Gibt diese Methode true zurück, werden folgende Methoden NICHT genutzt: getGameoverMessage(), getText(), setW(boolean), setA(boolean), ...
     */
    public boolean isStatic()
    {
        return false;
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public String getGameoverMessage()
    {
        return "";
    }
    /**
     * Es kann nur eine der crash-Varianten implementiert werden! Methode wird aufgerufen, wenn das Entity mit einem anderen Entity kollidiert. 
     */
    public void crash()
    {
    }
    /**
     * Es kann nur eine der crash-Varianten implementiert werden! Methode wird aufgerufen, wenn das Entity mit einem anderen Entity kollidiert. 
     * Der Wert des Parameters otherClassname ist der Name der Klasse des anderen Entities.
     */
    public void crash(String otherClassname)
    {
    }
    /**
     * Es kann nur eine der crash-Varianten implementiert werden! Methode wird aufgerufen, wenn das Entity mit einem anderen Entity kollidiert. 
     * Der Wert des Parameters ist das Objekt, mit dem das Entity kollidiert ist.
     */
    public void crash(Object other)
    {
    }
    /**
     * Es kann nur eine der crash-Varianten implementiert werden! Methode wird aufgerufen, wenn das Entity mit einem anderen Entity kollidiert. 
     * Der erste Parameter enthält den Namen der Klasse des anderen Entities, der zweite Parameter ist das Objekt, mit dem das Entity kollidiert ist.
     */
    public void crash(String otherClassname, Object other)
    {
    }
    /**
     * Wird aufgerufen, wenn der Pfeil nach links gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setLeft(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn der Pfeil nach rechts gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setRight(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn der Pfeil nach oben gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setUp(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn der Pfeil nach unten gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setDown(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn die Taste W gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setW(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn die Taste A gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setA(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn die Taste S gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setS(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn die Taste D gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setD(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn die Enter-Taste gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setEnter(boolean pressed)
    {
    }
    /**
     * Wird aufgerufen, wenn die Leertaste gedrückt oder losgelassen wird. Der Parameter pressed ist true, wenn die Taste gedrückt wird, und false, wenn sie losgelassen wird.
     */
    public void setSpace(boolean pressed)
    {
    }
}
