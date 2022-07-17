package application;

import application.database.CSVData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        CSVData.getInstance();
        SpringApplication.run(Application.class, args);
    }

}
