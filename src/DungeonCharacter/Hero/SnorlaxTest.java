package DungeonCharacter.Hero;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SnorlaxTest {

    @Test
    void specialAttack() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        for(int i = 0; i < 8; i++) {
            snorlax.takeDamage(20);
        }
        assertEquals(true, snorlax.getHP() < 200);
        snorlax.specialAttack();
        assertEquals(200, snorlax.getHP());
        assertEquals(false, snorlax.getBattleStatus());
    }

    @Test
    void sleepCounter() {
        Snorlax snorlax = null;
        try{
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        snorlax.specialAttack();
        assertEquals(false, snorlax.getBattleStatus());
        assertEquals(0, snorlax.getSleepCounter());
        snorlax.sleepCounter();
        assertEquals(1, snorlax.getSleepCounter());
        snorlax.sleepCounter();
        snorlax.sleepCounter();
        assertEquals(true, snorlax.getBattleStatus());

    }
}