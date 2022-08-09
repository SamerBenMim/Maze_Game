package DungeonCharacter.Hero;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Snorlax extends Hero{
    private int mySleepCounter;

    //I made it public because he cannot be accessed out of package unless public -Kevin
    public Snorlax() throws IOException {
        super("Snorlax", 200, 200,15, 20, 0,
                10, 5);
        this.mySleepCounter = 0;
        setSprite();
    }

    private void setSprite(){
        try {
            URL url = this.getClass().getResource("/Sprites/Hero/Snorlax/Snorlax_Up_Idle.png");
            up = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Snorlax/Snorlax_Down_Idle.png");
            down = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Snorlax/Snorlax_Left_Idle.png");
            left = ImageIO.read(url);
            url = this.getClass().getResource("/Sprites/Hero/Snorlax/Snorlax_Right_Idle.png");
            right = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("SNORLAX file NOT FOUND");
        } catch (IllegalArgumentException e){
            System.out.println("SNORLAX input MUST BE NULL");
        }
    }
    @Override
    public void specialAttack() {
        heal(this.getMaxHP());
        this.setBattleStatus(false);
    }

    public void sleepCounter() {
        if(!this.getBattleStatus()) {
            if(this.mySleepCounter == 2) {
                this.mySleepCounter = 0;
                this.setBattleStatus(true);
            } else {
                this.mySleepCounter++;
            }
        }
    }

    public int getSleepCounter() {
        return this.mySleepCounter;
    }
}