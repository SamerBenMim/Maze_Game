package DungeonCharacter.Enemy;

import SQL.SQLTables;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class EnemyFactory {
    private SQLTables myEnemyTable;

    public EnemyFactory() {
        try {
            this.myEnemyTable = new SQLTables();
        } catch (SQLException e) {
            System.out.println("Error creating enemy table");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public Enemy createEnemy() {
        Random rand = new Random();
        if(rand.nextInt(10) % 2 == 0) {
            try {
                Enemy newDK = new DonkeyKong();
                setEnemyValues(newDK, "DK");
                return newDK;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Error creating Donkey Kong enemy!");
            }

        } else {
            try {
                Enemy newTRG = new TeamRocketGrunt();
                setEnemyValues(newTRG, "TRG");
                return newTRG;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Error creating Team Rocket Grunt enemy!");
            }
        }

        System.out.println("Enemy factory failed to create enemy object.");
        System.exit(0);
        return null;
    }

    public void setEnemyValues(final Enemy THE_ENEMY, final String THE_TYPE) {
        String values = null;
        Scanner valueScan = null;
        switch(THE_TYPE) {
            case "DK":
                values = myEnemyTable.extractDonkeyKongInfo();
                valueScan = new Scanner (values);
                THE_ENEMY.setEnemyValues(valueScan.nextLine(),valueScan.nextInt(),valueScan.nextInt(),
                                         valueScan.nextInt(),valueScan.nextInt(),valueScan.nextInt(),
                                         valueScan.nextInt(),valueScan.nextInt());
            case "TRG":
                values = myEnemyTable.extractTeamRocketInfo();
                valueScan = new Scanner (values);
                THE_ENEMY.setEnemyValues(valueScan.nextLine(),valueScan.nextInt(),valueScan.nextInt(),
                        valueScan.nextInt(),valueScan.nextInt(),valueScan.nextInt(),
                        valueScan.nextInt(),valueScan.nextInt());
            default:
                break;
        }
    }



}
