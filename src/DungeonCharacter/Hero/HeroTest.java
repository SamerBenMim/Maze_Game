package DungeonCharacter.Hero;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void testToString() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        snorlax.collectOranBerry();
        snorlax.collectVisionSeeds();
        System.out.println(snorlax.toString());
    }

    @Test
    void collectOranBerry() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        for(int i = 0; i < 5; i++) {
            snorlax.collectOranBerry();
        }
        assertEquals(5, snorlax.getBerryCount());
    }

    @Test
    void collectVisionSeeds() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        for(int i = 0; i < 5; i++) {
            snorlax.collectVisionSeeds();
        }
        assertEquals(5, snorlax.getSeedCount());
    }
}