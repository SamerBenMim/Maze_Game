package SQL;

import org.junit.jupiter.api.Test;
import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class SQLTablesTest {

    @Test
    void extractDonkeyKongInfo() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractDonkeyKongInfo();
        System.out.println(result);
        System.out.println();
    }

    @Test
    void extractTeamRocketInfo() throws SQLException {
        SQLTables test = new SQLTables();
        String result = test.extractTeamRocketInfo();
        System.out.println(result);
        System.out.println();
    }
}