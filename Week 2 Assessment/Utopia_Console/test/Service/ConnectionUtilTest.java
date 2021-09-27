package Service;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionUtilTest {
    ConnectionUtil connectionUtil = new ConnectionUtil();

    @Test
    void getConnectionTest() throws SQLException, ClassNotFoundException {
        assertNotNull(connectionUtil.getConnection());
    }
}