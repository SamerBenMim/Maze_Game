package DungeonCharacter;

import DungeonCharacter.Hero.Gallade;
import DungeonCharacter.Hero.Snorlax;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DungeonCharacterTest {

    @Test
    void attack() {
        Snorlax snorlax = null;
        Snorlax enemy = null;
        try {
            snorlax = new Snorlax();
            enemy = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        snorlax.setTarget(enemy);
        assertEquals(enemy, snorlax.getTarget());
        for(int i = 0; i < 10; i++){
            snorlax.attack();
        }
        assertEquals(true, enemy.getMaxHP() > enemy.getHP());
    }

    @Test
    void specialAttack() {
        Gallade hero = null;
        Snorlax enemy = null;
        try {
            hero = new Gallade();
            enemy = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        hero.setTarget(enemy);
        assertEquals(enemy, hero.getTarget());
        for(int i = 0; i < 5; i++) {
            hero.specialAttack();
        }
        assertEquals(true, enemy.getMaxHP() > enemy.getHP());
    }

    @Test
    void takeDamage() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        assertEquals(200, snorlax.getHP());
        for(int i = 0; i < 10; i++) {
            snorlax.takeDamage(20);
        }
        assertEquals(true, snorlax.getHP() < snorlax.getMaxHP());
    }

    @Test
    void heal() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        assertEquals(200, snorlax.getHP());
        for(int i = 0; i < 10; i++) {
            snorlax.takeDamage(20);
        }
        assertEquals(true, snorlax.getHP() < snorlax.getMaxHP());
        snorlax.heal(1000);
        assertEquals(snorlax.getMaxHP(), snorlax.getHP());
    }

    @Test
    void setBattleStatus() {
        Snorlax snorlax = null;
        try {
            snorlax = new Snorlax();
        } catch (IOException e) {
            System.out.println(e);
        }
        assertEquals(true, snorlax.getBattleStatus());
        snorlax.setBattleStatus(false);
        assertEquals(false, snorlax.getBattleStatus());
    }
}