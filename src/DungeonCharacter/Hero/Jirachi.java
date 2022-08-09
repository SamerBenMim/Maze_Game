package DungeonCharacter.Hero;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Jirachi extends Hero{
    public Jirachi() throws IOException {
        super("Jirachi", 75, 75,20, 50, 0,
                2, 5);
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/Hero/Jirachi/Jirachi_Up_Idle.png");
            up = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Jirachi/Jirachi_Down_Idle.png");
            down = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Jirachi/Jirachi_Left_Idle.png");
            left = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Jirachi/Jirachi_Right_Idle.png");
            right = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("JIRACHI file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("JIRACHI input MUST BE NULL");
        }
    }

    @Override
    public void specialAttack() {
        this.getTarget().takeDamage((int)this.getTarget().getHP() / 2);
    }
}