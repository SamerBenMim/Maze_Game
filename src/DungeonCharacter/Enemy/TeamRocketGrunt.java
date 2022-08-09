package DungeonCharacter.Enemy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TeamRocketGrunt extends Enemy{

    public TeamRocketGrunt() throws IOException {
        super("Team Rocket Grunt");
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/Enemy/TeamRocketGrunt/TeamRocketGrunt_Down_Idle.png");
            sprite = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("TEAM ROCKET GRUNT file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("TEAM ROCKET GRUNT input MUST BE NULL");
        }
    }

}
