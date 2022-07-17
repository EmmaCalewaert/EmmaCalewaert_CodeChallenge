package application;

import application.dao.BetriebsstelleDAO;
import application.dao.IBetriebsstelleDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public IBetriebsstelleDAO betriebsstelleDAO() { return new BetriebsstelleDAO(); }
}
