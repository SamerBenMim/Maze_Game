package TileObjects;

import DungeonCharacter.DungeonCharacter;

import java.awt.image.BufferedImage;

public abstract class TileObject {
    private boolean isSolid = false;
    private String name;
    private String message;
    private String stringRepresentation;
    private boolean isVisibleOnMiniMap;
    protected Direction direction;
    protected BufferedImage sprite, up, down, left, right;

    public boolean getSolid() {
        return isSolid;
    }

    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

    public TileObject(final String name, final String stringRepresentation, final boolean isSolid){
        this.name = name;
        this.stringRepresentation = stringRepresentation;
        this.isSolid = isSolid;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setDirection(final Direction direction){
        if(this instanceof DungeonCharacter) this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsVisibleOnDungeonMap(){
        return isVisibleOnMiniMap;
    }
    public void setIsVisibleOnDungeonMap(final boolean isVisible){
        isVisibleOnMiniMap = isVisible;
    }

    @Override
    public String toString(){
        return stringRepresentation;
    }


}