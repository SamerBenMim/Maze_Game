package FloorGenerator;
import DungeonCharacter.DungeonCharacter;
import DungeonCharacter.Enemy.Enemy;
import DungeonCharacter.Enemy.EnemyFactory;
import DungeonCharacter.Hero.Hero;
import DungeonCharacter.Hero.Magikarp;
import TileObjects.*;
import TileObjects.Items.Item;
import TileObjects.Items.OranBerry;
import TileObjects.Items.VisionSeed;

import java.io.IOException;
import java.util.Random;

public class FloorGenerator {
    private TileObject[][] floor;
    private final int FLOOR_WIDTH =56; //56 IS DEFAULT
    private final int FLOOR_HEIGHT = 32; //32 IS DEFAULT
    private final int MIN_NUMBER_OF_ROOMS_PER_ROW_OR_COLUMN = 1; //2 IS DEFAULT
    private final int MAX_NUMBER_OF_ROOMS_PER_ROW_OR_COLUMN = 1; //6 IS DEFAULT
    private Room[] rooms;
    private final int numberOfRooms;
    private final int numberOfRoomsHorizontally;
    private final int numberOfRoomsVertically;
    private final int maxRoomWidth;
    private final int maxRoomHeight;
    private int playerRow;
    private int playerColumn;
    private Hero player;
    private final Random r;
    private EnemyFactory enemyFactory;

    public FloorGenerator(Hero player) throws IOException {
        enemyFactory = new EnemyFactory();
        this.player = player;
        r = new Random();
        floor = new TileObject[FLOOR_HEIGHT][FLOOR_WIDTH];
        numberOfRoomsHorizontally = generateFloorLayout();
        numberOfRoomsVertically = generateFloorLayout();
        numberOfRooms = generateNumberOfRooms();
        rooms = new Room[numberOfRooms];
        maxRoomWidth = (FLOOR_WIDTH / numberOfRoomsHorizontally);
        maxRoomHeight = (FLOOR_HEIGHT / numberOfRoomsVertically);
        createListOfRooms();
        putRoomsInFloor();
        placeTileObject(r.nextInt(1), new VisionSeed()); //place items
        Item item = new OranBerry();
        placeTileObject(r.nextInt(2), item); //place oran berry
        placeTileObject(r.nextInt(7), enemyFactory.createEnemy());//place enemies
        placeTileObject(r.nextInt(1), new SpikeTip());//place trap
       placeTileObject(1, new Staircase());//place staircase
        placePlayer(player);
        fillNullTilesWithWalls();
        System.out.println(debugToString());
    }

    private void placePlayer(final Hero player) throws IOException {
        int row = r.nextInt(FLOOR_HEIGHT);
        int column = r.nextInt(FLOOR_WIDTH);
        if (floor[row][column] instanceof Texture){ //if it is a texture
            floor[row][column] = player;
            playerRow = row;
            playerColumn = column;
        } else {
            placePlayer(player);
        }
    }

    private void placeHero(int i, TileObject player) {
        floor[20][30] = player;
    }

    private int generateFloorLayout(){
        int range = MAX_NUMBER_OF_ROOMS_PER_ROW_OR_COLUMN - MIN_NUMBER_OF_ROOMS_PER_ROW_OR_COLUMN;
        if (range < 1) range = 1;
        return MIN_NUMBER_OF_ROOMS_PER_ROW_OR_COLUMN + r.nextInt(range);
    }

    private int generateNumberOfRooms(){
        return numberOfRoomsHorizontally * numberOfRoomsVertically;
    }

    private void createListOfRooms() {
        for(int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(maxRoomHeight, maxRoomWidth);
        }
    }

    private void putRoomsInFloor() throws IOException {
        int roomCounter = 0;
        int isStaircasePlaced = 1 + r.nextInt(numberOfRooms);
        for(int i = 0; i < numberOfRoomsVertically; i++) { //columns/height
            for (int j = 0; j < numberOfRoomsHorizontally; j++) {
                Room room = rooms[roomCounter];
                Hallway hallway = room.getHallway();
                int roomHeight = room.getHeight();
                int roomWidth = room.getWidth();
                placeHorizontalTileObjects((maxRoomWidth*j), (maxRoomWidth*j)+roomWidth, maxRoomHeight * i, new Wall());
                placeHorizontalTileObjects((maxRoomWidth*j), (maxRoomWidth*j)+roomWidth, (maxRoomHeight * i) + roomHeight-1, new Wall());
                placeVerticalTileObjects((maxRoomHeight*i), (maxRoomHeight*i)+roomHeight, maxRoomWidth * j, new Wall());
                placeVerticalTileObjects((maxRoomHeight*i), (maxRoomHeight*i)+roomHeight, (maxRoomWidth * j) + roomWidth-1, new Wall());
                placeTexturesInRoom((maxRoomWidth*j)+1, (maxRoomWidth*j)+roomWidth-1, maxRoomHeight * i + 1,
                        (maxRoomHeight * i) + roomHeight - 1);
                placeHallways(roomWidth, roomHeight, hallway.getWidth(), hallway.getHeight(), i, j);
                roomCounter++;
            }
        }
    }

