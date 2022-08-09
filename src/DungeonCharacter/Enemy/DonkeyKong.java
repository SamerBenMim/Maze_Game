package DungeonCharacter.Enemy;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class DonkeyKong extends Enemy{


    public DonkeyKong() throws IOException {
        super("Donkey Kong");
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/Enemy/DonkeyKong/DonkeyKong_Down_Idle.png");
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("DONKEY KONG file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("DONKEY KONG input MUST BE NULL");
        }
    }

}
