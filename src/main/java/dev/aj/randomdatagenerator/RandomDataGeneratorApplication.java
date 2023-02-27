package dev.aj.randomdatagenerator;

import dev.aj.randomdatagenerator.csvops.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class RandomDataGeneratorApplication {

    @Autowired
    private CSVWriter csvWriter;

    public static void main(String[] args) {
        SpringApplication.run(RandomDataGeneratorApplication.class, args);
    }

    @PostConstruct
    public void run() {
        try {
            csvWriter.processedEntity(10);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
