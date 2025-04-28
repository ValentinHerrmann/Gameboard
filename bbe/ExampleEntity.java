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
     * Der Rückgabewert wird als Bild für das Entity angezeigt. Eine Übersicht über alle im Paket verfügbaren Bilder gibt es hier: <a href="https://gameboard.valentin-herrmann.com/resources/images.html">gameboard.valentin-herrmann.com/resources/images.html</a>
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
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void crash()
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void crash(String otherClassname)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void crash(Object other)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void crash(String otherClassname, Object other)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setLeft(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setRight(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setUp(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setDown(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setW(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setA(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setS(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setD(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setEnter(boolean pressed)
    {
    }
    /**
     * TODO: Dokumentation kommt in den nächsten Tagen.
     */
    public void setSpace(boolean pressed)
    {
    }
}
