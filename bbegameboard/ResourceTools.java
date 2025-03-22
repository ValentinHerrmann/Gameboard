package bbegameboard;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;


class ResourceTools
{
    private static final Map<String, Image> imageMap = new java.util.HashMap<>();


    static Image getImage(String name)
    {
        if(imageMap.containsKey(name))
        {
            return imageMap.get(name);
        }

        Image img;
        // Check if file exists in working directory
        if(Paths.get(name).toFile().exists())
        {
            img = new ImageIcon(name).getImage();
        }
        // Check if file exists in resources directory
        else if(Paths.get("resources/" + name).toFile().exists())
        {
            img = new ImageIcon("resources/" + name).getImage();
        }
        // Check if file exists in resources directory
        else if(Paths.get("images/" + name).toFile().exists())
        {
            img = new ImageIcon("images/" + name).getImage();
        }
        else if (ResourceTools.class.getResource("/" + name) != null)
        {
            img = new ImageIcon(Objects.requireNonNull(ResourceTools.class.getResource("/" + name))).getImage();
        }
        else
        {
            return null;
        }
        imageMap.put(name, img);
        return img;
    }
}
