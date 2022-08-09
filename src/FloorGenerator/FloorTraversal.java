package FloorGenerator;

import DungeonCharacter.Enemy.Enemy;
import DungeonCharacter.Hero.Hero;
import TileObjects.Staircase;
import TileObjects.Texture;
import TileObjects.TileObject;
import TileObjects.Wall;

public class FloorTraversal {
    private final TileObject[][] floor;
    private boolean isTraversable;
    private final int playerRow;
    private final int playerColumn;

    private final int FLOOR_HEIGHT;
    private final int FLOOR_WIDTH;

    public FloorTraversal(TileObject[][] floor, int playerRow, int playerColumn) {
        this.floor = floor;
        FLOOR_HEIGHT = floor.length;
        FLOOR_WIDTH = floor[0].length;
        this.playerColumn = playerColumn;
        this.playerRow = playerRow;
        this.setTraversable();
    }

    private boolean isFloorTraversable(int currentRow, int currentColumn, int[][] memory) {
        memory[currentRow][currentColumn] = 3 ;
        System.out.println( currentRow + " - " + currentColumn );
        System.out.println("you are on : "+ floor[currentRow][currentColumn].getName());
        if(currentRow > 0  && currentRow <FLOOR_HEIGHT && currentColumn> 0 && currentColumn <  FLOOR_WIDTH)  {
            if(floor[currentRow][currentColumn].getName()=="Staircase" ) { // Staircase
                System.out.println("YOU WON  !!!!! the staris  x:" +currentRow+" y: " +currentColumn ) ;
                return true;
            }

        boolean result = false;

        if(!result &&(!floor[currentRow -1 ][currentColumn].getSolid() ) && memory[currentRow-1][currentColumn]!=3 ){
            System.out.println("direction DOWN");
            result = isFloorTraversable(currentRow - 1, currentColumn, memory) ;
        } 
        if(!result && !floor[currentRow ][currentColumn-1].getSolid()&& memory[currentRow][currentColumn-1]!=3)  {
            System.out.println("direction LEFT");
            result = isFloorTraversable(currentRow , currentColumn - 1, memory) ;
        } 
        if(!result && (!floor[currentRow +1 ][currentColumn].getSolid()) && memory[currentRow+1][currentColumn]!=3 ){
            System.out.println("direction TOP");
            result = isFloorTraversable(currentRow + 1, currentColumn, memory) ;
        } 

        if(!result&& !floor[currentRow ][currentColumn+1].getSolid() && memory[currentRow][currentColumn+1]!=3){
            System.out.println("direction RIGHT");
            result = isFloorTraversable(currentRow , currentColumn + 1, memory) ;
        }   
        
if(result) return true;    }
        return false;
    }

    public void setTraversable() {
        int[][] memory = new int [FLOOR_HEIGHT][FLOOR_WIDTH];
        for(int i = 0; i < FLOOR_HEIGHT; i++) {
            for(int j = 0; j < FLOOR_WIDTH; j++) {
                memory[i][j] = -1;
            }
        }
        this.isTraversable = isFloorTraversable(this.playerRow, this.playerColumn, memory);
    }

    public boolean getTraversable() {
    //    this.setTraversable();

        return this.isTraversable;
    }
}