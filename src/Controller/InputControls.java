package Controller;
import DungeonCharacter.DungeonCharacter;
import DungeonCharacter.Enemy.Enemy;
import DungeonCharacter.Hero.Hero;
import DungeonCharacter.Hero.Snorlax;
import FloorGenerator.Floor;
import FloorGenerator.FloorTraversal;
import TileObjects.*;
import TileObjects.Items.OranBerry;
import TileObjects.Items.VisionSeed;

import java.awt.event.KeyAdapter;
import java.io.IOException;

public final class InputControls extends KeyAdapter {
    private static int playerRow;
    private static int playerColumn;
    private static TileObject[][] floor;

    public static void useRegularAttack() {
    }

    public static void useSpecialAttack() {
    }

    public static void useOranBerry() {
    }

    public static void useVisionSeed() {
    }

    public static void quitGame() {
    }

    //This method exists for readability - shorthanding these fields
    //And elminates some duplicate lines of code
    private static void updateFloorFields(final Floor theFloor){
        playerRow = theFloor.getPlayerRow();
        playerColumn = theFloor.getPlayerColumn();
        floor = theFloor.getFloorArray();
    }

    public static Floor move(final Floor theFloor, final int destinationRow,
                             final int destinationColumn, final String errorMessage,
                             final DungeonCharacter.Direction direction) throws IOException {
        Floor returnFloor = theFloor;
        Hero hero = theFloor.player;
        if(playerRow != 0 && !(floor[destinationRow][destinationColumn] instanceof Wall) &&
                !(floor[destinationRow][destinationColumn] instanceof Enemy)) {
            TileObject playerTemp = floor[playerRow][playerColumn];
            if(floor[destinationRow][destinationColumn] instanceof OranBerry){
                hero.collectOranBerry();
                System.out.println("berry count: " + hero.getBerryCount());
            }
            if(floor[destinationRow][destinationColumn] instanceof VisionSeed){
                hero.collectVisionSeeds();
                System.out.println("seed count: " + hero.getSeedCount());
            }
            if(floor[destinationRow][destinationColumn] instanceof Staircase){
                hero.updateMyCurrentLevel();
                System.out.println("current level: " + hero.getMyCurrentLevel());
                returnFloor = getGoodMaze(hero);
                floor = returnFloor.getFloorArray();
            }
            try {
                floor[playerRow][playerColumn] = new Texture();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            floor[destinationRow][destinationColumn] = playerTemp;
            returnFloor.setPlayerRow(destinationRow);
            returnFloor.setPlayerColumn(destinationColumn);
            returnFloor.setFloorArray(floor);
            returnFloor = updateTileObjectVisibility(returnFloor);
            returnFloor.getFloorArray()[destinationRow][destinationColumn].setDirection(direction);
            return returnFloor;
        }
        System.out.println(errorMessage);
        returnFloor.getFloorArray()[playerRow][playerColumn].setDirection(direction);
        returnFloor = updateTileObjectVisibility(returnFloor);
        return returnFloor;
    }
    public static Floor getGoodMaze(final Hero hero) throws IOException {
        Floor returnFloor = new Floor(hero);
        return returnFloor;
    }

    public void collectOranBerry() throws IOException {
        Hero updateOranBerry = new Snorlax();
        updateOranBerry.collectOranBerry();
    }

    private static Floor updateTileObjectVisibility(final Floor theFloor){
        updateFloorFields(theFloor);
        floor[playerRow-1][playerColumn-1].setIsVisibleOnDungeonMap(true);
        floor[playerRow-1][playerColumn].setIsVisibleOnDungeonMap(true);
        floor[playerRow-1][playerColumn+1].setIsVisibleOnDungeonMap(true);
        floor[playerRow][playerColumn-1].setIsVisibleOnDungeonMap(true);
        floor[playerRow][playerColumn].setIsVisibleOnDungeonMap(true);
        floor[playerRow][playerColumn+1].setIsVisibleOnDungeonMap(true);
        floor[playerRow+1][playerColumn-1].setIsVisibleOnDungeonMap(true);
        floor[playerRow+1][playerColumn].setIsVisibleOnDungeonMap(true);
        floor[playerRow+1][playerColumn+1].setIsVisibleOnDungeonMap(true);
        Floor returnFloor = theFloor;
        returnFloor.setFloorArray(floor);
        return returnFloor;
    }

    public static Floor moveUp(final Floor theFloor) throws IOException {
        updateFloorFields(theFloor);
        return move(theFloor, playerRow-1, playerColumn,
                "Cannot move up!", DungeonCharacter.Direction.UP);
    }

    public static Floor moveDown(final Floor theFloor) throws IOException {
        updateFloorFields(theFloor);
        return move(theFloor, playerRow+1, playerColumn,
                "Cannot move down!", DungeonCharacter.Direction.DOWN);
    }

    public static Floor moveLeft(final Floor theFloor) throws IOException {
        updateFloorFields(theFloor);
        return move(theFloor, playerRow, playerColumn-1,
                "Cannot move left!", DungeonCharacter.Direction.LEFT);
    }

    public static Floor moveRight(final Floor theFloor) throws IOException {
        updateFloorFields(theFloor);
        return move(theFloor, playerRow, playerColumn+1,
                "Cannot move right!", DungeonCharacter.Direction.RIGHT);
    }
}