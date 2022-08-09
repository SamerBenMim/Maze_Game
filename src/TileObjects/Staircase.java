package TileObjects;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Staircase extends TileObject{

     public Staircase(){
         super("Staircase", "s", false);
         setSprite();
     }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/TileObjects/Staircase.png");
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("STAIRCASE file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("STAIRCASE input MUST BE NULL");
        }
    }
}
