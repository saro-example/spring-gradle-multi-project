package web;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Slf4j
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories("web.repositories")
public class DBConfiguration {
    @Bean
    public DataSource dataSource() {

        String jdbcUrl = "jdbc:h2:file:../sample";

        log.info("h2 db jdbcUrl : " + jdbcUrl);

        var conf = new HikariDataSource();
        conf.setDriverClassName("org.h2.Driver");
        conf.setJdbcUrl(jdbcUrl);
        return conf;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) throws IOException {
        return builder.dataSource(dataSource()).packages("web.models").build();
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) throws IOException {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }
}
