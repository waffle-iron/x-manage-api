package lab.desire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;

@SpringBootApplication
public class ManageApplication {
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder) throws IOException {
        LocalContainerEntityManagerFactoryBean emf = builder
                .dataSource(primaryDataSource())
                .packages("lab.desire.entity")
                .persistenceUnit("primary")
                .build();
        emf.setMappingResources("META-INF/manage-query.xml");
        return emf;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder) throws IOException {
        LocalContainerEntityManagerFactoryBean emf = builder
                .dataSource(secondaryDataSource())
                .packages("lab.desire.entity")
                .persistenceUnit("second")
                .build();
        emf.setMappingResources("META-INF/manage-query.xml");
        return emf;
    }

	public static void main(String[] args) {
		SpringApplication.run(ManageApplication.class, args);
	}
}
