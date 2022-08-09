package FloorGenerator;

import java.util.Random;

public class Room {
    private Hallway hallway;
    private final int MIN_ROOM_WIDTH = 4;
    private final int MIN_ROOM_HEIGHT = 4;
    private final int maxWidth;
    private final int maxHeight;
    private int height;
    private int width;
    private Random r;

    public Room(final int maxHeight, final int maxWidth){
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.r = new Random();
        this.height = createRoomHeight(maxHeight);
        this.width = createRoomWidth(maxWidth);
        this.hallway = generateHallway();
        generateHallway();
        while(isRoomRatioAtLeast3By2(height, width) == false){
            height = createRoomHeight(maxHeight);
            width = createRoomWidth(maxWidth);
        }
    }

    private Hallway generateHallway() {
        Hallway hallway = new Hallway(maxHeight, maxWidth, height, width);
        return hallway;
    }

    private boolean isRoomRatioAtLeast3By2(final int height, final int width){
        //We want to maintain rooms of a minimum of a 3:2 ratio
        //To prevent funky (weird long) looking rooms from being created
        if (height == width) return true;
        double max = Math.max(height, width);
        double min = Math.min(height, width);
        if(max/min <= 3) return true;
        return false;
    }

    private int createRoomWidth(final int maxWidth){
        int width = MIN_ROOM_WIDTH + r.nextInt(maxWidth);
        if (width >= maxWidth){
            return createRoomWidth(maxWidth);
        }
        return width;
    }

    private int createRoomHeight(final int maxHeight){
        int height = MIN_ROOM_HEIGHT + r.nextInt(maxHeight);
        if (height >= maxHeight){
            return createRoomHeight(maxHeight);
        }
        return height;
    }

    @Override //prints out the dimensions of the room
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                sb.append("R");
            }
            sb.append("\n");
        }
        sb.append("\n");
        sb.append("FloorGenerator.Room size: " + width + " x " + height);
        return sb.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Hallway getHallway() {
        return hallway;
    }

    //Getter for Junit Test
    public boolean testIsRoomRatioAtLeast3By2(final int height, final int width){
        return isRoomRatioAtLeast3By2(height, width);
    }

    //Getter for Junit Test
    public int testCreateRoomHeight(final int maxHeight){
        return createRoomHeight(maxHeight);
    }
    //Getter for Junit Test
    public int getMIN_ROOM_HEIGHT(){
        return MIN_ROOM_HEIGHT;
    }

    //Getter for Junit Test
    public int testCreateRoomWidth(final int maxWidth){
        return createRoomWidth(maxWidth);
    }
    //Getter for Junit Test
    public int getMIN_ROOM_WIDTH(){
        return MIN_ROOM_WIDTH;
    }
}
