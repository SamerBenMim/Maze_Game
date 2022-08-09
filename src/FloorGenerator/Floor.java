package FloorGenerator;

import DungeonCharacter.Hero.Hero;
import TileObjects.TileObject;

import java.io.IOException;

public class Floor {

    private TileObject[][] floor;
    private int playerRow;
    private int playerColumn;
    public Hero player;

    public Floor(final Hero player) throws IOException {
        this.player = player;
        createFloor();
    }

    public void createFloor() throws IOException {
        //uncomment when FloorTraversal is finished
        FloorGenerator floorGenerator = new FloorGenerator(player);
        playerRow = floorGenerator.getPlayerRow();
        playerColumn = floorGenerator.getPlayerColumn();
        floor = floorGenerator.getFloor();
        System.out.println(" playerRow: " + playerRow  + ' ' +playerColumn );

       FloorTraversal testNewFloor = new FloorTraversal(floor, playerRow, playerColumn);
       boolean status = testNewFloor.getTraversable();
       System.out.println("is the floor traversable: " + status);
       if (!status){
           createFloor();
       }
    }

    public int getPlayerRow(){
        return playerRow;
    }

    public int getPlayerColumn(){
        return playerColumn;
    }

    public void setPlayerRow(final int playerRow){
        this.playerRow = playerRow;
    }

    public void setPlayerColumn(final int playerColumn){
        this.playerColumn = playerColumn;
    }

    public void setFloorArray(TileObject[][] floor){
        this.floor = floor;
    }

    public TileObject[][] getFloorArray(){
        return floor;
    }
}