    //Switch is used to facilitate random chance of a hallway spawning
    private void placeHallways(int roomWidth, int roomHeight, int hallwayWidth, int hallwayHeight, int i, int j) throws IOException {
        int chanceOfHallway = r.nextInt(5); //0-4
        switch (chanceOfHallway){
            case 1: chanceOfHallway = 0;
                placeEastHallway((maxRoomWidth * j) + roomWidth,
                        maxRoomWidth * j + roomWidth + hallwayWidth, (maxRoomHeight * i) + (roomHeight / 2),
                        new Wall());
                break;
            case 2: chanceOfHallway = 1;
                placeSouthHallway((maxRoomHeight * i) + roomHeight,
                        maxRoomHeight * i + roomHeight + hallwayHeight, (maxRoomWidth * j) + (roomWidth / 2),
                        new Wall());
                break;
            default:
                placeEastHallway((maxRoomWidth * j) + roomWidth,
                        maxRoomWidth * j + roomWidth + hallwayWidth, (maxRoomHeight * i) + (roomHeight / 2),
                        new Wall());
                placeSouthHallway((maxRoomHeight * i) + roomHeight,
                        maxRoomHeight * i + roomHeight + hallwayHeight, (maxRoomWidth * j) + (roomWidth / 2),
                        new Wall());
                break;
        }
    }

    private void placeTileObject(final int number, final TileObject tile){
        int count = number;
        while(count > 0) {
            int row = r.nextInt(FLOOR_HEIGHT);
            int column = r.nextInt(FLOOR_WIDTH);
            if (floor[row][column] instanceof Texture){ //if it is a texture
                System.out.println(" stairs: " + row + "   "+column + "  " + tile);
                floor[row][column] = tile;
                count--;
            }
        }
    }

    private void placeSouthHallway(final int start, final int end, final int column, final TileObject tile) throws IOException {
        if(end < FLOOR_HEIGHT) placeVerticalTileObjects(start, end-1, column-1, tile);
        if(end < FLOOR_HEIGHT) placeVerticalTileObjects(start, end, column+1, tile);
        if(end >= FLOOR_HEIGHT){
            placeVerticalTileObjects(start-1, end-2, column, new Texture()); //place textures
            placeVerticalTileObjects(end-2, end-1, column, new Wall());

        } else {
            placeVerticalTileObjects(start-1, end+1, column, new Texture()); //place textures
        }
    }

    private void placeEastHallway(final int start, final int end, final int row, final TileObject tile) throws IOException {
        placeHorizontalTileObjects(start, end, row-1, tile);
        placeHorizontalTileObjects(start, end, row+1, tile);
        if(end >= FLOOR_WIDTH){
            placeHorizontalTileObjects(start-1, end-2, row, new Texture()); //place textures
            placeHorizontalTileObjects(end-2, end-1, row, new Wall()); //place wall

        } else {
            placeHorizontalTileObjects(start-1, end+1, row, new Texture()); //place textures
        }
    }

    private void placeTexturesInRoom(final int start, final int end, final int topRow, final int bottomRow) throws IOException {
        for (int i = topRow; i < bottomRow; i++){
            placeHorizontalTileObjects(start, end, i, new Texture());
        }
    }

    private void placeHorizontalTileObjects(final int start, final int end, final int row, final TileObject tile){
        int theEnd = 0;
        if (end >= FLOOR_WIDTH){
            theEnd = FLOOR_WIDTH -1;
        } else {
            theEnd = end;
        }
        for(int i = start; i < theEnd; i++){

            if( !(floor[row][i] instanceof Texture) ) floor[row][i] = tile;
        }
    }

    private void placeVerticalTileObjects(final int start, final int end, final int column, final TileObject tile){
        int theEnd = 0;
        if (end >= FLOOR_HEIGHT){
            theEnd = FLOOR_HEIGHT -1;
        } else {
            theEnd = end;
        }
        for(int i = start; i < theEnd; i++){
            if( !(floor[i][column] instanceof Texture) ) floor[i][column] = tile;
        }
    }

    private void fillNullTilesWithWalls(){
        for(int i = 0; i < floor.length; i++){
            for (int j = 0; j < floor[0].length; j++){
                if(floor[i][j] == null) floor[i][j] = new Wall();
            }
        }
    }

    public TileObject[][] getFloor(){
        return floor;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < floor.length; i++){
            for(int j = 0; j < floor[0].length; j++){
                sb.append(floor[i][j].toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String debugToString(){
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        sb.append("\n");
        sb.append("Floor Layout size: " + numberOfRoomsHorizontally + " x " + numberOfRoomsVertically);
        sb.append("\n");
        sb.append("Number of Rooms: " + numberOfRooms);
        sb.append("\n");
        sb.append("Max Room Height: " + maxRoomHeight);
        sb.append("\n");
        sb.append("Max Room Width: " + maxRoomWidth);
        return sb.toString();
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerColumn() {
        return playerColumn;
    }

}