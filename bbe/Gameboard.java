package bbe;

@SuppressWarnings("unused")
public class Gameboard
{
    private final InternalGameboard gb;

    /**
     * Erstellt ein neues Gameboard mit 1000 x 700 Pixel (Breite x Hoehe).
     */
    public Gameboard()
    {
        gb = new InternalGameboard();
    }

    public void start(String title)
    {
        gb.start(title);
    }



    /**
     * Nach dem aktuellen Durchlauf ein neues Objekt/Entity auf das Gameboard hinzufuegen.
     */
    public void add(Object object)
    {
        gb.add(object);
    }


    /**
     * Nach dem aktuellen Durchlauf das eingegebene Objekt/Entity vom Gameboard entfernen.
     */
    public void remove(Object object)
    {
        gb.remove(object);
    }


    /**
     * Nach dem aktuellen Durchlauf alle Objekte/Entities vom Gameboard entfernen.
     */
    public void clear()
    {
        gb.clear();
    }

    /**
     * Den Dateipfad des Hintergrundbildes setzen. Dateipfade beginnen entweder direkt im Projektordner oder im
     * Unterordner "resources". In Dateipfaden werden Ordner mit "/" getrennt. Bilder aus diesem Paket sind ebenfalls
     * verfuegbar (z.B. mit "background/gras_1200x691.jpg"): <a href="https://gameboard.valentin-herrmann.com/resources/images.html">gameboard.valentin-herrmann.com/resources/images.html</a>
     * @param backgroundImagePath Der Dateipfad des Hintergrundbildes mit Dateiendung (.png, .gif, .jpg, ...).
     */
    public void setBackgroundImagePath(String backgroundImagePath)
    {
        gb.setBackgroundImagePath(backgroundImagePath);
    }

    public void setShowHitboxes(boolean showHitboxes)
    {
        gb.setShowHitboxes(showHitboxes);
    }

    /**
     * Ein Array mit allen Objekten/Entities auf dem Gameboard.
     */
    public Object[] getObjects()
    {
        return gb.getObjects();
    }
}
