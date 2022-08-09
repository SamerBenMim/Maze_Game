package TileObjects.Items;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class OranBerry extends Item {

    public OranBerry(){
        super("Oran Berry", "O");
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/TileObjects/Items/Oran_Berry.png");
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("ORAN BERRY file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("ORAN BERRY input MUST BE NULL");
        }
    }

    private void heal() {}
}
