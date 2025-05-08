[![(push) Build Maven and Deploy JavaDoc](https://github.com/ValentinHerrmann/Gameboard/actions/workflows/deploy_javadocs.yml/badge.svg)](https://github.com/ValentinHerrmann/Gameboard/actions/workflows/deploy_javadocs.yml)
[![Release Build](https://github.com/ValentinHerrmann/Gameboard/actions/workflows/createRelease_onTagPushed.yml/badge.svg)](https://github.com/ValentinHerrmann/Gameboard/actions/workflows/createRelease_onTagPushed.yml)

# Gameboard 

A basic Gameboard package to be installed in `.../BlueJ/lib/userlib`. 

All images need to be placed in the project folder or be loaded from the resources of this library. 

### Getting started 

In your main create a Gameboard and add entities like this:
``` java 
public static void main(String[] args) { 
    Gameboard board = new Gameboard(); 
    board.setBackgroundImagePath("background/gras_1200x691.jpg"); 
    
    CustomPlayer player = new CustomPlayer();
    board.add(player); 
    
    board.start("Custom Window Title");
} 
``` 

Optional: Customize Gameboard:
``` java 
import bbe.*; 
public CustomClassName extends Gameboard { 
    // implement custom functionality for your Gameboard 
} 
``` 



The Gameboard cycles through the run-Methods of all entities and then displays them at their position using getX() and getY(). 

More details on how to implement entity classes with arbitrary names as well as available images for background 
and entities can be found here: 

[gameboard.valentin-herrmann.com](https://gameboard.valentin-herrmann.com)