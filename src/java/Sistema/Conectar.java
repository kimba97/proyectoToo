package Sistema;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar {
   
    public DriverManagerDataSource conectar()
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/too115");
        dataSource.setUsername("too115");
        dataSource.setPassword("too1152017");
        return dataSource;
        
    }
}
