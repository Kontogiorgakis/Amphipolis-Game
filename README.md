# Amphipolis-Game
Engaging Amphipolis board game implementation using Java technology.


## Introduction


"Amphipolis" is a Java game project that serves as a comprehensive learning experience in Java programming. Through its development, valuable insights into problem-solving, project structuring, and debugging techniques are gained. Delving into object-oriented programming principles, it provides practical exposure to implementing game mechanics and user interactions. With a focus on Java syntax, data structures, and algorithms, "Amphipolis" fosters a deeper understanding of programming concepts while honing practical skills in game development.


## Instalation and Play


1. Open the project using IntelliJ and ensure JDK 15.0.1 Java version for successful execution. The main class is located in myMain.java.

2. Clicking the Play Button displays the game board along with two additional panels for the randomly selected starting player.

3. Areas of the tiles are initialized beforehand, and buttons cannot be clicked initially.

4. The player can make their initial selection by choosing "Draw Tiles." Clicking the corresponding button adds 4 new tiles from the assumed bag to the areas, making them clickable.

5. The remaining option buttons become clickable only if the player has at least one tile.

6. Clicking "End Turn" loads the panels for the next player.

7. This process repeats until all 16 landslides are filled.
