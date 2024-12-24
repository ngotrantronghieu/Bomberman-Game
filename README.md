# Bomberman Game

This is a Java-based Bomberman game developed using JavaFX for the user interface.

## Description

This project is an implementation of the classic Bomberman game. Players navigate a grid-based map, strategically placing bombs to destroy obstacles and defeat enemies. The game features various entities, including the player character (Bomber), different types of enemies (Balloom, Oneal), power-up items (BombItem, FlameItem, SpeedItem), and destructible/indestructible blocks (Brick, Wall).

## Prerequisites

-   Java Development Kit (JDK) 17 or later
-   Apache Maven

## Building the Project

1. Clone the repository:
    ```bash
    git clone <repository_url>
    ```
2. Navigate to the project directory:
    ```bash
    cd Bomberman-Game
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Running the Game

After successfully building the project, you can run the game using the following command:

```bash
mvn javafx:run
```

## Game Controls

-   **Movement:** Arrow keys (Up, Down, Left, Right)
-   **Place Bomb:** Spacebar

## Game Features

-   Classic Bomberman gameplay
-   Multiple enemy types with different behaviors
-   Power-up items to enhance the player's abilities
-   Destructible and indestructible blocks
-   Sound effects

## Project Structure

-   `src/main/java`: Contains the Java source code for the game.
-   `src/main/resources`: Contains game assets such as images, sounds, and FXML files.
-   `target`: Contains the compiled output of the project.
-   `PreRenderedMap.txt`: Contains the layout of the game levels.
-   `pom.xml`: Maven project configuration file.

## Acknowledgements

This project was inspired by the original Bomberman game.
