package bbe;

import javax.swing.*;
import java.awt.*;

class Window extends JFrame
{
    public Window(String windowTitle, InternalGameboard gameboard)
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

    void start()
    {
        // Spiel starten
        // Achtung: Hier keinesfalls etwas aendern!
        EventQueue.invokeLater(() -> this.setVisible(true));
    }
}
