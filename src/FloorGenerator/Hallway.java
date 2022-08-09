package FloorGenerator;

public class Hallway {

    private final int width;
    private final int height;

    public Hallway(final int maxHeight, final int maxWidth, final int roomHeight, final int roomWidth){
        width = maxWidth - roomWidth;
        height = maxHeight - roomHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
