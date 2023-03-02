package dev.aj.randomdatagenerator;

import dev.aj.randomdatagenerator.writeoperations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
@RequiredArgsConstructor
public class RandomDataGeneratorApplication {

    private final WriteOperationFactory writeOperation;

    public static void main(String[] args) {
        SpringApplication.run(RandomDataGeneratorApplication.class, args);
    }

    @PostConstruct
    public void run() {
        try {
            writeOperation.getWriteOperation(WriteType.CSV).generateDataToFile(5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
