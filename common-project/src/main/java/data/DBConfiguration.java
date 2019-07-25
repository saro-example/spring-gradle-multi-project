package data;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableTransactionManagement
public class DBConfiguration {
    @Bean
    public DataSource dataSource() {

        String jdbcUrl = "jdbc:h2:file:~/sample.db";

        log.info("h2 db jdbcUrl : " + jdbcUrl);

        var conf = new HikariDataSource();
        conf.setDriverClassName("org.h2.Driver");
        conf.setJdbcUrl(jdbcUrl);
        conf.setUsername("user");
        conf.setPassword("pass");
        return conf;
    }
}
