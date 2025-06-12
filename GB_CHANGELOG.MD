## Changelog: [Gameboard](https://github.com/ValentinHerrmann/Gameboard)

### [Version 2.3](https://github.com/ValentinHerrmann/Gameboard/releases/tag/2.3)
#### Pull Request https://github.com/ValentinHerrmann/Gameboard/pull/11:
- fixed bug when clearing gameboard (and propably when adding entities)
- New Images: Mario with movements, Sushi and Wasabi

### [Version 2.2](https://github.com/ValentinHerrmann/Gameboard/releases/tag/2.2)
#### Pull Request https://github.com/ValentinHerrmann/Gameboard/pull/10:
- fixed collision detection 
- Patch: removed debug logging

### [Version 2.1](https://github.com/ValentinHerrmann/Gameboard/releases/tag/2.1)
- fixed background image not being loaded

### [Version 2.0](https://github.com/ValentinHerrmann/Gameboard/releases/tag/2.0)
- not backward compatible to 1.x !
#### Pull Request https://github.com/ValentinHerrmann/Gameboard/pull/3:
- Load images by name from project-folder, resources-folder, images-folder or jar-library (checked in this order)
- More generic methods in EntityReflection and Gameboard
- Renamed package to `bbe` (shorter)
#### Pull Request https://github.com/ValentinHerrmann/Gameboard/pull/8:
- Added several images to resources (players, items and blocks from minecraft, supermario and spongebob + several backgrounds)
- Improved performance (check existing methods once, option to set as static = skip calling of several methods)
- Option to show hitboxes.
- Option to scale entity images by any factor (at any time of the game).
- Option to let game end and set game over message fom any entity on the gameboard.

### [Version 1.2](https://github.com/ValentinHerrmann/Gameboard/releases/tag/1.2)
- Build Gameboard from IntelliJ
