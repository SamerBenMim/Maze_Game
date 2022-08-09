package DungeonCharacter.Hero;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class Magikarp extends Hero {
    private double myBigAttackChance;

    public Magikarp() throws IOException {
        super("Magikarp", 60, 60,
                0, 1, 0,
                2, 5);
        this.myBigAttackChance = 0.1;
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/Hero/Magikarp/Magikarp_Up_Idle.png");
            up = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Magikarp/Magikarp_Down_Idle.png");
            down = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Magikarp/Magikarp_Left_Idle.png");
            left = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Magikarp/Magikarp_Right_Idle.png");
            right = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("MAGIKARP file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("MAGIKARP input MUST BE NULL");
        }
    }


    @Override
    public void specialAttack() {
        if(this.myBigAttackChance < Math.random()) {
            this.getTarget().takeDamage(this.getTarget().getMaxHP());
            this.myBigAttackChance += 0.05;
            this.heal(this.getMaxHP());
        }
    }

    public double getMyBigAttackChance() {
        return this.myBigAttackChance;
    }
}
