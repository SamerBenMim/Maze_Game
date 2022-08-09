package DungeonCharacter.Hero;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class Gallade extends Hero{
    private final double SELF_INFLICTION = 12;

    public Gallade() throws IOException {
        super("Gallade", 100, 100,30, 20, 30,
                3, 15);
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/Hero/Gallade/Gallade_Up_Idle.png");
            up = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Gallade/Gallade_Down_Idle.png");
            down = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Gallade/Gallade_Left_Idle.png");
            left = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Gallade/Gallade_Right_Idle.png");
            right = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("GALLADE file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("GALLADE input MUST BE NULL");
        }
    }

    @Override
    public void specialAttack() {
        this.getTarget().takeDamage(this.getMySpecialAttack());
        this.takeDamage((int)SELF_INFLICTION);
    }
}
