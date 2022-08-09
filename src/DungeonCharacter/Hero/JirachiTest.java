package DungeonCharacter.Hero;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JirachiTest {

    @Test
    void specialAttack() {
        Jirachi hero = null;
        Snorlax enemy = null;
        try {
            hero = new Jirachi();
            enemy = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }

        hero.setTarget(enemy);
        assertEquals(enemy, hero.getTarget());
        hero.specialAttack();
        assertEquals(true, enemy.getHP() < enemy.getMaxHP());

    }
}