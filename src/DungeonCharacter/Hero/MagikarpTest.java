package DungeonCharacter.Hero;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MagikarpTest {

    @Test
    void specialAttack() {
        Magikarp hero = null;
        Snorlax enemy = null;

        try {
            hero = new Magikarp();
            enemy = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }

        hero.setTarget(enemy);
        assertEquals(enemy, hero.getTarget());
        for(int i = 0; i < 100; i++) {
            hero.attack();
        }
        assertEquals(enemy.getHP(), enemy.getMaxHP());

        while(enemy.getHP() > 0) {
            hero.specialAttack();
        }
        System.out.println("Enemy health: " + enemy.getHP());

        assertEquals(true, hero.getMyBigAttackChance() > 0.1);
    }
}