import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTests {
    @Test
    public void testConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("드라이버 로딩 성공");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/member_db?serverTimezone=Asia/Seoul&characterEncoding=UTF-8",
                "root",
                "mysql1234"
        );
        Assertions.assertNotNull(conn);
        System.out.println(conn);
        conn.close();
    }

    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/member_db?serverTimezone=Asia/Seoul&characterEncoding=UTF-8");
        config.setUsername("root");
        config.setPassword("mysql1234");
        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection();
        Assertions.assertNotNull(conn);
        System.out.println(conn);
        conn.close();
    }
}
