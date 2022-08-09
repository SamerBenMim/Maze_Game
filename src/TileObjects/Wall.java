package TileObjects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class Wall extends TileObject{

    public Wall(){
        super("Wall", "W", true);
        setSprite();

    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/TileObjects/Walls/Wall_Top.png");
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("WALL file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("WALL input MUST BE NULL");
        }
    }
}
