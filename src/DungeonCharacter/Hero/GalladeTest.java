package DungeonCharacter.Hero;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GalladeTest {

    @Test
    void specialAttack() {
        Gallade test = null;
        Snorlax test2 = null;
        try {
            test = new Gallade();
            test2 = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }

        test.setTarget(test2);
        assertEquals(test2, test.getTarget());
        test.specialAttack();
        assertEquals(true, test.getHP() < test.getMaxHP());
        assertEquals(true,test2.getHP() < test2.getMaxHP());
    }
}