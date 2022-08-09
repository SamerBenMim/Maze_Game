package SQL;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTables {
    private SQLiteDataSource enemyTable;
    private Connection connection;
    private Statement statement;
    private String query;
    private int returnValue;
    private ResultSet myResultSet;

    public SQLTables() throws SQLException {
        createEnemyTable();
        fillEnemyTable();
    }

    private void createEnemyTable() {
        this.enemyTable = new SQLiteDataSource();

         this.query = "CREATE TABLE enemyDB (" +
                      "NAME TEXT PRIMARY KEY," +
                      "HP TEXT NOT NULL," +
                      "MAXHP TEXT NOT NULL," +
                      "DAMAGERANGE TEXT NOT NULL," +
                      "ATTACK TEXT NOT NULL," +
                      "SPECIALATTACK TEXT NOT NULL," +
                      "DEFENSE TEXT NOT NULL," +
                      "EVASION TEXT NOT NULL);";

        try {
            this.connection =  enemyTable.getConnection();
            this.statement = connection.createStatement();
            returnValue = statement.executeUpdate( query );
            System.out.println("executeUpdate() returned " + returnValue);
        } catch (SQLException e) {
            System.out.println("Error creating enemy table");
            System.exit(0);
        }
        System.out.println("Enemy table created successfully!");

    }

    private void fillEnemyTable() {

        this.query = "INSERT INTO 'enemyDB' ('NAME','HP','MAXHP','DAMAGERANGE','ATTACK','SPECIALATTACK','DEFENSE','EVASION') VALUES" +
                "('DONKEY KONG', '100','100','0','5','10','5','5')," +
                "('TEAM ROCKET GRUNT', '100','100','0','5','10','5','5');";

        try {
            returnValue = statement.executeUpdate( query );
            System.out.println("executeUpdate() returned " + returnValue);
        } catch (SQLException e) {
            System.out.println("Error filling values into enemy table");
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println("Values filled into enemy table successfully!");
    }

    public String extractDonkeyKongInfo() {
        String result = "";
        //this.query = "SELECT * FROM 'enemyDB';";
        this.query = "SELECT * FROM enemyDB LIMIT 1";
        //this.query = "SELECT rowid, * FROM enemyDB WHERE NAME = 'Donkey Kong'";

        try {
            this.myResultSet = this.statement.executeQuery(this.query);
            while(this.myResultSet.next()) {
                result += this.myResultSet.getString("NAME") + "\n";
                result += this.myResultSet.getString("HP") + "\n";
                result += this.myResultSet.getString("MAXHP") + "\n";
                result += this.myResultSet.getString("DAMAGERANGE") + "\n";
                result += this.myResultSet.getString("ATTACK") + "\n";
                result += this.myResultSet.getString("SPECIALATTACK") + "\n";
                result += this.myResultSet.getString("DEFENSE") + "\n";
                result += this.myResultSet.getString("EVASION");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving Donkey Kong info from table.");
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return result;
    }

    public String extractTeamRocketInfo() {
        String result = "";
        this.query = "SELECT * FROM enemyDB LIMIT 1 OFFSET 1";

        try {
            this.myResultSet = this.statement.executeQuery(this.query);
            while(this.myResultSet.next()) {
                result += this.myResultSet.getString("NAME") + "\n";
                result += this.myResultSet.getString("HP") + "\n";
                result += this.myResultSet.getString("MAXHP") + "\n";
                result += this.myResultSet.getString("DAMAGERANGE") + "\n";
                result += this.myResultSet.getString("ATTACK") + "\n";
                result += this.myResultSet.getString("SPECIALATTACK") + "\n";
                result += this.myResultSet.getString("DEFENSE") + "\n";
                result += this.myResultSet.getString("EVASION");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Error retrieving Team Rocket Grunt info from table.");
            System.exit(0);
        }

        return result;
    }
}
