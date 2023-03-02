package dev.aj.randomdatagenerator;

import dev.aj.randomdatagenerator.csvops.CSVOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class RandomDataGeneratorApplication {

    @Autowired
    private CSVOperations csvOperations;

    public static void main(String[] args) {
        SpringApplication.run(RandomDataGeneratorApplication.class, args);
    }

    @PostConstruct
    public void run() {
        try {
            csvOperations.generateDataToCSV(30_000); //Can have underscore to help visualise the value
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
