package TileObjects;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class SpikeTip extends TileObject{

    public SpikeTip(){
        super("SpikeTip", "t", false);
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/TileObjects/trap.png");
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("TRAP file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("TRAP input MUST BE NULL");
        }
    }

    private void inflictDamage() {}
}
