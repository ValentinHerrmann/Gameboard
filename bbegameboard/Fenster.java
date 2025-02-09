package bbegameboard;

import javax.swing.*;
import java.awt.*;

public class Fenster extends JFrame
{
    public Fenster(String windowTitle, Gameboard gameboard)
    {
        // Gameboard dem Fenster hinzufuegen
        add(gameboard);

        // Einstellen, ob die Groesse des Fensters angepasst werden kann
        setResizable(false);

        // Fenster vorbereiten
        pack();

        // Fenstertitel anzeigen
        setTitle(windowTitle);

        // Programm beenden, wenn Fenster geschlossen wird
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start()
    {
        // Spiel starten
        // Achtung: Hier keinesfalls etwas aendern!
        EventQueue.invokeLater(() ->
        {
            this.setVisible(true);
        });
    }
}
