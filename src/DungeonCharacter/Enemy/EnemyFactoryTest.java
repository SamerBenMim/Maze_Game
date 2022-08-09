package DungeonCharacter.Enemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyFactoryTest {

    @Test
    void createEnemy() {
        EnemyFactory enemyFactory = new EnemyFactory();
        Enemy[] eArray = new Enemy[100];
        for(int i = 0; i < eArray.length; i++) {
            eArray[i] = enemyFactory.createEnemy();
        }
        for(int i = 0; i < eArray.length; i++) {
            assertNotNull(eArray[i]);
        }

        Enemy test = enemyFactory.createEnemy();
        assertNotNull(test);

        System.out.println(test.getName());
        System.out.println(test.getHP());
        System.out.println(test.getAttack());
        System.out.println(test.getDefense());
        System.out.println(test.getDamageRange());
        System.out.println(test.getTarget());
        System.out.println(test.getBattleStatus());
    }
}