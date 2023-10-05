import lombok.extern.log4j.Log4j2;
import model.dao.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
public class ConnectionUtilTests {
    @Test
    public void TestsConnectionUtil() throws SQLException {
        Connection connection = ConnectionUtil.INSTANCE.getConnection();
        log.info("connectionTest : " + connection);
    }


}
